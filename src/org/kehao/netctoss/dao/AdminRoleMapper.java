package org.kehao.netctoss.dao;

import org.kehao.netctoss.model.AdminRoleKey;

public interface AdminRoleMapper {
    int deleteByPrimaryKey(AdminRoleKey key);

    int insert(AdminRoleKey record);

    int insertSelective(AdminRoleKey record);
}