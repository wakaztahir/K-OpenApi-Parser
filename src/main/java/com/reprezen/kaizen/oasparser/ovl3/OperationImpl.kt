package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.kaizen.oasparser.model3.*;
import com.reprezen.jsonoverlay.MapOverlay;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.ovl3.CallbackImpl;
import com.reprezen.jsonoverlay.parser.Generated;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.ListOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.Builder;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.ovl3.RequestBodyImpl;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.kaizen.oasparser.ovl3.ResponseImpl;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.kaizen.oasparser.ovl3.ServerImpl;
import com.reprezen.kaizen.oasparser.ovl3.ParameterImpl;
import com.reprezen.kaizen.oasparser.ovl3.SecurityRequirementImpl;
import com.reprezen.jsonoverlay.ObjectOverlay;
import kotlin.collections.List;
import com.reprezen.jsonoverlay.JsonOverlay;
import kotlin.collections.Map;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.kaizen.oasparser.ovl3.ExternalDocsImpl;

class OperationImpl : PropertiesOverlay<Operation> ,Operation {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	constructor(json : JsonNode, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : super(json, parent, Companion.factory, refMgr)

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	constructor(operation : Operation?, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : super(operation, parent, Companion.factory, refMgr)

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// Tag
	override fun getTags() : List<String> {
		return _getList("tags", String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getTags(elaborate : Boolean) : List<String> {
		return _getList("tags", elaborate, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasTags() : Boolean {
		return _isPresent("tags")
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getTag(index : Int) : String {
		return _get("tags", index, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setTags(tags : MutableList<String>) {
		_setList("tags", tags, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setTag(index : Int, tag : String) {
		_set("tags", index, tag, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun addTag(tag : String) {
		_add("tags", tag, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun insertTag(index : Int, tag : String) {
		_insert("tags", index, tag, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun removeTag(index : Int) {
		_remove("tags", index, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// Summary
	override fun getSummary() : String? {
		return _get("summary", String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setSummary(summary : String) {
		_setScalar("summary", summary, String::class.java)
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
	// ExternalDocs
	override fun getExternalDocs() : ExternalDocs? {
		return _get("externalDocs", ExternalDocs::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getExternalDocs(elaborate : Boolean) : ExternalDocs? {
		return _get("externalDocs", elaborate, ExternalDocs::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setExternalDocs(externalDocs : ExternalDocs) {
		_setScalar("externalDocs", externalDocs, ExternalDocs::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// OperationId
	override fun getOperationId() : String? {
		return _get("operationId", String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setOperationId(operationId : String) {
		_setScalar("operationId", operationId, String::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// Parameter
	override fun getParameters() : List<Parameter> {
		return _getList("parameters", Parameter::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getParameters(elaborate : Boolean) : List<Parameter> {
		return _getList("parameters", elaborate, Parameter::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasParameters() : Boolean {
		return _isPresent("parameters")
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getParameter(index : Int) : Parameter {
		return _get("parameters", index, Parameter::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setParameters(parameters : MutableList<Parameter>) {
		_setList("parameters", parameters, Parameter::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setParameter(index : Int, parameter : Parameter) {
		_set("parameters", index, parameter, Parameter::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun addParameter(parameter : Parameter) {
		_add("parameters", parameter, Parameter::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun insertParameter(index : Int, parameter : Parameter) {
		_insert("parameters", index, parameter, Parameter::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun removeParameter(index : Int) {
		_remove("parameters", index, Parameter::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// RequestBody
	override fun getRequestBody() : RequestBody? {
		return _get("requestBody", RequestBody::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getRequestBody(elaborate : Boolean) : RequestBody? {
		return _get("requestBody", elaborate, RequestBody::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setRequestBody(requestBody : RequestBody) {
		_setScalar("requestBody", requestBody, RequestBody::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// Response
	override fun getResponses() : MutableMap<String, Response> {
		return _getMap("responses", Response::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getResponses(elaborate : Boolean) : MutableMap<String, Response> {
		return _getMap("responses", elaborate, Response::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasResponses() : Boolean {
		return _isPresent("responses")
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasResponse(name : String) : Boolean {
		return _getMap("responses", Response::class.java).containsKey(name)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getResponse(name : String) : Response? {
		return _get("responses", name, Response::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setResponses(responses : MutableMap<String, Response>) {
		_setMap("responses", responses, Response::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setResponse(name : String, response : Response) {
		_set("responses", name, response, Response::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun removeResponse(name : String) {
		_remove("responses", name, Response::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// ResponsesExtension
	override fun getResponsesExtensions() : MutableMap<String, Any> {
		return _getMap("responsesExtensions", Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getResponsesExtensions(elaborate : Boolean) : MutableMap<String, Any> {
		return _getMap("responsesExtensions", elaborate, Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasResponsesExtensions() : Boolean {
		return _isPresent("responsesExtensions")
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasResponsesExtension(name : String) : Boolean {
		return _getMap("responsesExtensions", Any::class.java).containsKey(name)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getResponsesExtension(name : String) : Any? {
		return _get("responsesExtensions", name, Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setResponsesExtensions(responsesExtensions : MutableMap<String, Any>) {
		_setMap("responsesExtensions", responsesExtensions, Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setResponsesExtension(name : String, responsesExtension : Any) {
		_set("responsesExtensions", name, responsesExtension, Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun removeResponsesExtension(name : String) {
		_remove("responsesExtensions", name, Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// Callback
	override fun getCallbacks() : MutableMap<String, Callback> {
		return _getMap("callbacks", Callback::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getCallbacks(elaborate : Boolean) : MutableMap<String, Callback> {
		return _getMap("callbacks", elaborate, Callback::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasCallbacks() : Boolean {
		return _isPresent("callbacks")
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasCallback(name : String) : Boolean {
		return _getMap("callbacks", Callback::class.java).containsKey(name)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getCallback(name : String) : Callback? {
		return _get("callbacks", name, Callback::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setCallbacks(callbacks : MutableMap<String, Callback>) {
		_setMap("callbacks", callbacks, Callback::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setCallback(name : String, callback : Callback) {
		_set("callbacks", name, callback, Callback::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun removeCallback(name : String) {
		_remove("callbacks", name, Callback::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// CallbacksExtension
	override fun getCallbacksExtensions() : MutableMap<String, Any> {
		return _getMap("callbacksExtensions", Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getCallbacksExtensions(elaborate : Boolean) : MutableMap<String, Any> {
		return _getMap("callbacksExtensions", elaborate, Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasCallbacksExtensions() : Boolean {
		return _isPresent("callbacksExtensions")
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasCallbacksExtension(name : String) : Boolean {
		return _getMap("callbacksExtensions", Any::class.java).containsKey(name)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getCallbacksExtension(name : String) : Any? {
		return _get("callbacksExtensions", name, Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setCallbacksExtensions(callbacksExtensions : MutableMap<String, Any>) {
		_setMap("callbacksExtensions", callbacksExtensions, Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setCallbacksExtension(name : String, callbacksExtension : Any) {
		_set("callbacksExtensions", name, callbacksExtension, Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun removeCallbacksExtension(name : String) {
		_remove("callbacksExtensions", name, Any::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// Deprecated
	override fun getDeprecated() : Boolean? {
		return _get("deprecated", Boolean::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun isDeprecated() : Boolean {
		return _get("deprecated", Boolean::class.java) ?: false
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setDeprecated(deprecated : Boolean) {
		_setScalar("deprecated", deprecated, Boolean::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// SecurityRequirement
	override fun getSecurityRequirements() : List<SecurityRequirement> {
		return _getList("securityRequirements", SecurityRequirement::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getSecurityRequirements(elaborate : Boolean) : List<SecurityRequirement> {
		return _getList("securityRequirements", elaborate, SecurityRequirement::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasSecurityRequirements() : Boolean {
		return _isPresent("securityRequirements")
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getSecurityRequirement(index : Int) : SecurityRequirement {
		return _get("securityRequirements", index, SecurityRequirement::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setSecurityRequirements(securityRequirements : MutableList<SecurityRequirement>) {
		_setList("securityRequirements", securityRequirements, SecurityRequirement::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setSecurityRequirement(index : Int, securityRequirement : SecurityRequirement) {
		_set("securityRequirements", index, securityRequirement, SecurityRequirement::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun addSecurityRequirement(securityRequirement : SecurityRequirement) {
		_add("securityRequirements", securityRequirement, SecurityRequirement::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun insertSecurityRequirement(index : Int, securityRequirement : SecurityRequirement) {
		_insert("securityRequirements", index, securityRequirement, SecurityRequirement::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun removeSecurityRequirement(index : Int) {
		_remove("securityRequirements", index, SecurityRequirement::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// Server
	override fun getServers() : List<Server> {
		return _getList("servers", Server::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getServers(elaborate : Boolean) : List<Server> {
		return _getList("servers", elaborate, Server::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun hasServers() : Boolean {
		return _isPresent("servers")
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun getServer(index : Int) : Server {
		return _get("servers", index, Server::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setServers(servers : MutableList<Server>) {
		_setList("servers", servers, Server::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setServer(index : Int, server : Server) {
		_set("servers", index, server, Server::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun addServer(server : Server) {
		_add("servers", server, Server::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun insertServer(index : Int, server : Server) {
		_insert("servers", index, server, Server::class.java)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun removeServer(index : Int) {
		_remove("servers", index, Server::class.java)
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
		_createList("tags", "tags", StringOverlay.factory)
		_createScalar("summary", "summary", StringOverlay.factory)
		_createScalar("description", "description", StringOverlay.factory)
		_createScalar("externalDocs", "externalDocs", ExternalDocsImpl.factory)
		_createScalar("operationId", "operationId", StringOverlay.factory)
		_createList("parameters", "parameters", ParameterImpl.factory)
		_createScalar("requestBody", "requestBody", RequestBodyImpl.factory)
		_createMap("responses", "responses", ResponseImpl.factory, "default|(\\d[0-9X]{2})")
		_createMap("responsesExtensions", "responses", ObjectOverlay.factory, "x-.+")
		_createMap("callbacks", "callbacks", CallbackImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+")
		_createMap("callbacksExtensions", "callbacks", ObjectOverlay.factory, "x-.+")
		_createScalar("deprecated", "deprecated", BooleanOverlay.factory)
		_createList("securityRequirements", "security", SecurityRequirementImpl.factory)
		_createList("servers", "servers", ServerImpl.factory)
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+")
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun _getModelType() : Class<*> {
		return OpenApi3::class.java
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun _getFactory() : OverlayFactory<Operation> {
		return Companion.factory
	}

	companion object {
		const val F_tags : String = "tags"

		const val F_summary : String = "summary"

		const val F_description : String = "description"

		const val F_externalDocs : String = "externalDocs"

		const val F_operationId : String = "operationId"

		const val F_parameters : String = "parameters"

		const val F_requestBody : String = "requestBody"

		const val F_responses : String = "responses"

		const val F_responsesExtensions : String = "responsesExtensions"

		const val F_callbacks : String = "callbacks"

		const val F_callbacksExtensions : String = "callbacksExtensions"

		const val F_deprecated : String = "deprecated"

		const val F_securityRequirements : String = "securityRequirements"

		const val F_servers : String = "servers"

		const val F_extensions : String = "extensions"

		val factory = object : OverlayFactory<Operation>() {
		
			override fun getOverlayClass() : Class<out JsonOverlay<in Operation>> {
				return OperationImpl::class.java
			}
		
			override fun _create(operation : Operation?, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : JsonOverlay<Operation> {
				return OperationImpl(operation, parent, refMgr)
			}
		
			override fun _create(json : JsonNode, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : JsonOverlay<Operation> {
				return OperationImpl(json, parent, refMgr)
			}
		
			override val isExtendedType : Boolean get() = false
		};

		private fun getSubtypeOf(operation : Operation) : Class<out Operation> {
			return Operation::class.java
		}

		private fun getSubtypeOf(json : JsonNode) : Class<out Operation> {
			return Operation::class.java
		}
		

		fun builder(modelMember : JsonOverlay<*>) : Builder<Operation> {
			return Builder<Operation>(factory, modelMember)
		}

		fun create(modelMember : JsonOverlay<*>) : Operation {
			return builder(modelMember).build() as Operation
		}
	}

}
