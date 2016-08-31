package org.kehao.netctoss.dao;

import org.kehao.netctoss.model.AdminInfo;

public interface AdminInfoMapper {
	AdminInfo selectByPrimaryKey(Integer adminId);
	
	AdminInfo selectByAdminCode(String adminCode);
	
    int deleteByPrimaryKey(Integer adminId);

    int insert(AdminInfo record);

    int insertSelective(AdminInfo record);

    int updateByPrimaryKeySelective(AdminInfo record);

    int updateByPrimaryKey(AdminInfo record);
}