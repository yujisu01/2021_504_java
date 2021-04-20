package com.bizpoll.dto;

import java.io.Serializable;
// 직렬화 
import java.sql.Date;
public class ProductDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String p_code;
	private String p_name;
	private String p_kind;
	private int p_price1;  // 원가
	private int p_price2; // 판매가
	private int p_price3; // 순수익
	private String p_content; 
	private String p_img;
	private String p_useyn; // 상품 삭제여부
	private String p_bestyn; // best여부
	private Date p_indate; // 상품등록일
	
	
	public ProductDTO() {
	}
	
	
	public ProductDTO(String p_code, String p_name, String p_kind, int p_price1, int p_price2, int p_price3,
			String p_content, String p_img, String p_useyn, String p_bestyn, Date p_indate) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_kind = p_kind;
		this.p_price1 = p_price1;
		this.p_price2 = p_price2;
		this.p_price3 = p_price3;
		this.p_content = p_content;
		this.p_img = p_img;
		this.p_useyn = p_useyn;
		this.p_bestyn = p_bestyn;
		this.p_indate = p_indate;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_kind() {
		return p_kind;
	}
	public void setP_kind(String p_kind) {
		this.p_kind = p_kind;
	}
	public int getP_price1() {
		return p_price1;
	}
	public void setP_price1(int p_price1) {
		this.p_price1 = p_price1;
	}
	public int getP_price2() {
		return p_price2;
	}
	public void setP_price2(int p_price2) {
		this.p_price2 = p_price2;
	}
	public int getP_price3() {
		return p_price3;
	}
	public void setP_price3(int p_price3) {
		this.p_price3 = p_price3;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public String getP_img() {
		return p_img;
	}
	public void setP_img(String p_img) {
		this.p_img = p_img;
	}
	public String getP_useyn() {
		return p_useyn;
	}
	public void setP_useyn(String p_useyn) {
		this.p_useyn = p_useyn;
	}
	public String getP_bestyn() {
		return p_bestyn;
	}
	public void setP_bestyn(String p_bestyn) {
		this.p_bestyn = p_bestyn;
	}
	public Date getP_indate() {
		return p_indate;
	}
	public void setP_indate(Date p_indate) {
		this.p_indate = p_indate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ProductDTO [p_code=" + p_code + ", p_name=" + p_name + ", p_kind=" + p_kind + ", p_price1=" + p_price1
				+ ", p_price2=" + p_price2 + ", p_price3=" + p_price3 + ", p_content=" + p_content + ", p_img=" + p_img
				+ ", p_useyn=" + p_useyn + ", p_bestyn=" + p_bestyn + ", p_indate=" + p_indate + "]";
	}
	
	
}
