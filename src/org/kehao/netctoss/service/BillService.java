package org.kehao.netctoss.service;

import org.kehao.netctoss.model.NetCtossResult;

public interface BillService {
	NetCtossResult findBillByPage(int page,Integer pageSize);
}
