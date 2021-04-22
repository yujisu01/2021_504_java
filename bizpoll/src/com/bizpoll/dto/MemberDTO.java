package com.bizpoll.dto;

import java.io.Serializable;
import java.sql.Date;

public class MemberDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String useyn;
	private Date indate;
	private String zipNum;
	
	
	public MemberDTO() {
		
	}


	public MemberDTO(String id, String pwd, String name, String email, String address, String phone, String useyn,
			Date indate, String zipNum) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.useyn = useyn;
		this.indate = indate;
		this.zipNum = zipNum;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getUseyn() {
		return useyn;
	}


	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}


	public Date getIndate() {
		return indate;
	}


	public void setIndate(Date indate) {
		this.indate = indate;
	}


	public String getZipNum() {
		return zipNum;
	}


	public void setZipNum(String zipNum) {
		this.zipNum = zipNum;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", phone=" + phone + ", useyn=" + useyn + ", indate=" + indate + ", zipNum=" + zipNum + "]";
	}
	
	

	
	
	
}
