package com.example.demo.ModL;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class ModelLogin {
	@Id
	private String uname;
	private String pwd;
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	



}
