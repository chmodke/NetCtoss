package org.kehao.netctoss.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kehao.netctoss.dao.CostMapper;
import org.kehao.netctoss.model.Cost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CostDaoTest {
	@Autowired
	CostMapper costMapper;
	
	@Test
	public void testSelectCostByPage(){
		List<Cost> list=costMapper.selectCostByPage(3, 7);
		for(Cost c:list){
			System.out.println(c.getCostId()+":"+c.getName());
		}
	}
}
