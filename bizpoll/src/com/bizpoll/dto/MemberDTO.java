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
	private String zip_num;
	
	
	public MemberDTO() {
		
	}
	public MemberDTO(String id, String pwd, String name, String email, String address, String phone, String useyn,
			Date indate, String zip_num) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.useyn = useyn;
		this.indate = indate;
		this.zip_num = zip_num;
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
	public String getZip_num() {
		return zip_num;
	}
	public void setZip_num(String zip_num) {
		this.zip_num = zip_num;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", phone=" + phone + ", useyn=" + useyn + ", indate=" + indate + ", zip_num=" + zip_num + "]";
	}

	
	
	
}
