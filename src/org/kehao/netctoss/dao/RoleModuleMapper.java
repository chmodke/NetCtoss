package org.kehao.netctoss.dao;

import org.kehao.netctoss.model.RoleModuleKey;

public interface RoleModuleMapper {
    int deleteByPrimaryKey(RoleModuleKey key);

    int insert(RoleModuleKey record);

    int insertSelective(RoleModuleKey record);
}