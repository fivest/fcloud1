/**
 * Created with IntelliJ IDEA.
 * User: zxpfss
 * Date: 13-12-15
 * Time: 上午9:14
 * To change this template use File | Settings | File Templates.
 */
var template = function (e, t) {
    return template[typeof t == "object" ? "render" : "compile"].apply(template, arguments);
};

(function (e, t) {
    "use strict";
    e.version = "2.0.1", e.openTag = "<#", e.closeTag = "#>", e.isEscape = !0, e.isCompress = !1, e.parser = null, e.render = function (e, t) {
        var n = r(e);
        return n === undefined ? i({
            id: e,
            name: "Render Error",
            message: "No Template"
        }) : n(t);
    }, e.compile = function (t, r) {
        function c(n) {
            try {
                return new f(n) + "";
            } catch (s) {
                return u ? (s.id = t || r, s.name = "Render Error", s.source = r, i(s)) : e.compile(t, r, !0)(n);
            }
        }

        var o = arguments, u = o[2], a = "anonymous";
        typeof r != "string" && (u = o[1], r = o[0], t = a);
        try {
            var f = s(r, u);
        } catch (l) {
            return l.id = t || r, l.name = "Syntax Error", i(l);
        }
        return c.prototype = f.prototype, c.toString = function () {
            return f.toString();
        }, t !== a && (n[t] = c), c;
    }, e.helper = function (t, n) {
        e.prototype[t] = n;
    }, e.onerror = function (e) {
        var n = "[template]:\n" + e.id + "\n\n[name]:\n" + e.name;
        e.message && (n += "\n\n[message]:\n" + e.message), e.line && (n += "\n\n[line]:\n" + e.line, n += "\n\n[source]:\n" + e.source.split(/\n/)[e.line - 1].replace(/^[\s\t]+/, "")), e.temp && (n += "\n\n[temp]:\n" + e.temp), t.console && console.error(n);
    };
    var n = {}, r = function (r) {
        var i = n[r];
        if (i === undefined && "document" in t) {
            var s = document.getElementById(r);
            if (s) {
                var o = s.value || s.innerHTML;
                return e.compile(r, o.replace(/^\s*|\s*$/g, ""));
            }
        } else if (n.hasOwnProperty(r)) return i;
    }, i = function (t) {
        function n() {
            return n + "";
        }

        return e.onerror(t), n.toString = function () {
            return "{Template Error}";
        }, n;
    }, s = function () {
        e.prototype = {
            $render: e.render,
            $escape: function (e) {
                return typeof e == "string" ? e.replace(/&(?![\w#]+;)|[<>"']/g, function (e) {
                    return {
                        "<": "&#60;",
                        ">": "&#62;",
                        '"': "&#34;",
                        "'": "&#39;",
                        "&": "&#38;"
                    }[e];
                }) : e;
            },
            $string: function (e) {
                return typeof e == "string" || typeof e == "number" ? e : typeof e == "function" ? e() : "";
            }
        };
        var t = Array.prototype.forEach || function (e, t) {
            var n = this.length >>> 0;
            for (var r = 0; r < n; r++) r in this && e.call(t, this[r], r, this);
        }, n = function (e, n) {
            t.call(e, n);
        }, r = "break,case,catch,continue,debugger,default,delete,do,else,false,finally,for,function,if,in,instanceof,new,null,return,switch,this,throw,true,try,typeof,var,void,while,with,abstract,boolean,byte,char,class,const,double,enum,export,extends,final,float,goto,implements,import,int,impl,long,native,package,private,protected,public,short,static,super,synchronized,throws,transient,volatile,arguments,let,yield,undefined", i = /\/\*(?:.|\n)*?\*\/|\/\/[^\n]*\n|\/\/[^\n]*$|'[^']*'|"[^"]*"|[\s\t\n]*\.[\s\t\n]*[$\w\.]+/g, s = /[^\w$]+/g, o = new RegExp([ "\\b" + r.replace(/,/g, "\\b|\\b") + "\\b" ].join("|"), "g"), u = /\b\d[^,]*/g, a = /^,+|,+$/g, f = function (e) {
            return e = e.replace(i, "").replace(s, ",").replace(o, "").replace(u, "").replace(a, ""), e = e ? e.split(/,+/) : [], e;
        };
        return function (t, r) {
            function S(t) {
                return l += t.split(/\n/).length - 1, e.isCompress && (t = t.replace(/[\n\r\t\s]+/g, " ")), t = t.replace(/('|\\)/g, "\\$1").replace(/\r/g, "\\r").replace(/\n/g, "\\n"), t = m[1] + "'" + t + "'" + m[2], t + "\n";
            }

            function x(t) {
                var n = l;
                o ? t = o(t) : r && (t = t.replace(/\n/g, function () {
                    return l++, "$line=" + l + ";";
                }));
                if (t.indexOf("=") === 0) {
                    var i = t.indexOf("==") !== 0;
                    t = t.replace(/^=*|[\s;]*$/g, "");
                    if (i && e.isEscape) {
                        var s = t.replace(/\s*\([^\)]+\)/, "");
                        !h.hasOwnProperty(s) && !/^(include|print)$/.test(s) && (t = "$escape($string(" + t + "))");
                    } else t = "$string(" + t + ")";
                    t = m[1] + t + m[2];
                }
                return r && (t = "$line=" + n + ";" + t), T(t), t + "\n";
            }

            function T(e) {
                e = f(e), n(e, function (e) {
                    c.hasOwnProperty(e) || (N(e), c[e] = !0);
                });
            }

            function N(e) {
                var t;
                e === "print" ? t = y : e === "include" ? (p.$render = h.$render, t = b) : (t = "$data." + e, h.hasOwnProperty(e) && (p[e] = h[e], e.indexOf("$") === 0 ? t = "$helpers." + e : t = t + "===undefined?$helpers." + e + ":" + t)), d += e + "=" + t + ",";
            }

            var i = e.openTag, s = e.closeTag, o = e.parser, u = t, a = "", l = 1, c = {
                $data: !0,
                $helpers: !0,
                $out: !0,
                $line: !0
            }, h = e.prototype, p = {}, d = "var $helpers=this," + (r ? "$line=0," : ""), v = "".trim, m = v ? [ "$out='';", "$out+=", ";", "$out" ] : [ "$out=[];", "$out.push(", ");", "$out.join('')" ], g = v ? "if(content!==undefined){$out+=content;return content}" : "$out.push(content);", y = "function(content){" + g + "}", b = "function(id,data){if(data===undefined){data=$data}var content=$helpers.$render(id,data);" + g + "}";
            n(u.split(i), function (e, t) {
                e = e.split(s);
                var n = e[0], r = e[1];
                e.length === 1 ? a += S(n) : (a += x(n), r && (a += S(r)));
            }), u = a, r && (u = "try{" + u + "}catch(e){" + "e.line=$line;" + "throw e" + "}"), u = "'use strict';" + d + m[0] + u + "return new String(" + m[3] + ")";
            try {
                var w = new Function("$data", u);
                return w.prototype = p, w;
            } catch (E) {
                throw E.temp = "function anonymous($data) {" + u + "}", E;
            }
        };
    }();
    e.openTag = "{", e.closeTag = "}", e.parser = function (t) {
        t = t.replace(/^\s/, "");
        var n = t.split(" "), r = n.shift(), i = e.keywords, s = i[r];
        return s && i.hasOwnProperty(r) ? (n = n.join(" "), t = s.call(t, n)) : e.prototype.hasOwnProperty(r) ? (n = n.join(","), t = "==" + r + "(" + n + ");") : (t = t.replace(/[\s;]*$/, ""), t = "=" + t), t;
    }, e.keywords = {
        "if": function (e) {
            return "if(" + e + "){";
        },
        "else": function (e) {
            return e = e.split(" "), e.shift() === "if" ? e = " if(" + e.join(" ") + ")" : e = "", "}else" + e + "{";
        },
        "/if": function () {
            return "}";
        },
        each: function (e) {
            e = e.split(" ");
            var t = e[0] || "$data", n = e[1] || "as", r = e[2] || "$value", i = e[3] || "$index", s = r + "," + i;
            return n !== "as" && (t = "[]"), "$each(" + t + ",function(" + s + "){";
        },
        "/each": function () {
            return "});";
        },
        echo: function (e) {
            return "print(" + e + ");";
        },
        include: function (e) {
            e = e.split(" ");
            var t = e[0], n = e[1], r = t + (n ? "," + n : "");
            return "include(" + r + ");";
        }
    }, e.helper("$each", function (e, t) {
        var n = Array.isArray || function (e) {
            return Object.prototype.toString.call(e) === "[object Array]";
        };
        if (n(e)) for (var r = 0, i = e.length; r < i; r++) t.call(e, e[r], r, e); else for (r in e) t.call(e, e[r], r);
    });
})(template, this), typeof define == "function" ? define("/public/js/pic/template.js", [], function (e, t, n) {
    try {
        n.exports = template;
    } catch (r) {
        wx.jslog({
            src: "/public/js/pic/template.js"
        }, r);
    }
}) : typeof exports != "undefined" && (module.exports = template);
;