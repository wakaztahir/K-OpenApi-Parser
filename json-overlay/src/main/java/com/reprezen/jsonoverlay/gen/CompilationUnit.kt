package com.reprezen.jsonoverlay.gen

class CompilationUnit(private var packageDec: String, val type: TypeDeclaration) {

    private val imports = mutableListOf<String>()

    fun setPackageDeclaration(pkg: String) {
        this.packageDec = pkg
    }

    fun addImport(import: String) {
        imports.add(import)
    }

    fun addGeneratedMembers(members: Collection<ClassMember>) {
        for (member in members) type.addMember(member.generated())
    }

    fun format(): String {
        var formatted = packageDec
        if (imports.size > 0) {
            formatted += "\n\n"
            formatted += imports.joinToString("\n")
        }
        formatted += "\n\n${type.format()}"
        return formatted
    }

}