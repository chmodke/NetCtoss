package org.kehao.netctoss.dao;

import org.kehao.netctoss.model.ModuleInfo;

public interface ModuleInfoMapper {
    int deleteByPrimaryKey(Short moduleId);

    int insert(ModuleInfo record);

    int insertSelective(ModuleInfo record);

    ModuleInfo selectByPrimaryKey(Short moduleId);

    int updateByPrimaryKeySelective(ModuleInfo record);

    int updateByPrimaryKey(ModuleInfo record);
}