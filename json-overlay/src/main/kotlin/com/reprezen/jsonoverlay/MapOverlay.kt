/*********************************************************************
 * Copyright (c) 2023 ModelSolv, Inc. and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * WaqasTahir - Contributions after 2022
 * ModelSolv, Inc.
 * - initial API and implementation and/or initial documentation
 */
package com.reprezen.jsonoverlay

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject

class MapOverlay<V> private constructor(
    value: MutableMap<String, V>,
    json: JsonElement?,
    parent: JsonOverlay<*>?,
    factory: MapOverlayFactory<V>,
    refMgr: ReferenceManager,
) : JsonOverlay<MutableMap<String, V>>(
    parent = parent,
    factory = factory,
    refMgr = refMgr
), KeyValueOverlay, Map<String, V> by value, MutableMap<String, V> {

    private val overlays: MutableMap<String, JsonOverlay<V>> = mutableMapOf()

    private val valueFactory: OverlayFactory<V> = factory.valueFactory
    private val keyPattern: Regex? = if (factory.keyPattern != null) Regex(factory.keyPattern) else null

    init {
        this.value = value
        this.json = json
        _elaborate()
    }

    override fun _getValueOverlayByName(name: String): JsonOverlay<V>? {
        return overlays[name]
    }

    override fun _findByPointer(path: JsonPointer): JsonOverlay<*>? {
//        val debug = path == JsonPointer("/2.0/users/{username}")
//        if (debug) println("FINDING $path IN MapOverlay")
        overlays[path.toString()]?.let { return it }
//        if(debug) println("FINDING SEGMENT ${path.segments.firstOrNull()} IN MapOverlay")
        path.segments.firstOrNull()?.let { key ->
            (overlays[key])?.let { ov ->
//                if(debug) println("FOUND $key , FINDING ${JsonPointer(path.segments.drop(1))} IN ${ov::class.qualifiedName}")
                if (path.segments.size == 1) return ov
                return ov._findByPointer(JsonPointer(path.segments.drop(1)))
            }
//            if (debug) println("FINDING F-SLASH")
//            if (key.getOrNull(0) == '/') {
//                overlays["/"]?.let { ov ->
//                    if (debug) println("FINDING AFTER F-SLASH")
//                    return ov.findByPointer(JsonPointer(key.removePrefix("/") + path.segments.drop(1)))
//                }
//            }
        }
        return null
    }

    override fun _getPathOfChild(child: JsonOverlay<*>): String {
        for (item in overlays) if (item.value == child) return item.key
        return "-1".also {
            Throwable("returning child path -1 in map overlay child :  $child \n\n\n map : $this").printStackTrace()
        }
    }

    override fun _fromJson(json: JsonElement): MutableMap<String, V> {
        return this
    }

    override fun _toJsonInternal(options: SerializationOptions): JsonElement {
        if (overlays.isEmpty() && !options.isKeepThisEmpty) return JsonNull
        return JsonObject(overlays.mapValues { it.value._toJson(options.minus(SerializationOptions.Option.KEEP_ONE_EMPTY)) })
    }

    fun _elaborate() {
        if (json != null) {
            fillWithJson()
        } else {
            fillWithValues()
        }
    }

    private fun fillWithJson() {
        value!!.clear()
        overlays.clear()
        if (json !is JsonObject) return
        for (item in json!!.jsonObject) {
            if (keyPattern == null || keyPattern.matches(item.key)) {
                val valOverlay = valueFactory.create(item.value, this, refMgr)
                overlays[item.key] = valOverlay
                valOverlay._get()?.let { value!!.put(item.key, it) }
            }
        }
    }

    private fun fillWithValues() {
        overlays.clear()
        for ((key, value1) in value!!) {
            val valOverlay = valueOverlayFor(value1)
            overlays[key] = valOverlay
        }
    }

    private fun valueOverlayFor(`val`: V): JsonOverlay<V> {
        return valueFactory.create(`val`, this, refMgr)
    }

    override operator fun get(key: String): V? {
        val valOverlay = overlays[key]
        return valOverlay?._get()
    }

    override fun _getPropertyNames(): List<String> {
        return overlays.keys.toList()
    }

    override val keys: MutableSet<String>
        get() = value!!.keys

    override val values: MutableCollection<V>
        get() = value!!.values

    operator fun set(key: String, value: V) {
        this.value!![key] = value
        overlays[key] = valueOverlayFor(value)
    }

    override fun remove(key: String): V? {
        overlays.remove(key)
        return value!!.remove(key)
    }

    override val size: Int
        get() = overlays.size

    private fun checkOrder(other: MapOverlay<*>): Boolean {
        val myKeys: Iterator<String> = overlays.keys.iterator()
        val theirKeys: Iterator<String> = other.overlays.keys.iterator()
        while (myKeys.hasNext() && theirKeys.hasNext()) {
            if (myKeys.next() != theirKeys.next()) {
                return false
            }
        }
        return !myKeys.hasNext() && !theirKeys.hasNext()
    }

    private class MapOverlayFactory<V>(val valueFactory: OverlayFactory<V>, val keyPattern: String?) :
        OverlayFactory<MutableMap<String, V>>() {

        override val signature: String
            get() = String.format("map[%s|%s]", valueFactory.signature, keyPattern ?: "*")

        override fun _create(
            value: MutableMap<String, V>?,
            parent: JsonOverlay<*>?,
            refMgr: ReferenceManager
        ): JsonOverlay<MutableMap<String, V>> {
            return MapOverlay<V>(value = value ?: mutableMapOf(), json = null, parent = parent, this, refMgr)
        }

        override fun _create(
            json: JsonElement,
            parent: JsonOverlay<*>?,
            refMgr: ReferenceManager
        ): JsonOverlay<MutableMap<String, V>> {
            return MapOverlay<V>(value = mutableMapOf(), json = json, parent = parent, this, refMgr)
        }
    }

    companion object {
        fun <V> getFactory(
            valueFactory: OverlayFactory<V>,
            keyPattern: String?
        ): OverlayFactory<MutableMap<String, V>> {
            return MapOverlayFactory(valueFactory, keyPattern)
        }
    }

    override val entries: MutableSet<MutableMap.MutableEntry<String, V>>
        get() = value!!.entries

    override fun clear() {
        value!!.clear()
        overlays.clear()
    }

    private fun itemOverlayOf(value: V): JsonOverlay<V> {
        return valueFactory.create(value = value, parent = this, refMgr = refMgr)
    }

    override fun putAll(from: Map<out String, V>) {
        value!!.putAll(from)
        overlays.putAll(from.mapValues { itemOverlayOf(it.value) })
    }

    override fun put(key: String, value: V): V? {
        val previous = this.value?.get(key)
        this.value!![key] = value
        overlays[key] = itemOverlayOf(value)
        return previous
    }

}