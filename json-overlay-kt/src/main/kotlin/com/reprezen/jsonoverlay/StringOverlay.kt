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
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull

class StringOverlay : ScalarOverlay<String> {

    private constructor(json: JsonElement, parent: JsonOverlay<*>?, refMgr: ReferenceManager) : super(
        json,
        parent,
        Companion.factory,
        refMgr
    )

    private constructor(value: String?, parent: JsonOverlay<*>?, refMgr: ReferenceManager) : super(
        value,
        parent,
        Companion.factory,
        refMgr
    )

    override fun _fromJson(json: JsonElement): String? {
        return (json as? JsonPrimitive)?.contentOrNull
    }

    override fun _toJsonInternal(options: SerializationOptions): JsonElement {
        return if (value != null) _jsonScalar(value!!) else _jsonMissing()
    }

    override fun _getFactory(): OverlayFactory<*> {
        return Companion.factory
    }

    override fun toString(): String {
        // we don't want quotes here; the default rendering uses toJson, which does
        // include them.
        return if (value != null) value!! else ""
    }

    companion object {

        @JvmField
        var factory: OverlayFactory<String> = object : OverlayFactory<String>() {
            override fun getOverlayClass(): Class<StringOverlay> {
                return StringOverlay::class.java
            }

            override fun _create(value: String?, parent: JsonOverlay<*>?, refMgr: ReferenceManager): StringOverlay {
                return StringOverlay(value, parent, refMgr)
            }

            public override fun _create(
                json: JsonElement,
                parent: JsonOverlay<*>?,
                refMgr: ReferenceManager
            ): StringOverlay {
                return StringOverlay(json, parent, refMgr)
            }
        }

        fun builder(modelMember: JsonOverlay<*>?): Builder<String> {
            return Builder(factory, modelMember)
        }

        fun create(modelMember: JsonOverlay<*>?): JsonOverlay<String> {
            return builder(modelMember).build()
        }

        fun create(value: String, modelMember: JsonOverlay<*>?): JsonOverlay<String> {
            val result = create(modelMember)
            result._set(value)
            return result
        }
    }
}