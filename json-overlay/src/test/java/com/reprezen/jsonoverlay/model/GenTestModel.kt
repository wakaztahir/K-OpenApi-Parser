/*********************************************************************
 * Copyright (c) 2017 ModelSolv, Inc. and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * ModelSolv, Inc.
 * - initial API and implementation and/or initial documentation
 */
package com.reprezen.jsonoverlay.model

import com.reprezen.jsonoverlay.gen.CodeGenerator
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.nio.charset.StandardCharsets

object GenTestModel {

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        CodeGenerator.main(
            CodeGenerator.Options(
                typeDataFile = "json-overlay/src/test/java/com/reprezen/jsonoverlay/model/types.yaml",
                pkg = "com.reprezen.jsonoverlay.model",
                topDir = "json-overlay/src/test/java/com/reprezen/jsonoverlay/model",
                interfaceDir = "intf",
                interfacePackage = "intf",
                classDir = "impl",
                classPackage = "impl"
            )
        )
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