package org.kehao.netctoss.dao;

import java.util.List;

import org.kehao.netctoss.model.AdminInfo;

public interface AdminInfoMapper {
	AdminInfo selectByPrimaryKey(Integer adminId);

	int deleteByPrimaryKey(Integer adminId);

	int insert(AdminInfo record);

	int insertSelective(AdminInfo record);

	int updateByPrimaryKeySelective(AdminInfo record);

	int updateByPrimaryKey(AdminInfo record);

	AdminInfo selectByAdminCode(String adminCode);

	List<AdminInfo> selectAdminInfoByPage(int start, int end);

	int selectAdminInfoCount();
}