package org.kehao.netctoss.test.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.kehao.netctoss.dao.AdminInfoMapper;
import org.kehao.netctoss.model.AdminInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminInfoDaoTest {
	@Autowired
	AdminInfoMapper adminInfoMapper;
	
	@Test
	public void testGetAdminById(){
		AdminInfo admin=adminInfoMapper.selectByPrimaryKey(2000);
		System.out.println(admin.getName());
	}
}
