package org.kehao.netctoss.dao;

import java.util.List;

import org.kehao.netctoss.model.Bill;

public interface BillMapper {
	int deleteByPrimaryKey(Long billId);

	int insert(Bill record);

	int insertSelective(Bill record);

	Bill selectByPrimaryKey(Long billId);

	int updateByPrimaryKeySelective(Bill record);

	int updateByPrimaryKey(Bill record);

	List<Bill> selectBillByPage(int page, int pageSize);

	int selectBillCount();
}