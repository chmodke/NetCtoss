package org.kehao.netctoss.service;

import org.kehao.netctoss.model.NetCtossResult;

public interface AccountService {
	NetCtossResult findAccountByPage(int page,Integer pageSize);
}
