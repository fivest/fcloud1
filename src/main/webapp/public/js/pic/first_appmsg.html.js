/**
 * Created with IntelliJ IDEA.
 * User: zxpfss
 * Date: 13-12-14
 * Time: 下午11:22
 * To change this template use File | Settings | File Templates.
 */
define("public/js/pic/first_appmsg.html.js", [], function (e, t, n) {
    return '<div id="appmsgItem{id}" data-fileId="{file_id}" data-id="{id}" class="js_appmsg_item {if cover}has_thumb{/if}">\n    {if isMul}\n        <div class="appmsg_info">\n            <em class="appmsg_date">{create_time}</em>\n        </div>\n        <div class="cover_appmsg_item">\n            <h4 class="appmsg_title"><a href="javascript:void(0);" onclick="return false;" target="_blank">{title || \'标题\'}</a></h4>\n            <div class="appmsg_thumb_wrp">\n                <img class="js_appmsg_thumb appmsg_thumb" src="{cover}">\n                <i class="appmsg_thumb default">封面图片</i>\n            </div>\n            <div class="appmsg_edit_mask">\n                <a onclick="return false;" class="icon18_common edit_gray js_edit" data-id="{id}" href="javascript:;">编辑</a>\n            </div>\n        </div>\n    {else}\n        <h4 class="appmsg_title"><a onclick="return false;" href="javascript:void(0);" target="_blank">{title || \'标题\'}</a></h4>\n        <div class="appmsg_info">\n            <em class="appmsg_date">{create_time}</em>\n        </div>\n        <div class="appmsg_thumb_wrp">\n            <img class="js_appmsg_thumb appmsg_thumb" src="{cover}">\n            <i class="appmsg_thumb default">封面图片</i>\n        </div>\n        <p class="appmsg_desc">{=digest.html(true)}</p>\n    {/if}\n</div>\n';
});