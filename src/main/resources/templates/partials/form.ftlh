<#import "/spring.ftl" as spring>

<#macro label path required=false>
    <label class="col-sm-3 col-form-label">
        <@spring.message path />
        <#if required>
            <span class="text-danger">*</span>
        </#if>
    </label>
</#macro>

<#macro fullImage imageObj class="" alt="">
    <@image imageObj "full" class alt />
</#macro>

<#macro image imageObj="" type="" class="" alt="">
    <img src="${(imageObj?hasContent)?then(imageHelper.getImagePath(imageDomain, imageObj, type), "/static/assets/images/placeholder.jpg")}"
         alt="${alt}" class="${class}">
</#macro>

<#macro imagePath imageObj="">${(imageObj?hasContent)?then(imageHelper.getImagePath(imageDomain, imageObj), "")}</#macro>

<#macro imagePathType imageObj type>${imageHelper.getImagePath(imageDomain, imageObj, type)}</#macro>

<#macro print path="" title="" name="" method="POST" submit="form.submit">
    <!-- Basic layout-->
    <form action="${path}" name="${name}" method="${method}" class="form-horizontal" enctype="multipart/form-data">
        <div class="panel panel-flat">

            <#if title?hasContent>
                <div class="panel-heading">
                    <h5 class="panel-title"><@spring.message title/></h5>
                </div>
            </#if>

            <div class="panel-body">
                <#nested />
                <div class="text-right">
                    <button type="submit" class="btn btn-primary"><@spring.message submit/> <i
                                class="icon-arrow-right14 position-right"></i></button>
                </div>
            </div>
        </div>
    </form>
    <!-- /basic layout -->
</#macro>

<#macro simplePrint path="" title="" name="" method="POST" submit="form.submit">
    <!-- Basic layout-->
    <form action="${path}" name="${name}" method="${method}" class="form-horizontal" enctype="multipart/form-data">

        <div class="panel-body">
            <#nested />
            <div class="text-right">
                <button type="submit" class="btn btn-primary"><@spring.message submit/> <i
                            class="icon-arrow-right14 position-right"></i></button>
            </div>
        </div>
    </form>
    <!-- /basic layout -->
</#macro>

<#macro simpleWithoutButtonPrint path="" id="" name="" style="display: block;" method="POST" submit="form.submit">
    <!-- Basic layout-->
    <form action="${path}" id="${id}" name="${name}" method="${method}" class="form-horizontal"
          enctype="multipart/form-data" style="${style}">

        <div class="panel-body">
            <#nested />
        </div>
    </form>
    <!-- /basic layout -->
</#macro>

<#macro inputHidden path>
    <@spring.formHiddenInput path/>
</#macro>

<#macro inputDate path label>
    <#assign attr = 'class="form-control" '/>
    <#assign inputId = path?split(".")[1]/>

    <div class="form-group">
        <label>
            ${label!""}
        </label>
        <div class="">
            <@spring.formInput path attr />
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>

    <script type="text/javascript">
        $('#${inputId}').datepicker({
            dateFormat: 'yy-mm-dd',
            changeYear: true,
            yearRange: "2022:2030",
            defaultDate: new Date(2022, 1 - 1, 1),
            maxDate: new Date(2025, 1 - 1, 1)
        });
    </script>
</#macro>

<#macro inputBirthDate path label>
    <#assign attr = 'class="form-control" '/>
    <#assign inputId = path?split(".")[1]/>

    <div class="form-group">
        <label>
            ${label!""}
        </label>
        <div class="form-group">
            <@spring.formInput path attr />
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>

    <script type="text/javascript">
        $('#${inputId}').datepicker({
            dateFormat: 'yy-mm-dd',
            changeYear: true,
            yearRange: "1910:2030",
            defaultDate: new Date(1990, 1 - 1, 1),
            maxDate: new Date(2022, 1 - 1, 16)
        });
    </script>
</#macro>

<#macro inputDateTime path title>
    <@spring.bind path />
    <div class="form-group">
        <div class="row">
            <label for="datetimepicker-${spring.status.expression}" class="control-label col-lg-3">
                ${title!""}
            </label>
            <div class="col-lg-9">
                <input
                        id="datetimepicker-${spring.status.expression}"
                        class="form-control"
                        name="${spring.status.expression}"
                        value="${spring.status.displayValue}"
                />
                <script type="application/javascript">
                    $(function () {
                        $('#datetimepicker-${spring.status.expression}')
                            .datetimepicker({
                                dateFormat: "yy-mm-dd",
                                timeFormat: "HH:00:00",
                                showMinute: false
                            });
                    })
                </script>
            </div>
        </div>
    </div>
