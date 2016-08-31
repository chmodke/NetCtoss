package org.kehao.netctoss.service.impl;

import org.kehao.netctoss.dao.AccountMapper;
import org.kehao.netctoss.model.NetCtossResult;
import org.kehao.netctoss.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountMapper accountMapper;

	@Override
	public NetCtossResult findAccountByPage(int page, Integer pageSize) {
		pageSize = (pageSize == null ? 5 : pageSize);
		NetCtossResult result=new NetCtossResult();
		int start=((page-1)*pageSize)+1;
		int end=page*pageSize;
		result.setData(accountMapper.selectAccountByPage(start, end));
		result.setStatus(0);
		int pageCont=(accountMapper.selectAccountCount())/pageSize;
		result.setMsg("已获取:"+(int)Math.floor(pageCont+1));
		return result;
	}

}
