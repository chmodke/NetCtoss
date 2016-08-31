package org.kehao.netctoss.test.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

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
		
		@Test
		public void testfindAdminInfoByPage() throws UnsupportedEncodingException {
			@SuppressWarnings("unchecked")
			List<AdminInfo> list = (List<AdminInfo>) (adminInfoService.findAdminInfoByPage(1,2)).getData();
			for(AdminInfo a:list){
				System.out.println(a.getAdminCode()+"::"+a.getName());
			}
		}
}