</#macro>

<#macro smallInputDateTime path title>
    <@spring.bind path />
    <div class="form-group">
        <div class="row">
            <label class="control-label col-lg-4">
                ${title!""}
            </label>
            <div class="col-lg-8">
                <input
                        id="datetimepicker-${spring.status.expression}"
                        class="form-control"
                        name="${spring.status.expression}"
                        value="${spring.status.displayValue}"
                />
                <script type="application/javascript">
                    $(function () {
                        $('#datetimepicker-${spring.status.expression}')
                            .datetimepicker({
                                dateFormat: "yy-mm-dd",
                                timeFormat: "HH:00:00",
                                showMinute: false
                            });
                    })
                </script>
            </div>
        </div>
    </div>
</#macro>

<#macro inputText path fieldType="text" placeholder="" required=false class="" attrs="">
    <#assign attr = 'class="form-control ' + class + '" ' + attrs/>
    <#assign attr = attr + (placeholder?hasContent)?then(' placeholder="'+springMacroRequestContext.getMessage(placeholder)+'"', "")/>
    <#assign attr = attr + (required)?then(' required="required"', "")/>

    <div class="form-group">
        <label class="control-label col-lg-3">
            <@spring.message path/>
            <#if required>
                <span class="text-danger">*</span>
            </#if>
        </label>
        <div class="col-lg-9">
            <@spring.formInput path attr fieldType/>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>
</#macro>

<#macro textArea path>
    <@spring.bind path />
    <div class="form-group">
        <label class="col-sm-3 control-label"><@spring.message path />: </label>
        <div class="col-sm-9">
            <@spring.formTextarea path 'rows="12" cols="5" class="form-control"' />
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>
</#macro>

<#macro wysiwyg path required=false readonly=false height=0>
    <div class="form-group">
        <div class="col-sm-12">
            <label class="control-label"><@spring.message path />: </label>
            <@spring.formTextarea path 'wysiwyg="wysiwyg" ${required?string("required","")}'/>
            <@spring.showErrors "<br>" "text-danger" />
        </div>
    </div>
    <script type="text/javascript">

        <#if height gt 0 >
        $("#${spring.status.expression}").summernote({
            height: ${height}
        });
        </#if>

        $("#${spring.status.expression}").summernote(
            ${readonly?string("'disable'","'enable'")}
        );

    </script>
</#macro>

<#macro codeEditor path height=400 required=false>
    <#assign id = path?replace(".","")/>
    <div class="panel panel-flat">
        <div class="panel-heading">
            <label class="control-label"><@spring.message path />: </label>
        </div>
        <div class="panel-body">
            <@spring.bind path />
            <div id="codeEditor${id}" style="height: #{height}px !important;">
            </div>
            <textarea name="${spring.status.expression}" id="textarea${id}"
                      class="hidden">${spring.stringStatusValue!""}</textarea>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>
    <script type="application/javascript">
        $(function () {
            // HTML editor
            var ${id}editor = ace.edit("codeEditor${id}");
            ${id}editor.setTheme("ace/theme/monokai");
            ${id}editor.getSession().setMode("ace/mode/html");
            ${id}editor.setShowPrintMargin(false);

            var ${id}textarea = $("#textarea${id}");
            ${id}editor.getSession().setValue(${id}textarea.val());
            ${id}editor.getSession().on('change', function () {
                ${id}textarea.val(${id}editor.getSession().getValue());
            });
        });
    </script>
</#macro>

<#macro switchCheckBox path required=false checked=false formGroupClass="" attrs="">
    <@spring.bind path />
    <#assign attr = 'class="switchery" ' + checked?then('checked','') + (attrs?hasContent)?then(' '+attrs, '') />
    <div class="form-group ${formGroupClass}">
        <label class="col-sm-3 control-label"><@spring.message path />: </label>
        <div class="col-lg-9">
            <@spring.formCheckbox path attr/>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>
</#macro>

