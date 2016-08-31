package org.kehao.netctoss.dao;

import org.kehao.netctoss.model.ServiceUpdateBak;

public interface ServiceUpdateBakMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ServiceUpdateBak record);

    int insertSelective(ServiceUpdateBak record);

    ServiceUpdateBak selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ServiceUpdateBak record);

    int updateByPrimaryKey(ServiceUpdateBak record);
}