package org.kehao.netctoss.web.controller.account;

import org.kehao.netctoss.model.NetCtossResult;
import org.kehao.netctoss.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/account")
public class AccountListController {
	@Autowired
	AccountService accountService;
	
	@RequestMapping("/toList.do")
	public String toAccountList(){
		return "account/account_list";
	}
		
	@RequestMapping("/getListByPage.do")
	@ResponseBody
	public NetCtossResult getAccountListByPage(int page,Integer pageSize){
		return accountService.findAccountByPage(page, pageSize);
	}
}