<#macro select2list path options value>
    <@spring.bind path/>
    <#assign replacedPath = path?replace(".", "-") />
    <#assign selectId = "select-id-${replacedPath}" />
    <div class="form-group">
        <@label path/>
        <div class="col-sm-9">
            <select id="${selectId}" class="select" name="${spring.status.expression}">
                <option value=""></option>
                <#list options as option>
                    <#if value?hasContent && value.getSelectorId() == option.getSelectorId()>
                        <#assign selected = true>
                    <#else>
                        <#assign selected = false>
                    </#if>
                    <option value="${option.getSelectorId()}" ${selected?then(' selected="selected"','')}><@spring.message option.getSelectorTitle() /></option>
                </#list>
            </select>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>

    <script type="application/javascript">
        $("#${selectId}").select2({
            width: "100%",
            minimumResultsForSearch: Infinity,
            placeholder: "<@spring.message path/>",
            allowClear: true
        });
    </script>
</#macro>

<#macro select2listmultiple path options values>
    <@spring.bind path/>
    <#assign replacedPath = path?replace(".", "-") />
    <#assign selectId = "select-id-${replacedPath}" />
    <div class="form-group">
        <@label path/>
        <div class="col-sm-9">
            <select id="${selectId}" class="select" name="${spring.status.expression}" multiple="multiple">
                <#list options as option>
                    <#assign isSelected = false/>
                    <#list values as s>
                        <#assign isSelected = s.getSelectorId() == option.getSelectorId()>
                        <#if isSelected><#break/></#if>
                    </#list>
                    <option value="${option.getSelectorId()}" ${isSelected?then(' selected="selected"','')}><@spring.message option.getSelectorTitle()/></option>
                </#list>
            </select>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>

    <script type="application/javascript">
        $("#${selectId}").select2({
            width: "100%",
            minimumResultsForSearch: Infinity,
            placeholder: "<@spring.message path/>"
        });
    </script>
</#macro>

<#macro select2tags path options>
    <@spring.bind path/>
    <#assign replacedPath = path?replace(".", "-") />
    <#assign selectId = "select-id-${replacedPath}" />
    <div class="form-group">
        <@label path/>
        <div class="col-sm-9">
            <select id="${selectId}" class="select" multiple="multiple" name="${spring.status.expression}">
                <#list options as option>
                    <option value="${option}" selected="selected"><@spring.message option/></option>
                </#list>
            </select>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>

    <script type="application/javascript">
        $("#${selectId}").select2({
            tags: true,
            tokenSeparators: [","],
            placeholder: "<@spring.message path/>"
        });
    </script>
</#macro>

<#macro select2simple path options>
    <@spring.bind path/>
    <#assign replacedPath = path?replace(".", "-") />
    <#assign selectId = "select-id-${replacedPath}" />
    <div class="form-group row">
        <@label path/>
        <div class="col-sm-9">
            <select id="${selectId}" class="select" name="${spring.status.expression}">
                <option></option>
                <#list options as option>
                    <#assign selected = (spring.stringStatusValue?hasContent && spring.stringStatusValue = option)?then("selected", "")/>
                    <option ${selected} value="${option}">${option}</option>
                </#list>
            </select>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>

    <script type="application/javascript">
        $("#${selectId}").select2({
            width: "100%",
            placeholder: "<@spring.message path/>",
            minimumResultsForSearch: Infinity
        });
    </script>
</#macro>

<#macro select2numbers path options>
    <@spring.bind path/>
    <#assign replacedPath = path?replace(".", "-") />
    <#assign selectId = "select-id-${replacedPath}" />
    <div class="form-group">
        <@label path/>
        <div class="col-sm-9">
            <select id="${selectId}" class="select" name="${spring.status.expression}">
                <option></option>
                <#list options as option>
                    <#assign selected = (spring.stringStatusValue?hasContent && spring.stringStatusValue?number = option)?then("selected", "")/>
                    <option ${selected} value="${option}">${option}</option>
                </#list>
            </select>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>

    <script type="application/javascript">
        $("#${selectId}").select2({
            placeholder: "<@spring.message path/>",
            allowClear: true
        });
    </script>
</#macro>

<#macro selectOptions path options title>
    <@spring.bind path/>
    <label class="mt-3" for="${spring.status.expression}">${title!""}</label>
    <select class="custom-select" id="${spring.status.expression}" name="${spring.status.expression}">
        <#list options as option>
            <option value="${option.getSelectorId()}" <@spring.checkSelected option.getSelectorId()/>>${option.getSelectorTitle()!""}</option>
        </#list>
    </select>
