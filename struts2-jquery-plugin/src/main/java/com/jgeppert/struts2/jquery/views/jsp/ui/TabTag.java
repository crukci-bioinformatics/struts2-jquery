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

import com.jgeppert.struts2.jquery.components.Tab;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 * @see Tab
 */
public class TabTag extends AbstractRemoteTag {

    private static final long serialVersionUID = 5309231035916461758L;

    protected String target;
    protected String closable;

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Tab(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();

        Tab tab = (Tab) component;
        tab.setTarget(target);
        tab.setClosable(closable);
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setClosable(String closable) {
        this.closable = closable;
    }

}
