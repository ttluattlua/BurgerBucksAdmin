package bba.com.a.model;

import java.io.Serializable;

public class Bb_StoreDto implements Serializable {
	private int seq;
	private String name;
	private String phone;
	private String address;
	private String lat;
	private String lng;
	private int del;
	
	public Bb_StoreDto() {}

	public Bb_StoreDto(int seq, String name, String phone, String address, String lat, String lng, int del) {
		super();
		this.seq = seq;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
		this.del = del;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "Bb_StoreDto [seq=" + seq + ", name=" + name + ", phone=" + phone + ", address=" + address + ", lat="
				+ lat + ", lng=" + lng + ", del=" + del + "]";
	}
	
	
}
