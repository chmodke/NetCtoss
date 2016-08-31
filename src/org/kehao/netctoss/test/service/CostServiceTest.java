package org.kehao.netctoss.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kehao.netctoss.model.Cost;
import org.kehao.netctoss.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CostServiceTest {
	@Autowired
	CostService costService;

	@Test
	public void testFindAllCost() {
		@SuppressWarnings("unchecked")
		List<Cost> list = (List<Cost>) (costService.findAllCost().getData());
		for (Cost c : list) {
			System.out.println(c.getName());
		}
	}
	@Test
	public void testFindCostByPage() {
		@SuppressWarnings("unchecked")
		List<Cost> list = (List<Cost>) (costService.findCostByPage(1,5).getData());
		for (Cost c : list) {
			System.out.println(c.getCostId()+"::"+c.getName());
		}
	}
}
