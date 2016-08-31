package org.kehao.netctoss.service.impl;

import org.kehao.netctoss.dao.CostMapper;
import org.kehao.netctoss.model.NetCtossResult;
import org.kehao.netctoss.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostServiceImpl implements CostService {
	@Autowired
	CostMapper costMapper;

	@Override
	public NetCtossResult findAllCost() {
		NetCtossResult result = new NetCtossResult();
		result.setData(costMapper.selectAllCost());
		result.setMsg("已获取");
		result.setStatus(0);
		return result;
	}
	@Override
	public NetCtossResult findCostByPage(int page,Integer pageSize) {
		NetCtossResult result = new NetCtossResult();
		pageSize=(pageSize==null?5:pageSize);
		result.setData(costMapper.selectCostByPage(((page-1)*pageSize)+1, page*pageSize));
		int pageCont=(costMapper.selectCostCount())/pageSize;
		result.setMsg("已获取:"+(int)Math.floor(pageCont+1));
		result.setStatus(0);
		return result;
	}

}
