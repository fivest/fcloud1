define("tpl/dialog.html.js", [], function (e, t, n) {
    return '<div class="dialog_wrp" style="{if width}width:{width}px;{/if}{if height}height:{height}px;{/if};display:none;">\n  <div class="dialog" id="{id}">\n    <div class="dialog_hd">\n      <h3>{title}</h3>\n      <a href="javascript:;" class="pop_closed">关闭</a>\n    </div>\n    <div class="dialog_bd">\n      <div class="page_msg simple default {msg.msgClass}">\n        <div class="inner group">\n          <span class="msg_icon_wrapper"><i class="icon_msg {icon} "></i></span>\n          <div class="msg_content ">\n          {if msg.title}<h4>{=msg.title}</h4>{/if}\n          {if msg.text}<p>{=msg.text}</p>{/if}\n          </div>\n        </div>\n      </div>\n    </div> \n    <div class="dialog_ft">\n      {each buttons as bt index}\n      <a href="javascript:;" class="btn {bt.type} js_btn">{bt.text}</a>\n      {/each}\n    </div>\n  </div>\n</div>\n{if mask}<div class="mask"></div>{/if}\n\n';
});
define("common/lib/jquery.ui.draggable.js", [], function (e, t, n) {
    try {
        (function (e, t) {
            function n(t, n) {
                var i, s, o, u = t.nodeName.toLowerCase();
                return "area" === u ? (i = t.parentNode, s = i.name, !t.href || !s || i.nodeName.toLowerCase() !== "map" ? !1 : (o = e("img[usemap=#" + s + "]")[0], !!o && r(o))) : (/input|select|textarea|button|object/.test(u) ? !t.disabled : "a" === u ? t.href || n : n) && r(t);
            }

            function r(t) {
                return e.expr.filters.visible(t) && !e(t).parents().addBack().filter(function () {
                    return e.css(this, "visibility") === "hidden";
                }).length;
            }

            var i = 0, s = /^ui-id-\d+$/;
            e.ui = e.ui || {}, e.extend(e.ui, {
                version: "1.10.3"
            }), e.fn.extend({
                focus: function (t) {
                    return function (n, r) {
                        return typeof n == "number" ? this.each(function () {
                            var t = this;
                            setTimeout(function () {
                                e(t).focus(), r && r.call(t);
                            }, n);
                        }) : t.apply(this, arguments);
                    };
                }(e.fn.focus),
                scrollParent: function () {
                    var t;
                    return e.ui.ie && /(static|relative)/.test(this.css("position")) || /absolute/.test(this.css("position")) ? t = this.parents().filter(function () {
                        return /(relative|absolute|fixed)/.test(e.css(this, "position")) && /(auto|scroll)/.test(e.css(this, "overflow") + e.css(this, "overflow-y") + e.css(this, "overflow-x"));
                    }).eq(0) : t = this.parents().filter(function () {
                        return /(auto|scroll)/.test(e.css(this, "overflow") + e.css(this, "overflow-y") + e.css(this, "overflow-x"));
                    }).eq(0), /fixed/.test(this.css("position")) || !t.length ? e(document) : t;
                },
                zIndex: function (n) {
                    if (n !== t) return this.css("zIndex", n);
                    if (this.length) {
                        var r = e(this[0]), i, s;
                        while (r.length && r[0] !== document) {
                            i = r.css("position");
                            if (i === "absolute" || i === "relative" || i === "fixed") {
                                s = parseInt(r.css("zIndex"), 10);
                                if (!isNaN(s) && s !== 0) return s;
                            }
                            r = r.parent();
                        }
                    }
                    return 0;
                },
                uniqueId: function () {
                    return this.each(function () {
                        this.id || (this.id = "ui-id-" + ++i);
                    });
                },
                removeUniqueId: function () {
                    return this.each(function () {
                        s.test(this.id) && e(this).removeAttr("id");
                    });
                }
            }), e.extend(e.expr[":"], {
                data: e.expr.createPseudo ? e.expr.createPseudo(function (t) {
                    return function (n) {
                        return !!e.data(n, t);
                    };
                }) : function (t, n, r) {
                    return !!e.data(t, r[3]);
                },
                focusable: function (t) {
                    return n(t, !isNaN(e.attr(t, "tabindex")));
                },
                tabbable: function (t) {
                    var r = e.attr(t, "tabindex"), i = isNaN(r);
                    return (i || r >= 0) && n(t, !i);
                }
            }), e.extend(e.ui, {
                plugin: {
                    add: function (t, n, r) {
                        var i, s = e.ui[t].prototype;
                        for (i in r) s.plugins[i] = s.plugins[i] || [], s.plugins[i].push([ n, r[i] ]);
                    },
                    call: function (e, t, n) {
                        var r, i = e.plugins[t];
                        if (!i || !e.element[0].parentNode || e.element[0].parentNode.nodeType === 11) return;
                        for (r = 0; r < i.length; r++) e.options[i[r][0]] && i[r][1].apply(e.element, n);
                    }
                },
                hasScroll: function (t, n) {
                    if (e(t).css("overflow") === "hidden") return !1;
                    var r = n && n === "left" ? "scrollLeft" : "scrollTop", i = !1;
                    return t[r] > 0 ? !0 : (t[r] = 1, i = t[r] > 0, t[r] = 0, i);
                }
            });
        })(jQuery), function (e, t) {
            var n = 0, r = Array.prototype.slice, i = e.cleanData;
            e.cleanData = function (t) {
                for (var n = 0, r; (r = t[n]) != null; n++) try {
                    e(r).triggerHandler("remove");
                } catch (s) {
                }
                i(t);
            }, e.widget = function (t, n, r) {
                var i, s, o, u, a = {}, f = t.split(".")[0];
                t = t.split(".")[1], i = f + "-" + t, r || (r = n, n = e.Widget), e.expr[":"][i.toLowerCase()] = function (t) {
                    return !!e.data(t, i);
                }, e[f] = e[f] || {}, s = e[f][t], o = e[f][t] = function (e, t) {
                    if (!this._createWidget) return new o(e, t);
                    arguments.length && this._createWidget(e, t);
                }, e.extend(o, s, {
                    version: r.version,
                    _proto: e.extend({}, r),
                    _childConstructors: []
                }), u = new n, u.options = e.widget.extend({}, u.options), e.each(r, function (t, r) {
                    if (!e.isFunction(r)) {
                        a[t] = r;
                        return;
                    }
                    a[t] = function () {
                        var e = function () {
                            return n.prototype[t].apply(this, arguments);
                        }, i = function (e) {
                            return n.prototype[t].apply(this, e);
                        };
                        return function () {
                            var t = this._super, n = this._superApply, s;
                            return this._super = e, this._superApply = i, s = r.apply(this, arguments), this._super = t, this._superApply = n, s;
                        };
                    }();
                }), o.prototype = e.widget.extend(u, {
                    widgetEventPrefix: s ? u.widgetEventPrefix : t
                }, a, {
                    constructor: o,
                    namespace: f,
                    widgetName: t,
                    widgetFullName: i
                }), s ? (e.each(s._childConstructors, function (t, n) {
                    var r = n.prototype;
                    e.widget(r.namespace + "." + r.widgetName, o, n._proto);
                }), delete s._childConstructors) : n._childConstructors.push(o), e.widget.bridge(t, o);
            }, e.widget.extend = function (n) {
                var i = r.call(arguments, 1), s = 0, o = i.length, u, a;
                for (; s < o; s++) for (u in i[s]) a = i[s][u], i[s].hasOwnProperty(u) && a !== t && (e.isPlainObject(a) ? n[u] = e.isPlainObject(n[u]) ? e.widget.extend({}, n[u], a) : e.widget.extend({}, a) : n[u] = a);
                return n;
            }, e.widget.bridge = function (n, i) {
                var s = i.prototype.widgetFullName || n;
                e.fn[n] = function (o) {
                    var u = typeof o == "string", a = r.call(arguments, 1), f = this;
                    return o = !u && a.length ? e.widget.extend.apply(null, [ o ].concat(a)) : o, u ? this.each(function () {
                        var r, i = e.data(this, s);
                        if (!i) return e.error("cannot call methods on " + n + " prior to initialization; " + "attempted to call method '" + o + "'");
                        if (!e.isFunction(i[o]) || o.charAt(0) === "_") return e.error("no such method '" + o + "' for " + n + " widget instance");
                        r = i[o].apply(i, a);
                        if (r !== i && r !== t) return f = r && r.jquery ? f.pushStack(r.get()) : r, !1;
                    }) : this.each(function () {
                        var t = e.data(this, s);
                        t ? t.option(o || {})._init() : e.data(this, s, new i(o, this));
                    }), f;
                };
            }, e.Widget = function () {
            }, e.Widget._childConstructors = [], e.Widget.prototype = {
                widgetName: "widget",
                widgetEventPrefix: "",
                defaultElement: "<div>",
                options: {
                    disabled: !1,
                    create: null
                },
                _createWidget: function (t, r) {
                    r = e(r || this.defaultElement || this)[0], this.element = e(r), this.uuid = n++, this.eventNamespace = "." + this.widgetName + this.uuid, this.options = e.widget.extend({}, this.options, this._getCreateOptions(), t), this.bindings = e(), this.hoverable = e(), this.focusable = e(), r !== this && (e.data(r, this.widgetFullName, this), this._on(!0, this.element, {
                        remove: function (e) {
                            e.target === r && this.destroy();
                        }
                    }), this.document = e(r.style ? r.ownerDocument : r.document || r), this.window = e(this.document[0].defaultView || this.document[0].parentWindow)), this._create(), this._trigger("create", null, this._getCreateEventData()), this._init();
                },
                _getCreateOptions: e.noop,
                _getCreateEventData: e.noop,
                _create: e.noop,
                _init: e.noop,
                destroy: function () {
                    this._destroy(), this.element.unbind(this.eventNamespace).removeData(this.widgetName).removeData(this.widgetFullName).removeData(e.camelCase(this.widgetFullName)), this.widget().unbind(this.eventNamespace).removeAttr("aria-disabled").removeClass(this.widgetFullName + "-disabled " + "ui-state-disabled"), this.bindings.unbind(this.eventNamespace), this.hoverable.removeClass("ui-state-hover"), this.focusable.removeClass("ui-state-focus");
                },
                _destroy: e.noop,
                widget: function () {
                    return this.element;
                },
                option: function (n, r) {
                    var i = n, s, o, u;
                    if (arguments.length === 0) return e.widget.extend({}, this.options);
                    if (typeof n == "string") {
                        i = {}, s = n.split("."), n = s.shift();
                        if (s.length) {
                            o = i[n] = e.widget.extend({}, this.options[n]);
                            for (u = 0; u < s.length - 1; u++) o[s[u]] = o[s[u]] || {}, o = o[s[u]];
                            n = s.pop();
                            if (r === t) return o[n] === t ? null : o[n];
                            o[n] = r;
                        } else {
                            if (r === t) return this.options[n] === t ? null : this.options[n];
                            i[n] = r;
                        }
                    }
                    return this._setOptions(i), this;
                },
                _setOptions: function (e) {
                    var t;
                    for (t in e) this._setOption(t, e[t]);
                    return this;
                },
                _setOption: function (e, t) {
                    return this.options[e] = t, e === "disabled" && (this.widget().toggleClass(this.widgetFullName + "-disabled ui-state-disabled", !!t).attr("aria-disabled", t), this.hoverable.removeClass("ui-state-hover"), this.focusable.removeClass("ui-state-focus")), this;
                },
                enable: function () {
                    return this._setOption("disabled", !1);
                },
                disable: function () {
                    return this._setOption("disabled", !0);
                },
                _on: function (t, n, r) {
                    var i, s = this;
                    typeof t != "boolean" && (r = n, n = t, t = !1), r ? (n = i = e(n), this.bindings = this.bindings.add(n)) : (r = n, n = this.element, i = this.widget()), e.each(r, function (r, o) {
                        function u() {
                            if (!t && (s.options.disabled === !0 || e(this).hasClass("ui-state-disabled"))) return;
                            return (typeof o == "string" ? s[o] : o).apply(s, arguments);
                        }

                        typeof o != "string" && (u.guid = o.guid = o.guid || u.guid || e.guid++);
                        var a = r.match(/^(\w+)\s*(.*)$/), f = a[1] + s.eventNamespace, l = a[2];
                        l ? i.delegate(l, f, u) : n.bind(f, u);
                    });
                },
                _off: function (e, t) {
                    t = (t || "").split(" ").join(this.eventNamespace + " ") + this.eventNamespace, e.unbind(t).undelegate(t);
                },
                _delay: function (e, t) {
                    function n() {
                        return (typeof e == "string" ? r[e] : e).apply(r, arguments);
                    }

                    var r = this;
                    return setTimeout(n, t || 0);
                },
                _hoverable: function (t) {
                    this.hoverable = this.hoverable.add(t), this._on(t, {
                        mouseenter: function (t) {
                            e(t.currentTarget).addClass("ui-state-hover");
                        },
                        mouseleave: function (t) {
                            e(t.currentTarget).removeClass("ui-state-hover");
                        }
                    });
                },
                _focusable: function (t) {
                    this.focusable = this.focusable.add(t), this._on(t, {
                        focusin: function (t) {
                            e(t.currentTarget).addClass("ui-state-focus");
                        },
                        focusout: function (t) {
                            e(t.currentTarget).removeClass("ui-state-focus");
                        }
                    });
                },
                _trigger: function (t, n, r) {
                    var i, s, o = this.options[t];
                    r = r || {}, n = e.Event(n), n.type = (t === this.widgetEventPrefix ? t : this.widgetEventPrefix + t).toLowerCase(), n.target = this.element[0], s = n.originalEvent;
                    if (s) for (i in s) i in n || (n[i] = s[i]);
                    return this.element.trigger(n, r), !(e.isFunction(o) && o.apply(this.element[0], [ n ].concat(r)) === !1 || n.isDefaultPrevented());
                }
            }, e.each({
                show: "fadeIn",
                hide: "fadeOut"
            }, function (t, n) {
                e.Widget.prototype["_" + t] = function (r, i, s) {
                    typeof i == "string" && (i = {
                        effect: i
                    });
                    var o, u = i ? i === !0 || typeof i == "number" ? n : i.effect || n : t;
                    i = i || {}, typeof i == "number" && (i = {
                        duration: i
                    }), o = !e.isEmptyObject(i), i.complete = s, i.delay && r.delay(i.delay), o && e.effects && e.effects.effect[u] ? r[t](i) : u !== t && r[u] ? r[u](i.duration, i.easing, s) : r.queue(function (n) {
                        e(this)[t](), s && s.call(r[0]), n();
                    });
                };
            });
        }(jQuery), function (e, t) {
            var n = !1;
            e(document).mouseup(function () {
                n = !1;
            }), e.widget("ui.mouse", {
                version: "1.10.3",
                options: {
                    cancel: "input,textarea,button,select,option",
                    distance: 1,
                    delay: 0
                },
                _mouseInit: function () {
                    var t = this;
                    this.element.bind("mousedown." + this.widgetName,function (e) {
                        return t._mouseDown(e);
                    }).bind("click." + this.widgetName, function (n) {
                            if (!0 === e.data(n.target, t.widgetName + ".preventClickEvent")) return e.removeData(n.target, t.widgetName + ".preventClickEvent"), n.stopImmediatePropagation(), !1;
                        }), this.started = !1;
                },
                _mouseDestroy: function () {
                    this.element.unbind("." + this.widgetName), this._mouseMoveDelegate && e(document).unbind("mousemove." + this.widgetName, this._mouseMoveDelegate).unbind("mouseup." + this.widgetName, this._mouseUpDelegate);
                },
                _mouseDown: function (t) {
                    if (n) return;
                    this._mouseStarted && this._mouseUp(t), this._mouseDownEvent = t;
                    var r = this, i = t.which === 1, s = typeof this.options.cancel == "string" && t.target.nodeName ? e(t.target).closest(this.options.cancel).length : !1;
                    if (!i || s || !this._mouseCapture(t)) return !0;
                    this.mouseDelayMet = !this.options.delay, this.mouseDelayMet || (this._mouseDelayTimer = setTimeout(function () {
                        r.mouseDelayMet = !0;
                    }, this.options.delay));
                    if (this._mouseDistanceMet(t) && this._mouseDelayMet(t)) {
                        this._mouseStarted = this._mouseStart(t) !== !1;
                        if (!this._mouseStarted) return t.preventDefault(), !0;
                    }
                    return !0 === e.data(t.target, this.widgetName + ".preventClickEvent") && e.removeData(t.target, this.widgetName + ".preventClickEvent"), this._mouseMoveDelegate = function (e) {
                        return r._mouseMove(e);
                    }, this._mouseUpDelegate = function (e) {
                        return r._mouseUp(e);
                    }, e(document).bind("mousemove." + this.widgetName, this._mouseMoveDelegate).bind("mouseup." + this.widgetName, this._mouseUpDelegate), t.preventDefault(), n = !0, !0;
                },
                _mouseMove: function (t) {
                    return e.ui.ie && (!document.documentMode || document.documentMode < 9) && !t.button ? this._mouseUp(t) : this._mouseStarted ? (this._mouseDrag(t), t.preventDefault()) : (this._mouseDistanceMet(t) && this._mouseDelayMet(t) && (this._mouseStarted = this._mouseStart(this._mouseDownEvent, t) !== !1, this._mouseStarted ? this._mouseDrag(t) : this._mouseUp(t)), !this._mouseStarted);
                },
                _mouseUp: function (t) {
                    return e(document).unbind("mousemove." + this.widgetName, this._mouseMoveDelegate).unbind("mouseup." + this.widgetName, this._mouseUpDelegate), this._mouseStarted && (this._mouseStarted = !1, t.target === this._mouseDownEvent.target && e.data(t.target, this.widgetName + ".preventClickEvent", !0), this._mouseStop(t)), !1;
                },
                _mouseDistanceMet: function (e) {
                    return Math.max(Math.abs(this._mouseDownEvent.pageX - e.pageX), Math.abs(this._mouseDownEvent.pageY - e.pageY)) >= this.options.distance;
                },
                _mouseDelayMet: function () {
                    return this.mouseDelayMet;
                },
                _mouseStart: function () {
                },
                _mouseDrag: function () {
                },
                _mouseStop: function () {
                },
                _mouseCapture: function () {
                    return !0;
                }
            });
        }(jQuery), function (e, t) {
            e.widget("ui.draggable", e.ui.mouse, {
                version: "1.10.3",
                widgetEventPrefix: "drag",
                options: {
                    addClasses: !0,
                    appendTo: "parent",
                    axis: !1,
                    connectToSortable: !1,
                    containment: !1,
                    cursor: "auto",
                    cursorAt: !1,
                    grid: !1,
                    handle: !1,
                    helper: "original",
                    iframeFix: !1,
                    opacity: !1,
                    refreshPositions: !1,
                    revert: !1,
                    revertDuration: 500,
                    scope: "default",
                    scroll: !0,
                    scrollSensitivity: 20,
                    scrollSpeed: 20,
                    snap: !1,
                    snapMode: "both",
                    snapTolerance: 20,
                    stack: !1,
                    zIndex: !1,
                    drag: null,
                    start: null,
                    stop: null
                },
                _create: function () {
                    this.options.helper === "original" && !/^(?:r|a|f)/.test(this.element.css("position")) && (this.element[0].style.position = "relative"), this.options.addClasses && this.element.addClass("ui-draggable"), this.options.disabled && this.element.addClass("ui-draggable-disabled"), this._mouseInit();
                },
                _destroy: function () {
                    this.element.removeClass("ui-draggable ui-draggable-dragging ui-draggable-disabled"), this._mouseDestroy();
                },
                _mouseCapture: function (t) {
                    var n = this.options;
                    return this.helper || n.disabled || e(t.target).closest(".ui-resizable-handle").length > 0 ? !1 : (this.handle = this._getHandle(t), this.handle ? (e(n.iframeFix === !0 ? "iframe" : n.iframeFix).each(function () {
                        e("<div class='ui-draggable-iframeFix' style='background: #fff;'></div>").css({
                            width: this.offsetWidth + "px",
                            height: this.offsetHeight + "px",
                            position: "absolute",
                            opacity: "0.001",
                            zIndex: 1e3
                        }).css(e(this).offset()).appendTo("body");
                    }), !0) : !1);
                },
                _mouseStart: function (t) {
                    var n = this.options;
                    return this.helper = this._createHelper(t), this.helper.addClass("ui-draggable-dragging"), this._cacheHelperProportions(), e.ui.ddmanager && (e.ui.ddmanager.current = this), this._cacheMargins(), this.cssPosition = this.helper.css("position"), this.scrollParent = this.helper.scrollParent(), this.offsetParent = this.helper.offsetParent(), this.offsetParentCssPosition = this.offsetParent.css("position"), this.offset = this.positionAbs = this.element.offset(), this.offset = {
                        top: this.offset.top - this.margins.top,
                        left: this.offset.left - this.margins.left
                    }, this.offset.scroll = !1, e.extend(this.offset, {
                        click: {
                            left: t.pageX - this.offset.left,
                            top: t.pageY - this.offset.top
                        },
                        parent: this._getParentOffset(),
                        relative: this._getRelativeOffset()
                    }), this.originalPosition = this.position = this._generatePosition(t), this.originalPageX = t.pageX, this.originalPageY = t.pageY, n.cursorAt && this._adjustOffsetFromHelper(n.cursorAt), this._setContainment(), this._trigger("start", t) === !1 ? (this._clear(), !1) : (this._cacheHelperProportions(), e.ui.ddmanager && !n.dropBehaviour && e.ui.ddmanager.prepareOffsets(this, t), this._mouseDrag(t, !0), e.ui.ddmanager && e.ui.ddmanager.dragStart(this, t), !0);
                },
                _mouseDrag: function (t, n) {
                    this.offsetParentCssPosition === "fixed" && (this.offset.parent = this._getParentOffset()), this.position = this._generatePosition(t), this.positionAbs = this._convertPositionTo("absolute");
                    if (!n) {
                        var r = this._uiHash();
                        if (this._trigger("drag", t, r) === !1) return this._mouseUp({}), !1;
                        this.position = r.position;
                    }
                    if (!this.options.axis || this.options.axis !== "y") this.helper[0].style.left = this.position.left + "px";
                    if (!this.options.axis || this.options.axis !== "x") this.helper[0].style.top = this.position.top + "px";
                    return e.ui.ddmanager && e.ui.ddmanager.drag(this, t), !1;
                },
                _mouseStop: function (t) {
                    var n = this, r = !1;
                    return e.ui.ddmanager && !this.options.dropBehaviour && (r = e.ui.ddmanager.drop(this, t)), this.dropped && (r = this.dropped, this.dropped = !1), this.options.helper === "original" && !e.contains(this.element[0].ownerDocument, this.element[0]) ? !1 : (this.options.revert === "invalid" && !r || this.options.revert === "valid" && r || this.options.revert === !0 || e.isFunction(this.options.revert) && this.options.revert.call(this.element, r) ? e(this.helper).animate(this.originalPosition, parseInt(this.options.revertDuration, 10), function () {
                        n._trigger("stop", t) !== !1 && n._clear();
                    }) : this._trigger("stop", t) !== !1 && this._clear(), !1);
                },
                _mouseUp: function (t) {
                    return e("div.ui-draggable-iframeFix").each(function () {
                        this.parentNode.removeChild(this);
                    }), e.ui.ddmanager && e.ui.ddmanager.dragStop(this, t), e.ui.mouse.prototype._mouseUp.call(this, t);
                },
                cancel: function () {
                    return this.helper.is(".ui-draggable-dragging") ? this._mouseUp({}) : this._clear(), this;
                },
                _getHandle: function (t) {
                    return this.options.handle ? !!e(t.target).closest(this.element.find(this.options.handle)).length : !0;
                },
                _createHelper: function (t) {
                    var n = this.options, r = e.isFunction(n.helper) ? e(n.helper.apply(this.element[0], [ t ])) : n.helper === "clone" ? this.element.clone().removeAttr("id") : this.element;
                    return r.parents("body").length || r.appendTo(n.appendTo === "parent" ? this.element[0].parentNode : n.appendTo), r[0] !== this.element[0] && !/(fixed|absolute)/.test(r.css("position")) && r.css("position", "absolute"), r;
                },
                _adjustOffsetFromHelper: function (t) {
                    typeof t == "string" && (t = t.split(" ")), e.isArray(t) && (t = {
                        left: +t[0],
                        top: +t[1] || 0
                    }), "left" in t && (this.offset.click.left = t.left + this.margins.left), "right" in t && (this.offset.click.left = this.helperProportions.width - t.right + this.margins.left), "top" in t && (this.offset.click.top = t.top + this.margins.top), "bottom" in t && (this.offset.click.top = this.helperProportions.height - t.bottom + this.margins.top);
                },
                _getParentOffset: function () {
                    var t = this.offsetParent.offset();
                    this.cssPosition === "absolute" && this.scrollParent[0] !== document && e.contains(this.scrollParent[0], this.offsetParent[0]) && (t.left += this.scrollParent.scrollLeft(), t.top += this.scrollParent.scrollTop());
                    if (this.offsetParent[0] === document.body || this.offsetParent[0].tagName && this.offsetParent[0].tagName.toLowerCase() === "html" && e.ui.ie) t = {
                        top: 0,
                        left: 0
                    };
                    return {
                        top: t.top + (parseInt(this.offsetParent.css("borderTopWidth"), 10) || 0),
                        left: t.left + (parseInt(this.offsetParent.css("borderLeftWidth"), 10) || 0)
                    };
                },
                _getRelativeOffset: function () {
                    if (this.cssPosition === "relative") {
                        var e = this.element.position();
                        return {
                            top: e.top - (parseInt(this.helper.css("top"), 10) || 0) + this.scrollParent.scrollTop(),
                            left: e.left - (parseInt(this.helper.css("left"), 10) || 0) + this.scrollParent.scrollLeft()
                        };
                    }
                    return {
                        top: 0,
                        left: 0
                    };
                },
                _cacheMargins: function () {
                    this.margins = {
                        left: parseInt(this.element.css("marginLeft"), 10) || 0,
                        top: parseInt(this.element.css("marginTop"), 10) || 0,
                        right: parseInt(this.element.css("marginRight"), 10) || 0,
                        bottom: parseInt(this.element.css("marginBottom"), 10) || 0
                    };
                },
                _cacheHelperProportions: function () {
                    this.helperProportions = {
                        width: this.helper.outerWidth(),
                        height: this.helper.outerHeight()
                    };
                },
                _setContainment: function () {
                    var t, n, r, i = this.options;
                    if (!i.containment) {
                        this.containment = null;
                        return;
                    }
                    if (i.containment === "window") {
                        this.containment = [ e(window).scrollLeft() - this.offset.relative.left - this.offset.parent.left, e(window).scrollTop() - this.offset.relative.top - this.offset.parent.top, e(window).scrollLeft() + e(window).width() - this.helperProportions.width - this.margins.left, e(window).scrollTop() + (e(window).height() || document.body.parentNode.scrollHeight) - this.helperProportions.height - this.margins.top ];
                        return;
                    }
                    if (i.containment === "document") {
                        this.containment = [ 0, 0, e(document).width() - this.helperProportions.width - this.margins.left, (e(document).height() || document.body.parentNode.scrollHeight) - this.helperProportions.height - this.margins.top ];
                        return;
                    }
                    if (i.containment.constructor === Array) {
                        this.containment = i.containment;
                        return;
                    }
                    i.containment === "parent" && (i.containment = this.helper[0].parentNode), n = e(i.containment), r = n[0];
                    if (!r) return;
                    t = n.css("overflow") !== "hidden", this.containment = [ (parseInt(n.css("borderLeftWidth"), 10) || 0) + (parseInt(n.css("paddingLeft"), 10) || 0), (parseInt(n.css("borderTopWidth"), 10) || 0) + (parseInt(n.css("paddingTop"), 10) || 0), (t ? Math.max(r.scrollWidth, r.offsetWidth) : r.offsetWidth) - (parseInt(n.css("borderRightWidth"), 10) || 0) - (parseInt(n.css("paddingRight"), 10) || 0) - this.helperProportions.width - this.margins.left - this.margins.right, (t ? Math.max(r.scrollHeight, r.offsetHeight) : r.offsetHeight) - (parseInt(n.css("borderBottomWidth"), 10) || 0) - (parseInt(n.css("paddingBottom"), 10) || 0) - this.helperProportions.height - this.margins.top - this.margins.bottom ], this.relative_container = n;
                },
                _convertPositionTo: function (t, n) {
                    n || (n = this.position);
                    var r = t === "absolute" ? 1 : -1, i = this.cssPosition !== "absolute" || this.scrollParent[0] !== document && !!e.contains(this.scrollParent[0], this.offsetParent[0]) ? this.scrollParent : this.offsetParent;
                    return this.offset.scroll || (this.offset.scroll = {
                        top: i.scrollTop(),
                        left: i.scrollLeft()
                    }), {
                        top: n.top + this.offset.relative.top * r + this.offset.parent.top * r - (this.cssPosition === "fixed" ? -this.scrollParent.scrollTop() : this.offset.scroll.top) * r,
                        left: n.left + this.offset.relative.left * r + this.offset.parent.left * r - (this.cssPosition === "fixed" ? -this.scrollParent.scrollLeft() : this.offset.scroll.left) * r
                    };
                },
                _generatePosition: function (t) {
                    var n, r, i, s, o = this.options, u = this.cssPosition !== "absolute" || this.scrollParent[0] !== document && !!e.contains(this.scrollParent[0], this.offsetParent[0]) ? this.scrollParent : this.offsetParent, a = t.pageX, f = t.pageY;
                    return this.offset.scroll || (this.offset.scroll = {
                        top: u.scrollTop(),
                        left: u.scrollLeft()
                    }), this.originalPosition && (this.containment && (this.relative_container ? (r = this.relative_container.offset(), n = [ this.containment[0] + r.left, this.containment[1] + r.top, this.containment[2] + r.left, this.containment[3] + r.top ]) : n = this.containment, t.pageX - this.offset.click.left < n[0] && (a = n[0] + this.offset.click.left), t.pageY - this.offset.click.top < n[1] && (f = n[1] + this.offset.click.top), t.pageX - this.offset.click.left > n[2] && (a = n[2] + this.offset.click.left), t.pageY - this.offset.click.top > n[3] && (f = n[3] + this.offset.click.top)), o.grid && (i = o.grid[1] ? this.originalPageY + Math.round((f - this.originalPageY) / o.grid[1]) * o.grid[1] : this.originalPageY, f = n ? i - this.offset.click.top >= n[1] || i - this.offset.click.top > n[3] ? i : i - this.offset.click.top >= n[1] ? i - o.grid[1] : i + o.grid[1] : i, s = o.grid[0] ? this.originalPageX + Math.round((a - this.originalPageX) / o.grid[0]) * o.grid[0] : this.originalPageX, a = n ? s - this.offset.click.left >= n[0] || s - this.offset.click.left > n[2] ? s : s - this.offset.click.left >= n[0] ? s - o.grid[0] : s + o.grid[0] : s)), {
                        top: f - this.offset.click.top - this.offset.relative.top - this.offset.parent.top + (this.cssPosition === "fixed" ? -this.scrollParent.scrollTop() : this.offset.scroll.top),
                        left: a - this.offset.click.left - this.offset.relative.left - this.offset.parent.left + (this.cssPosition === "fixed" ? -this.scrollParent.scrollLeft() : this.offset.scroll.left)
                    };
                },
                _clear: function () {
                    this.helper.removeClass("ui-draggable-dragging"), this.helper[0] !== this.element[0] && !this.cancelHelperRemoval && this.helper.remove(), this.helper = null, this.cancelHelperRemoval = !1;
                },
                _trigger: function (t, n, r) {
                    return r = r || this._uiHash(), e.ui.plugin.call(this, t, [ n, r ]), t === "drag" && (this.positionAbs = this._convertPositionTo("absolute")), e.Widget.prototype._trigger.call(this, t, n, r);
                },
                plugins: {},
                _uiHash: function () {
                    return {
                        helper: this.helper,
                        position: this.position,
                        originalPosition: this.originalPosition,
                        offset: this.positionAbs
                    };
                }
            }), e.ui.plugin.add("draggable", "connectToSortable", {
                start: function (t, n) {
                    var r = e(this).data("ui-draggable"), i = r.options, s = e.extend({}, n, {
                        item: r.element
                    });
                    r.sortables = [], e(i.connectToSortable).each(function () {
                        var n = e.data(this, "ui-sortable");
                        n && !n.options.disabled && (r.sortables.push({
                            instance: n,
                            shouldRevert: n.options.revert
                        }), n.refreshPositions(), n._trigger("activate", t, s));
                    });
                },
                stop: function (t, n) {
                    var r = e(this).data("ui-draggable"), i = e.extend({}, n, {
                        item: r.element
                    });
                    e.each(r.sortables, function () {
                        this.instance.isOver ? (this.instance.isOver = 0, r.cancelHelperRemoval = !0, this.instance.cancelHelperRemoval = !1, this.shouldRevert && (this.instance.options.revert = this.shouldRevert), this.instance._mouseStop(t), this.instance.options.helper = this.instance.options._helper, r.options.helper === "original" && this.instance.currentItem.css({
                            top: "auto",
                            left: "auto"
                        })) : (this.instance.cancelHelperRemoval = !1, this.instance._trigger("deactivate", t, i));
                    });
                },
                drag: function (t, n) {
                    var r = e(this).data("ui-draggable"), i = this;
                    e.each(r.sortables, function () {
                        var s = !1, o = this;
                        this.instance.positionAbs = r.positionAbs, this.instance.helperProportions = r.helperProportions, this.instance.offset.click = r.offset.click, this.instance._intersectsWith(this.instance.containerCache) && (s = !0, e.each(r.sortables, function () {
                            return this.instance.positionAbs = r.positionAbs, this.instance.helperProportions = r.helperProportions, this.instance.offset.click = r.offset.click, this !== o && this.instance._intersectsWith(this.instance.containerCache) && e.contains(o.instance.element[0], this.instance.element[0]) && (s = !1), s;
                        })), s ? (this.instance.isOver || (this.instance.isOver = 1, this.instance.currentItem = e(i).clone().removeAttr("id").appendTo(this.instance.element).data("ui-sortable-item", !0), this.instance.options._helper = this.instance.options.helper, this.instance.options.helper = function () {
                            return n.helper[0];
                        }, t.target = this.instance.currentItem[0], this.instance._mouseCapture(t, !0), this.instance._mouseStart(t, !0, !0), this.instance.offset.click.top = r.offset.click.top, this.instance.offset.click.left = r.offset.click.left, this.instance.offset.parent.left -= r.offset.parent.left - this.instance.offset.parent.left, this.instance.offset.parent.top -= r.offset.parent.top - this.instance.offset.parent.top, r._trigger("toSortable", t), r.dropped = this.instance.element, r.currentItem = r.element, this.instance.fromOutside = r), this.instance.currentItem && this.instance._mouseDrag(t)) : this.instance.isOver && (this.instance.isOver = 0, this.instance.cancelHelperRemoval = !0, this.instance.options.revert = !1, this.instance._trigger("out", t, this.instance._uiHash(this.instance)), this.instance._mouseStop(t, !0), this.instance.options.helper = this.instance.options._helper, this.instance.currentItem.remove(), this.instance.placeholder && this.instance.placeholder.remove(), r._trigger("fromSortable", t), r.dropped = !1);
                    });
                }
            }), e.ui.plugin.add("draggable", "cursor", {
                start: function () {
                    var t = e("body"), n = e(this).data("ui-draggable").options;
                    t.css("cursor") && (n._cursor = t.css("cursor")), t.css("cursor", n.cursor);
                },
                stop: function () {
                    var t = e(this).data("ui-draggable").options;
                    t._cursor && e("body").css("cursor", t._cursor);
                }
            }), e.ui.plugin.add("draggable", "opacity", {
                start: function (t, n) {
                    var r = e(n.helper), i = e(this).data("ui-draggable").options;
                    r.css("opacity") && (i._opacity = r.css("opacity")), r.css("opacity", i.opacity);
                },
                stop: function (t, n) {
                    var r = e(this).data("ui-draggable").options;
                    r._opacity && e(n.helper).css("opacity", r._opacity);
                }
            }), e.ui.plugin.add("draggable", "scroll", {
                start: function () {
                    var t = e(this).data("ui-draggable");
                    t.scrollParent[0] !== document && t.scrollParent[0].tagName !== "HTML" && (t.overflowOffset = t.scrollParent.offset());
                },
                drag: function (t) {
                    var n = e(this).data("ui-draggable"), r = n.options, i = !1;
                    if (n.scrollParent[0] !== document && n.scrollParent[0].tagName !== "HTML") {
                        if (!r.axis || r.axis !== "x") n.overflowOffset.top + n.scrollParent[0].offsetHeight - t.pageY < r.scrollSensitivity ? n.scrollParent[0].scrollTop = i = n.scrollParent[0].scrollTop + r.scrollSpeed : t.pageY - n.overflowOffset.top < r.scrollSensitivity && (n.scrollParent[0].scrollTop = i = n.scrollParent[0].scrollTop - r.scrollSpeed);
                        if (!r.axis || r.axis !== "y") n.overflowOffset.left + n.scrollParent[0].offsetWidth - t.pageX < r.scrollSensitivity ? n.scrollParent[0].scrollLeft = i = n.scrollParent[0].scrollLeft + r.scrollSpeed : t.pageX - n.overflowOffset.left < r.scrollSensitivity && (n.scrollParent[0].scrollLeft = i = n.scrollParent[0].scrollLeft - r.scrollSpeed);
                    } else {
                        if (!r.axis || r.axis !== "x") t.pageY - e(document).scrollTop() < r.scrollSensitivity ? i = e(document).scrollTop(e(document).scrollTop() - r.scrollSpeed) : e(window).height() - (t.pageY - e(document).scrollTop()) < r.scrollSensitivity && (i = e(document).scrollTop(e(document).scrollTop() + r.scrollSpeed));
                        if (!r.axis || r.axis !== "y") t.pageX - e(document).scrollLeft() < r.scrollSensitivity ? i = e(document).scrollLeft(e(document).scrollLeft() - r.scrollSpeed) : e(window).width() - (t.pageX - e(document).scrollLeft()) < r.scrollSensitivity && (i = e(document).scrollLeft(e(document).scrollLeft() + r.scrollSpeed));
                    }
                    i !== !1 && e.ui.ddmanager && !r.dropBehaviour && e.ui.ddmanager.prepareOffsets(n, t);
                }
            }), e.ui.plugin.add("draggable", "snap", {
                start: function () {
                    var t = e(this).data("ui-draggable"), n = t.options;
                    t.snapElements = [], e(n.snap.constructor !== String ? n.snap.items || ":data(ui-draggable)" : n.snap).each(function () {
                        var n = e(this), r = n.offset();
                        this !== t.element[0] && t.snapElements.push({
                            item: this,
                            width: n.outerWidth(),
                            height: n.outerHeight(),
                            top: r.top,
                            left: r.left
                        });
                    });
                },
                drag: function (t, n) {
                    var r, i, s, o, u, a, f, l, c, h, p = e(this).data("ui-draggable"), d = p.options, v = d.snapTolerance, m = n.offset.left, g = m + p.helperProportions.width, y = n.offset.top, b = y + p.helperProportions.height;
                    for (c = p.snapElements.length - 1; c >= 0; c--) {
                        u = p.snapElements[c].left, a = u + p.snapElements[c].width, f = p.snapElements[c].top, l = f + p.snapElements[c].height;
                        if (g < u - v || m > a + v || b < f - v || y > l + v || !e.contains(p.snapElements[c].item.ownerDocument, p.snapElements[c].item)) {
                            p.snapElements[c].snapping && p.options.snap.release && p.options.snap.release.call(p.element, t, e.extend(p._uiHash(), {
                                snapItem: p.snapElements[c].item
                            })), p.snapElements[c].snapping = !1;
                            continue;
                        }
                        d.snapMode !== "inner" && (r = Math.abs(f - b) <= v, i = Math.abs(l - y) <= v, s = Math.abs(u - g) <= v, o = Math.abs(a - m) <= v, r && (n.position.top = p._convertPositionTo("relative", {
                            top: f - p.helperProportions.height,
                            left: 0
                        }).top - p.margins.top), i && (n.position.top = p._convertPositionTo("relative", {
                            top: l,
                            left: 0
                        }).top - p.margins.top), s && (n.position.left = p._convertPositionTo("relative", {
                            top: 0,
                            left: u - p.helperProportions.width
                        }).left - p.margins.left), o && (n.position.left = p._convertPositionTo("relative", {
                            top: 0,
                            left: a
                        }).left - p.margins.left)), h = r || i || s || o, d.snapMode !== "outer" && (r = Math.abs(f - y) <= v, i = Math.abs(l - b) <= v, s = Math.abs(u - m) <= v, o = Math.abs(a - g) <= v, r && (n.position.top = p._convertPositionTo("relative", {
                            top: f,
                            left: 0
                        }).top - p.margins.top), i && (n.position.top = p._convertPositionTo("relative", {
                            top: l - p.helperProportions.height,
                            left: 0
                        }).top - p.margins.top), s && (n.position.left = p._convertPositionTo("relative", {
                            top: 0,
                            left: u
                        }).left - p.margins.left), o && (n.position.left = p._convertPositionTo("relative", {
                            top: 0,
                            left: a - p.helperProportions.width
                        }).left - p.margins.left)), !p.snapElements[c].snapping && (r || i || s || o || h) && p.options.snap.snap && p.options.snap.snap.call(p.element, t, e.extend(p._uiHash(), {
                            snapItem: p.snapElements[c].item
                        })), p.snapElements[c].snapping = r || i || s || o || h;
                    }
                }
            }), e.ui.plugin.add("draggable", "stack", {
                start: function () {
                    var t, n = this.data("ui-draggable").options, r = e.makeArray(e(n.stack)).sort(function (t, n) {
                        return (parseInt(e(t).css("zIndex"), 10) || 0) - (parseInt(e(n).css("zIndex"), 10) || 0);
                    });
                    if (!r.length) return;
                    t = parseInt(e(r[0]).css("zIndex"), 10) || 0, e(r).each(function (n) {
                        e(this).css("zIndex", t + n);
                    }), this.css("zIndex", t + r.length);
                }
            }), e.ui.plugin.add("draggable", "zIndex", {
                start: function (t, n) {
                    var r = e(n.helper), i = e(this).data("ui-draggable").options;
                    r.css("zIndex") && (i._zIndex = r.css("zIndex")), r.css("zIndex", i.zIndex);
                },
                stop: function (t, n) {
                    var r = e(this).data("ui-draggable").options;
                    r._zIndex && e(n.helper).css("zIndex", r._zIndex);
                }
            });
        }(jQuery);
    } catch (r) {
        wx.jslog({
            src: "common/lib/jquery.ui.draggable.js"
        }, r);
    }
});
define("common/qq/events.js", [], function (e, t, n) {
    try {
        "use strict";
        function r(e) {
            e === !0 ? this.data = window.wx.events || {} : this.data = {};
        }

        r.prototype = {
            on: function (e, t) {
                return this.data[e] = this.data[e] || [], this.data[e].push(t), this;
            },
            off: function (e, t) {
                this.data[e] && this.data[e].length > 0 && (t && typeof t == "function" ? $.each(this.data[e], function (n, r) {
                    r === t && this.data[e].splice(n, 1);
                }) : this.data[e] = []);
            },
            trigger: function (e) {
                var t = arguments;
                this.data[e] && this.data[e].length > 0 && $.each(this.data[e], function (e, n) {
                    var r = n.apply(this, Array.prototype.slice.call(t, 1));
                    if (r === !1) return !1;
                });
            }
        }, n.exports = function (e) {
            return new r(e);
        };
    } catch (i) {
        wx.jslog({
            src: "common/qq/events.js"
        }, i);
    }
});
define("tpl/verifycode.html.js", [], function (e, t, n) {
    return '<div class="verifycode">\n	<span class="frm_input_box"><input id="imgcode" name="imgcode" type="text" value="" class="frm_input"></span>\n	<img src="">\n	<a href="javascript:;" class="changeVerifyCode">换一张</a>\n</div>\n';
});
define("public/js/pic/spin.js", [], function (e, t, n) {
    try {
        var r = function () {
            function e(e, t) {
                var n = ~~((e[a] - 1) / 2);
                for (var r = 1; r <= n; r++) t(e[r * 2 - 1], e[r * 2]);
            }

            function t(t) {
                var n = document.createElement(t || "div");
                return e(arguments, function (e, t) {
                    n[e] = t;
                }), n;
            }

            function n(e, t, r) {
                return r && !r[x] && n(e, r), e.insertBefore(t, r || null), e;
            }

            function r(e, t) {
                var n = [ p, t, ~~(e * 100) ].join("-"), r = "{" + p + ":" + e + "}", i;
                if (!H[n]) {
                    for (i = 0; i < P[a]; i++) try {
                        j.insertRule("@" + (P[i] && "-" + P[i].toLowerCase() + "-" || "") + "keyframes " + n + "{0%{" + p + ":1}" + t + "%" + r + "to" + r + "}", j.cssRules[a]);
                    } catch (s) {
                    }
                    H[n] = 1;
                }
                return n;
            }

            function i(e, t) {
                var n = e[m], r, i;
                if (n[t] !== undefined) return t;
                t = t.charAt(0).toUpperCase() + t.slice(1);
                for (i = 0; i < P[a]; i++) {
                    r = P[i] + t;
                    if (n[r] !== undefined) return r;
                }
            }

            function s(t) {
                return e(arguments, function (e, n) {
                    t[m][i(t, e) || e] = n;
                }), t;
            }

            function o(t) {
                return e(arguments, function (e, n) {
                    t[e] === undefined && (t[e] = n);
                }), t;
            }

            var u = "width", a = "length", f = "radius", l = "lines", c = "trail", h = "color", p = "opacity", d = "speed", v = "shadow", m = "style", g = "height", y = "left", b = "top", w = "px", E = "childNodes", S = "firstChild", x = "parentNode", T = "position", N = "relative", C = "absolute", k = "animation", L = "transform", A = "Origin", O = "Timeout", M = "coord", _ = "#000", D = m + "Sheets", P = "webkit0Moz0ms0O".split(0), H = {}, B;
            n(document.getElementsByTagName("head")[0], t(m));
            var j = document[D][document[D][a] - 1], F = function (e) {
                this.opts = o(e || {}, l, 12, c, 100, a, 7, u, 5, f, 10, h, _, p, .25, d, 1);
            }, I = F.prototype = {
                spin: function (e) {
                    var t = this, r = t.el = t[l](t.opts);
                    e && n(e, s(r, y, ~~(e.offsetWidth / 2) + w, b, ~~(e.offsetHeight / 2) + w), e[S]);
                    if (!B) {
                        var i = t.opts, o = 0, u = 20 / i[d], a = (1 - i[p]) / (u * i[c] / 100), f = u / i[l];
                        (function h() {
                            o++;
                            for (var e = i[l]; e; e--) {
                                var n = Math.max(1 - (o + e * f) % u * a, i[p]);
                                t[p](r, i[l] - e, n, i);
                            }
                            t[O] = t.el && window["set" + O](h, 50);
                        })();
                    }
                    return t;
                },
                stop: function () {
                    var e = this, t = e.el;
                    return window["clear" + O](e[O]), t && t[x] && t[x].removeChild(t), e.el = undefined, e;
                }
            };
            I[l] = function (e) {
                function i(n, r) {
                    return s(t(), T, C, u, e[a] + e[u] + w, g, e[u] + w, "background", n, "boxShadow", r, L + A, y, L, "rotate(" + ~~(360 / e[l] * E) + "deg) translate(" + e[f] + w + ",0)", "borderRadius", "100em");
                }

                var o = s(t(), T, N), m = r(e[p], e[c]), E = 0, S;
                for (; E < e[l]; E++) S = s(t(), T, C, b, 1 + ~(e[u] / 2) + w, L, "translate3d(0,0,0)", k, m + " " + 1 / e[d] + "s linear infinite " + (1 / e[l] / e[d] * E - 1 / e[d]) + "s"), e[v] && n(S, s(i(_, "0 0 4px " + _), b, 2 + w)), n(o, n(S, i(e[h], "0 0 1px rgba(0,0,0,.1)")));
                return o;
            }, I[p] = function (e, t, n) {
                e[E][t][m][p] = n;
            };
            var q = "behavior", R = "url(#default#VML)", U = "group0roundrect0fill0stroke".split(0);
            return function () {
                var e = s(t(U[0]), q, R), r;
                if (!i(e, L) && e.adj) {
                    for (r = 0; r < U[a]; r++) j.addRule(U[r], q + ":" + R);
                    I[l] = function () {
                        function e() {
                            return s(t(U[0], M + "size", c + " " + c, M + A, -o + " " + -o), u, c, g, c);
                        }

                        function r(r, a, c) {
                            n(d, n(s(e(), "rotation", 360 / i[l] * r + "deg", y, ~~a), n(s(t(U[1], "arcsize", 1), u, o, g, i[u], y, i[f], b, -i[u] / 2, "filter", c), t(U[2], h, i[h], p, i[p]), t(U[3], p, 0))));
                        }

                        var i = this.opts, o = i[a] + i[u], c = 2 * o, d = e(), m = ~(i[a] + i[f] + i[u]) + w, E;
                        if (i[v]) for (E = 1; E <= i[l]; E++) r(E, -2, "progid:DXImage" + L + ".Microsoft.Blur(pixel" + f + "=2,make" + v + "=1," + v + p + "=.3)");
                        for (E = 1; E <= i[l]; E++) r(E);
                        return n(s(t(), "margin", m + " 0 0 " + m, T, N), d);
                    }, I[p] = function (e, t, n, r) {
                        r = r[v] && r[l] || 0, e[S][E][t + r][S][S][p] = n;
                    };
                } else B = i(e, k);
            }(), F;
        }();
        $.fn.spin = function (e, t) {
            return this.each(function () {
                var n = $(this), i = n.data();
                i.spinner && (i.spinner.stop(), delete i.spinner), e !== !1 && (e = $.extend({
                    color: t || n.css("color")
                }, $.fn.spin.presets[e] || e), i.spinner = (new r(e)).spin(this));
            });
        }, $.fn.spin.presets = {
            tiny: {
                lines: 8,
                length: 2,
                width: 2,
                radius: 3
            },
            small: {
                lines: 8,
                length: 4,
                width: 3,
                radius: 5
            },
            large: {
                lines: 10,
                length: 8,
                width: 4,
                radius: 8
            }
        };
    } catch (i) {
        wx.jslog({
            src: "public/js/pic/spin.js"
        }, i);
    }
});
define("tpl/top.html.js", [], function (e, t, n) {
    return '<ul class="title_tab_navs">\n    {each data as o index}\n    {if (typeof o.acl == "undefined" || o.acl == 1)}\n    <li class="title_tab_nav js_top {o.className}" data-id="{o.id}"><a href="{o.url}">{o.name}</a></li>\n    {/if}\n    {/each}\n</ul>\n';
});
define("common/lib/swfobject.js", [], function (e, t, n) {
    try {
        var r = function () {
            function e() {
                if (U) return;
                try {
                    var e = M.getElementsByTagName("body")[0].appendChild(g("span"));
                    e.parentNode.removeChild(e);
                } catch (t) {
                    return;
                }
                U = !0;
                var n = P.length;
                for (var r = 0; r < n; r++) P[r]();
            }

            function t(e) {
                U ? e() : P[P.length] = e;
            }

            function n(e) {
                if (typeof O.addEventListener != x) O.addEventListener("load", e, !1); else if (typeof M.addEventListener != x) M.addEventListener("load", e, !1); else if (typeof O.attachEvent != x) y(O, "onload", e); else if (typeof O.onload == "function") {
                    var t = O.onload;
                    O.onload = function () {
                        t(), e();
                    };
                } else O.onload = e;
            }

            function i() {
                D ? s() : o();
            }

            function s() {
                var e = M.getElementsByTagName("body")[0], t = g(T);
                t.setAttribute("type", k);
                var n = e.appendChild(t);
                if (n) {
                    var r = 0;
                    (function () {
                        if (typeof n.GetVariable != x) {
                            var i = n.GetVariable("$version");
                            i && (i = i.split(" ")[1].split(","), $.pv = [ parseInt(i[0], 10), parseInt(i[1], 10), parseInt(i[2], 10) ]);
                        } else if (r < 10) {
                            r++, setTimeout(arguments.callee, 10);
                            return;
                        }
                        e.removeChild(t), n = null, o();
                    })();
                } else o();
            }

            function o() {
                var e = H.length;
                if (e > 0) for (var t = 0; t < e; t++) {
                    var n = H[t].id, r = H[t].callbackFn, i = {
                        success: !1,
                        id: n
                    };
                    if ($.pv[0] > 0) {
                        var s = m(n);
                        if (s) if (b(H[t].swfVersion) && !($.wk && $.wk < 312)) E(n, !0), r && (i.success = !0, i.ref = u(n), r(i)); else if (H[t].expressInstall && a()) {
                            var o = {};
                            o.data = H[t].expressInstall, o.width = s.getAttribute("width") || "0", o.height = s.getAttribute("height") || "0", s.getAttribute("class") && (o.styleclass = s.getAttribute("class")), s.getAttribute("align") && (o.align = s.getAttribute("align"));
                            var c = {}, h = s.getElementsByTagName("param"), p = h.length;
                            for (var d = 0; d < p; d++) h[d].getAttribute("name").toLowerCase() != "movie" && (c[h[d].getAttribute("name")] = h[d].getAttribute("value"));
                            f(o, c, n, r);
                        } else l(s), r && r(i);
                    } else {
                        E(n, !0);
                        if (r) {
                            var v = u(n);
                            v && typeof v.SetVariable != x && (i.success = !0, i.ref = v), r(i);
                        }
                    }
                }
            }

            function u(e) {
                var t = null, n = m(e);
                if (n && n.nodeName == "OBJECT") if (typeof n.SetVariable != x) t = n; else {
                    var r = n.getElementsByTagName(T)[0];
                    r && (t = r);
                }
                return t;
            }

            function a() {
                return !z && b("6.0.65") && ($.win || $.mac) && !($.wk && $.wk < 312);
            }

            function f(e, t, n, r) {
                z = !0, q = r || null, R = {
                    success: !1,
                    id: n
                };
                var i = m(n);
                if (i) {
                    i.nodeName == "OBJECT" ? (F = c(i), I = null) : (F = i, I = n), e.id = L;
                    if (typeof e.width == x || !/%$/.test(e.width) && parseInt(e.width, 10) < 310) e.width = "310";
                    if (typeof e.height == x || !/%$/.test(e.height) && parseInt(e.height, 10) < 137) e.height = "137";
                    M.title = M.title.slice(0, 47) + " - Flash Player Installation";
                    var s = $.ie && $.win ? "ActiveX" : "PlugIn", o = "MMredirectURL=" + O.location.toString().replace(/&/g, "%26") + "&MMplayerType=" + s + "&MMdoctitle=" + M.title;
                    typeof t.flashvars != x ? t.flashvars += "&" + o : t.flashvars = o;
                    if ($.ie && $.win && i.readyState != 4) {
                        var u = g("div");
                        n += "SWFObjectNew", u.setAttribute("id", n), i.parentNode.insertBefore(u, i), i.style.display = "none", function () {
                            i.readyState == 4 ? i.parentNode.removeChild(i) : setTimeout(arguments.callee, 10);
                        }();
                    }
                    h(e, t, n);
                }
            }

            function l(e) {
                if ($.ie && $.win && e.readyState != 4) {
                    var t = g("div");
                    e.parentNode.insertBefore(t, e), t.parentNode.replaceChild(c(e), t), e.style.display = "none", function () {
                        e.readyState == 4 ? e.parentNode.removeChild(e) : setTimeout(arguments.callee, 10);
                    }();
                } else e.parentNode.replaceChild(c(e), e);
            }

            function c(e) {
                var t = g("div");
                if ($.win && $.ie) t.innerHTML = e.innerHTML; else {
                    var n = e.getElementsByTagName(T)[0];
                    if (n) {
                        var r = n.childNodes;
                        if (r) {
                            var i = r.length;
                            for (var s = 0; s < i; s++) (r[s].nodeType != 1 || r[s].nodeName != "PARAM") && r[s].nodeType != 8 && t.appendChild(r[s].cloneNode(!0));
                        }
                    }
                }
                return t;
            }

            function h(e, t, n) {
                var r, i = m(n);
                if ($.wk && $.wk < 312) return r;
                if (i) {
                    typeof e.id == x && (e.id = n);
                    if ($.ie && $.win) {
                        var s = "";
                        for (var o in e) e[o] != Object.prototype[o] && (o.toLowerCase() == "data" ? t.movie = e[o] : o.toLowerCase() == "styleclass" ? s += ' class="' + e[o] + '"' : o.toLowerCase() != "classid" && (s += " " + o + '="' + e[o] + '"'));
                        var u = "";
                        for (var a in t) t[a] != Object.prototype[a] && (u += '<param name="' + a + '" value="' + t[a] + '" />');
                        i.outerHTML = '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"' + s + ">" + u + "</object>", B[B.length] = e.id, r = m(e.id);
                    } else {
                        var f = g(T);
                        f.setAttribute("type", k);
                        for (var l in e) e[l] != Object.prototype[l] && (l.toLowerCase() == "styleclass" ? f.setAttribute("class", e[l]) : l.toLowerCase() != "classid" && f.setAttribute(l, e[l]));
                        for (var c in t) t[c] != Object.prototype[c] && c.toLowerCase() != "movie" && p(f, c, t[c]);
                        i.parentNode.replaceChild(f, i), r = f;
                    }
                }
                return r;
            }

            function p(e, t, n) {
                var r = g("param");
                r.setAttribute("name", t), r.setAttribute("value", n), e.appendChild(r);
            }

            function d(e) {
                var t = m(e);
                t && t.nodeName == "OBJECT" && ($.ie && $.win ? (t.style.display = "none", function () {
                    t.readyState == 4 ? v(e) : setTimeout(arguments.callee, 10);
                }()) : t.parentNode.removeChild(t));
            }

            function v(e) {
                var t = m(e);
                if (t) {
                    for (var n in t) typeof t[n] == "function" && (t[n] = null);
                    t.parentNode.removeChild(t);
                }
            }

            function m(e) {
                var t = null;
                try {
                    t = M.getElementById(e);
                } catch (n) {
                }
                return t;
            }

            function g(e) {
                return M.createElement(e);
            }

            function y(e, t, n) {
                e.attachEvent(t, n), j[j.length] = [ e, t, n ];
            }

            function b(e) {
                var t = $.pv, n = e.split(".");
                return n[0] = parseInt(n[0], 10), n[1] = parseInt(n[1], 10) || 0, n[2] = parseInt(n[2], 10) || 0, t[0] > n[0] || t[0] == n[0] && t[1] > n[1] || t[0] == n[0] && t[1] == n[1] && t[2] >= n[2] ? !0 : !1;
            }

            function w(e, t, n, r) {
                if ($.ie && $.mac) return;
                var i = M.getElementsByTagName("head")[0];
                if (!i) return;
                var s = n && typeof n == "string" ? n : "screen";
                r && (W = null, X = null);
                if (!W || X != s) {
                    var o = g("style");
                    o.setAttribute("type", "text/css"), o.setAttribute("media", s), W = i.appendChild(o), $.ie && $.win && typeof M.styleSheets != x && M.styleSheets.length > 0 && (W = M.styleSheets[M.styleSheets.length - 1]), X = s;
                }
                $.ie && $.win ? W && typeof W.addRule == T && W.addRule(e, t) : W && typeof M.createTextNode != x && W.appendChild(M.createTextNode(e + " {" + t + "}"));
            }

            function E(e, t) {
                if (!V) return;
                var n = t ? "visible" : "hidden";
                U && m(e) ? m(e).style.visibility = n : w("#" + e, "visibility:" + n);
            }

            function S(e) {
                var t = /[\\\"<>\.;]/, n = t.exec(e) != null;
                return n && typeof encodeURIComponent != x ? encodeURIComponent(e) : e;
            }

            var x = "undefined", T = "object", N = "Shockwave Flash", C = "ShockwaveFlash.ShockwaveFlash", k = "application/x-shockwave-flash", L = "SWFObjectExprInst", A = "onreadystatechange", O = window, M = document, _ = navigator, D = !1, P = [ i ], H = [], B = [], j = [], F, I, q, R, U = !1, z = !1, W, X, V = !0, $ = function () {
                var e = typeof M.getElementById != x && typeof M.getElementsByTagName != x && typeof M.createElement != x, t = _.userAgent.toLowerCase(), n = _.platform.toLowerCase(), r = n ? /win/.test(n) : /win/.test(t), i = n ? /mac/.test(n) : /mac/.test(t), s = /webkit/.test(t) ? parseFloat(t.replace(/^.*webkit\/(\d+(\.\d+)?).*$/, "$1")) : !1, o = !1, u = [ 0, 0, 0 ], a = null;
                if (typeof _.plugins != x && typeof _.plugins[N] == T) a = _.plugins[N].description, a && (typeof _.mimeTypes == x || !_.mimeTypes[k] || !!_.mimeTypes[k].enabledPlugin) && (D = !0, o = !1, a = a.replace(/^.*\s+(\S+\s+\S+$)/, "$1"), u[0] = parseInt(a.replace(/^(.*)\..*$/, "$1"), 10), u[1] = parseInt(a.replace(/^.*\.(.*)\s.*$/, "$1"), 10), u[2] = /[a-zA-Z]/.test(a) ? parseInt(a.replace(/^.*[a-zA-Z]+(.*)$/, "$1"), 10) : 0); else if (typeof O.ActiveXObject != x) try {
                    var f = new ActiveXObject(C);
                    f && (a = f.GetVariable("$version"), a && (o = !0, a = a.split(" ")[1].split(","), u = [ parseInt(a[0], 10), parseInt(a[1], 10), parseInt(a[2], 10) ]));
                } catch (l) {
                }
                return {
                    w3: e,
                    pv: u,
                    wk: s,
                    ie: o,
                    win: r,
                    mac: i
                };
            }(), J = function () {
                if (!$.w3) return;
                (typeof M.readyState != x && M.readyState == "complete" || typeof M.readyState == x && (M.getElementsByTagName("body")[0] || M.body)) && e(), U || (typeof M.addEventListener != x && M.addEventListener("DOMContentLoaded", e, !1), $.ie && $.win && (M.attachEvent(A, function () {
                    M.readyState == "complete" && (M.detachEvent(A, arguments.callee), e());
                }), O == top && function () {
                    if (U) return;
                    try {
                        M.documentElement.doScroll("left");
                    } catch (t) {
                        setTimeout(arguments.callee, 0);
                        return;
                    }
                    e();
                }()), $.wk && function () {
                    if (U) return;
                    if (!/loaded|complete/.test(M.readyState)) {
                        setTimeout(arguments.callee, 0);
                        return;
                    }
                    e();
                }(), n(e));
            }(), K = function () {
                $.ie && $.win && window.attachEvent("onunload", function () {
                    var e = j.length;
                    for (var t = 0; t < e; t++) j[t][0].detachEvent(j[t][1], j[t][2]);
                    var n = B.length;
                    for (var i = 0; i < n; i++) d(B[i]);
                    for (var s in $) $[s] = null;
                    $ = null;
                    for (var o in r) r[o] = null;
                    r = null;
                });
            }();
            return {
                registerObject: function (e, t, n, r) {
                    if ($.w3 && e && t) {
                        var i = {};
                        i.id = e, i.swfVersion = t, i.expressInstall = n, i.callbackFn = r, H[H.length] = i, E(e, !1);
                    } else r && r({
                        success: !1,
                        id: e
                    });
                },
                getObjectById: function (e) {
                    if ($.w3) return u(e);
                },
                embedSWF: function (e, n, r, i, s, o, u, l, c, p) {
                    var d = {
                        success: !1,
                        id: n
                    };
                    $.w3 && !($.wk && $.wk < 312) && e && n && r && i && s ? (E(n, !1), t(function () {
                        r += "", i += "";
                        var t = {};
                        if (c && typeof c === T) for (var v in c) t[v] = c[v];
                        t.data = e, t.width = r, t.height = i;
                        var m = {};
                        if (l && typeof l === T) for (var g in l) m[g] = l[g];
                        if (u && typeof u === T) for (var y in u) typeof m.flashvars != x ? m.flashvars += "&" + y + "=" + u[y] : m.flashvars = y + "=" + u[y];
                        if (b(s)) {
                            var w = h(t, m, n);
                            t.id == n && E(n, !0), d.success = !0, d.ref = w;
                        } else {
                            if (o && a()) {
                                t.data = o, f(t, m, n, p);
                                return;
                            }
                            E(n, !0);
                        }
                        p && p(d);
                    })) : p && p(d);
                },
                switchOffAutoHideShow: function () {
                    V = !1;
                },
                ua: $,
                getFlashPlayerVersion: function () {
                    return {
                        major: $.pv[0],
                        minor: $.pv[1],
                        release: $.pv[2]
                    };
                },
                hasFlashPlayerVersion: b,
                createSWF: function (e, t, n) {
                    return $.w3 ? h(e, t, n) : undefined;
                },
                showExpressInstall: function (e, t, n, r) {
                    $.w3 && a() && f(e, t, n, r);
                },
                removeSWF: function (e) {
                    $.w3 && d(e);
                },
                createCSS: function (e, t, n, r) {
                    $.w3 && w(e, t, n, r);
                },
                addDomLoadEvent: t,
                addLoadEvent: n,
                getQueryParamValue: function (e) {
                    var t = M.location.search || M.location.hash;
                    if (t) {
                        /\?/.test(t) && (t = t.split("?")[1]);
                        if (e == null) return S(t);
                        var n = t.split("&");
                        for (var r = 0; r < n.length; r++) if (n[r].substring(0, n[r].indexOf("=")) == e) return S(n[r].substring(n[r].indexOf("=") + 1));
                    }
                    return "";
                },
                expressInstallCallback: function () {
                    if (z) {
                        var e = m(L);
                        e && F && (e.parentNode.replaceChild(F, e), I && (E(I, !0), $.ie && $.win && (F.style.display = "block")), q && q(R)), z = !1;
                    }
                }
            };
        }();
        return r;
    } catch (i) {
        wx.jslog({
            src: "common/lib/swfobject.js"
        }, i);
    }
});
define("tpl/uploader.html.js", [], function (e, t, n) {
    return '<li id="uploadItem{id}" data-status="{className}" class="upload_file">\n    <strong class="upload_file_name">{fileName}</strong>\n    <span class="upload_file_size">({size})</span>\n    <div class="progress_bar"><div class="progress_bar_thumb" style="width:0%"></div></div>\n    <em class="upload_file_status {className}">{status}</em>\n</li>\n';
});
define("common/lib/uploadify.js", [ "common/lib/swfobject.js" ], function (e, t, n) {
    try {
        var r = e("common/lib/swfobject.js");
        $.extend($.fn, {
            uploadify: function (e) {
                $(this).each(function () {
                    var t = $(this), n = t.attr("id"), i = location.pathname, s = $.extend({
                        id: n,
                        uploader: "uploadify.swf",
                        script: "uploadify.php",
                        expressInstall: null,
                        folder: "",
                        height: null,
                        width: null,
                        cancelImg: "cancel.png",
                        wmode: "opaque",
                        scriptAccess: "always",
                        fileDataName: "Filedata",
                        method: "POST",
                        queueSizeLimit: 5,
                        simUploadLimit: 1,
                        queueID: !1,
                        displayData: "percentage",
                        buttonImg: null,
                        buttonText: "",
                        rollover: !1,
                        hideButton: !0,
                        onInit: function () {
                        },
                        onSelect: function () {
                        },
                        onQueueFull: function () {
                        },
                        onCheck: function () {
                        },
                        onCancel: function () {
                        },
                        onError: function () {
                        },
                        onProgress: function () {
                        },
                        onComplete: function () {
                        },
                        onAllComplete: function () {
                        }
                    }, e);
                    i = i.split("/"), i.pop(), i = i.join("/") + "/";
                    var o = {};
                    o.uploadifyID = s.id, o.pagepath = i, s.buttonImg && (o.buttonImg = escape(s.buttonImg)), s.buttonText && (o.buttonText = escape(s.buttonText)), s.rollover && (o.rollover = !0), o.script = encodeURIComponent(s.script), o.folder = escape(s.folder);
                    if (s.scriptData) {
                        var u = "";
                        for (var a in s.scriptData) u += "&" + a + "=" + s.scriptData[a];
                        o.scriptData = escape(u.substr(1));
                    }
                    o.width = s.width || t.outerWidth(), o.height = s.height || t.outerHeight(), o.wmode = s.wmode, o.method = s.method, o.queueSizeLimit = s.queueSizeLimit, o.simUploadLimit = s.simUploadLimit, s.hideButton && (o.hideButton = !0), s.fileDesc && (o.fileDesc = s.fileDesc), s.fileExt && (o.fileExt = s.fileExt), s.multi && (o.multi = !0), s.auto && (o.auto = !0), s.sizeLimit && (o.sizeLimit = s.sizeLimit), s.checkScript && (o.checkScript = s.checkScript), s.fileDataName && (o.fileDataName = s.fileDataName), s.queueID && (o.queueID = s.queueID);
                    if (s.onInit() !== !1) {
                        var f = t.offset();
                        t.parent().append($('<div id="' + n + 'Uploader"></div>')).parent().addClass("upload_box"), r.switchOffAutoHideShow(), r.registerObject("flashAntelope", "9.0.0"), r.embedSWF(s.uploader, s.id + "Uploader", "100%", "100%", "9.0.24", s.expressInstall, o, {
                            quality: "high",
                            wmode: s.wmode,
                            allowScriptAccess: s.scriptAccess
                        }), s.queueID == 0 && $("#" + n + "Uploader").after('<div id="' + n + 'Queue" class="uploadifyQueue"></div>');
                    }
                    typeof s.onOpen == "function" && t.bind("uploadifyOpen", s.onOpen), t.bind("uploadifySelect", {
                        action: s.onSelect,
                        queueID: s.queueID
                    }, function (e, n, r) {
                        e.data.action(e, n, r) === !1 && document.getElementById(t.attr("id") + "Uploader").cancelFileUpload(n, !0, !1);
                    }), typeof s.onSelectOnce == "function" && t.bind("uploadifySelectOnce", s.onSelectOnce), t.bind("uploadifyQueueFull", {
                        action: s.onQueueFull
                    }, function (e, t) {
                        e.data.action(e, t) !== !1 && alert("The queue is full.  The max size is " + t + ".");
                    }), t.bind("uploadifyCancel", {
                        action: s.onCancel
                    }, function (e, t, r, i, s) {
                        if (e.data.action(e, t, r, i, s) !== !1) {
                            var o = s == 1 ? 0 : 250;
                            $("#" + n + t).fadeOut(o, function () {
                                $(this).remove();
                            });
                        }
                    }), typeof s.onClearQueue == "function" && t.bind("uploadifyClearQueue", s.onClearQueue);
                    var l = [];
                    t.bind("uploadifyError", {
                        action: s.onError
                    }, function (e, t, r, i) {
                        if (e.data.action(e, t, r, i) !== !1) {
                            var s = new Array(t, r, i);
                            l.push(s), $("#" + n + t + " .percentage").text(" - " + i.type + " Error"), $("#" + n + t).addClass("uploadifyError");
                        }
                    }), t.bind("uploadifyProgress", {
                        action: s.onProgress,
                        toDisplay: s.displayData
                    }, function (e, t, r, i) {
                        e.data.action(e, t, r, i) !== !1 && ($("#" + n + t + "ProgressBar").css("width", i.percentage + "%"), e.data.toDisplay == "percentage" && (displayData = " - " + i.percentage + "%"), e.data.toDisplay == "speed" && (displayData = " - " + i.speed + "KB/s"), e.data.toDisplay == null && (displayData = " "), $("#" + n + t + " .percentage").text(displayData));
                    }), t.bind("uploadifyComplete", {
                        action: s.onComplete
                    }, function (e, t, n, r, i) {
                        e.data.action(e, t, n, unescape(r), i) !== !1;
                    }), typeof s.onAllComplete == "function" && t.bind("uploadifyAllComplete", {
                        action: s.onAllComplete
                    }, function (e, t) {
                        e.data.action(e, t) !== !1 && (l = []);
                    });
                });
            },
            uploadifySettings: function (e, t, n) {
                var r = !1;
                this$.each(function () {
                    if (e == "scriptData" && t != null) {
                        if (n) var i = t; else var i = $.extend(settings.scriptData, t);
                        var s = "";
                        for (var o in i) s += "&" + o + "=" + escape(i[o]);
                        t = s.substr(1);
                    }
                    r = document.getElementById(id + "Uploader").updateSettings(e, t);
                });
                if (t == null) {
                    if (e == "scriptData") {
                        var i = unescape(r).split("&"), s = new Object;
                        for (var o = 0; o < i.length; o++) {
                            var u = i[o].split("=");
                            s[u[0]] = u[1];
                        }
                        r = s;
                    }
                    return r;
                }
            },
            uploadifyUpload: function (e) {
                $(this).each(function () {
                    document.getElementById($(this).attr("id") + "Uploader").startFileUpload(e, !1);
                });
            },
            uploadifyCancel: function (e) {
                $(this).each(function () {
                    document.getElementById($(this).attr("id") + "Uploader").cancelFileUpload(e, !0, !1);
                });
            },
            uploadifyClearQueue: function () {
                $(this).each(function () {
                    document.getElementById($(this).attr("id") + "Uploader").clearFileUploadQueue(!1);
                });
            }
        });
    } catch (i) {
        wx.jslog({
            src: "common/lib/uploadify.js"
        }, i);
    }
});
define("common/lib/json.js", [], function (require, exports, module) {
    try {
        return typeof JSON != "object" && (JSON = {}), function () {
            "use strict";
            function f(e) {
                return e < 10 ? "0" + e : e;
            }

            function quote(e) {
                return escapable.lastIndex = 0, escapable.test(e) ? '"' + e.replace(escapable, function (e) {
                    var t = meta[e];
                    return typeof t == "string" ? t : "\\u" + ("0000" + e.charCodeAt(0).toString(16)).slice(-4);
                }) + '"' : '"' + e + '"';
            }

            function str(e, t) {
                var n, r, i, s, o = gap, u, a = t[e];
                a && typeof a == "object" && typeof a.toJSON == "function" && (a = a.toJSON(e)), typeof rep == "function" && (a = rep.call(t, e, a));
                switch (typeof a) {
                    case "string":
                        return quote(a);
                    case "number":
                        return isFinite(a) ? String(a) : "null";
                    case "boolean":
                    case "null":
                        return String(a);
                    case "object":
                        if (!a) return "null";
                        gap += indent, u = [];
                        if (Object.prototype.toString.apply(a) === "[object Array]") {
                            s = a.length;
                            for (n = 0; n < s; n += 1) u[n] = str(n, a) || "null";
                            return i = u.length === 0 ? "[]" : gap ? "[\n" + gap + u.join(",\n" + gap) + "\n" + o + "]" : "[" + u.join(",") + "]", gap = o, i;
                        }
                        if (rep && typeof rep == "object") {
                            s = rep.length;
                            for (n = 0; n < s; n += 1) typeof rep[n] == "string" && (r = rep[n], i = str(r, a), i && u.push(quote(r) + (gap ? ": " : ":") + i));
                        } else for (r in a) Object.prototype.hasOwnProperty.call(a, r) && (i = str(r, a), i && u.push(quote(r) + (gap ? ": " : ":") + i));
                        return i = u.length === 0 ? "{}" : gap ? "{\n" + gap + u.join(",\n" + gap) + "\n" + o + "}" : "{" + u.join(",") + "}", gap = o, i;
                }
            }

            typeof Date.prototype.toJSON != "function" && (Date.prototype.toJSON = function (e) {
                return isFinite(this.valueOf()) ? this.getUTCFullYear() + "-" + f(this.getUTCMonth() + 1) + "-" + f(this.getUTCDate()) + "T" + f(this.getUTCHours()) + ":" + f(this.getUTCMinutes()) + ":" + f(this.getUTCSeconds()) + "Z" : null;
            }, String.prototype.toJSON = Number.prototype.toJSON = Boolean.prototype.toJSON = function (e) {
                return this.valueOf();
            });
            var cx = /[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g, escapable = /[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g, gap, indent, meta = {
                "\b": "\\b",
                "	": "\\t",
                "\n": "\\n",
                "\f": "\\f",
                "\r": "\\r",
                '"': '\\"',
                "\\": "\\\\"
            }, rep;
            JSON.stringify2 = function (e, t, n) {
                var r;
                gap = "", indent = "";
                if (typeof n == "number") for (r = 0; r < n; r += 1) indent += " "; else typeof n == "string" && (indent = n);
                rep = t;
                if (!t || typeof t == "function" || typeof t == "object" && typeof t.length == "number") return str("", {
                    "": e
                });
                throw new Error("JSON.stringify");
            }, typeof JSON.parse != "function" && (JSON.parse = function (text, reviver) {
                function walk(e, t) {
                    var n, r, i = e[t];
                    if (i && typeof i == "object") for (n in i) Object.prototype.hasOwnProperty.call(i, n) && (r = walk(i, n), r !== undefined ? i[n] = r : delete i[n]);
                    return reviver.call(e, t, i);
                }

                var j;
                text = String(text), cx.lastIndex = 0, cx.test(text) && (text = text.replace(cx, function (e) {
                    return "\\u" + ("0000" + e.charCodeAt(0).toString(16)).slice(-4);
                }));
                if (/^[\],:{}\s]*$/.test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g, "@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, "]").replace(/(?:^|:|,)(?:\s*\[)+/g, ""))) return j = eval("(" + text + ")"), typeof reviver == "function" ? walk({
                    "": j
                }, "") : j;
                throw new SyntaxError("JSON.parse");
            });
        }(), JSON;
    } catch (e) {
        wx.jslog({
            src: "common/lib/json.js"
        }, e);
    }
});
define("tpl/popup.html.js", [], function (e, t, n) {
    return '<div class="dialog_wrp {className}" style="{if width}width:{width}px;{/if}{if height}height:{height}px;{/if}">\n	<div class="dialog">\n		<div class="dialog_hd">\n			<h3>{title}</h3>\n			<a href="javascript:;" class="icon16_opr closed pop_closed">关闭</a>\n		</div>\n		<div class="dialog_bd">{=content}</div>\n		{if buttons && buttons.length}\n		<div class="dialog_ft">\n			{each buttons as bt index}\n            <span class="btn {bt.type} btn_input js_btn_p"><button class="js_btn" data-index="{index}">{bt.text}</button></span>\n	        {/each}\n		</div>\n		{/if}\n	</div>\n</div>{if mask}<div class="mask"><iframe frameborder="0" style="filter:progid:DXImageTransform.Microsoft.Alpha(opacity:0);position:absolute;top:0px;left:0px;width:100%;height:100%;" src="about:blank"></iframe></div>{/if}\n';
});
define("common/wx/widgetBridge.js", [], function (e, t, n) {
    try {
        "use strict", $.widgetBridge || ($.widgetBridge = function (e, t) {
            var n = e, r = n.split("."), e = r.length > 1 ? r[1] : r[0];
            $.fn[e] = function (r) {
                var i = typeof r == "string", s = [].slice.call(arguments, 1), o = this;
                r = r || {};
                if (i) {
                    var u;
                    return r.indexOf("_") !== 0 && this.each(function () {
                        var t = $.data(this, n);
                        if (!t) return $.error("cannot call methods on " + e + " prior to initialization; " + "attempted to call method '" + r + "'");
                        if (r === "instance") return u = t, !1;
                        if (r === "option") return u = t.options, !1;
                        u || (u = (t[r] || jQuery.noop).apply(t, s)), r === "destroy" && (t.elements = null);
                    }), u;
                }
                var a = this;
                return this.each(function () {
                    var e = this, i = $.data(this, n);
                    if (!i) {
                        i = $.extend(!0, {}, t), i.destroy || (i.destroy = function () {
                            $.removeData(e, n);
                        }), i.options = $.extend(!0, i.options || {}, r), i.element = $(this), i.elements = a, i._create && (o = i._create.call(i, r));
                        var s = o && o.length && o.get(0) || this;
                        $.data(s, n, i);
                    }
                }), o;
            };
        });
    } catch (r) {
        wx.jslog({
            src: "common/wx/widgetBridge.js"
        }, r);
    }
});
define("common/wx/verifycode.js", [ "xss/ui/verifycode.css", "tpl/verifycode.html.js", "common/qq/events.js" ], function (e, t, n) {
    try {
        "use strict", e("xss/ui/verifycode.css");
        var r = e("tpl/verifycode.html.js"), i = "/cgi-bin/verifycode?r=", s = e("common/qq/events.js"), o = s(!0);

        function u(e) {
            var t = this;
            this.$dom = $(r), this.$img = this.$dom.find("img"), this.$input = this.$dom.find("input"), this.$img.on("load", function () {
                o.trigger("VerifyCode:load", t);
            }), this.$dom.find("a").click(function (e) {
                t.$img.attr("src", i + +(new Date));
            }).click(), e && $(e).append(this.$dom) && (this.$container = $(e));
        }

        u.prototype.getCode = function () {
            return this.$input.val();
        }, u.prototype.focus = function () {
            this.$input.focus();
        }, u.prototype.getInput = function () {
            return this.$input;
        }, u.prototype.refresh = function () {
            this.$img.attr("src", i + +(new Date));
        }, $.fn.verifycode = function () {
            return this.each(function () {
                $.data(this, "verifycode", new u(this));
            });
        }, n.exports = u;
    } catch (a) {
        wx.jslog({
            src: "common/wx/verifycode.js"
        }, a);
    }
});
define("public/js/pic/mask.js", [ "pic/spin.js" ], function (e, t, n) {
    try {
        "use strict", e("public/js/pic/spin.js");
        var r = 0, i = '<div class="mask"></div>';

        function s(e) {
            if (this.mask) this.mask.show(); else {
                var t = "body";
                e && !!e.parent && (t = $(e.parent)), this.mask = $(i).appendTo(t), this.mask.id = "wxMask_" + ++r;
            }
            if (e) {
                if (e.spin === !1) return this;
                this.mask.spin(e.spin || "flower");
            }
            return this;
        }

        s.prototype = {
            show: function () {
                this.mask.show();
            },
            hide: function () {
                this.mask.hide();
            },
            remove: function () {
                this.mask.remove();
            }
        }, t.show = function (e) {
            return new s(e);
        }, t.hide = function () {
            $(".mask").hide();
        }, t.remove = function () {
            $(".mask").remove();
        };
    } catch (o) {
        wx.jslog({
            src: "public/js/list/mask.js"
        }, o);
    }
});
define("public/js/pic/editor.html.js", [], function (e, t, n) {
    return '<div class="appmsg_editor">\n	<div class="inner">\n		<div class="appmsg_edit_item">\n			<label for="" class="frm_label">标题</label>\n			<span class="frm_input_box"><input type="text" class="frm_input js_title"></span>\n		</div>\n		<div class="appmsg_edit_item">\n			<label for="" class="frm_label">\n				<strong class="title">标签</strong>\n				<p class="tips l">（选填）</p>\n			</label>\n			<span class="frm_input_box"><input type="text" class="frm_input js_author "></span>\n		</div>\n		<div class="appmsg_edit_item">\n			<label for="" class="frm_label">\n				<strong class="title">封面</strong>\n				<p class="js_cover_tip tips r"></p>\n			</label>\n			<div class="frm_input_box">\n                <div class="upload_box">\n                    <div class="upload_area">\n                        <div id="fileDiv" style="height:0px; overflow:hidden; width:0;"><input type="file" data-role="none" name="fdPic" id="uploadPic"/></div><a id="js_appmsg_upload_cover" href="javascript:void(0);" onclick="return false;" class="upload_access">\n                            <i class="icon18_common upload_gray"></i>\n                            上传                        </a>\n                    </div>\n                </div>&nbsp;\n                <p class="js_cover upload_preview">\n					<a class="js_removeCover" href="javascript:void(0);" onclick="return false;">删除</a>\n                </p>\n			</div>\n		</div>\n        {if type==10}\n		<p><a class="js_addDesc" href="javascript:void(0);" onclick="return false;">添加摘要</a></p>\n		<div class="js_desc_area dn appmsg_edit_item">\n			<label for="" class="frm_label">摘要</label>\n			<span class="frm_textarea_box"><textarea class="js_desc frm_textarea"></textarea></span>\n		</div>\n		<div id="js_ueditor" class="appmsg_edit_item content_edit">\n            <a href="javascript:void(0);" class="icon16_common close jsClose" onclick="return false;">关闭</a>\n            <label for="" class="frm_label">\n                <strong class="title">正文</strong>\n                <p class="tips r">\n                    <em id="js_auto_tips"></em> \n                	<a id="js_cancle" style="display:none;" href="javascript:void(0);" onclick="return false;">取消</a>\n                </p>\n            </label>\n			<div id="js_editor" class="edui_editor_wrp">\n				\n			</div>\n            <div class="tool_bar">\n                <a id="js_finish_zoom" onclick="return false;" href="javascript:void(0);" class="btn btn_primary">完成编辑</a>\n            </div>\n        </div>\n		<p><a class="js_addURL" href="javascript:void(0);" onclick="return false;">添加原文链接</a></p>\n		<div class="js_url_area dn appmsg_edit_item">\n			<label for="" class="frm_label">原文链接</label>\n			<span class="frm_input_box"><input type="text" class="js_url frm_input"></span>\n		</div>\n        {else}\n		<div class="js_desc_area appmsg_edit_item">\n			<label for="" class="frm_label">描述</label>\n			<span class="frm_textarea_box"><textarea class="js_desc frm_textarea"></textarea></span>\n		</div>\n		<div class="js_url_area appmsg_edit_item">\n			<label for="" class="frm_label">商品链接</label>\n			<span class="frm_input_box"><input type="text" class="js_url frm_input"></span>\n		</div>\n        {/if}\n	</div>\n	<i class="arrow arrow_out"></i>\n	<i class="arrow arrow_in"></i>\n</div>\n';
});