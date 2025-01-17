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

import com.reprezen.kaizen.oasparser.model3.Operation
import com.reprezen.kaizen.oasparser.model3.Parameter
import com.reprezen.kaizen.oasparser.model3.Path
import com.reprezen.kaizen.oasparser.model3.Server
import com.reprezen.kaizen.oasparser.ovl3.PathImpl
import com.reprezen.kaizen.oasparser.validate.ObjectValidatorBase

class PathValidator : ObjectValidatorBase<Path>() {
    override fun runObjectValidations() {
        val path = value.overlay as Path
        validateStringField(PathImpl.F_summary, false)
        validateStringField(PathImpl.F_description, false)
        validateMapField<Operation>(PathImpl.F_operations, false, false, OperationValidator())
        validateListField<Server>(PathImpl.F_servers, false, false, ServerValidator())
        validateListField<Parameter>(PathImpl.F_parameters, false, false, ParameterValidator())
        validateExtensions(path.getExtensions())
    }
}