package org.kehao.netctoss.service;

import org.kehao.netctoss.model.NetCtossResult;

public interface CostService {
	NetCtossResult findAllCost();
	NetCtossResult findCostByPage(int page,Integer pageSize);
}
