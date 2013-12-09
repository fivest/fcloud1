/**
 * 
 */
package com.fcloud.wechat.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fcloud.core.controller.ActionController;
import com.fcloud.wechat.auth.model.ModuleAccess;
import com.fcloud.wechat.auth.repository.ModuleAccessRepository;

/**
 * @author ruben
 *
 */
@Controller
@RequestMapping({"/wechat/auth/module_access"})
public class ModuleAccessController extends ActionController<ModuleAccess, ModuleAccessRepository> {

}
