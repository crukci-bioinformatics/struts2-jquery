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
import java.util.Random;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * A tag that creates an HTML &lt;a/&gt; element, that when clicked makes an
 * asynchronous request(XMLHttpRequest). The url attribute must be build using
 * the &lt;s:url/&gt; tag.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * <pre>
 * &lt;div id=&quot;div1&quot;&gt;Div 1&lt;/div&gt;
 * &lt;s:url id=&quot;ajaxTest&quot; value=&quot;/AjaxTest.action&quot;/&gt;
 *
 * &lt;sj:a id=&quot;link1&quot; href=&quot;%{ajaxTest}&quot; target=&quot;div1&quot;&gt; Update Content &lt;/sj:a&gt;
 * </pre>
 * <!-- END SNIPPET: example1 -->
 * <!-- START SNIPPET: example2 -->
 * <pre>
 * &lt;s:form id=&quot;form&quot; action=&quot;AjaxTest&quot;&gt;
 * &lt;input type=&quot;textbox&quot; name=&quot;data&quot;&gt; &lt;/s:form&gt;
 *
 * &lt;sj:a formId=&quot;form&quot; targets=&quot;div1&quot;&gt;Submit form&lt;/sj:a&gt;
 * </pre>
 * <!-- END SNIPPET: example2 -->
 *
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "a", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.AnchorTag", description = "Renders an HTML anchor element that when clicked calls a URL via remote XMLHttpRequest and updates its targets content", allowDynamicAttributes = true)
public class Anchor extends AbstractRemoteBean implements ButtonBean {

    public static final String TEMPLATE = "a";
    public static final String TEMPLATE_CLOSE = "a-close";
    public static final String COMPONENT_NAME = Anchor.class.getName();
    public static final Random RANDOM = new Random();
    public static final String JQUERYACTION = "anchor";

    private static final String PARAM_OPEN_DIALOG = "openDialog";
    private static final String PARAM_OPEN_DIALOG_TITLE = "openDialogTitle";
    private static final String PARAM_ON_CLICK_TOPICS = "onClickTopics";
    private static final String PARAM_BUTTON = "button";
    private static final String PARAM_BUTTON_ICON = "buttonIcon";
    private static final String PARAM_BUTTON_ICON_SECONDARY = "buttonIconSecondary";
    private static final String PARAM_BUTTON_TEXT = "buttonText";
    private static final String PARAM_VALIDATE = "validate";
    private static final String PARAM_VALIDATE_FUNCTION = "validateFunction";
    private static final String PARAM_CLEAR_FORM = "clearForm";
    private static final String PARAM_RESET_FORM = "resetForm";
    private static final String PARAM_IFRAME = "iframe";
    private static final String PARAM_REPLACE_TARGET = "replaceTarget";

    private static final String ID_PREFIX_ANCHOR = "anchor_";

    protected String openDialog;
    protected String openDialogTitle;
    protected String onClickTopics;
    protected String validate;
    protected String validateFunction;
    protected String button;
    protected String buttonIcon;
    protected String buttonIconSecondary;
    protected String buttonText;
    protected String clearForm;
    protected String resetForm;
    protected String iframe;
    protected String replaceTarget;

