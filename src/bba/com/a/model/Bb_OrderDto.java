package bba.com.a.model;

import java.io.Serializable;
import java.util.List;

public class Bb_OrderDto implements Serializable {
	private int seq;
	private int member_seq;
	private int member_addr;
	private int store_seq;
	private String order_date;
	private int status;
	private int del;
	
	List<Bb_OrderMenuDto> order_menu;

	public Bb_OrderDto() {
		super();
	}

	public Bb_OrderDto(int seq, int member_seq, int member_addr, int store_seq, String order_date, int status, int del,
			List<Bb_OrderMenuDto> order_menu) {
		super();
		this.seq = seq;
		this.member_seq = member_seq;
		this.member_addr = member_addr;
		this.store_seq = store_seq;
		this.order_date = order_date;
		this.status = status;
		this.del = del;
		this.order_menu = order_menu;
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

	public int getMember_addr() {
		return member_addr;
	}

	public void setMember_addr(int member_addr) {
		this.member_addr = member_addr;
	}

	public int getStore_seq() {
		return store_seq;
	}

	public void setStore_seq(int store_seq) {
		this.store_seq = store_seq;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public List<Bb_OrderMenuDto> getOrder_menu() {
		return order_menu;
	}

	public void setOrder_menu(List<Bb_OrderMenuDto> order_menu) {
		this.order_menu = order_menu;
	}

	@Override
	public String toString() {
		return "Bb_OrderDto [seq=" + seq + ", member_seq=" + member_seq + ", member_addr=" + member_addr
				+ ", store_seq=" + store_seq + ", order_date=" + order_date + ", status=" + status + ", del=" + del
				+ ", order_menu=" + order_menu + "]";
	}

	
	

}
