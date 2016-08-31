package org.kehao.netctoss.web.controller.service;

import org.kehao.netctoss.model.NetCtossResult;
import org.kehao.netctoss.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/service")
public class ServiceController {
	@Autowired
	ServiceService serviceService;
	
	@RequestMapping("/toList.do")
	public String toAccountList(){
		return "service/service_list";
	}
		
	@RequestMapping("/getListByPage.do")
	@ResponseBody
	public NetCtossResult getAccountListByPage(int page,Integer pageSize){
		return serviceService.findServiceByPage(page, pageSize);
	}
}
