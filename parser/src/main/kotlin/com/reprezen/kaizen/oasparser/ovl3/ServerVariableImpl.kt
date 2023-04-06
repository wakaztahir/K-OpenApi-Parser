package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.kaizen.oasparser.model3.*;
import com.reprezen.jsonoverlay.MapOverlay;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.jsonoverlay.parser.Generated;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.ListOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.Builder;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.ObjectOverlay;
import kotlin.collections.List;
import com.reprezen.jsonoverlay.JsonOverlay;
import kotlin.collections.Map;

class ServerVariableImpl : PropertiesOverlay<ServerVariable> ,ServerVariable {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	constructor(json : JsonNode, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : super(json, parent, Companion.factory, refMgr)

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	constructor(serverVariable : ServerVariable?, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : super(serverVariable, parent, Companion.factory, refMgr)

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// EnumValue
	override fun getEnumValues() : List<String> {
		return _getList("enumValues", String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getEnumValues(elaborate : Boolean) : List<String> {
		return _getList("enumValues", elaborate, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasEnumValues() : Boolean {
		return _isPresent("enumValues")
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getEnumValue(index : Int) : String {
		return _get("enumValues", index, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setEnumValues(enumValues : MutableList<String>) {
		_setList("enumValues", enumValues, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setEnumValue(index : Int, enumValue : String) {
		_set("enumValues", index, enumValue, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun addEnumValue(enumValue : String) {
		_add("enumValues", enumValue, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun insertEnumValue(index : Int, enumValue : String) {
		_insert("enumValues", index, enumValue, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun removeEnumValue(index : Int) {
		_remove("enumValues", index, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// Default
	override fun getDefault() : String? {
		return _get("defaultValue", String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setDefault(defaultValue : String) {
		_setScalar("defaultValue", defaultValue, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// Description
	override fun getDescription() : String? {
		return _get("description", String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setDescription(description : String) {
		_setScalar("description", description, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// Extension
	override fun getExtensions() : MutableMap<String, Any> {
		return _getMap("extensions", Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getExtensions(elaborate : Boolean) : MutableMap<String, Any> {
		return _getMap("extensions", elaborate, Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasExtensions() : Boolean {
		return _isPresent("extensions")
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasExtension(name : String) : Boolean {
		return _getMap("extensions", Any::class.java).containsKey(name)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getExtension(name : String) : Any? {
		return _get("extensions", name, Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setExtensions(extensions : MutableMap<String, Any>) {
		_setMap("extensions", extensions, Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setExtension(name : String, extension : Any) {
		_set("extensions", name, extension, Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun removeExtension(name : String) {
		_remove("extensions", name, Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun _elaborateJson() {
		super._elaborateJson()
		_createList("enumValues", "enum", StringOverlay.factory)
		_createScalar("defaultValue", "default", StringOverlay.factory)
		_createScalar("description", "description", StringOverlay.factory)
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+")
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun _getModelType() : Class<*> {
		return OpenApi3::class.java
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun _getFactory() : OverlayFactory<ServerVariable> {
		return Companion.factory
	}

	companion object {
		const val F_enumValues : String = "enumValues"

		const val F_defaultValue : String = "defaultValue"

		const val F_description : String = "description"

		const val F_extensions : String = "extensions"

		val factory = object : OverlayFactory<ServerVariable>() {
		
			override fun getOverlayClass() : Class<out JsonOverlay<in ServerVariable>> {
				return ServerVariableImpl::class.java
			}
		
			override fun _create(serverVariable : ServerVariable?, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : JsonOverlay<ServerVariable> {
				return ServerVariableImpl(serverVariable, parent, refMgr)
			}
		
			override fun _create(json : JsonNode, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : JsonOverlay<ServerVariable> {
				return ServerVariableImpl(json, parent, refMgr)
			}
		
			override val isExtendedType : Boolean get() = false
		};

		private fun getSubtypeOf(serverVariable : ServerVariable) : Class<out ServerVariable> {
			return ServerVariable::class.java
		}

		private fun getSubtypeOf(json : JsonNode) : Class<out ServerVariable> {
			return ServerVariable::class.java
		}
		

		fun builder(modelMember : JsonOverlay<*>) : Builder<ServerVariable> {
			return Builder<ServerVariable>(factory, modelMember)
		}

		fun create(modelMember : JsonOverlay<*>) : ServerVariable {
			return builder(modelMember).build() as ServerVariable
		}
	}

}