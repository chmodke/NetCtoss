package org.kehao.netctoss.web.controller.admininfo;

import java.io.Serializable;

import org.kehao.netctoss.model.NetCtossResult;
import org.kehao.netctoss.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminInfoController implements Serializable{
	private static final long serialVersionUID = 2436394383350951711L;
	@Autowired
	AdminInfoService adminInfoService;
	
	@RequestMapping("/toList.do")
	public String toAdminInfoList(){
		return "admin/admin_list";
	}

	@RequestMapping("/getListByPage.do")
	@ResponseBody
	public NetCtossResult getAdminInfoListByPage(int page,Integer pageSize){
		return adminInfoService.findAdminInfoByPage(page, pageSize);
	}
}
