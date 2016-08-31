package org.kehao.netctoss.dao;

import org.kehao.netctoss.model.BillItem;

public interface BillItemMapper {
    int deleteByPrimaryKey(Long itemId);

    int insert(BillItem record);

    int insertSelective(BillItem record);

    BillItem selectByPrimaryKey(Long itemId);

    int updateByPrimaryKeySelective(BillItem record);

    int updateByPrimaryKey(BillItem record);
}