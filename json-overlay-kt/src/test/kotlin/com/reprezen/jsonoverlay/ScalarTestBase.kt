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
import org.junit.Assert
import org.junit.Test
import java.net.MalformedURLException

abstract class ScalarTestBase<V>(private val factory: OverlayFactory<V>) : Assert() {

    private val refMgr = ReferenceManager()

    var value: V? = null

    protected abstract fun toJson(value: V?): JsonElement
    @Test
    fun testOvlValueFromJson() {
        val json = toJson(value)
        testWithJson(json, value)
    }

    @Test
    fun testOvlValueFromValue() {
        val ovl = factory.create(value, null, refMgr)
        assertTrue(factory.getOverlayClass().isAssignableFrom(ovl.javaClass))
        assertEquals(value, ovl._get())
        testCopy(ovl)
    }

    @Test
    fun testWithNull() {
        value = null
        testOvlValueFromJson()
        testOvlValueFromValue()
    }

    @Test
    fun testWithMissingJson() {
        testWithJson(JsonNull, null)
    }

    @Test
    open fun testWithWrongJson() {
        testWithJson(JsonObject(mapOf()), null)
    }

    @Test
    fun testSerialization() {
        val ovl = factory.create(value!!, null, refMgr)
        val json = ovl._toJson()
        val ovl2 = factory.create(json, null, refMgr)
        assertEquals(ovl._get(), ovl2._get())
    }

    @Test
    fun testRoot() {
        val ovl = factory.create(value!!, null, refMgr)
        assertSame(ovl, ovl._getRoot())
        assertNull(Overlay.of(ovl).getModel())
    }

    @Test
    fun testPathFromRoot() {
        val ovl = factory.create(value!!, null, refMgr)
        assertNull(Overlay.of(ovl).pathFromRoot)
    }

    @Test
    @Throws(MalformedURLException::class)
    fun testJsonRef() {
        val ovl = factory.create(value!!, null, refMgr)
        assertEquals("#", Overlay.of(ovl).jsonReference)
    }

    fun testWithJson(json: JsonElement, `val`: V?) {
        val ovl = factory.create(json, null, refMgr)
        assertTrue(factory.getOverlayClass().isAssignableFrom(ovl.javaClass))
        assertEquals(`val`, ovl._get())
        testCopy(ovl)
    }

    fun testCopy(ovl: JsonOverlay<V>) {
        val copy = ovl._copy()
        assertNotSame("Copy operation should yield different object", ovl, copy)
        assertEquals(ovl, copy)
        assertEquals(ovl._get(), copy._get())
    }

}
