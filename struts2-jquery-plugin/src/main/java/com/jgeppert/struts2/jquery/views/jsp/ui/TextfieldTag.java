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

package com.jgeppert.struts2.jquery.views.jsp.ui;

import com.jgeppert.struts2.jquery.components.Textfield;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 * @see Textfield
 */
public class TextfieldTag extends AbstractFormElementTag {

    private static final long serialVersionUID = 8332089683341849748L;

    protected String maxlength;
    protected String readonly;
    protected String size;

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Textfield(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();

        Textfield text = (Textfield) component;
        text.setMaxlength(maxlength);
        text.setReadonly(readonly);
        text.setSize(size);
    }

    public void setMaxlength(String maxlength) {
        this.maxlength = maxlength;
    }

    public void setReadonly(String readonly) {
        this.readonly = readonly;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
