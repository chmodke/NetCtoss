package org.kehao.netctoss.dao;

import org.kehao.netctoss.model.Cost;

public interface CostMapper {
    int deleteByPrimaryKey(Short costId);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Short costId);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);
}