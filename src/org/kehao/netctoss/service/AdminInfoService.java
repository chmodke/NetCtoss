package org.kehao.netctoss.service;

import java.io.UnsupportedEncodingException;

import org.kehao.netctoss.model.AdminInfo;
import org.kehao.netctoss.model.NetCtossResult;

public interface AdminInfoService {
	public AdminInfo getAdminByAdminId(int adminId);
	/**
	 * 解析加密请求头文件
	 * @param header 请求头字符串
	 * @return 结果对象
	 * @throws UnsupportedEncodingException
	 */
	public NetCtossResult checkAdminLogin(String header) throws UnsupportedEncodingException;
	/**
	 * 校验用户名和密码
	 * @param adminCode 用户名
	 * @param adminPwd 密码
	 * @return status=0成功，status=1用户名不存在，status=2密码错误
	 */
	public NetCtossResult checkAdminLogin(String adminCode,String adminPwd)throws UnsupportedEncodingException;
	
	public NetCtossResult findAdminInfoByPage(int page,Integer pageSize);
}
