package org.kehao.netctoss.test.service;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kehao.netctoss.model.AdminInfo;
import org.kehao.netctoss.model.NetCtossResult;
import org.kehao.netctoss.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminInfoServiceTest {
		@Autowired
		AdminInfoService adminInfoService;
		
		@Test
		public void testGetAdminById() {
			AdminInfo admin = adminInfoService.getAdminByAdminId(4000);
			System.out.println(admin.getName());
		}
		@Test
		public void testCheckAdminLogin() throws UnsupportedEncodingException {
			NetCtossResult result = adminInfoService.checkAdminLogin("admin", "1243");
			System.out.println(result.getMsg());
		}
}
