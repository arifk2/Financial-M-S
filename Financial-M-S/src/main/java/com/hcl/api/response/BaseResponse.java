
package com.hcl.api.response;

public class BaseResponse {

	private Object data;
	private Integer errorCode;
	private String errorMessage;
	private String message;
	private int status;

	public BaseResponse() {

	}

	public BaseResponse(int status, Integer errorCode, String errorMessage) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public BaseResponse(int status, String message) {
		this.message = message;
		this.status = status;
	}

	public BaseResponse(int status, String message, Object data) {
		this.data = data;
		this.message = message;
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResponseObj [data=" + data + ", status=" + status + ", message=" + message + ", errorCode=" + errorCode
				+ ", errorMessage=" + errorMessage + "]";
	}

}
