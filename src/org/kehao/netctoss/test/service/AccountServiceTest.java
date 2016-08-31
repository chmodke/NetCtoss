package org.kehao.netctoss.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kehao.netctoss.model.Account;
import org.kehao.netctoss.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountServiceTest {
	@Autowired
	AccountService accountService;

	@Test
	public void testFindCostByPage() {
		@SuppressWarnings("unchecked")
		List<Account> list = (List<Account>) (accountService.findAccountByPage(1,5).getData());
		for (Account a : list) {
			System.out.println(a.getLoginName()+":"+a.getAccountId());
		}
	}
}
