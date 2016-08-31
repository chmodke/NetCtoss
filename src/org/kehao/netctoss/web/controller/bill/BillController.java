package org.kehao.netctoss.web.controller.bill;

import org.kehao.netctoss.model.NetCtossResult;
import org.kehao.netctoss.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bill")
public class BillController {
	@Autowired
	BillService billService;
	
	@RequestMapping("/toList.do")
	public String toBillList(){
		return "bill/bill_list";
	}
		
	@RequestMapping("/getListByPage.do")
	@ResponseBody
	public NetCtossResult getBillListByPage(int page,Integer pageSize){
		return billService.findBillByPage(page, pageSize);
	}
}
