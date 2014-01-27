package com.fcloud.sys.att.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fcloud.core.controller.ActionController;
import com.fcloud.sys.att.model.SysAtt;
import com.fcloud.sys.att.repository.SysAttRepository;
import com.fcloud.util.DateUtil;
import com.fcloud.util.FileOptUtil;
import com.fcloud.util.IdGenerator;
import com.fcloud.util.StringUtil;
import com.fcloud.weservice.model.WePublic;
import com.thoughtworks.xstream.core.ReferenceByIdMarshaller.IDGenerator;

@Controller
@RequestMapping("/sys/att")
public class SysAttController extends
		ActionController<SysAtt, SysAttRepository> {
	@RequestMapping("/fileUpload")
    public ModelAndView fileUpload(HttpServletRequest request,HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
        	out = response.getWriter();
        	CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
    				request.getSession().getServletContext());
    		if (multipartResolver.isMultipart(request)) {
    			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

    			Iterator<String> iter = multiRequest.getFileNames();
    			String fileSaveName = "";
    			MultipartFile myfile = null;
    			if (iter.hasNext()) {
    				myfile = multiRequest.getFile((String) iter.next());
    				if(myfile.isEmpty()){  
                        out.print("1`閻犲洨鍏橀敓浠嬪箯閳哄倹鐎ù鐘烘硾閹绋夋繝浣虹倞");  
                        out.flush();  
                        return null;  
                    }else{  
                        String originalFilename = myfile.getOriginalFilename();
                        try {  
                        	// 重新上传新的图片
                    		
                    		SysAtt sysAtt = null;    
                    		if(request.getParameter("fileId").toString().endsWith("false")){
                    			sysAtt = new SysAtt(); 
                        		String id = IdGenerator.newId();
                        		sysAtt.setId(id);
                    		}else{
                    			sysAtt = getRepository().findOne(request.getParameter("fileId"));
                    			if(sysAtt == null){
                    				sysAtt = new SysAtt(); 
                            		String id = IdGenerator.newId();
                            		sysAtt.setId(id);
                    			}else{
                    				System.out.println(sysAtt.getFileUrl());
                    				String delPath = sysAtt.getFileUrl();
                    				File delFiele = new File(delPath);
                    				if (delFiele.isFile() && delFiele.exists()) {  
                    					delFiele.delete();  
                    			    }  
                    			}
                    		}
                        	String realPath = request.getSession().getServletContext().getRealPath("/upload"); 
                        	realPath = realPath.replaceAll("\\\\", "/");
                        	String datefilePath = DateUtil.convertDateToString("yyyyMMdd", new Date());
                        	String path = StringUtil.linkString(realPath, "/",
                        			datefilePath);
                    		while (!FileOptUtil.checkFilePath(path)) {
                    			FileOptUtil.createFilePaths(path);
                    		}
                    		
                    		String formFilePath = StringUtil.linkString(path, "/", sysAtt.getId()+"-"+originalFilename);
                    		String picFilePath = "/"+datefilePath+"/"+sysAtt.getId()+"-"+originalFilename;
                    		if(!FileOptUtil.checkFilePath(formFilePath)){
                    			File localFile = new File(formFilePath);
                        		myfile.transferTo(localFile);
                    		}
                    		sysAtt.setFileName(originalFilename);
                    		sysAtt.setFileUrl(formFilePath);
                    		sysAtt.setPicUrl(picFilePath);
                    		          		
                    		getRepository().save(sysAtt);
                    		JSONObject result = new JSONObject();
                    		result.put("attId",sysAtt.getId());
                    		String pathUrl = request.getLocalAddr();
                    		if(request.getLocalPort() != 80){
                    			pathUrl = StringUtil.linkString(pathUrl, ":", String.valueOf(request.getLocalPort()));
                    		}
                    		pathUrl = StringUtil.linkString(pathUrl, "/", request.getContextPath());
                    		result.put("picUrl","http://"+pathUrl+"/upload"+picFilePath);
                    		//返回相关请求的信息
                    		out.print(result.toString());
                        } catch (Exception e) {  
                            System.out.println("文件" + originalFilename + "]上传错误");  
                            e.printStackTrace();  
                            out.print("1上传错误");
                            return null;  
                        }  
                    }  
    			}
    			
    		}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
        return null;
    }
	
	@RequestMapping("/deleteById")
    public ModelAndView deleteById(HttpServletRequest request,HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
        	out = response.getWriter();
        	String fileId = request.getParameter("fileId");
        	getRepository().deleteByAttId(fileId);
        	out.print("{code:1}");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
        return null;
    }
}