</#macro>

<#macro select2 path title url selected attributes="">
    <@spring.bind path/>
    <#assign replacedPath = path?replace(".", "-") />
    <#assign selectId = "select-id-${replacedPath}" />
    <#assign varId = path?replace(".", "") />
    <div class="form-group row">
        <label class="col-sm-3 col-form-label">
            ${title!""}
        </label>
        <div class="col-lg-9">
            <select id="${selectId}" name="${spring.status.expression}" ${attributes}>
                <#if selected?? && selected?hasContent>
                    <option value="${selected.getSelectorId()}"
                            selected="selected"> ${selected.getSelectorTitle()!""} </option>
                </#if>
            </select>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>


    <script type="application/javascript">
        var select2${varId} = "${url}";
        $(function () {
            $("#${selectId}").select2({
                width: "100%",
                placeholder: ${path},
                allowClear: true,
                theme: "bootstrap",
                ajax: {
                    url: function () {
                        console.log(select2${varId});
                        return select2${varId};
                    },
                    dataType: 'json',
                    delay: 250,
                    data: function (params) {
                        return {
                            q: params.term, // search term
                            page: params.page ? params.page - 1 : params.page
                        };
                    },
                    error: function (request, status, error) {
                        alert(request.responseJSON.message);
                    },
                    processResults: function (data, params) {
                        return {
                            results: data._embedded.data,
                            pagination: {
                                more: ((data.page.number + 1) * data.page.size) < data.page.total_elements
                            }
                        };
                    },
                },
                templateSelection: function (data) {
                    return data.title || data.text;
                },
                templateResult: function (data) {
                    return data.title;
                }
            });
        });
    </script>
</#macro>


<#macro select2string path url selected attributes="">
    <@spring.bind path/>
    <#assign replacedPath = path?replace(".", "-") />
    <#assign selectId = "select-id-${replacedPath}" />
    <#assign varId = path?replace(".", "") />
    <div class="form-group row">
        <label class="col-sm-3 col-form-label">
            <@spring.message path/>
        </label>
        <div class="col-lg-9">
            <select id="${selectId}" name="${spring.status.expression}" ${attributes}>
                <#if selected?? && selected?hasContent>
                    <option value="${selected}" selected="selected">${selected}</option>
                </#if>
            </select>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>

    <script type="application/javascript">
        var select2${varId} = "${url}";
        $(function () {
            $("#${selectId}").select2({
                width: "100%",
                placeholder: "<@spring.message path/>",
                allowClear: true,
                theme: "bootstrap",
                ajax: {
                    url: function () {
                        console.log(select2${varId});
                        return select2${varId};
                    },
                    dataType: 'json',
                    delay: 250,
                    data: function (params) {
                        console.log(params);

                        return {
                            q: params.term, // search term
                            page: params.page ? params.page - 1 : params.page
                        };
                    },
                    processResults: function (data, params) {
                        return {
                            results: data._embedded.data,
                            pagination: {
                                more: ((data.page.number + 1) * data.page.size) < data.page.totalElements
                            }
                        };
                    },
                    cache: true
                },
                templateSelection: function (data) {
                    return data.title || data.text;
                },
                templateResult: function (data) {
                    return data.title;
                }
            });
        });
    </script>
</#macro>

<#macro select2enum path url selected=[] attributes="">
    <@spring.bind path/>
    <#assign replacedPath = path?replace(".", "-") />
    <#assign selectId = "select-id-${replacedPath}" />
    <div class="form-group">
        <@label path attributes?contains("required")/>
        <div class="col-sm-9">
            <select id="${selectId}" name="${spring.status.expression}" ${attributes}>
                <#if selected?? && selected?hasContent>
                    <option value="${selected.getSelectorId()}"
                            selected="selected">${selected.getSelectorTitle()}</option>
                </#if>
            </select>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>

    <script type="application/javascript">
        $(function () {
            $("#${selectId}").select2({
                width: "100%",
                minimumResultsForSearch: -1,
                ajax: {
                    url: "${url}",
                    dataType: 'json',
                    delay: 250,
                    data: function (params) {
                        console.log(params);
                    },
                    processResults: function (data, params) {
                        return {
                            results: data
                        };
                    },
                    cache: true
                },
                templateSelection: function (data) {
                    return data.title || data.text;
                },
                templateResult: function (data) {
                    return data.title;
                }
            });
        });
    </script>
