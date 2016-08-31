package org.kehao.netctoss.web.controller.admininfo;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kehao.netctoss.model.NetCtossResult;
import org.kehao.netctoss.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class AdminInfoLoginController implements Serializable{
	private static final long serialVersionUID = 2436394383350951711L;
	@Autowired
	AdminInfoService adminInfoService;
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "main/login";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "main/index";
	}

	@RequestMapping("/checkLogin.do")
	@ResponseBody
	public NetCtossResult login(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
		NetCtossResult result= adminInfoService.checkAdminLogin(request.getHeader("header"));
		session.setAttribute("admin", result.getData());
		return result;
	}
}
