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

package com.jgeppert.struts2.jquery.richtext.views.freemarker.tags;

import com.opensymphony.xwork2.util.ValueStack;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 */
public class JqueryRichtextModels {
    protected CkeditorModel ckeditor;
    protected TinymceModel tinymce;

    private final ValueStack stack;
    private final HttpServletRequest req;
    private final HttpServletResponse res;

    public JqueryRichtextModels(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        this.stack = stack;
        this.req = req;
        this.res = res;
    }

    public CkeditorModel getCkeditor() {
        if (ckeditor == null) {
            ckeditor = new CkeditorModel(stack, req, res);
        }

        return ckeditor;
    }

    public TinymceModel getTinymce() {
        if (tinymce == null) {
            tinymce = new TinymceModel(stack, req, res);
        }

        return tinymce;
    }
}