</#macro>

<#macro select2Multiple path url selected=[] required=false showLabel=true>
    <@spring.bind path/>
    <#assign replacedPath = path?replace(".", "-") />
    <#assign selectId = "select-id-${replacedPath}" />
    <#assign varId = path?replace(".", "") />
    <div class="form-group row">
        <label class="col-sm-3 col-form-label"><@spring.message path/></label>
        <div class="col-sm-9">
            <select id="${selectId}" multiple="multiple"
                    name="${spring.status.expression}" ${required?then("required","")}>
                <#if selected?? && selected?hasContent>
                    <#list selected as selectedItem>
                        <option value="${selectedItem.getSelectorId()}"
                                selected="selected">
                            <@spring.message selectedItem.getSelectorTitle()/>
                        </option>
                    </#list>
                </#if>
            </select>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>

    <script type="application/javascript">
        var select2${varId} = "${url}";
        $(function () {
            $("#${selectId}").select2({
                width: "100%",
                placeholder: "<@spring.message path/>",
                ajax: {
                    url: function () {
                        <#--console.log(select2${varId});-->
                        return select2${varId};
                    },
                    dataType: 'json',
                    delay: 250,
                    data: function (params) {
                        return {
                            q: params.term, // search term
                            page: params.page ? params.page - 1 : params.page
                        };
                    },
                    processResults: function (data, params) {
                        // console.log(data);
                        return {
                            results: data._embedded.data,
                            pagination: {
                                more: ((data.page.number + 1) * data.page.size) < data.page.totalElements
                            }
                        };
                    },
                    cache: true
                },
                templateSelection: function (data) {
                    // console.log(data);
                    return data.selectorTitle || data.title || data.text;
                },
                templateResult: function (data) {
                    // console.log(data);
                    return data.selectorTitle || data.title;
                }
            });
        });
    </script>
</#macro>

<#macro smallSelect2Multiple path url selected=[] required=false showLabel=true>
    <@spring.bind path/>
    <#assign replacedPath = path?replace(".", "-") />
    <#assign selectId = "select-id-${replacedPath}" />
    <#assign varId = path?replace(".", "") />
    <div class="form-group row">
        <label class="col-sm-4 col-form-label"><@spring.message path/></label>
        <div class="col-sm-8">
            <select id="${selectId}" multiple="multiple"
                    name="${spring.status.expression}" ${required?then("required","")}>
                <#if selected?? && selected?hasContent>
                    <#list selected as selectedItem>
                        <option value="${selectedItem.getSelectorId()}"
                                selected="selected">
                            <@spring.message selectedItem.getSelectorTitle()/>
                        </option>
                    </#list>
                </#if>
            </select>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>

    <script type="application/javascript">
        var select2${varId} = "${url}";
        $(function () {
            $("#${selectId}").select2({
                width: "100%",
                placeholder: "<@spring.message path/>",
                ajax: {
                    url: function () {
                        <#--console.log(select2${varId});-->
                        return select2${varId};
                    },
                    dataType: 'json',
                    delay: 250,
                    data: function (params) {
                        return {
                            q: params.term, // search term
                            page: params.page ? params.page - 1 : params.page
                        };
                    },
                    processResults: function (data, params) {
                        // console.log(data);
                        return {
                            results: data._embedded.data,
                            pagination: {
                                more: ((data.page.number + 1) * data.page.size) < data.page.totalElements
                            }
                        };
                    },
                    cache: true
                },
                templateSelection: function (data) {
                    // console.log(data);
                    return data.selectorTitle || data.title || data.text;
                },
                templateResult: function (data) {
                    // console.log(data);
                    return data.selectorTitle || data.title;
                }
            });
        });
    </script>
</#macro>

