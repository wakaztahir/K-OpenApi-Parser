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
package com.reprezen.jsonoverlay.gen

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import org.yaml.snakeyaml.Yaml
import java.io.File
import java.io.FileInputStream
import java.io.IOException

class CodeGenerator private constructor(private val opts: Options) {

    @Throws(IOException::class)
    private fun generate(typeData: TypeData) {
        generateInterfaces(typeData)
        generateImpls(typeData)
        if (!opts.preserve) {
            System.err.println("WARNING: Preservation of non-generated code is suppressed!")
            System.err
                .println("This is normally appropriate only when modifying the code generator and/or input data,")
            System.err.println("during which compilation errors are likely to be present in generated code.")
            System.err.println("")
            System.err.println("Please be sure to revert the generated code to a known good state and then regenerate")
            System.err.println("after completing modifications, so as to carry forward any non-generated code that")
            System.err.println("has been previously added.")
        }
    }

    @Throws(IOException::class)
    private fun generateInterfaces(typeData: TypeData) {
        val intfDir = intfDir
        val intfPackage = intfPackage
        val implPackage = implPackage
        for (type in typeData.types) {
            if (type.isNoGen) {
                return
            }
            JavaInterfaceGenerator(intfDir, intfPackage, implPackage, "", opts.preserve).generate(type)
        }
    }

    @Throws(IOException::class)
    private fun generateImpls(typeData: TypeData) {
        val implDir = implDir
        val intfPackage = intfPackage
        val implPackage = implPackage
        for (type in typeData.types) {
            if (type.isNoGen) {
                return
            }
            JavaImplGenerator(implDir, intfPackage, implPackage, opts.classSuffix, opts.preserve).generate(type)
        }
    }

    private val implDir: File = File(opts.topDir, opts.classDir.path)
    private val implPackage: String = opts.pkg + "." + opts.classPackage
    private val intfDir: File = File(opts.topDir, opts.interfaceDir.path)
    private val intfPackage: String = opts.pkg + "." + opts.interfacePackage

    data class Options(
        var topDir: File = File("."),
        var typeDataFile: File = File("type-data.yaml"),
        var interfacePackage: String = "",
        var interfaceDir: File = File("."),
        var classDir: File = File("impl"),
        var pkg: String = CodeGenerator::class.java.getPackage().name,
        var classPackage: String = "impl",
        var classSuffix: String = "Impl",
        var preserve: Boolean = true
    ) {
        constructor(
            topDir: String = ".",
            typeDataFile: String = "type-data.yaml",
            interfacePackage: String = "",
            interfaceDir: String = ".",
            classDir: String = "impl",
            pkg: String = CodeGenerator::class.java.getPackage().name,
            classPackage: String = "impl",
            classSuffix: String = "Impl",
            preserve: Boolean = true,
        ) : this(
            topDir = File(topDir),
            typeDataFile = File(typeDataFile),
            interfacePackage = interfacePackage,
            interfaceDir = File(interfaceDir),
            classDir = File(classDir),
            pkg = pkg,
            classPackage = classPackage,
            classSuffix = classSuffix,
            preserve = preserve
        )
    }


    companion object {
        @Throws(Exception::class)
        @JvmStatic
        fun main(options: Options) {
            val parsedYaml = Yaml().load<Any>(FileInputStream(options.typeDataFile))
            val typeData = YAMLMapper().convertValue(parsedYaml, TypeData::class.java)
            typeData.init()
            CodeGenerator(options).generate(typeData)
        }
    }
}