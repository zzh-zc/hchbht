package com.hchbht.model.commons;

import java.io.Serializable;

/**
 * 返回数据格式
 * @author Administrator
 *
 */
public class AjaxResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean success;
	private String returnCode;
	private String msg = "";
	private Object data;

	public AjaxResult() {

	}

	public AjaxResult(boolean success, Object data) {
		this.success = success;
		this.data = data;
	}

	public AjaxResult(String returnCode, String msg) {
		this.success = false;
		this.returnCode = returnCode;
		this.msg = msg;
	}

	public AjaxResult(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public AjaxResult(boolean success, String msg, Object data) {
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
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
	
	public String toString() {
		return "AjaxResult [success=" + success + ", msg=" + msg + ", data=" + data + "]";
	}

}
