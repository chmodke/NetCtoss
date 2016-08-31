package org.kehao.netctoss.dao;

import org.kehao.netctoss.model.RoleInfo;

public interface RoleInfoMapper {
    int deleteByPrimaryKey(Short roleId);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    RoleInfo selectByPrimaryKey(Short roleId);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);
}