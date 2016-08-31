package org.kehao.netctoss.web.controller.admininfo;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.kehao.netctoss.model.AdminInfo;
import org.kehao.netctoss.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/main")
public class AdminInfoLoginController implements Serializable{
	private static final long serialVersionUID = 2436394383350951711L;
	@Autowired
	AdminInfoService adminInfoService;

	@RequestMapping("/login")
	@ResponseBody
	public AdminInfo login(int id,HttpServletRequest req){
		return adminInfoService.getAdmin(id);
	}
}
