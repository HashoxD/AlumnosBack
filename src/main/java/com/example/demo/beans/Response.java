package com.example.demo.beans;

public class Response {
	private String status;
	private String message;
	private String data;
	public Response(String status, String message, String data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
