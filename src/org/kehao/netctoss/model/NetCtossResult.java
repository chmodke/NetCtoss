package org.kehao.netctoss.model;

import java.io.Serializable;

public class NetCtossResult implements Serializable {
	private static final long serialVersionUID = 9042113640936411588L;
	/**
	 * 0正常，1异常
	 */
	private Integer status;
	/**
	 * 封装需要返回的状态
	 */
	private String msg;
	/**
	 * 封装需要返回的数据
	 */
	private Object data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
