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

package com.jgeppert.struts2.jquery.components;

import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Render HTML textfield providing content from remote call via AJAX
 * </p>
 * <!-- END SNIPPET: javadoc -->
 *
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 */

@StrutsTag(name = "textfield", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.TextfieldTag", description = "Render HTML textfield providing content from remote call via AJAX", allowDynamicAttributes = true)
public class Textfield extends AbstractFormElement {

    public static final String TEMPLATE = "textfield";
    public static final String TEMPLATE_CLOSE = "textfield-close";
    public static final String COMPONENT_NAME = Textfield.class.getName();
    public static final String JQUERYACTION = "container";

    private static final String PARAM_SIZE = "size";
    private static final String PARAM_MAXLENGTH = "maxlength";
    private static final String PARAM_READONLY = "readonly";

    private static final String ID_PREFIX_TEXTFIELD = "textfield_";

    protected String maxlength;
    protected String readonly;
    protected String size;

    public Textfield(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    public String getDefaultOpenTemplate() {
        return TEMPLATE;
    }

    protected String getDefaultTemplate() {
        return TEMPLATE_CLOSE;
    }

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        addParameter(PARAM_JQUERY_ACTION, JQUERYACTION);

        addParameterIfPresent(PARAM_SIZE, this.size);
        addParameterIfPresent(PARAM_MAXLENGTH, this.maxlength);
        addParameterIfPresent(PARAM_READONLY, this.readonly, Boolean.class);

        addGeneratedIdParam(ID_PREFIX_TEXTFIELD);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setTheme(String theme) {
        super.setTheme(theme);
    }

    @Override
    public String getTheme() {
        return "jquery";
    }

    @StrutsTagAttribute(description = "HTML maxlength attribute", type = "Integer")
    public void setMaxlength(String maxlength) {
        this.maxlength = maxlength;
    }

    @StrutsTagAttribute(description = "Whether the input is readonly", type = "Boolean", defaultValue = "false")
    public void setReadonly(String readonly) {
        this.readonly = readonly;
    }

    @StrutsTagAttribute(description = "HTML size attribute", type = "Integer")
    public void setSize(String size) {
        this.size = size;
    }
}
