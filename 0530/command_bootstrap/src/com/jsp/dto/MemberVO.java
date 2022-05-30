package com.jsp.dto;

import java.util.Date;

public class MemberVO {
	private String id;
	private String pwd;
	private String name = "---";
	private String phone;
	private String email;
	private String picture; //member 테이블에 있다는 것은 1인당 사진은 1장씩, 경로로 저장된다는 것
	private Date regdate;
	private String authority;
	private int enabled;
	private String register;
	private String address;
	
	public MemberVO() {}
	public MemberVO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", picture=" + picture + ", regdate=" + regdate + ", authority=" + authority + ", enabled=" + enabled
				+ ", register=" + register + ", address=" + address + "]";
	}
	
}
