package org.kehao.netctoss.web.controller.cost;

import org.kehao.netctoss.model.NetCtossResult;
import org.kehao.netctoss.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cost")
public class CostListController {
	@Autowired
	CostService costService;
	
	@RequestMapping("/toList.do")
	public String toCostList(){
		return "fee/fee_list";
	}
	
	@RequestMapping("/getList.do")
	@ResponseBody
	public NetCtossResult getCostList(){
		return costService.findAllCost();
	}
	
	@RequestMapping("/getListByPage.do")
	@ResponseBody
	public NetCtossResult getCostListByPage(int page,Integer pageSize){
		return costService.findCostByPage(page, pageSize);
	}
}
