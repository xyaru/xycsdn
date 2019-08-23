package com.example.demo.result;

public class result {
	private int code;
	private String messeage;
	
	public result(int code,String messeage) {
		this.code = code;
		this.messeage = messeage;
	}

	public int getCode() {
		return code;
	}

	public String getMesseage() {
		return messeage;
	}

	public void setMesseage(String messeage) {
		this.messeage = messeage;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
