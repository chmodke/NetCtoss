package org.kehao.netctoss.service.impl;

import org.kehao.netctoss.dao.ServiceMapper;
import org.kehao.netctoss.model.NetCtossResult;
import org.kehao.netctoss.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServiceServiceImpl implements ServiceService {
	@Autowired
	ServiceMapper serviceMapper;
	@Override
	public NetCtossResult findServiceByPage(int page, Integer pageSize) {
		pageSize = (pageSize == null ? 5 : pageSize);
		NetCtossResult result=new NetCtossResult();
		int start=((page-1)*pageSize)+1;
		int end=page*pageSize;
		result.setData(serviceMapper.selectServiceByPage(start, end));
		result.setStatus(0);
		int pageCont=(serviceMapper.selectServiceCount())/pageSize;
		result.setMsg("已获取:"+(int)Math.floor(pageCont+1));
		return result;
	}
}
