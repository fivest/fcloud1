try {
    (function (e) {
        if (/msie 6/i.test(navigator.userAgent)) {
            window.location = "/cgi-bin/readtemplate?t=err/noie6_tmpl";
            return;
        }
        window.console || (window.console = {
            log: function () {
            },
            error: function () {
            },
            info: function () {
            }
        }), function () {
            function e() {
                var e = {};
                $("#menuBar").find(".menu").each(function () {
                    var t = $(this), n = t.attr("id"), r = n.substr("menu_".length);
                    t.hasClass("closed") || (e[r] = !0);
                });
                var t = wx.data.uin + ":" + Cookies.stringify(e);
                Cookies.set("menu_status", t);
            }

            $("#menuBar").on("click", "dt", function () {
                $(this).parent().hasClass("closed") ? $(this).parent().removeClass("closed") : $(this).parent().addClass("closed"), e();
            }), $("#menuBar").on("selectstart", function () {
                return !1;
            }), wx.selectMenu = function (t) {
                var n = "selected";
                $("#menuBar .menu").removeClass(n), $("#menuBar .menu_item").removeClass(n);
                var r = window.Cookies.get("menu_status");
                r = r ? Cookies.parse(r) : {}, r = r[wx.data.uin] || {};
                var i = $("#menu_" + t).addClass(n), s = i.parent().filter(".menu").addClass(n);
                $.isEmptyObject(r) && s.removeClass("closed"), e();
            };
        }(), e.wx = e.wx || {}, wx.T = function (e, t) {
            return template.compile(e)(t);
        }, wx.url = function (e) {
            if (e.startsWith("javasript:")) return e;
            var t = wx.data.param;
            return e.indexOf("?") != -1 ? e + t : e + "?1=1" + t;
        }, wx.getUrl = function (e) {
            var t = (window.location + "&").match(new RegExp("(?:\\?|\\&)" + e + "=(.*?)\\&"));
            if (t && t[1]) return String(t[1]).html(!0);
        }, function () {
            function t(e, t) {
                if (t.indexOf("ueditor") != -1 || t.indexOf("media/appmsg_edit") != -1) return;
                jQuery.ajax({
                    url: "/cgi-bin/jslog?1=1" + wx.data.param,
                    data: {
                        content: t,
                        id: e,
                        level: "error"
                    },
                    type: "POST"
                });
            }

            var e = {
                fakeid: wx.data.uin,
                userAgent: window.navigator.userAgent,
                url: location.href
            };
            window.onerror = function (n, r, i) {
                n != "Script error." && t(3, "[fakeid={fakeid}] [runtime] [url={url}] [useragent={userAgent}] [line={line}] [msg={msg}]".format(e).format({
                    msg: n,
                    url: r,
                    line: i
                }));
            }, jQuery("img").error(function () {
                t(1, "[fakeid={fakeid}] [img] [url={url}] [useragent={userAgent}] [src={0}]".format(e).format([ jQuery(this).src || "" ]));
            }), jQuery("script").error(function () {
                t(2, "[fakeid={fakeid}] [script] [url={url}] [useragent={userAgent}] [src={0}]".format(e).format([ jQuery(this).src || "" ]));
            }), wx.jslog = function (n, r) {
                n = jQuery.extend(n, e);
                var i = [];
                !r || jQuery.each([ "message", "stack", "lineNumber" ], function (e, t) {
                    i.push(t + ":" + (r[t] || ""));
                }), n.e = i.join(";");
                var s = "[fakeid={fakeid}] [script] [url={url}] [useragent={userAgent}] [src={src}] [exception={e}]".format(n);
                throw t(3, s), r;
            };
        }(), setTimeout(function () {
            seajs.use("common/lib/store.js", function (e) {
                var t = $("#logout");
                t.click(function () {
                    function r() {
                        var t = e.get(n);
                        return new Date - t > 864e5;
                    }

                    e.remove("hasNotice"), e.remove("templateClassStatus"), e.remove("templateClassStatusTime");
                    var t = "__draft__" + wx.data.uin, n = "__draft__time__" + wx.data.uin;
                    r() && (e.remove(t), e.remove(n));
                });
            });
        }, 5e3), wx.resPath = location.hostname == "mp.weixin.qq.com" ? "https://res.wx.qq.com" : "";
    })(window);
} catch (e) {
//    wx.jslog({
//        src: "wx/wx.js"
//    }, m);
}
;
;//样式居中
$.fn.extend({
    center: function () {
        this.css("position", "absolute"), this.css("top", ($(window).height() - this.height()) / 2 + $(window).scrollTop() + "px"), this.css("left", ($(window).width() - this.width()) / 2 + $(window).scrollLeft() + "px");
    }
});
;
$.fn.disable = function (e) {
    e = e || "btn_disabled";
    var t = this.hasClass("btn_input") ? this.find("button") : this;
    return t.attr("disabled", "disabled"), e && this.addClass(e), this.parent().filter(".btn_input").addClass(e), this;
}, $.fn.enable = function (e) {
    e = e || "btn_disabled";
    var t = this.hasClass("btn_input") ? this.find("button") : this;
    return t.attr("disabled", !1), e && this.removeClass(e), this.parent().filter(".btn_input").removeClass(e), this;
}, function () {
    var e = function (e) {
        e = e || "btn_loading";
        var t = this.hasClass("btn_input") ? this.find("button") : this;
        return t.prepend("<i></i>"), this.disable(e), this;
    }, t = function (e) {
        e = e || "btn_loading";
        var t = this.hasClass("btn_input") ? this.find("button") : this;
        return t.find("i:first-child").remove(), this.enable(e), this;
    };
    $.fn.btn = function (n, r) {
        return n ? t.call(this, r) : e.call(this, r);
    };
}();
;//滚屏延迟加载
$.fn.scrollLoading = function (e) {
    function r(t) {
        return t.offset().top > $(window).scrollTop() && t.offset().top + t.height() < $(window).scrollTop() + $(window).height() + e.pre;
    }

    function i() {
        $.each(n, function (t, n) {
            var i = r($(n.obj));
            i && (n.src && n.tag.toLowerCase() == "img" && (n.obj.src = n.src, n.obj.data_src = n.src = ""), $.isFunction(e.callback) ? e.callback.apply(n.obj) : "");
        });
    }

    var t = {
        callback: $.noop,
        pre: 100,
        context: window
    };
    e = $.extend({}, t, e || {});
    var n = [];
    $(this).each(function () {
        var e = this.nodeName;
        if (!e) return;
        n.push({
            obj: this,
            src: $(this).data("src"),
            tag: e.toLowerCase()
        });
    }), i(), e.context.unbind("scroll", i), e.context.bind("scroll", i);
}, $.fn.fixed = function () {
    var e = this, t = e.offset().top;
    $(document).on("scroll", function (n) {
        $(window).scrollTop() < t ? e.css("position", "static") : e.css("position", "fixed").css("top", 0);
    });
};
;//定义快捷操作
(function (e) {
    var t = function () {
    };
    "placeholder" in document.createElement("input") || (t = function () {
        var t = e(this), n = t.attr("placeholder");
        n && (t.focus(function () {
            this.value === n && (this.value = ""), t.removeClass("placeholder");
        }).blur(function () {
                this.value === "" && (this.value = n, t.addClass("placeholder"));
            }), t.val() === "" && t.addClass("placeholder"), t.val() || t.val(n));
    }), e.fn.placeholder = t;
})(jQuery);
;//控制台输出
$.extend({
    log: function (e) {
        console && console.log(e);
    }
});
;
$.fn.extend({
    serializeObject: function () {
        var e = this.serializeArray(), t = {};
        return $(e).each(function (e, n) {
            t[n.name] = n.value;
        }), t;
    }
});
;
(function () {
    function u(e, t) {
        for (var n in t) e[n] = t[n];
        return e;
    }

    function a(e, t) {
        if (t === !0) {
            var n;
            if (Object.isArray(e)) {
                n = [];
                for (var r in e) e.hasOwnProperty(r) && (Object.isObject(e[r]) ? n.push(Object.clone(e[r], !0)) : n.push(e[r]));
            } else {
                n = {};
                for (var r in e) e.hasOwnProperty(r) && (Object.isObject(e[r]) ? n[r] = Object.clone(e[r], !0) : n[r] = e[r]);
            }
            return n;
        }
        return u({}, e);
    }

    function f(e) {
        return !!this && e.nodeType == 1;
    }

    function l(e) {
        return Object.prototype.toString.call(e) === s;
    }

    function c(e) {
        return Object.prototype.toString.call(e) === i;
    }

    function h(t) {
        return Object.prototype.toString.call(t) === e;
    }

    function p(e) {
        return Object.prototype.toString.call(e) === r;
    }

    function d(e) {
        return Object.prototype.toString.call(e) === n;
    }

    function v(e) {
        return Object.prototype.toString.call(e) === o;
    }

    function m(e) {
        return typeof e == "undefined";
    }

    function g(e, t) {
        var n = [];
        for (var r in e) e.hasOwnProperty(r) && (t === !0 ? n.push([ encodeURIComponent(r), "=", encodeURIComponent(e[r]), "&" ].join("")) : n.push([ r, "=", e[r], "&" ].join("")));
        return n.join("").slice(0, -1);
    }

    function y(e, t) {
        if (typeof t == "undefined") return;
        for (var n in e) if (e.hasOwnProperty(n) && t(e[n], n) === !1) break;
    }

    var e = "[object Function]", t = "[object Boolean]", n = "[object Number]", r = "[object String]", i = "[object Array]", s = "[object Object]", o = "[object Date]";
    u(Object, {
        extend: u,
        clone: a,
        isObject: l,
        isElement: f,
        isArray: c,
        isFunction: h,
        isString: p,
        isNumber: d,
        isDate: v,
        isUndefined: m,
        param: g,
        each: y
    });
})(), Object.extend(String.prototype, function () {
    function e(e) {
        return this.replace(/\{(\w+)\}/g, function (t, n) {
            return e[n] !== undefined ? e[n] : t;
        });
    }

    function t() {
        return this.replace(/[^\x00-\xff]/g, "**").length;
    }

    function n(e, t) {
        return e = e || 30, t = Object.isUndefined(t) ? "..." : t, this.length > e ? this.slice(0, e - t.length) + t : String(this);
    }

    function r(e) {
        return e === !0 ? this.replace(/^\s+/, "") : e === !1 ? this.replace(/\s+$/, "") : this.replace(/^\s+/, "").replace(/\s+$/, "");
    }

    function s(e) {
        var t = [ "&", "&amp;", "<", "&lt;", ">", "&gt;", " ", "&nbsp;", '"', "&quot;", "'", "&#39;" ];
        e === !1 && t.reverse();
        for (var n = 0, r = this; n < t.length; n += 2) r = r.replace(new RegExp(t[n], "g"), t[1 + n]);
        return r;
    }

    function o(e) {
        return this.indexOf(e) > -1;
    }

    function u(e) {
        return this.lastIndexOf(e, 0) === 0;
    }

    function a(e) {
        var t = this.length - e.length;
        return t >= 0 && this.indexOf(e, t) === t;
    }

    function f() {
        return this == "";
    }

    function l() {
        return this.replace(/<\/?[^>]*\/?>/g, "");
    }

    function c() {
        return /^\s*$/.test(this);
    }

    function h() {
        var e, t = this, n, r, i = arguments.length;
        if (i < 1) return l;
        e = 0;
        while (e < i) t = t.replace(/%s/, "{#" + e++ + "#}");
        t.replace("%s", ""), e = 0;
        while ((n = arguments[e]) !== undefined) r = new RegExp("{#" + e + "#}", "g"), t = t.replace(r, n), e++;
        return t;
    }

    function p() {
        var e = this, t = 0, n, r = 0;
        while (n = e.charAt(t++)) r += n.charCodeAt().toString(16).length / 2;
        return r;
    }

    var i = document.createElement("div");
    return {
        format: e,
        sprintf: h,
        text: l,
        len: t,
        truncate: n,
        trim: String.prototype.trim || r,
        html: s,
        has: o,
        startsWith: u,
        endsWith: a,
        empty: f,
        blank: c,
        bytes: p
    };
}()), Object.extend(Function.prototype, function () {
    function t(e, t) {
        var n = e.length, r = t.length;
        while (r--) e[n + r] = t[r];
        return e;
    }

    function n(n, r) {
        return n = e.call(n, 0), t(n, r);
    }

    function r(t) {
        if (arguments.length < 2 && Object.isUndefined(arguments[0])) return this;
        var r = this, i = e.call(arguments, 1);
        return function () {
            var e = n(i, arguments);
            return r.apply(t, e);
        };
    }

    function i(t) {
        var n = this, r = e.call(arguments, 1);
        return t *= 1e3, window.setTimeout(function () {
            return n.apply(n, r);
        }, t);
    }

    function s() {
        var e = t([ .01 ], arguments);
        return this.delay.apply(this, e);
    }

    function o(e) {
        var t = this;
        return function () {
            return e.apply(this, arguments) === !1 ? !1 : t.apply(this, arguments);
        };
    }

    function u(e) {
        var n = this;
        return function () {
            var r = n.apply(this, arguments), i = t([ r ], arguments);
            return e.apply(this, i), r;
        };
    }

    function a(e) {
        var n = this;
        return function () {
            var r = t([ n.bind(this) ], arguments);
            return e.apply(this, r);
        };
    }

    var e = Array.prototype.slice;
    return {
        bind: r,
        delay: i,
        defer: s,
        before: o,
        after: u,
        wrap: a
    };
}()), function () {
    function n(e, t) {
        for (var n = 0, r = this.length >>> 0; n < r; n++) n in this && e.call(t, this[n], n, this);
    }

    function r() {
        return this[this.length - 1];
    }

    function i(e) {
        return e === !0 ? Object.clone.apply(this, arguments) : t.call(this, 0);
    }

    function s(e) {
        var t = [];
        return this.each(function (n, r) {
            t.push(e(n, r));
        }), t;
    }

    function o(e) {
        var t = -1;
        return this.each(function (n, r) {
            if (e == n) return t = r, !1;
        }), t;
    }

    var e = Array.prototype, t = e.slice;
    Object.extend(e, {
        each: Array.prototype.forEach || n,
        indexOf: Array.prototype.indexOf || o,
        last: r,
        clone: i,
        map: s
    });
}();
;

