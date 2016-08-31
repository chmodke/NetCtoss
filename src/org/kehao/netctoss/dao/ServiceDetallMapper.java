package org.kehao.netctoss.dao;

import org.kehao.netctoss.model.ServiceDetall;

public interface ServiceDetallMapper {
    int deleteByPrimaryKey(Long detailId);

    int insert(ServiceDetall record);

    int insertSelective(ServiceDetall record);

    ServiceDetall selectByPrimaryKey(Long detailId);

    int updateByPrimaryKeySelective(ServiceDetall record);

    int updateByPrimaryKey(ServiceDetall record);
}