/*******************************************************************************
 * Copyright (c) 2023 ModelSolv, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * WaqasTahir - Contributions after 2022
 * ModelSolv, Inc. - initial API and implementation and/or initial documentation
 */
package com.reprezen.kaizen.oasparser.val3

import com.reprezen.kaizen.oasparser.model3.ExternalDocs
import com.reprezen.kaizen.oasparser.ovl3.ExternalDocsImpl
import com.reprezen.kaizen.oasparser.validate.ObjectValidatorBase

class ExternalDocsValidator : ObjectValidatorBase<ExternalDocs>() {
    override fun runObjectValidations() {
        val externalDocs: ExternalDocs = value.overlay as ExternalDocs
        validateStringField(ExternalDocsImpl.F_description, false)
        validateUrlField(ExternalDocsImpl.F_url, required = true, allowRelative = true, allowVars = false)
        validateExtensions(externalDocs.getExtensions())
    }
}