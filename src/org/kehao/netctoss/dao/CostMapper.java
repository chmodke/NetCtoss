package org.kehao.netctoss.dao;

import java.util.List;

import org.kehao.netctoss.model.Cost;

public interface CostMapper {
	int deleteByPrimaryKey(Short costId);

	int insert(Cost record);

	int insertSelective(Cost record);

	Cost selectByPrimaryKey(Short costId);

	int updateByPrimaryKeySelective(Cost record);

	int updateByPrimaryKey(Cost record);

	List<Cost> selectAllCost();

	List<Cost> selectCostByPage(int start, int end);

	int selectCostCount();
}