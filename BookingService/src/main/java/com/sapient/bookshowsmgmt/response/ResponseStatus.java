package com.sapient.bookshowsmgmt.response;

public class ResponseStatus {

	private int code;
	private String message;
	private String uniqueErrorId;
	private String messageCode;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUniqueErrorId() {
		return uniqueErrorId;
	}

	public void setUniqueErrorId(String uniqueErrorId) {
		this.uniqueErrorId = uniqueErrorId;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

}