<#macro imagePicker path imageData="" required=false>
    <#assign attr = 'class="file-styled-primary"'/>
    <#assign attr = attr + 'accept=".png,.jpeg,.jpg"'/>
    <#if imageData?? && imageData?hasContent>
        <br/>
        <br/>
        <div style="text-align: center">
            <@fullImage imageData/>
        </div>
        <br/>
        <br/>
    </#if>
    <div class="form-group">
        <label class="control-label col-lg-3">
            <@spring.message path/>
            <#if required>
                <span class="text-danger">*</span>
            </#if>
        </label>
        <div class="col-lg-9">
            <@spring.formInput path attr "file"/>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>
    <script type="text/javascript">
        $(function () {
            $(".file-styled-primary").uniform({
                fileButtonClass: 'action btn bg-blue'
            });
        });
    </script>
</#macro>

<#macro submitForm action="">
    <form method="post" action="${action}">
        <#nested/>
        <button type="submit" class="btn btn-primary mt-2"><@spring.message "form.submit"/></button>
    </form>
</#macro>

<#macro submitResetForm action="" reset="">
    <form method="post" action="${action}">
        <#nested/>
        <div class="row col-lg-12 justify-content-center">
            <button type="submit"
                    class="btn btn-primary col-lg-5 mt-2 float-left"><@spring.message "form.submit"/></button>
            <a class="btn btn-danger mt-2 ml-3 col-lg-5 float-right"
               href=${reset} role="button"><@spring.message "button.reset" /></a>
        </div>
    </form>
</#macro>

<#macro textField path type="text" placeholder="" required=false attributes="">
    <#assign attr = 'class="form-control" '/>
    <#assign attr = attr + (placeholder?hasContent)?then(' placeholder="' + placeholder + '"', "")/>
    <#assign attr = attr + (placeholder?hasContent)?then(' placeholder="' + placeholder + '"', "")/>
    <#assign attr = attr + " " + attributes/>

    <div class="form-group row">
        <label class="col-sm-3 col-form-label"><@spring.message path/></label>
        <div class="col-sm-9">
            <@spring.formInput path attr type/>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>
</#macro>

<#macro passwordField path type="text" placeholder="" required=false>
    <#assign attr = 'class="form-control" '/>
    <#assign attr = attr + (placeholder?hasContent)?then(' placeholder="' + placeholder + '"', "")/>
    <#assign attr = attr + (required)?then(' required="required"', "")/>

    <div class="form-group row">
        <label class="col-sm-3 col-form-label"><@spring.message path/></label>
        <div class="col-sm-9">
            <@spring.bind path/>
            <input type="password" id="${spring.status.expression?replace('[','')?replace(']','')}"
                   name="${spring.status.expression}" value="${spring.stringStatusValue}" ${attr} />
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>
</#macro>

<#macro avatarUpload path imageId>
    <#assign attr = 'hidden '/>
    <#assign attr = attr + 'accept=".png,.jpeg,.jpg"'/>
    <#assign avatarId = path?split(".")[1] />
    <form method="post" enctype="multipart/form-data" action="/user/avatar/upload">
        <div class="mt-3">
            <div class="btn btn-primary mt-2 btn-block" role="button" aria-pressed="true">
                <label class="mb-0">
                    <#--                    <@spring.message "append"/>-->
                    <@spring.formInput path attr "file"/>
                </label>
                <@spring.showErrors "" "validation-error-label" />
            </div>
            <div class="text-right mt-2">
                <button type="submit" class="btn btn-warning mt-2 btn-block" role="button"
                        aria-pressed="true"><@spring.message "load"/></button>
            </div>
        </div>
    </form>
    <script>
        $(document).ready(function () {
            $("#${avatarId}").change(function () {
                if (!(this.files && this.files[0]))
                    return;

                var reader = new FileReader();
                reader.onload = function (e) {
                    $('#${imageId}').attr('src', e.target.result);

                };

                reader.readAsDataURL(this.files[0]);
            });
        });
    </script>
</#macro>

<#macro select path options>
    <@spring.bind path/>
    <#assign replacedPath = path?replace(".", "-") />
    <#assign selectId = "select-id-${replacedPath}" />
    <div class="form-group row">
        <@label path/>
        <div class="col-sm-9">
            <select id="${selectId}" class="select" name="${spring.status.expression}">
                <option></option>
                <#list options as option>
                    <#assign selected = (spring.stringStatusValue?hasContent && spring.stringStatusValue = option)?then("selected", "")/>
                    <option ${selected} value="${option}">${option}</option>
                </#list>
            </select>
            <@spring.showErrors "" "validation-error-label" />
        </div>
    </div>

</#macro>