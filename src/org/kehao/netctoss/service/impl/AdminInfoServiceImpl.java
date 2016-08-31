package org.kehao.netctoss.service.impl;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.kehao.netctoss.dao.AdminInfoMapper;
import org.kehao.netctoss.model.AdminInfo;
import org.kehao.netctoss.model.NetCtossResult;
import org.kehao.netctoss.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminInfoServiceImpl implements AdminInfoService, Serializable {
	private static final long serialVersionUID = 1972370822258645158L;
	@Autowired
	AdminInfoMapper adminInfoMapper;

	@Override
	public AdminInfo getAdminByAdminId(int id) {
		return adminInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public NetCtossResult checkAdminLogin(String header)
			throws UnsupportedEncodingException {
		String base64_msg = header.split(" ")[1];
		byte[] output = Base64.decodeBase64(base64_msg);
		String msg = new String(output, "utf-8");
		String[] info = msg.split(":");
		String adminCode = info[0];
		String adminPwd = info[1];
		return checkAdminLogin(adminCode, adminPwd);
	}

	@Override
	public NetCtossResult checkAdminLogin(String adminCode, String adminPwd) {
		NetCtossResult result = new NetCtossResult();
		AdminInfo admin = adminInfoMapper.selectByAdminCode(adminCode);
		if (admin != null) {
			if (admin.getPassword().equals(adminPwd)) {
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("adminInfoCode", adminCode);
				data.put("adminInfoId", admin.getAdminId());
				result.setStatus(0);
				result.setMsg("验证成功");
				result.setData(data);
			} else {
				result.setStatus(2);
				result.setMsg("密码不正确");
			}
		} else {
			result.setStatus(1);
			result.setMsg("用户名不存在");
		}
		return result;
	}

	@Override
	public NetCtossResult findAdminInfoByPage(int page, Integer pageSize) {
		pageSize = (pageSize == null ? 5 : pageSize);
		NetCtossResult result = new NetCtossResult();
		int start = ((page - 1) * pageSize) + 1;
		int end = page * pageSize;
		result.setData(adminInfoMapper.selectAdminInfoByPage(start, end));
		result.setStatus(0);
		int pageCont = (adminInfoMapper.selectAdminInfoCount()) / pageSize;
		result.setMsg("已获取:" + (int) Math.floor(pageCont + 1));
		return result;
	}

}
