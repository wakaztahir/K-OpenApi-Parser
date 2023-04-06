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
package com.reprezen.jsonoverlay

object Primitive {
    // This is a placeholder because we have values defined as type "Primitive"
    // in
    // the type descriptors, but the values are really represented by Objects
    // (since
    // there's no way to splice Primitive into the Java type hierarchy). This is
    // listed as an "auto" import type in the type generator, which prevents an
    // import from being attempted for it.
    fun _isPrimitive(o: Any?): Boolean {
        return o == null || o is Number || o is String
    }
}
