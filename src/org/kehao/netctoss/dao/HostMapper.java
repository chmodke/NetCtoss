package org.kehao.netctoss.dao;

import org.kehao.netctoss.model.Host;

public interface HostMapper {
    int deleteByPrimaryKey(String hostId);

    int insert(Host record);

    int insertSelective(Host record);

    Host selectByPrimaryKey(String hostId);

    int updateByPrimaryKeySelective(Host record);

    int updateByPrimaryKey(Host record);
}