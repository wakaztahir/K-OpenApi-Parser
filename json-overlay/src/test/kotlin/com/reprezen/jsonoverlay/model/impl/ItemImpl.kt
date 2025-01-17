package com.reprezen.jsonoverlay.model.impl

import com.reprezen.jsonoverlay.model.intf.*
import com.reprezen.jsonoverlay.StringOverlay
import kotlin.reflect.KClass
import com.reprezen.jsonoverlay.parser.Generated
import com.reprezen.jsonoverlay.IJsonOverlay
import com.reprezen.jsonoverlay.OverlayFactory
import kotlinx.serialization.json.JsonElement
import com.reprezen.jsonoverlay.Builder
import com.reprezen.jsonoverlay.PropertiesOverlay
import com.reprezen.jsonoverlay.JsonOverlay
import com.reprezen.jsonoverlay.ReferenceManager

class ItemImpl : PropertiesOverlay<Item> ,Item {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	constructor(json : JsonElement, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : super(json, parent, Companion.factory, refMgr)

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	constructor(item : Item?, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : super(item, parent, Companion.factory, refMgr)

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	// Title
	override fun getTitle() : String? {
		return _get("title")
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun setTitle(title : String) {
		_setScalar("title", title)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun _elaborateJson() {
		super._elaborateJson()
		_createScalar("title", "title", StringOverlay.factory)
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	override fun _getModelType() : Class<*> {
		return TestModel::class.java
	}

	companion object {
		const val F_title : String = "title"

		val factory = object : OverlayFactory<Item>() {
		
			override val signature: String?
				get() = ItemImpl::class.simpleName
		
			override fun _create(value : Item?, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : JsonOverlay<Item> {
				return ItemImpl(value, parent, refMgr)
			}
		
			override fun _create(json : JsonElement, parent : JsonOverlay<*>?, refMgr : ReferenceManager) : JsonOverlay<Item> {
				return ItemImpl(json, parent, refMgr)
			}
		
			override val isExtendedType : Boolean get() = false
		};

		fun builder(modelMember : JsonOverlay<*>) : Builder<Item> {
			return Builder<Item>(factory, modelMember)
		}

		fun create(modelMember : JsonOverlay<*>) : Item {
			return builder(modelMember).build() as Item
		}
	}

}
