package bba.com.a.model;

import java.io.Serializable;


/*------------------------------------------------------------------------------
 * 사이드메뉴를위한 DTO
 * -----------------------------------------------------------------------------*/
public class Bb_SideDto implements Serializable {
	private int seq;			//시퀀스
	private String name;		//사이드 이름
	private int price;			//사이드 가격
	private int cal;			//사이드 칼로리
	private int del;			//삭제 여부 
	
	public Bb_SideDto() {}

	public Bb_SideDto(int seq, String name, int price, int cal, int del) {
		super();
		this.seq = seq;
		this.name = name;
		this.price = price;
		this.cal = cal;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCal() {
		return cal;
	}

	public void setCal(int cal) {
		this.cal = cal;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "Bb_SideDto [seq=" + seq + ", name=" + name + ", price=" + price + ", cal=" + cal + ", del=" + del + "]";
	}
	
	
}
