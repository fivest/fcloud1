package com.fcloud.weservice.controller;

import com.fcloud.core.controller.ActionController;
import com.fcloud.core.model.Entity;
import com.fcloud.util.IdGenerator;
import com.fcloud.weservice.model.WeRuleReply;
import com.fcloud.weservice.model.WeRuleReplyPictext;
import com.fcloud.weservice.model.WeRuleReplyPictexts;
import com.fcloud.weservice.model.WeRuleReplyPictextson;
import com.fcloud.weservice.repository.WeRuleReplyPictextsRepository;
import com.fcloud.weservice.repository.WeRuleReplyPictextsonRepository;
import com.fcloud.weservice.repository.WeRuleReplyRepository;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 * 多图文回复
 *
 * @author
 * @version 1.0 2013-11-12
 */
@Controller
@RequestMapping("/weservice/we_rule_reply_pictexts")
public class WeRuleReplyPictextsController extends ActionController<WeRuleReplyPictexts, WeRuleReplyPictextsRepository> {

    @Resource
    private WeRuleReplyRepository weRuleReplyRepository;

    @Resource
    private WeRuleReplyPictextsonRepository weRuleReplyPictextsonRepository;

    @RequestMapping("/add")
    @Transactional
    public ModelAndView create(HttpServletRequest request, HttpServletResponse response) {
        WeRuleReplyPictexts model = null;
        String fdRuleId = request.getParameter("ruleId");
        WeRuleReply ruleReply = weRuleReplyRepository.findOne(fdRuleId);
        if (!StringUtils.isEmpty(fdRuleId)) {
            try {
                List<WeRuleReplyPictexts> ruleReplyTexts = getRepository().getDao().queryBuilder().where().eq("fd_werulereply", fdRuleId).query();
                JSONObject infos = new JSONObject();
                if (ruleReplyTexts != null && ruleReplyTexts.size() > 0) {
                    model = ruleReplyTexts.get(0);
                    //获取子图文
                    ForeignCollection<WeRuleReplyPictextson> pictextsons = model.getWeRuleReplyPictextsons();
                    if(pictextsons != null && !pictextsons.isEmpty()){
                        infos = setPicJson(pictextsons);
                    }
                } else {
                    model = createModel();
                }
                model.setFdWerulereply(ruleReply);
                request.setAttribute("infos",infos);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return render("edit", model);
    }

    @RequestMapping("/save")
    @Transactional
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        String fdId = request.getParameter("id");
        String picitems = request.getParameter("picitems");
        String ruleId = request.getParameter("fdWerulereply.id");
        WeRuleReply ruleReply = weRuleReplyRepository.findOne(ruleId);
        if (ruleReply != null) {
            try {
                WeRuleReplyPictexts ruleReplyText = getRepository().findOne(fdId);
                if (ruleReplyText == null) {
                    ruleReplyText = createModel();
                    ruleReplyText.setId(fdId);
                }
                //设置规则
                ruleReplyText.setFdWerulereply(ruleReply);
                getRepository().save(ruleReplyText);
                //设置子图文内容
                saveChildPic(picitems, ruleReplyText);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return render("/public/success");
    }

    @Transactional
    private void saveChildPic(String picitems, WeRuleReplyPictexts ruleReplyText) throws SQLException {
        //删除当前所有信息关联信息
        List<WeRuleReplyPictextson> pictextsonList = weRuleReplyPictextsonRepository.getDao().queryBuilder().where().eq("fd_werulereply", ruleReplyText.getId()).query();
        weRuleReplyPictextsonRepository.delete(pictextsonList);
        if (!StringUtils.isEmpty(picitems)) {
            JSONObject picitemsJson = JSONObject.fromObject(picitems);
            int count = picitemsJson.getInt("count");
            for (int i = 0; i < count; i++) {
                WeRuleReplyPictextson pictextson = new WeRuleReplyPictextson();
                pictextson.setId(IdGenerator.newId());
                pictextson.setFdWerulereply(ruleReplyText);
                pictextson.setFdOrder(i);
                if (picitemsJson.containsKey("title" + i)) {
                    pictextson.setFdTitle(picitemsJson.getString("title" + i));
                }
                if (picitemsJson.containsKey("content" + i)) {
                    pictextson.setFdText(picitemsJson.getString("content" + i));
                }
                if (picitemsJson.containsKey("author" + i)) {
                    pictextson.setFdTags(picitemsJson.getString("author" + i));
                }
                if (picitemsJson.containsKey("sourceurl" + i)) {
                    pictextson.setFdUrl(picitemsJson.getString("sourceurl" + i));
                }
                //TODO 缺少附件
                weRuleReplyPictextsonRepository.save(pictextson);
            }
        }
    }

    private JSONObject setPicJson(ForeignCollection<WeRuleReplyPictextson> pictextsons) {
        JSONArray multiitem = new JSONArray();
        JSONObject firstobj = new JSONObject();
        int i = 0;
        for(WeRuleReplyPictextson pictextson : pictextsons){
            JSONObject multiobj = new JSONObject();
            multiobj.element("seq", i);
            multiobj.element("title", pictextson.getFdTitle());
            multiobj.element("show_cover_pic", 1);
            multiobj.element("content", pictextson.getFdText());
            multiobj.element("author",pictextson.getFdTags());
            multiitem.add(multiobj);
            if(i==0){
                firstobj = JSONObject.fromObject(firstobj);
            }
        }

        firstobj.element("multi_item", multiitem);
        JSONArray item = new JSONArray();
        //multiobj.remove("show_cover_pic");
        item.add(firstobj);
        JSONObject infos = new JSONObject();
        infos.element("item", item);
        System.out.println(infos);
        return infos;
    }
}
