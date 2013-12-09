/**
 * 
 */
package com.fcloud.wechat.auth.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fcloud.core.controller.MultiResourcesController;
import com.fcloud.wechat.auth.model.ModuleAccess;
import com.fcloud.wechat.auth.model.ModuleAccessMapping;
import com.fcloud.wechat.auth.repository.ModuleAccessMappingRepository;
import com.fcloud.wechat.user.model.User;

/**
 * @author ruben
 *
 */
@Controller
@RequestMapping({"/wechat/auth/module_access_mapping"})
public class ModuleAccessMappingController extends MultiResourcesController {
	
	private User getUser(String id) {
		User user = getRepository(User.class).findOne(id);
        if (user == null) {
        	throw new NullPointerException("没找到用户！");
        }
        return user;
	}
	
	private Iterable<ModuleAccessMapping> getMappings(String userid) {
		 ModuleAccessMappingRepository mapRep = getRepository(ModuleAccessMapping.class);
	     return mapRep.findUserMapping(userid);
	}
	

	@RequestMapping(value = {"/{userid}/edit"}, method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public ModelAndView edit(@PathVariable("userid") String userid, WebRequest request) {
        Map<String, Object> models = new HashMap<String, Object>();
        User user = getUser(userid);
        Iterable<ModuleAccess> modules = getRepository(ModuleAccess.class).findAll();
        
        Iterable<ModuleAccessMapping> mappings = getMappings(userid);
        Map<String, Object> maps = new HashMap<String, Object>();
        for (ModuleAccessMapping mapping : mappings) {
        	maps.put(mapping.getModule().getId(), mapping);
        }
        
        models.put("maps", maps);
        models.put("mappings", mappings);
        models.put("modules", modules);
        models.put("user", user);
        return new ModelAndView("wechat/auth/module_access_mapping/edit" , models);
    }
	
	@RequestMapping(value = {"/{userid}"}, method = RequestMethod.POST)
    @Transactional
	public ModelAndView update(@PathVariable("userid") String userid, @RequestParam("module") String[] modules) {
        User user = getUser(userid);
        Iterable<ModuleAccess> mds = getRepository(ModuleAccess.class).findAll(Arrays.asList(modules));
		ModuleAccessMappingRepository mapRep = getRepository(ModuleAccessMapping.class);
		mapRep.updateUserMapping(user, mds);
        return new ModelAndView("public/success");
	}
	
}