    public Anchor(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    public String getDefaultOpenTemplate() {
        return TEMPLATE;
    }

    protected String getDefaultTemplate() {
        return TEMPLATE_CLOSE;
    }

    public String getComponentName() {
        return COMPONENT_NAME;
    }

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        addParameter(PARAM_JQUERY_ACTION, JQUERYACTION);
        addParameterIfPresent(PARAM_OPEN_DIALOG, this.openDialog);
        addParameterIfPresent(PARAM_OPEN_DIALOG_TITLE, this.openDialogTitle);
        addParameterIfPresent(PARAM_ON_CLICK_TOPICS, this.onClickTopics);
        addParameterIfPresent(PARAM_BUTTON, this.button, Boolean.class);
        addParameterIfPresent(PARAM_BUTTON_ICON, this.buttonIcon);
        addParameterIfPresent(PARAM_BUTTON_ICON_SECONDARY, this.buttonIconSecondary);
        addParameterIfPresent(PARAM_BUTTON_TEXT, this.buttonText, Boolean.class);
        addParameterIfPresent(PARAM_VALIDATE, this.validate, Boolean.class);
        addParameterIfPresent(PARAM_VALIDATE_FUNCTION, this.validateFunction);
        addParameterIfPresent(PARAM_CLEAR_FORM, this.clearForm, Boolean.class);
        addParameterIfPresent(PARAM_RESET_FORM, this.resetForm, Boolean.class);
        addParameterIfPresent(PARAM_IFRAME, this.iframe, Boolean.class);
        addParameterIfPresent(PARAM_REPLACE_TARGET, this.replaceTarget, Boolean.class);

        addGeneratedIdParam(ID_PREFIX_ANCHOR);
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

    @StrutsTagAttribute(description = "id of dialog that will be opened when clicked.")
    public void setOpenDialog(String openDialog) {
        this.openDialog = openDialog;
    }

    @StrutsTagAttribute(description = "Set the title of a dialog opened by openDialog or openDialogTopics")
    public void setOpenDialogTitle(String openDialogTitle) {
        this.openDialogTitle = openDialogTitle;
    }

    @StrutsTagAttribute(name = "onClickTopics", description = "A comma delimited list of topics that published when the element is clicked")
    public void setOnClickTopics(String onClickTopics) {
        this.onClickTopics = onClickTopics;
    }

    @StrutsTagAttribute(description = "jQuery UI Button", defaultValue = "false", type = "Boolean")
    public void setButton(String button) {
        this.button = button;
    }

    @StrutsTagAttribute(description = "Icons to display. The primary icon is displayed on the left of the label text. Value must be a classname (String), eg. ui-icon-gear.")
    public void setButtonIcon(String buttonIcon) {
        this.buttonIcon = buttonIcon;
    }

    @StrutsTagAttribute(description = "Icons to display. The secondary icon is displayed on the right of the label text. Value must be a classname (String), eg. ui-icon-gear.")
    public void setButtonIconSecondary(String buttonIconSecondary) {
        this.buttonIconSecondary = buttonIconSecondary;
    }

    @StrutsTagAttribute(description = "Whether to show any text - when set to false (display no text), icons (see icons option) must be enabled, otherwise it'll be ignored.", defaultValue = "true", type = "Boolean")
    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    @StrutsTagAttribute(description = "A function that handle the client validation result. eg.: myValidation(form, errors)")
    public void setValidateFunction(String validateFunction) {
        this.validateFunction = validateFunction;
    }

    @StrutsTagAttribute(description = "Enable client AJAX validation", defaultValue = "false", type = "Boolean")
    public void setValidate(String validate) {
        this.validate = validate;
    }

    @StrutsTagAttribute(description = "Clear all form fields after successful submit when using formIds. Default: false", type = "Boolean")
    public void setClearForm(String clearForm) {
        this.clearForm = clearForm;
    }

    @StrutsTagAttribute(description = "Reset the form after successful submi twhen using formIds. Default: false", type = "Boolean")
    public void setResetForm(String resetForm) {
        this.resetForm = resetForm;
    }

    @StrutsTagAttribute(description = "Boolean flag indicating whether the form should always target the server response to an iframe when using formIds. This is useful in conjuction with file uploads. Default: false", type = "Boolean")
    public void setIframe(String iframe) {
        this.iframe = iframe;
    }

    @StrutsTagAttribute(description = "Set to true if the target should be replaced or false if only the target contents should be replaced when using formIds.", defaultValue = "false", type = "Boolean")
    public void setReplaceTarget(String replaceTarget) {
        this.replaceTarget = replaceTarget;
    }
}
