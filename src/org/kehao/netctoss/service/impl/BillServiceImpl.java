package org.kehao.netctoss.service.impl;

import org.kehao.netctoss.dao.BillMapper;
import org.kehao.netctoss.model.NetCtossResult;
import org.kehao.netctoss.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BillServiceImpl implements BillService {
	@Autowired
	BillMapper billMapper;

	@Override
	public NetCtossResult findBillByPage(int page, Integer pageSize) {
		pageSize = (pageSize == null ? 5 : pageSize);
		NetCtossResult result = new NetCtossResult();
		int start = ((page - 1) * pageSize) + 1;
		int end = page * pageSize;
		result.setData(billMapper.selectBillByPage(start, end));
		result.setStatus(0);
		int pageCont = (billMapper.selectBillCount()) / pageSize;
		result.setMsg("已获取:" + (int) Math.floor(pageCont + 1));
		return result;
	}

}