(function (e) {
    function r(e) {
        return e >= 49 && e <= 90;
    }

    function i(e) {
        return (e || "").toLowerCase().split("+").sort().join("").replace(/\s/ig, "");
    }

    function s(e) {
        var t = e.type;
        return t == "mousewheel" || t == "DOMMouseScroll";
    }

    function o(e) {
        return e.wheelDelta > 0 || e.detail < 0 ? "mousewheelup" : "mousewheeldown";
    }

    function u(e) {
        var i = e.keyCode, u = t[i], a = !u && r(i) && String.fromCharCode(i).toLowerCase() || s(e) && o(e), f = e.ctrlKey, l = e.shiftKey, c = e.altKey, h = l && (n[a] || n[u]), p = [];
        return !f && !c && h && (u = h, l = a = null), f && p.push("ctrl"), l && p.push("shift"), c && p.push("alt"), u && p.push(u), a && p.push(a), p.join("+");
    }

    function a(e, t) {
        return i(u(e)) == i(t);
    }

    var t = {
        27: "esc",
        9: "tab",
        32: "space",
        13: "enter",
        8: "backspace",
        145: "scroll",
        20: "capslock",
        144: "numlock",
        19: "pause",
        45: "insert",
        36: "home",
        46: "del",
        35: "end",
        33: "pageup",
        34: "pagedown",
        37: "left",
        38: "up",
        39: "right",
        40: "down",
        107: "=",
        109: "-",
        112: "f1",
        113: "f2",
        114: "f3",
        115: "f4",
        116: "f5",
        117: "f6",
        118: "f7",
        119: "f8",
        120: "f9",
        121: "f10",
        122: "f11",
        123: "f12",
        188: "<",
        190: ">",
        191: "/",
        192: "`",
        219: "[",
        220: "\\",
        221: "]",
        222: "'"
    }, n = {
        "`": "~",
        "1": "!",
        "2": "@",
        "3": "#",
        "4": "$",
        "5": "%",
        "6": "^",
        "7": "&",
        "8": "*",
        "9": "(",
        "0": ")",
        "-": "_",
        "=": "+",
        ";": ":",
        "'": '"',
        ",": "<",
        ".": ">",
        "/": "?",
        "\\": "|"
    };
    e.wx = e.wx || {}, e.wx.hotkeyStr = u, e.wx.isHotkey = a;
})(window);
;