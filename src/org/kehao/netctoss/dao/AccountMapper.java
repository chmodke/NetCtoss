package org.kehao.netctoss.dao;

import java.util.List;

import org.kehao.netctoss.model.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    
    List<Account> selectAccountByPage(int start,int end);
    int selectAccountCount();
}