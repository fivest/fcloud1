define("/public/js/pic/jquery.validate.js", [], function (e, t, n) {
    try {
        (function (e) {
            e.extend(e.fn, {
                validate: function (t) {
                    if (!this.length) {
                        t && t.debug && window.console && console.warn("Nothing selected, can't validate, returning nothing.");
                        return;
                    }
                    var n = e.data(this[0], "validator");
                    return n ? n : (this.attr("novalidate", "novalidate"), n = new e.validator(t, this[0]), e.data(this[0], "validator", n), n.settings.onsubmit && (this.validateDelegate(":submit", "click", function (t) {
                        n.settings.submitHandler && (n.submitButton = t.target), e(t.target).hasClass("cancel") && (n.cancelSubmit = !0), e(t.target).attr("formnovalidate") !== undefined && (n.cancelSubmit = !0);
                    }), this.submit(function (t) {
                        function r() {
                            var r;
                            return n.settings.submitHandler ? (n.submitButton && (r = e("<input type='hidden'/>").attr("name", n.submitButton.name).val(e(n.submitButton).val()).appendTo(n.currentForm)), n.settings.submitHandler.call(n, n.currentForm, t), n.submitButton && r.remove(), !1) : !0;
                        }

                        return n.settings.debug && t.preventDefault(), n.cancelSubmit ? (n.cancelSubmit = !1, r()) : n.form() ? n.pendingRequest ? (n.formSubmitted = !0, !1) : r() : (n.focusInvalid(), !1);
                    })), n);
                },
                valid: function () {
                    if (e(this[0]).is("form")) return this.validate().form();
                    var t = !0, n = e(this[0].form).validate();
                    return this.each(function () {
                        t = t && n.element(this);
                    }), t;
                },
                removeAttrs: function (t) {
                    var n = {}, r = this;
                    return e.each(t.split(/\s/), function (e, t) {
                        n[t] = r.attr(t), r.removeAttr(t);
                    }), n;
                },
                rules: function (t, n) {
                    var r = this[0];
                    if (t) {
                        var i = e.data(r.form, "validator").settings, s = i.rules, o = e.validator.staticRules(r);
                        switch (t) {
                            case "add":
                                e.extend(o, e.validator.normalizeRule(n)), delete o.messages, s[r.name] = o, n.messages && (i.messages[r.name] = e.extend(i.messages[r.name], n.messages));
                                break;
                            case "remove":
                                if (!n) return delete s[r.name], o;
                                var u = {};
                                return e.each(n.split(/\s/), function (e, t) {
                                    u[t] = o[t], delete o[t];
                                }), u;
                        }
                    }
                    var a = e.validator.normalizeRules(e.extend({}, e.validator.classRules(r), e.validator.attributeRules(r), e.validator.dataRules(r), e.validator.staticRules(r)), r);
                    if (a.required) {
                        var f = a.required;
                        delete a.required, a = e.extend({
                            required: f
                        }, a);
                    }
                    return a;
                }
            }), e.extend(e.expr[":"], {
                blank: function (t) {
                    return !e.trim("" + e(t).val());
                },
                filled: function (t) {
                    return !!e.trim("" + e(t).val());
                },
                unchecked: function (t) {
                    return !e(t).prop("checked");
                }
            }), e.validator = function (t, n) {
                this.settings = e.extend(!0, {}, e.validator.defaults, t), this.currentForm = n, this.init();
            }, e.validator.format = function (t, n) {
                return arguments.length === 1 ? function () {
                    var n = e.makeArray(arguments);
                    return n.unshift(t), e.validator.format.apply(this, n);
                } : (arguments.length > 2 && n.constructor !== Array && (n = e.makeArray(arguments).slice(1)), n.constructor !== Array && (n = [ n ]), e.each(n, function (e, n) {
                    t = t.replace(new RegExp("\\{" + e + "\\}", "g"), function () {
                        return n;
                    });
                }), t);
            }, e.extend(e.validator, {
                defaults: {
                    messages: {},
                    groups: {},
                    rules: {},
                    errorClass: "error",
                    validClass: "valid",
                    errorElement: "label",
                    focusInvalid: !0,
                    errorContainer: e([]),
                    errorLabelContainer: e([]),
                    onsubmit: !0,
                    ignore: ":hidden",
                    ignoreTitle: !1,
                    onfocusin: function (e, t) {
                        this.lastActive = e, this.settings.focusCleanup && !this.blockFocusCleanup && (this.settings.unhighlight && this.settings.unhighlight.call(this, e, this.settings.errorClass, this.settings.validClass), this.addWrapper(this.errorsFor(e)).hide());
                    },
                    onfocusout: function (t, n) {
                        e(t).valid();
                    },
                    onkeyup: function (e, t) {
                        if (t.which === 9 && this.elementValue(e) === "") return;
                        (e.name in this.submitted || e === this.lastElement) && this.element(e);
                    },
                    onclick: function (e, t) {
                        e.name in this.submitted ? this.element(e) : e.parentNode.name in this.submitted && this.element(e.parentNode);
                    },
                    highlight: function (t, n, r) {
                        t.type === "radio" ? this.findByName(t.name).addClass(n).removeClass(r) : e(t).addClass(n).removeClass(r);
                    },
                    unhighlight: function (t, n, r) {
                        t.type === "radio" ? this.findByName(t.name).removeClass(n).addClass(r) : e(t).removeClass(n).addClass(r);
                    }
                },
                setDefaults: function (t) {
                    e.extend(e.validator.defaults, t);
                },
                messages: {
                    required: "This field is required.",
                    remote: "Please fix this field.",
                    email: "Please enter a valid email address.",
                    url: "Please enter a valid URL.",
                    date: "Please enter a valid date.",
                    dateISO: "Please enter a valid date (ISO).",
                    number: "Please enter a valid number.",
                    digits: "Please enter only digits.",
                    creditcard: "Please enter a valid credit card number.",
                    equalTo: "Please enter the same value again.",
                    maxlength: e.validator.format("Please enter no more than {0} characters."),
                    minlength: e.validator.format("Please enter at least {0} characters."),
                    rangelength: e.validator.format("Please enter a value between {0} and {1} characters long."),
                    range: e.validator.format("Please enter a value between {0} and {1}."),
                    max: e.validator.format("Please enter a value less than or equal to {0}."),
                    min: e.validator.format("Please enter a value greater than or equal to {0}.")
                },
                autoCreateRanges: !1,
                prototype: {
                    init: function () {
                        function t(t) {
                            var n = e.data(this[0].form, "validator"), r = "on" + t.type.replace(/^validate/, "");
                            n.settings[r] && n.settings[r].call(n, this[0], t);
                        }

                        this.labelContainer = e(this.settings.errorLabelContainer), this.errorContext = this.labelContainer.length && this.labelContainer || e(this.currentForm), this.containers = e(this.settings.errorContainer).add(this.settings.errorLabelContainer), this.submitted = {}, this.valueCache = {}, this.pendingRequest = 0, this.pending = {}, this.invalid = {}, this.reset();
                        var n = this.groups = {};
                        e.each(this.settings.groups, function (t, r) {
                            typeof r == "string" && (r = r.split(/\s/)), e.each(r, function (e, r) {
                                n[r] = t;
                            });
                        });
                        var r = this.settings.rules;
                        e.each(r, function (t, n) {
                            r[t] = e.validator.normalizeRule(n);
                        }), e(this.currentForm).validateDelegate(":text, [type='password'], [type='file'], select, textarea, [type='number'], [type='search'] ,[type='tel'], [type='url'], [type='email'], [type='datetime'], [type='date'], [type='month'], [type='week'], [type='time'], [type='datetime-local'], [type='range'], [type='color'] ", "focusin focusout keyup", t).validateDelegate("[type='radio'], [type='checkbox'], select, option", "click", t), this.settings.invalidHandler && e(this.currentForm).bind("invalid-form.validate", this.settings.invalidHandler);
                    },
                    form: function () {
                        return this.checkForm(), e.extend(this.submitted, this.errorMap), this.invalid = e.extend({}, this.errorMap), this.valid() || e(this.currentForm).triggerHandler("invalid-form", [ this ]), this.showErrors(), this.valid();
                    },
                    checkForm: function () {
                        this.prepareForm();
                        for (var e = 0, t = this.currentElements = this.elements(); t[e]; e++) this.check(t[e]);
                        return this.valid();
                    },
                    element: function (t) {
                        t = this.validationTargetFor(this.clean(t)), this.lastElement = t, this.prepareElement(t), this.currentElements = e(t);
                        var n = this.check(t) !== !1;
                        return n ? delete this.invalid[t.name] : this.invalid[t.name] = !0, this.numberOfInvalids() || (this.toHide = this.toHide.add(this.containers)), this.showErrors(), n;
                    },
                    showErrors: function (t) {
                        if (t) {
                            e.extend(this.errorMap, t), this.errorList = [];
                            for (var n in t) this.errorList.push({
                                message: t[n],
                                element: this.findByName(n)[0]
                            });
                            this.successList = e.grep(this.successList, function (e) {
                                return !(e.name in t);
                            });
                        }
                        this.settings.showErrors ? this.settings.showErrors.call(this, this.errorMap, this.errorList) : this.defaultShowErrors();
                    },
                    resetForm: function () {
                        e.fn.resetForm && e(this.currentForm).resetForm(), this.submitted = {}, this.lastElement = null, this.prepareForm(), this.hideErrors(), this.elements().removeClass(this.settings.errorClass).removeData("previousValue");
                    },
                    numberOfInvalids: function () {
                        return this.objectLength(this.invalid);
                    },
                    objectLength: function (e) {
                        var t = 0;
                        for (var n in e) t++;
                        return t;
                    },
                    hideErrors: function () {
                        this.addWrapper(this.toHide).hide();
                    },
                    valid: function () {
                        return this.size() === 0;
                    },
                    size: function () {
                        return this.errorList.length;
                    },
                    focusInvalid: function () {
                        if (this.settings.focusInvalid) try {
                            e(this.findLastActive() || this.errorList.length && this.errorList[0].element || []).filter(":visible").focus().trigger("focusin");
                        } catch (t) {
                        }
                    },
                    findLastActive: function () {
                        var t = this.lastActive;
                        return t && e.grep(this.errorList,function (e) {
                            return e.element.name === t.name;
                        }).length === 1 && t;
                    },
                    elements: function () {
                        var t = this, n = {};
                        return e(this.currentForm).find("input, select, textarea").not(":submit, :reset, :image, [disabled]").not(this.settings.ignore).filter(function () {
                            return !this.name && t.settings.debug && window.console && console.error("%o has no name assigned", this), this.name in n || !t.objectLength(e(this).rules()) ? !1 : (n[this.name] = !0, !0);
                        });
                    },
                    clean: function (t) {
                        return e(t)[0];
                    },
                    errors: function () {
                        var t = this.settings.errorClass.replace(" ", ".");
                        return e(this.settings.errorElement + "." + t, this.errorContext);
                    },
                    reset: function () {
                        this.successList = [], this.errorList = [], this.errorMap = {}, this.toShow = e([]), this.toHide = e([]), this.currentElements = e([]);
                    },
                    prepareForm: function () {
                        this.reset(), this.toHide = this.errors().add(this.containers);
                    },
                    prepareElement: function (e) {
                        this.reset(), this.toHide = this.errorsFor(e);
                    },
                    elementValue: function (t) {
                        var n = e(t).attr("type"), r = e(t).val();
                        return n === "radio" || n === "checkbox" ? e("input[name='" + e(t).attr("name") + "']:checked").val() : typeof r == "string" ? r.replace(/\r/g, "") : r;
                    },
                    check: function (t) {
                        t = this.validationTargetFor(this.clean(t));
                        var n = e(t).rules(), r = !1, i = this.elementValue(t), s;
                        for (var o in n) {
                            var u = {
                                method: o,
                                parameters: n[o]
                            };
                            try {
                                s = e.validator.methods[o].call(this, i, t, u.parameters);
                                if (s === "dependency-mismatch") {
                                    r = !0;
                                    continue;
                                }
                                r = !1;
                                if (s === "pending") {
                                    this.toHide = this.toHide.not(this.errorsFor(t));
                                    return;
                                }
                                if (!s) return this.formatAndAdd(t, u), !1;
                            } catch (a) {
                                throw this.settings.debug && window.console && console.log("Exception occurred when checking element " + t.id + ", check the '" + u.method + "' method.", a), a;
                            }
                        }
                        if (r) return;
                        return this.objectLength(n) && this.successList.push(t), !0;
                    },
                    customDataMessage: function (t, n) {
                        return e(t).data("msg-" + n.toLowerCase()) || t.attributes && e(t).attr("data-msg-" + n.toLowerCase());
                    },
                    customMessage: function (e, t) {
                        var n = this.settings.messages[e];
                        return n && (n.constructor === String ? n : n[t]);
                    },
                    findDefined: function () {
                        for (var e = 0; e < arguments.length; e++) if (arguments[e] !== undefined) return arguments[e];
                        return undefined;
                    },
                    defaultMessage: function (t, n) {
                        return this.findDefined(this.customMessage(t.name, n), this.customDataMessage(t, n), !this.settings.ignoreTitle && t.title || undefined, e.validator.messages[n], "<strong>Warning: No message defined for " + t.name + "</strong>");
                    },
                    formatAndAdd: function (t, n) {
                        var r = this.defaultMessage(t, n.method), i = /\$?\{(\d+)\}/g;
                        typeof r == "function" ? r = r.call(this, n.parameters, t) : i.test(r) && (r = e.validator.format(r.replace(i, "{$1}"), n.parameters)), this.errorList.push({
                            message: r,
                            element: t
                        }), this.errorMap[t.name] = r, this.submitted[t.name] = r;
                    },
                    addWrapper: function (e) {
                        return this.settings.wrapper && (e = e.add(e.parent(this.settings.wrapper))), e;
                    },
                    defaultShowErrors: function () {
                        var e, t;
                        for (e = 0; this.errorList[e]; e++) {
                            var n = this.errorList[e];
                            this.settings.highlight && this.settings.highlight.call(this, n.element, this.settings.errorClass, this.settings.validClass), this.showLabel(n.element, n.message);
                        }
                        this.errorList.length && (this.toShow = this.toShow.add(this.containers));
                        if (this.settings.success) for (e = 0; this.successList[e]; e++) this.showLabel(this.successList[e]);
                        if (this.settings.unhighlight) for (e = 0, t = this.validElements(); t[e]; e++) this.settings.unhighlight.call(this, t[e], this.settings.errorClass, this.settings.validClass);
                        this.toHide = this.toHide.not(this.toShow), this.hideErrors(), this.addWrapper(this.toShow).show();
                    },
                    validElements: function () {
                        return this.currentElements.not(this.invalidElements());
                    },
                    invalidElements: function () {
                        return e(this.errorList).map(function () {
                            return this.element;
                        });
                    },
                    showLabel: function (t, n) {
                        var r = this.errorsFor(t);
                        r.length ? (r.removeClass(this.settings.validClass).addClass(this.settings.errorClass), r.html(n)) : (r = e("<" + this.settings.errorElement + ">").attr("for", this.idOrName(t)).addClass(this.settings.errorClass).html(n || ""), this.settings.wrapper && (r = r.hide().show().wrap("<" + this.settings.wrapper + " class='frm_msg fail'/>").parent().prepend("<i>●</i>")), this.labelContainer.append(r).length || (this.settings.errorPlacement ? this.settings.errorPlacement(r, e(t)) : r.insertAfter(t))), !n && this.settings.success && (r.text(""), typeof this.settings.success == "string" ? r.addClass(this.settings.success) : this.settings.success(r, t)), this.toShow = this.toShow.add(r);
                    },
                    errorsFor: function (t) {
                        var n = this.idOrName(t);
                        return this.errors().filter(function () {
                            return e(this).attr("for") === n;
                        });
                    },
                    idOrName: function (e) {
                        return this.groups[e.name] || (this.checkable(e) ? e.name : e.id || e.name);
                    },
                    validationTargetFor: function (e) {
                        return this.checkable(e) && (e = this.findByName(e.name).not(this.settings.ignore)[0]), e;
                    },
                    checkable: function (e) {
                        return /radio|checkbox/i.test(e.type);
                    },
                    findByName: function (t) {
                        return e(this.currentForm).find("[name='" + t + "']");
                    },
                    getLength: function (t, n) {
                        switch (n.nodeName.toLowerCase()) {
                            case "select":
                                return e("option:selected", n).length;
                            case "input":
                                if (this.checkable(n)) return this.findByName(n.name).filter(":checked").length;
                        }
                        return t.length;
                    },
                    depend: function (e, t) {
                        return this.dependTypes[typeof e] ? this.dependTypes[typeof e](e, t) : !0;
                    },
                    dependTypes: {
                        "boolean": function (e, t) {
                            return e;
                        },
                        string: function (t, n) {
                            return !!e(t, n.form).length;
                        },
                        "function": function (e, t) {
                            return e(t);
                        }
                    },
                    optional: function (t) {
                        var n = this.elementValue(t);
                        return !e.validator.methods.required.call(this, n, t) && "dependency-mismatch";
                    },
                    startRequest: function (e) {
                        this.pending[e.name] || (this.pendingRequest++, this.pending[e.name] = !0);
                    },
                    stopRequest: function (t, n) {
                        this.pendingRequest--, this.pendingRequest < 0 && (this.pendingRequest = 0), delete this.pending[t.name], n && this.pendingRequest === 0 && this.formSubmitted && this.form() ? (e(this.currentForm).submit(), this.formSubmitted = !1) : !n && this.pendingRequest === 0 && this.formSubmitted && (e(this.currentForm).triggerHandler("invalid-form", [ this ]), this.formSubmitted = !1);
                    },
                    previousValue: function (t) {
                        return e.data(t, "previousValue") || e.data(t, "previousValue", {
                            old: null,
                            valid: !0,
                            message: this.defaultMessage(t, "remote")
                        });
                    }
                },
                classRuleSettings: {
                    required: {
                        required: !0
                    },
                    email: {
                        email: !0
                    },
                    url: {
                        url: !0
                    },
                    date: {
                        date: !0
                    },
                    dateISO: {
                        dateISO: !0
                    },
                    number: {
                        number: !0
                    },
                    digits: {
                        digits: !0
                    },
                    creditcard: {
                        creditcard: !0
                    }
                },
                addClassRules: function (t, n) {
                    t.constructor === String ? this.classRuleSettings[t] = n : e.extend(this.classRuleSettings, t);
                },
                classRules: function (t) {
                    var n = {}, r = e(t).attr("class");
                    return r && e.each(r.split(" "), function () {
                        this in e.validator.classRuleSettings && e.extend(n, e.validator.classRuleSettings[this]);
                    }), n;
                },
                attributeRules: function (t) {
                    var n = {}, r = e(t), i = r[0].getAttribute("type");
                    for (var s in e.validator.methods) {
                        var o;
                        s === "required" ? (o = r.get(0).getAttribute(s), o === "" && (o = !0), o = !!o) : o = r.attr(s), /min|max/.test(s) && (i === null || /number|range|text/.test(i)) && (o = Number(o)), o ? n[s] = o : i === s && i !== "range" && (n[s] = !0);
                    }
                    return n.maxlength && /-1|2147483647|524288/.test(n.maxlength) && delete n.maxlength, n;
                },
                dataRules: function (t) {
                    var n, r, i = {}, s = e(t);
                    for (n in e.validator.methods) r = s.data("rule-" + n.toLowerCase()), r !== undefined && (i[n] = r);
                    return i;
                },
                staticRules: function (t) {
                    var n = {}, r = e.data(t.form, "validator");
                    return r.settings.rules && (n = e.validator.normalizeRule(r.settings.rules[t.name]) || {}), n;
                },
                normalizeRules: function (t, n) {
                    return e.each(t, function (r, i) {
                        if (i === !1) {
                            delete t[r];
                            return;
                        }
                        if (i.param || i.depends) {
                            var s = !0;
                            switch (typeof i.depends) {
                                case "string":
                                    s = !!e(i.depends, n.form).length;
                                    break;
                                case "function":
                                    s = i.depends.call(n, n);
                            }
                            s ? t[r] = i.param !== undefined ? i.param : !0 : delete t[r];
                        }
                    }), e.each(t, function (r, i) {
                        t[r] = e.isFunction(i) ? i(n) : i;
                    }), e.each([ "minlength", "maxlength" ], function () {
                        t[this] && (t[this] = Number(t[this]));
                    }), e.each([ "rangelength", "range" ], function () {
                        var n;
                        t[this] && (e.isArray(t[this]) ? t[this] = [ Number(t[this][0]), Number(t[this][1]) ] : typeof t[this] == "string" && (n = t[this].split(/[\s,]+/), t[this] = [ Number(n[0]), Number(n[1]) ]));
                    }), e.validator.autoCreateRanges && (t.min && t.max && (t.range = [ t.min, t.max ], delete t.min, delete t.max), t.minlength && t.maxlength && (t.rangelength = [ t.minlength, t.maxlength ], delete t.minlength, delete t.maxlength)), t;
                },
                normalizeRule: function (t) {
                    if (typeof t == "string") {
                        var n = {};
                        e.each(t.split(/\s/), function () {
                            n[this] = !0;
                        }), t = n;
                    }
                    return t;
                },
                addMethod: function (t, n, r) {
                    e.validator.methods[t] = n, e.validator.messages[t] = r !== undefined ? r : e.validator.messages[t], n.length < 3 && e.validator.addClassRules(t, e.validator.normalizeRule(t));
                },
                methods: {
                    required: function (t, n, r) {
                        if (!this.depend(r, n)) return "dependency-mismatch";
                        if (n.nodeName.toLowerCase() === "select") {
                            var i = e(n).val();
                            return i && i.length > 0;
                        }
                        return this.checkable(n) ? this.getLength(t, n) > 0 : e.trim(t).length > 0;
                    },
                    email: function (e, t) {
                        return this.optional(t) || /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))$/i.test(e);
                    },
                    url: function (e, t) {
                        return this.optional(t) || /^(https?|s?ftp|weixin):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(e);
                    },
                    date: function (e, t) {
                        return this.optional(t) || !/Invalid|NaN/.test((new Date(e)).toString());
                    },
                    dateISO: function (e, t) {
                        return this.optional(t) || /^\d{4}[\/\-]\d{1,2}[\/\-]\d{1,2}$/.test(e);
                    },
                    number: function (e, t) {
                        return this.optional(t) || /^-?(?:\d+|\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/.test(e);
                    },
                    digits: function (e, t) {
                        return this.optional(t) || /^\d+$/.test(e);
                    },
                    creditcard: function (e, t) {
                        if (this.optional(t)) return "dependency-mismatch";
                        if (/[^0-9 \-]+/.test(e)) return !1;
                        var n = 0, r = 0, i = !1;
                        e = e.replace(/\D/g, "");
                        for (var s = e.length - 1; s >= 0; s--) {
                            var o = e.charAt(s);
                            r = parseInt(o, 10), i && (r *= 2) > 9 && (r -= 9), n += r, i = !i;
                        }
                        return n % 10 === 0;
                    },
                    minlength: function (t, n, r) {
                        var i = e.isArray(t) ? t.length : this.getLength(e.trim(t), n);
                        return this.optional(n) || i >= r;
                    },
                    maxlength: function (t, n, r) {
                        var i = e.isArray(t) ? t.length : this.getLength(e.trim(t), n);
                        return this.optional(n) || i <= r;
                    },
                    rangelength: function (t, n, r) {
                        var i = e.isArray(t) ? t.length : this.getLength(e.trim(t), n);
                        return this.optional(n) || i >= r[0] && i <= r[1];
                    },
                    min: function (e, t, n) {
                        return this.optional(t) || e >= n;
                    },
                    max: function (e, t, n) {
                        return this.optional(t) || e <= n;
                    },
                    range: function (e, t, n) {
                        return this.optional(t) || e >= n[0] && e <= n[1];
                    },
                    equalTo: function (t, n, r) {
                        var i = e(r);
                        return this.settings.onfocusout && i.unbind(".validate-equalTo").bind("blur.validate-equalTo", function () {
                            e(n).valid();
                        }), t === i.val();
                    },
                    remote: function (t, n, r) {
                        if (this.optional(n)) return "dependency-mismatch";
                        var i = this.previousValue(n);
                        this.settings.messages[n.name] || (this.settings.messages[n.name] = {}), i.originalMessage = this.settings.messages[n.name].remote, this.settings.messages[n.name].remote = i.message, r = typeof r == "string" && {
                            url: r
                        } || r;
                        if (i.old === t) return i.valid;
                        i.old = t;
                        var s = this;
                        this.startRequest(n);
                        var o = {};
                        return o[n.name] = t, e.ajax(e.extend(!0, {
                            url: r,
                            mode: "abort",
                            port: "validate" + n.name,
                            dataType: "json",
                            data: o,
                            success: function (r) {
                                s.settings.messages[n.name].remote = i.originalMessage;
                                var o = r === !0 || r === "true";
                                if (o) {
                                    var u = s.formSubmitted;
                                    s.prepareElement(n), s.formSubmitted = u, s.successList.push(n), delete s.invalid[n.name], s.showErrors();
                                } else {
                                    var a = {}, f = r || s.defaultMessage(n, "remote");
                                    a[n.name] = i.message = e.isFunction(f) ? f(t) : f, s.invalid[n.name] = !0, s.showErrors(a);
                                }
                                i.valid = o, s.stopRequest(n, o);
                            }
                        }, r)), "pending";
                    }
                }
            }), e.format = e.validator.format;
        })(jQuery), function (e) {
            var t = {};
            if (e.ajaxPrefilter) e.ajaxPrefilter(function (e, n, r) {
                var i = e.port;
                e.mode === "abort" && (t[i] && t[i].abort(), t[i] = r);
            }); else {
                var n = e.ajax;
                e.ajax = function (r) {
                    var i = ("mode" in r ? r : e.ajaxSettings).mode, s = ("port" in r ? r : e.ajaxSettings).port;
                    return i === "abort" ? (t[s] && t[s].abort(), t[s] = n.apply(this, arguments), t[s]) : n.apply(this, arguments);
                };
            }
        }(jQuery), function (e) {
            e.extend(e.fn, {
                validateDelegate: function (t, n, r) {
                    return this.bind(n, function (n) {
                        var i = e(n.target);
                        if (i.is(t)) return r.apply(i, arguments);
                    });
                }
            });
        }(jQuery), function (e) {
            e.validator.defaults.errorClass = "frm_msg_content", e.validator.defaults.errorElement = "span", e.validator.defaults.errorPlacement = function (e, t) {
                t.parent().after(e);
            }, e.validator.defaults.wrapper = "p", e.validator.messages = {
                required: "必选字段",
                remote: "请修正该字段",
                email: "请输入正确格式的电子邮件",
                url: "请输入合法的网址",
                date: "请输入合法的日期",
                dateISO: "请输入合法的日期 (ISO).",
                number: "请输入合法的数字",
                digits: "只能输入整数",
                creditcard: "请输入合法的信用卡号",
                equalTo: "请再次输入相同的值",
                accept: "请输入拥有合法后缀名的字符串",
                maxlength: e.validator.format("请输入一个长度最多是 {0} 的字符串"),
                minlength: e.validator.format("请输入一个长度最少是 {0} 的字符串"),
                rangelength: e.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
                range: e.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
                max: e.validator.format("请输入一个最大为 {0} 的值"),
                min: e.validator.format("请输入一个最小为 {0} 的值")
            }, function () {
                function t(e) {
                    var t = 0;
                    e[17].toLowerCase() == "x" && (e[17] = 10);
                    for (var n = 0; n < 17; n++) t += s[n] * e[n];
                    return valCodePosition = t % 11, e[17] == o[valCodePosition] ? !0 : !1;
                }

                function n(e) {
                    var t = e.substring(6, 10), n = e.substring(10, 12), r = e.substring(12, 14), i = new Date(t, parseFloat(n) - 1, parseFloat(r));
                    return (new Date).getFullYear() - parseInt(t) < 18 ? !1 : i.getFullYear() != parseFloat(t) || i.getMonth() != parseFloat(n) - 1 || i.getDate() != parseFloat(r) ? !1 : !0;
                }

                function r(e) {
                    var t = e.substring(6, 8), n = e.substring(8, 10), r = e.substring(10, 12), i = new Date(t, parseFloat(n) - 1, parseFloat(r));
                    return i.getYear() != parseFloat(t) || i.getMonth() != parseFloat(n) - 1 || i.getDate() != parseFloat(r) ? !1 : !0;
                }

                function i(r) {
                    r = e.trim(r.replace(/ /g, ""));
                    if (r.length == 15) return !1;
                    if (r.length == 18) {
                        var i = r.split("");
                        return n(r) && t(i) ? !0 : !1;
                    }
                    return !1;
                }

                var s = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ], o = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ];
                e.validator.addMethod("idcard", function (e, t, n) {
                    return i(e);
                }, "身份证格式不正确，或者年龄未满18周岁，请重新填写。"), e.validator.addMethod("mobile", function (t, n, r) {
                    return t = e.trim(t), /^1\d{10}$/.test(t);
                }, "请输入正确的手机号码"), e.validator.addMethod("byteRangeLength", function (e, t, n) {
                    return this.optional(t) || e.len() <= n[1] && e.len() >= n[0];
                }, "_(必须为{0}到{1}个字节之间)");
            }();
        }(jQuery);
        var r = {
            optional: function (e) {
                return !1;
            },
            getLength: function (e) {
                return e ? e.length : 0;
            }
        };

        function i(e, t, n) {
            return $.validator.methods[e].call(r, t, null, n);
        }

        var s = $.validator;
        return s.rules = {}, $.each(s.methods, function (e, t) {
            s.rules[e] = function (e, n) {
                return t.call(r, e, null, n);
            };
        }), s;
    } catch (o) {
        wx.jslog({
            src: "common/lib/jquery.validate.js"
        }, o);
    }
});
define("/public/js/pic/appmsg_edit.js", ["pic/first_appmsg.html.js","pic/store.js","pic/Class.js","pic/editor.html.js","pic/small_appmsg.html.js","/public/css/qqcss/appmsg_editor.css","pic/jquery.validate.js","pic/Tips.js"], function (e, t, n) {
    try {
        "use strict" , e("/public/css/qqcss/appmsg_editor.css");
        var r = wx.T, i = wx.cgiData, s = i.type, o = i.app_id, u = i.appmsg_data, h=e("public/js/pic/store.js"),l = e("public/js/pic/Class.js"),  x = e("public/js/pic/editor.html.js"),E=e("public/js/pic/first_appmsg.html.js"),g = e("/public/js/pic/jquery.validate.js"), y = g.rules, p = e("/public/js/pic/Tips.js"),b = e("common/wx/top.js"),
S=e("public/js/pic/small_appmsg.html.js");
        
        var T = "#appmsgItem", N = ".js_appmsg_item", C = "appmsg", k = {
            maxNum: 8
        }, L = l.declare({
            init: function (e, t, n) {
                var r = this;
                if (!r._supportUserData() && typeof localStorage == "undefined") return !1;
               r.isMul = e, r.app_id = t, r.draftId = "", r.timeKey = "Time" + r.draftId, r.appKey = "App" + r.draftId, r.isDropped = !1, !h.get(r.timeKey) || (r._showTips("已载入" + r._getSaveTime() + "的草稿"), $("#js_cancle").show());
            },
            _supportUserData: function () {
                try {
                    var e = document.createElement("input");
                    e.addBehavior("#default#userData");
                } catch (t) {
                    return !1;
                }
                return !0;
            },
            _getSaveTime: function () {
                return h.get(this.timeKey);
            },
            _showTips: function (e) {
                $("#js_auto_tips").html(e).show();
            },
            clear: function () {
                h.remove(this.timeKey), h.remove(this.appKey);
            },
            save: function (e) {
                var t = this;
               //t.clear(), h.set(t.timeKey, d().format("YYYY/MM/DD HH:mm:ss")), h.set(t.appKey, e), t._showTips("自动保存：" + h.get(t.timeKey)), $("#js_cancle").hide();
            },
            get: function () {
                var e = h.get(this.appKey);
                return e ? e : !1;
            }
        });

        function A(e) {
            var t = e && e.multi_item;
            if (!t) return !1;
           // t[0].create_time = f.getFullTime(e.create_time) || d().format("YYYY-MM-DD HH:mm:ss");
            for (var n = 0; n < t.length; ++n) for (var r in t[n]) t[n][r].html && (t[n][r] = t[n][r].html(!1));
            return t ? t : !1;
        }

        var O = l.declare({
            init: function (e) {
                var t = this;
                t.gid = 1, 
                $.extend(!0, t, k, e), 
                t.maxNum = t.isMul ? t.maxNum : 1, 
                t.editor$ = $(t.editor_selector).html(r(x, {
                    isMul: t.isMul,
                    type: s
                })), 
                t._initEditor(), 
                t.appmsg$ = $(t.appmsg_selector), 
                t.nowitem$ = null, 
               t.uploadImgItem$ = null, 
                t.isNew = !0, 
                t.isFirst = !0, 
                t.list = A(t.appmsg_data), 
                window.Draft = t.draft = new L(t.isMul, t.app_id, s);
                if (s == 10) {
                    var n = t.get_draft();
                    !n || (t.list = n);
                }
                if (!t.list) t.add(), t.isMul && t.add(); else {
                    var i = t.list;
                    for (var o = 0; o < i.length; ++o) t.add(i[o]);
                }
                t._refreshUI(0), t.appmsg$.on("click", ".js_edit", function () {
                    var e = $(this), n = e.data("id");
                    t._refreshUI($(T + n));
                }), t.appmsg$.on("click", ".js_del", function () {
                    var e = $(this), n = e.data("id");
                    t.remove($(T + n));
                }), t.isMul ? $("#js_add_appmsg").click(function () {
                    t.add();
                }) : $("#js_add_appmsg").addClass("dn"), s == 10 && (setInterval(function () {
                    t.auto_save();
                }, 12e4), window.onbeforeunload = function () {
//                    var e = !0, n = t._getEditData();
//                    for (var r in n) if (!!n[r]) {
//                        e = !1;
//                        break;
//                    }
//                    if (!e && !t.draft.isDropped) {
//                        t.auto_save();
//                        var i = h.get(t.draft.timeKey);
//                        return "已自动保存" + i + "时的内容。";
//                    }
//                    t.draft.clear();
                });
            },
            _initEditor: function () {
                var e = this, t = e.editor$;
                $(".js_title", t).keyup(function () {
                    var t = $.trim($(this).val());
                    e.nowitem$ && e.nowitem$.find(".appmsg_title a").html(t);
                }), $(".js_desc", t).keyup(function () {
                    var t = $.trim($(this).val());
                    e.nowitem$ && e.nowitem$.find(".appmsg_desc").html(t);
                }), $(".js_addURL", t).click(function () {
                    $(this).hide(), $(".js_url_area", t).show();
                }),
                e.isMul ? ($(".js_addDesc", t).hide(), $(".js_desc_area", t).hide()) : $(".js_addDesc", t).show().click(function () {
                    $(this).hide(), $(".js_desc_area", t).show();
                }), $(".js_removeCover", t).click(function () {
                	var file_id = $(".js_cover", t).data("file_id");
                	$.ajax({
                        type: "GET",
                        url: "/sys/att/deleteById",
                        data: {fileId:file_id,type:wx.cgiData.isMul},
                        dataType: "text",
                        success: function (data) {
                            $(".js_cover", t).data("file_id", !1).hide().find("img").remove(), e.nowitem$ && e.nowitem$.removeClass("has_thumb");
                        },
                        error: function (data) {

                        }})
                }),$("#js_appmsg_upload_cover",t).click(function(){
                	$("#uploadPic",t).click();
                	
                }),$(t).on("change","#uploadPic",function(){
            		var file_id = $(".js_cover", t).data("file_id");
            		$(".js_cover", t).data("file_id", !1).hide().find("img").remove(), e.nowitem$ && e.nowitem$.removeClass("has_thumb");
                	$.ajaxFileUpload({  
                        //处理文件上传操作的服务器端地址(可以传参数,已亲测可用) 
                        url:'/sys/att/fileUpload',  
                        secureuri:false,                           //是否启用安全提交,默认为false   
                        fileElementId:'uploadPic', 
                        data:{fileId:file_id},//文件选择框的id属性  
                        dataType:'json',                           //服务器返回的格式,可以是json或xml等  
                        success:function(data, status){            //服务器响应成功时的处理函数 
                        	var picUrl = data.picUrl;
                        	$(".js_cover", t).find("img").remove(), $(".js_cover", t).show().prepend('<img src="%s">'.sprintf(picUrl)).data("file_id", data.attId), !e.nowitem$ || (e.nowitem$.find("img.js_appmsg_thumb").attr("src", picUrl), e.nowitem$.addClass("has_thumb"));
                        	$("#uploadPic",t).replaceWith('<input type="file" name="fdPic" id="uploadPic"/>'); 
                        },  
                        error:function(data, status, e){ //服务器响应失败时的处理函数  
                            //$('#result').html('图片上传失败，请重试！！');  
                        	p.err("图片上传失败，请重试");
                        }  
                    });  
                	
                });
                if (s == 10) {
                    var n = new baidu.editor.ui.Editor({
                        wordCount: !1,
                        elementPathEnabled: !1,
                        customDomain: !0
                    });
                    n.render("js_editor"), e.ueditor = n;
                }
            },
            _getItem$: function (e) {
                var t = this, n = null;
                return $.isNumeric(e) ? n = t.appmsg$.find(N).eq(e) : n = $(e), n;
            },
            _getNextItem$: function (e) {
                var t = this, n = t.appmsg$.find(N), r = n.length;
                for (var i = 0; i < r; ++i) if (n.eq(i).data("id") == e.data("id")) break;
                return i < r ? (i = (i + 1) % r, n.eq(i)) : null;
            },
            _getItemIdx: function (e) {
                var t = this, n = t.appmsg$.find(N), r = n.length;
                for (var i = 0; i < r; ++i) if (n.eq(i).data("id") == e.data("id")) return i;
                return -1;
            },
            _getEditData: function () {
                var e = this.editor$, t = {};
                return t.title = $(".js_title", e).val().trim(), t.author = $(".js_author", e).val().trim(), t.file_id = $(".js_cover", e).data("file_id"), s == 10 ? t.source_url = $(".js_url", e).val().trim() : t.content_url = $(".js_url", e).val().trim(), t.digest = $(".js_desc", e).val().trim(), s == 10 && (t.content = this.ueditor.getContent(), this.isMul ? t.digest = t.content.text().html(!1).substr(0, 54) : t.digest = t.digest || t.content.text().html(!1).substr(0, 54)), t;
            },
            _fillEditArea: function (e) {
                var t = this, n = t.editor$;
                n.find(".js_cover_tip").html(e.isFirst ? "大图片建议尺寸：360像素 * 200像素" : "小图片建议尺寸：200像素 * 200像素"), $(".js_title", n).val(e.title), $(".js_author", n).val(e.author), $(".js_cover", n).find("img").remove();
                if (!e.file_id) $(".js_cover", n).data("file_id", !1).hide(); else {
                	var r = "http://"+window.location.host+"/sys/att/showPic?file_id=%s".sprintf(e.file_id);
                    $(".js_cover", n).show().prepend('<img src="%s">'.sprintf(r)).data("file_id", e.file_id);
                }
                $(".js_desc", n).val(e.digest), !t.isMul && s == 10 && (e.digest ? ($(".js_addDesc", n).hide(), $(".js_desc_area", n).show()) : ($(".js_addDesc", n).show(), $(".js_desc_area", n).hide())), s == 10 ? $(".js_url", n).val(e.source_url || "") : $(".js_url", n).val(e.content_url || ""), !e.source_url && s == 10 ? ($(".js_addURL", n).show(), $(".js_url_area", n).hide()) : ($(".js_addURL", n).hide(), $(".js_url_area", n).show()), s == 10 && t._setEditorContent(e.content);
            },
            _setEditorContent: function (t) {
                var n = this;
                n.ueditor.ready(function () {
                    n.ueditor.setContent(t || "");
                    if (!n.initZoomArea) {
                        var r = '<a id="%s" href="javascript:void(0);" onclick="return false;" class="%s">%s</a>';
                        $("#js_editor .edui-toolbar").append(r.sprintf("js_zoomout", "zoomout_edit_tips", "放大编辑") + r.sprintf("js_zoomin", "zoomin_edit_tips", "缩小编辑"));
                        var i = e("public/js/pic/mask.js"), s = $("#js_ueditor"), o = i.show({
                            parent: $("#js_appmsg_editor .appmsg_editor"),
                            spin: !1
                        });
                        o.hide(), $("#js_zoomout").click(function () {
                            s.addClass("zoom_edit").css({
                                marginTop: -(s.outerHeight() / 2),
                                marginLeft: -(s.outerWidth() / 2)
                            }), o.show();
                        });
                        var u = function () {
                            s.removeClass("zoom_edit").css({
                                marginTop: 0,
                                marginLeft: 0
                            }), o.hide();
                        };
                        $("#js_zoomin").click(function () {
                            u();
                        }), $("#js_finish_zoom,.jsClose").click(function () {
                            u();
                        }), n.initZoomArea = !0;
                    }
                });
            },
            _flush: function () {
                var e = this;
                !e.nowitem$ || e._setData(e.nowitem$, e._getEditData());
            },
            _refreshUI: function (e) {
                var t = this, n = t._getItem$(e), r = t._getData(n);
                if (!!t.nowitem$ && n.data("id") == t.nowitem$.data("id")) return;
                t._flush(), t.nowitem$ = n, function () {
                    e = t._getItemIdx(n);
                    var r = n.offset(), i = t.editor$.offset(), o = s == 10 ? 580 : 390, u = n.outerHeight(), a = t.appmsg$.offset(), f = r.top - a.top;
                    e >= t.maxNum / 2 ? (t.editor$.find(".arrow").css({
                        marginTop: o - u
                    }), t.editor$.find(".appmsg_editor").css({
                        marginTop: f + u - o
                    })) : (t.editor$.find(".arrow").css({
                        marginTop: 0
                    }), t.editor$.find(".appmsg_editor").css({
                        marginTop: e == 0 ? 0 : f
                    }));
                }(), t._fillEditArea(r);
            },
            _setData: function (e, t) {
                var n = this, r = n._getItem$(e);
                return r.data(C, t);
            },
            _getData: function (e) {
                var t = this, n = t._getItem$(e);
                return n.data(C);
            },
            _getDatalist: function () {
                this._flush();
                var e = this, t = [], n = e.appmsg$.find(N);
                for (var r = 0; r < n.length; ++r) t.push(e._getData(n[r]));
                return t;
            },
            _validate: function (e) {
                return e.title == "" ? !1 : e.content == "" ? !1 : e.app_id == "" ? !1 : !0;
            },
            _validateList: function (e) {
                var t = this;
                for (var n = 0; n < e.length; ++n) if (!t._validate(e[n])) return _refreshUI(n), !1;
                return !0;
            },
            _initData: function (e) {
                return !e.file_id || (e.cover), $.extend({
                    author: "",
                    file_id: "",
                    content: "",
                    content_url: "",
                    source_url: "",
                    digest: "",
                    title: "",
                    id:""
                }, e);
            },
            add: function (e) {
                var t = this, n = t._getDatalist().length, i = t.maxNum;
                if (t._getDatalist().length >= i) {
                    p.err("你最多只可以加入%s条图文消息".sprintf(i));
                    return;
                }
                var e = t._initData(e || {});
                e.id = t.gid++, e.isMul = t.isMul, e.isFirst = t.isFirst;
                var s = t.isFirst ? E : S, o = $(r(s, e).trim()).appendTo(t.appmsg$);
                t._setData(o, e), t.isFirst = !1;
            },
            remove: function (e) {
                var t = this, n = t._getDatalist().length;
                if (t.isMul && n <= 2) {
                    p.err("无法删除，多条图文至少需要%s条消息。".sprintf(2));
                    return;
                }
                var r = t._getItem$(e), i = t._getNextItem$(r);
                r.remove(), !i || t._refreshUI(i);
            },
            preview: function () {
                var e = this, t = e._getDatalist();
                if (!e._validateList(t)) return !1;
                appmsgCgi.preview(t, fakeID, function () {
                });
            },
            auto_save: function () {
                var e = this._getDatalist();
                return this.draft.save(e);
            },
            get_draft: function () {
                return this.draft.get();
            },
            _getItemDataAndValid: function (e, t) {
                var n = this, r = {};
                r["title" + t] = e.title, r["content" + t] = e.content, r["digest" + t] = e.digest, r["author" + t] = e.author, r["fileid" + t] = e.file_id;
                var i = /:\/\//, o = s == 10 ? e.source_url : e.content_url;
                !!o && !i.test(o) && (o = "http://" + o), s == 11 ? r["contenturl" + t] = o : r["sourceurl" + t] = o;
                if (!y.rangelength(e.title, [ 1, 64 ])) return p.err("标题不能为空且长度不能超过%s字".sprintf(64)), $(".js_title", this.editor$).focus(), null;
                if (!y.maxlength(e.author, 50)) return p.err("标签不能超过%s个字".sprintf(50)), $(".js_author", this.editor$).focus(), null;
                if (!e.file_id) return p.err("必须插入一张图片"), null;
                return s == 10 && !y.rangelength(e.content.text(), [ 1, 2e4 ]) ? (p.err("正文不能为空且长度不能超过%s字".sprintf(2e4)), null) : !n.isMul && !y.rangelength(e.digest, [ 1, 120 ]) ? (p.err("%s不能为空且长度不能超过%s字".sprintf(s == 10 ? "摘要" : "描述", 120)), $(".js_desc", this.editor$).focus(), null) : s != 11 && !o || !!y.url(o) ? s == 10 && !e.content.split("<iframe ").length > 2 ? (p.err("正文只能包含%s个视频".sprintf(1)), null) : r : (p.err("链接不合法"), $(".js_url", this.editor$).focus(), null);
            },
            getData: function () {
                var e = this, t = {}, n = e._getDatalist();
                t.AppMsgId = e.app_id, t.count = n.length;
                for (var r = 0; r < n.length; ++r) {
                    var i = n[r];
                    i = e._getItemDataAndValid(i, r);
                    if (!i) return e._refreshUI(r), null;
                    $.extend(t, i);
                }
                return t;
            }
        });
        O.formatData = A, function () {
            var t = "#js_appmsg_editor", n = "#js_appmsg_preview", r = new O({
                app_id: o,
                editor_selector: t,
                appmsg_selector: n,
                isMul: !!i.isMul,
                appmsg_data: u
            });
            $("#js_cancle").click(function () {
                return Draft.clear(), Draft.isDropped = !0, window.location.reload(), !1;
            }), $("#js_submit").click(function () {
                var e = r.getData();
                if (!e) return false;
                //处理数据
                var data = JSON.stringify(e).toString();
                $("#picitems").val(data);
                $("#js_submit").btn(!0);
//                $("#js_submit").btn(!1), c.appmsg.save(s, e, function (e) {
//                    Draft.clear(), Draft.isDropped = !0, location.href = wx.url("/cgi-bin/appmsg?begin=0&count=10&t=media/appmsg_list&type=%s&action=list".sprintf(s));
//                }, function () {
//                    $("#js_submit").btn(!0);
//                });
            });
            var a = h.get("appMsgPreviewName"), f = null, l = null, d = e("common/wx/verifycode.js");
            $("#js_preview").click(function () {
                var e = r.getData();
                if (!e) return;
                var t = $(template.compile(w)({
                    label: "请输入微信号，此图文消息将发送至该微信号预览。",
                    value: a
                })).popup({
                        title: "发送预览",
                        className: "simple",
                        onOK: function () {
                            var t = this, n = t.get(), i = n.find(".frm_input"), o = i.val().trim();
                            e.preusername = o, h.set("appMsgPreviewName", o || "");
                            if (!y.rangelength(o, [ 1, 20 ])) return p.err("微信号必须为1到20个字符"), i.focus(), !0;
                            if (f != null && f.getCode().trim().length <= 0) return p.err("请输入验证码"), f.focus(), !0;
                            var u = n.find(".btn_primary .js_btn").btn(!1);
                            return e.imgcode = f && f.getCode().trim(), c.appmsg.preview(s, e, function (e) {
                                r.app_id = e.appMsgId, u.btn(!0), t.hide();
                            }, function (e) {
                                u.btn(!0), i.focus(), e && e.ret == "-6" && (l = n.find(".js_verifycode"), f = l.html("").removeClass("dn").verifycode().data("verifycode"), f.focus());
                            }), !0;
                        }
                    });
                $(".frm_input", t).focus();
            });
        }();
    } catch (M) {
        alert(M);
//        wx.jslog({
//            src: "media/appmsg_edit.js"
//        }, M);
    }
});
define("/public/js/pic/Tips.js", [], function(e, t, n) {
    try {
        "use strict";
        var r = t, i = {
            errMsg: "系统发生错误，请稍后重试",
            sucMsg: "操作成功",
            delay: 2
        }, s;
        function o(e, t, n) {
            $(".JS_TIPS").remove(), s = $(template.compile('<div class="JS_TIPS page_tips {type}" id="wxTips_' + (new Date).getTime() + '"><div class="inner">{=msg}</div></div>')({
                type: e || "error",
                msg: t
            })).appendTo("body").fadeIn(), u.delay(n || i.delay, s);
        }
        function u(e) {
            e.length > 0 && e.fadeOut({
                complete: function() {
                    e.remove();
                }
            });
        }
        r.err = function(e, t) {
            o("error", e || i.errMsg, t);
        }, r.suc = function(e, t) {
            o("success", e || i.sucMsg, t);
        };
    } catch (a) {
        wx.jslog({
            src: "/public/js/pic/Tips.js"
        }, a);
    }
});