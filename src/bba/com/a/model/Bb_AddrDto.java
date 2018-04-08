package bba.com.a.model;
import java.io.Serializable;
public class Bb_AddrDto implements Serializable {

	
	private int seq;
	private int member_seq;
	private String address;
	private String lat;
	private String lng;
	private String memo;
	private int del;
	public Bb_AddrDto() {
		super();
	}
	public Bb_AddrDto(int seq, int member_seq, String address, String lat, String lng, String memo, int del) {
		super();
		this.seq = seq;
		this.member_seq = member_seq;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
		this.memo = memo;
		this.del = del;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
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
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	@Override
	public String toString() {
		return "Bb_AddrDto [seq=" + seq + ", member_seq=" + member_seq + ", address=" + address + ", lat=" + lat
				+ ", lng=" + lng + ", memo=" + memo + ", del=" + del + "]";
	}
	
	
	
}
