package bba.com.a.model;

import java.io.Serializable;


/*------------------------------------------------------------------------------
* 사원등록(브랜치매니저) 위한 DTO
* -----------------------------------------------------------------------------*/


public class Bb_AdminDto implements Serializable{

	private int seq;			// 시퀀스
	private String id;			// id
	private String password;	// 비밀번호
	private String name;		// 매니저 이름
	private String phone;		// 전화번호
	private String store_seq;	// 지점 시퀀스 가져오기
	private int del;			// 기본 0 , 삭제된 정보 1		
	public Bb_AdminDto() {
		super();
	}
	public Bb_AdminDto(int seq, String id, String password, String name, String phone, String store_seq, int del) {
		super();
		this.seq = seq;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.store_seq = store_seq;
		this.del = del;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getStore_seq() {
		return store_seq;
	}
	public void setStore_seq(String store_seq) {
		this.store_seq = store_seq;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	@Override
	public String toString() {
		return "Bb_AdminDto [seq=" + seq + ", id=" + id + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", store_seq=" + store_seq + ", del=" + del + "]";
	}

	
	
	
}
