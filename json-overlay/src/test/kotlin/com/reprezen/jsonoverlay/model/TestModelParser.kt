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
package com.reprezen.jsonoverlay.model

import com.reprezen.jsonoverlay.Overlay
import com.reprezen.jsonoverlay.ReferenceManager
import com.reprezen.jsonoverlay.model.impl.TestModelImpl
import com.reprezen.jsonoverlay.model.intf.TestModel
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import java.nio.charset.StandardCharsets

object TestModelParser {

    @Throws(IOException::class)
    fun parse(url: URL): TestModel {
        val manager = ReferenceManager(url)
        val model = TestModelImpl.factory.create(manager.loadDoc(), null, manager) as TestModel
        (model as TestModelImpl)._setCreatingRef(manager.getReference(url.toString()))
        return Overlay.of(model).get()!!
    }

    fun loadResourceFileAsURL(resourcePath: String): URL {
        return object {}.javaClass.classLoader.getResource(resourcePath)!!
    }

    fun loadResourceFileAsString(resourcePath: String): String {
        val inputStream = object {}.javaClass.classLoader.getResourceAsStream(resourcePath)!!
        val reader = BufferedReader(InputStreamReader(inputStream, StandardCharsets.UTF_8))
        return reader.readText()
    }

}
