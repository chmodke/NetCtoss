package org.kehao.netctoss.service;

import org.kehao.netctoss.model.NetCtossResult;

public interface ServiceService {
	NetCtossResult findServiceByPage(int page,Integer pageSize);
}
