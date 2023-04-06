package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.kaizen.oasparser.model3.*;
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
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.reprezen.jsonoverlay.ReferenceManager;
import kotlin.collections.List;
import com.reprezen.jsonoverlay.JsonOverlay;

class SecurityParameterImpl : PropertiesOverlay<SecurityParameter> ,SecurityParameter {

    override fun _fixJson(json : JsonNode) : JsonNode {
        return if(json.isMissingNode()) _jsonArray() else json
    }

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	constructor(json : JsonNode, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : super(json, parent, Companion.factory, refMgr)

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	constructor(securityParameter : SecurityParameter?, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : super(securityParameter, parent, Companion.factory, refMgr)

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// Parameter
	override fun getParameters() : List<String> {
		return _getList("parameters", String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getParameters(elaborate : Boolean) : List<String> {
		return _getList("parameters", elaborate, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasParameters() : Boolean {
		return _isPresent("parameters")
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getParameter(index : Int) : String {
		return _get("parameters", index, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setParameters(parameters : MutableList<String>) {
		_setList("parameters", parameters, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setParameter(index : Int, parameter : String) {
		_set("parameters", index, parameter, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun addParameter(parameter : String) {
		_add("parameters", parameter, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun insertParameter(index : Int, parameter : String) {
		_insert("parameters", index, parameter, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun removeParameter(index : Int) {
		_remove("parameters", index, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun _elaborateJson() {
		super._elaborateJson()
		_createList("parameters", "", StringOverlay.factory)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun _getModelType() : Class<*> {
		return OpenApi3::class.java
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun _getFactory() : OverlayFactory<SecurityParameter> {
		return Companion.factory
	}

	companion object {
		const val F_parameters : String = "parameters"

		val factory = object : OverlayFactory<SecurityParameter>() {
		
			override fun getOverlayClass() : Class<out JsonOverlay<in SecurityParameter>> {
				return SecurityParameterImpl::class.java
			}
		
			override fun _create(securityParameter : SecurityParameter?, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : JsonOverlay<SecurityParameter> {
				return SecurityParameterImpl(securityParameter, parent, refMgr)
			}
		
			override fun _create(json : JsonNode, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : JsonOverlay<SecurityParameter> {
				return SecurityParameterImpl(json, parent, refMgr)
			}
		
			override val isExtendedType : Boolean get() = false
		};

		private fun getSubtypeOf(securityParameter : SecurityParameter) : Class<out SecurityParameter> {
			return SecurityParameter::class.java
		}

		private fun getSubtypeOf(json : JsonNode) : Class<out SecurityParameter> {
			return SecurityParameter::class.java
		}
		

		fun builder(modelMember : JsonOverlay<*>) : Builder<SecurityParameter> {
			return Builder<SecurityParameter>(factory, modelMember)
		}

		fun create(modelMember : JsonOverlay<*>) : SecurityParameter {
			return builder(modelMember).build() as SecurityParameter
		}
	}

}