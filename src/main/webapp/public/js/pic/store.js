/**
 * Created with IntelliJ IDEA.
 * User: zxpfss
 * Date: 13-12-14
 * Time: 下午9:40
 * To change this template use File | Settings | File Templates.
 */
define("public/js/pic/store.js", [ "public/js/pic/json.js" ], function (e, t, n) {
    try {
        var r = e("public/js/pic/json.js"), i = {}, s = window.document, o = "localStorage", u = "__storejs__", a;
        i.disabled = !1, i.set = function (e, t) {
        }, i.get = function (e) {
        }, i.remove = function (e) {
        }, i.clear = function () {
        }, i.transact = function (e, t, n) {
            var r = i.get(e);
            n == null && (n = t, t = null), typeof r == "undefined" && (r = t || {}), n(r), i.set(e, r);
        }, i.getAll = function () {
        }, i.serialize = function (e) {
            return r.stringify2(e);
        }, i.deserialize = function (e) {
            if (typeof e != "string") return undefined;
            try {
                return r.parse(e);
            } catch (t) {
                return e || undefined;
            }
        };
        function f() {
            try {
                return o in window && window[o];
            } catch (e) {
                return !1;
            }
        }

        if (f()) a = window[o], i.set = function (e, t) {
            return t === undefined ? i.remove(e) : (a.setItem(e, i.serialize(t)), t);
        }, i.get = function (e) {
            return i.deserialize(a.getItem(e));
        }, i.remove = function (e) {
            a.removeItem(e);
        }, i.clear = function () {
            a.clear();
        }, i.getAll = function () {
            var e = {};
            for (var t = 0; t < a.length; ++t) {
                var n = a.key(t);
                e[n] = i.get(n);
            }
            return e;
        }; else if (s.documentElement.addBehavior) {
            var l, c;
            try {
                c = new ActiveXObject("htmlfile"), c.open(), c.write('<script>document.w=window</script><iframe src="/favicon.ico"></iframe>'), c.close(), l = c.w.frames[0].document, a = l.createElement("div");
            } catch (h) {
                a = s.createElement("div"), l = s.body;
            }
            function p(e) {
                return function () {
                    var t = Array.prototype.slice.call(arguments, 0);
                    t.unshift(a), l.appendChild(a), a.addBehavior("#default#userData"), a.load(o);
                    var n = e.apply(i, t);
                    return l.removeChild(a), n;
                };
            }

            var d = new RegExp("[!\"#$%&'()*+,/\\\\:;<=>?@[\\]^`{|}~]", "g");

            function v(e) {
                return e.replace(d, "___");
            }

            i.set = p(function (e, t, n) {
                return t = v(t), n === undefined ? i.remove(t) : (e.setAttribute(t, i.serialize(n)), e.save(o), n);
            }), i.get = p(function (e, t) {
                return t = v(t), i.deserialize(e.getAttribute(t));
            }), i.remove = p(function (e, t) {
                t = v(t), e.removeAttribute(t), e.save(o);
            }), i.clear = p(function (e) {
                var t = e.XMLDocument.documentElement.attributes;
                e.load(o);
                for (var n = 0, r; r = t[n]; n++) e.removeAttribute(r.name);
                e.save(o);
            }), i.getAll = p(function (e) {
                var t = e.XMLDocument.documentElement.attributes, n = {};
                for (var r = 0, s; s = t[r]; ++r) {
                    var o = v(s.name);
                    n[s.name] = i.deserialize(e.getAttribute(o));
                }
                return n;
            });
        }
        try {
            i.set(u, u), i.get(u) != u && (i.disabled = !0), i.remove(u);
        } catch (h) {
            i.disabled = !0;
        }
        i.enabled = !i.disabled, n.exports = i;
    } catch (h) {
//        wx.jslog({
//            src: "common/lib/store.js"
//        }, h);
    }
});
