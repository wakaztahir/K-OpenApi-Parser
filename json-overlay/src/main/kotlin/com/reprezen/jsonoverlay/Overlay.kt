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

class Overlay<V> {

    var overlay: JsonOverlay<V>? = null
        private set

    constructor(overlay: JsonOverlay<V>) {
        this.overlay = overlay
    }

    constructor(overlay: IJsonOverlay<*>) {
        val castOverlay = overlay as? JsonOverlay<V>
        this.overlay = castOverlay
    }

    constructor(map: MapOverlay<V>, key: String) {
        overlay = map._getValueOverlayByName(key)
    }

    constructor(list: ListOverlay<V>, index: Int) {
        overlay = list._getValueOverlayByIndex(index)
    }

    constructor(props: KeyValueOverlay, fieldName: String) {
        val overlay = props._getValueOverlayByName(fieldName) as? JsonOverlay<V>
        this.overlay = overlay
    }

    val isPresent: Boolean
        get() = overlay?._isPresent() ?: false

    fun get(): V? {
        return overlay?._get()
    }

    fun find(path: String): JsonOverlay<*>? {
        return overlay?.findByPath(path)
    }

    val parent: JsonOverlay<*>?
        get() = overlay?._getParent()

    val pathInParent: String?
        get() = overlay?._getPathInParent()

    val root: JsonOverlay<*>?
        get() = overlay?._getRoot()

    fun <Model> getModel(): Model? {
        return overlay?._getModel() as Model?
    }

    val pathFromRoot: String?
        get() = overlay?._getPathFromRoot()

    val jsonReference: String
        get() = overlay?._getJsonReference() ?: throw IllegalArgumentException("overlay is null")

    val propertyNames: List<String>?
        get() = if (overlay is PropertiesOverlay<*>) {
            (overlay as PropertiesOverlay<*>)._getFactoryKeys()
        } else {
            null
        }

    fun getReference(key: String): Reference? {
        val propsOverlay = overlay as? KeyValueOverlay
        return propsOverlay?._getValueOverlayByPath(key)?._getReference()
    }

    fun getReference(key: Int): Reference? {
        val propsOverlay = overlay as? KeyValueOverlay
        return propsOverlay?._getValueOverlayByIndex(key)?._getReference()
    }

    val parentPropertiesOverlay: PropertiesOverlay<*>?
        get() {
            var parent = overlay?._getParent()
            while (parent != null) {
                parent = if (parent is PropertiesOverlay<*>) {
                    return parent
                } else {
                    getParent(parent)
                }
            }
            return null
        }

    override fun toString(): String {
        return overlay.toString()
    }

    fun isReference(): Boolean {
        return overlay?._getReference() != null
    }

    fun isReference(key: String): Boolean {
        return getReference(key) != null
    }

    fun isReference(index: Int): Boolean {
        return getReference(index) != null
    }

    companion object {

        fun <V> of(overlay: JsonOverlay<V>): Overlay<V> {
            return Overlay(overlay)
        }

        fun <V> of(overlay: IJsonOverlay<V>): Overlay<V> {
            return Overlay(overlay)
        }

        fun <V> of(overlay: MapOverlay<V>): Overlay<MutableMap<String, V>> {
            return Overlay(overlay)
        }

        fun <V> of(map: Map<String, V>): Overlay<MutableMap<String, V>> {
            return of(map as MapOverlay<V>)
        }

        fun <V> of(overlay: ListOverlay<V>): Overlay<MutableList<V>> {
            return Overlay(overlay)
        }

        fun <V> of(list: List<V>): Overlay<MutableList<V>> {
            return of(list as ListOverlay<V>)
        }

        fun <V> of(mapOverlay: MapOverlay<V>, key: String): Overlay<V> {
            return Overlay(mapOverlay, key)
        }

        @Suppress("UNCHECKED_CAST")
        fun <V> of(map: MutableMap<String, V>, key: String): Overlay<V> {
            return map[key]?.let { it as? JsonOverlay<V> }?.let { Overlay(it) } ?: of(map as MapOverlay<V>, key)
        }

        fun <V> of(list: ListOverlay<V>, index: Int): Overlay<V> {
            return Overlay(list, index)
        }

        @Suppress("UNCHECKED_CAST")
        fun <V> of(list: List<V>, index: Int): Overlay<V> {
            return (list.getOrNull(index) as? JsonOverlay<V>)?.let { Overlay(it) } ?: of(list as ListOverlay<V>, index)
        }

        fun <X> of(props: IJsonOverlay<X>, fieldName: String): Overlay<X>? {
            return if (props is PropertiesOverlay<*>) {
                val castProps = props as PropertiesOverlay<X>
                Overlay(castProps, fieldName)
            } else {
                null
            }
        }

        operator fun <V> get(overlay: JsonOverlay<V>): V? {
            return overlay._get()
        }

        fun <V> getParent(overlay: JsonOverlay<V>): JsonOverlay<*>? {
            return overlay._getParent()
        }

        fun <X> getListOverlay(overlay: Overlay<List<X>>): ListOverlay<X>? {
            return if (overlay.overlay is ListOverlay<*>) {
                overlay.overlay as ListOverlay<X>
            } else {
                null
            }
        }

        fun <X> getMapOverlay(overlay: Overlay<MutableMap<String, X>>): MapOverlay<X>? {
            return if (overlay.overlay is MapOverlay<*>) {
                overlay.overlay as MapOverlay<X>
            } else {
                null
            }
        }

        fun getPropertiesOverlay(overlay: Overlay<PropertiesOverlay<*>>): PropertiesOverlay<*>? {
            return if (overlay.overlay is PropertiesOverlay<*>) {
                overlay.overlay as? PropertiesOverlay<*>
            } else {
                null
            }
        }

    }
}
