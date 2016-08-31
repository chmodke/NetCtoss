package org.kehao.netctoss.service.impl;

import java.io.Serializable;

import org.kehao.netctoss.dao.AdminInfoMapper;
import org.kehao.netctoss.model.AdminInfo;
import org.kehao.netctoss.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminInfoServiceImpl implements AdminInfoService,Serializable {
	private static final long serialVersionUID = 1972370822258645158L;
	@Autowired
	AdminInfoMapper adminInfoMapper;

	@Override
	public AdminInfo getAdmin(int id) {
		return adminInfoMapper.selectByPrimaryKey(id);
	}

}
