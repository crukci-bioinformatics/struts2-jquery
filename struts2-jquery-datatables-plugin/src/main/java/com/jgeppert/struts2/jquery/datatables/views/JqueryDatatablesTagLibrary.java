/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.jgeppert.struts2.jquery.datatables.views;

import com.jgeppert.struts2.jquery.datatables.views.freemarker.tags.JqueryDatatablesModels;
import com.jgeppert.struts2.jquery.datatables.views.velocity.components.DatatablesDirective;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.views.TagLibraryDirectiveProvider;
import org.apache.struts2.views.TagLibraryModelProvider;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 */
public class JqueryDatatablesTagLibrary implements TagLibraryDirectiveProvider, TagLibraryModelProvider {

    @Override
    public Object getModels(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new JqueryDatatablesModels(stack, req, res);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public List<Class<?>> getDirectiveClasses() {
        Class[] directives = new Class[]{DatatablesDirective.class};
        return Arrays.asList(directives);
    }

}
