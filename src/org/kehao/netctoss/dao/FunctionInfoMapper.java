package org.kehao.netctoss.dao;

import org.kehao.netctoss.model.FunctionInfo;

public interface FunctionInfoMapper {
    int deleteByPrimaryKey(Integer functionId);

    int insert(FunctionInfo record);

    int insertSelective(FunctionInfo record);

    FunctionInfo selectByPrimaryKey(Integer functionId);

    int updateByPrimaryKeySelective(FunctionInfo record);

    int updateByPrimaryKey(FunctionInfo record);
}