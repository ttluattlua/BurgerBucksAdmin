package bba.com.a.model;

import java.io.Serializable;

/*------------------------------------------------------------------------------
 * 음료 테이블을 위한 DTO
 * -----------------------------------------------------------------------------*/
public class Bb_BeverageDto implements Serializable {
	private int seq;			//시퀀스
	private String name;		//음료이름
	private int price;			//음료가격
	private int cal;			//음료 칼로리
	private int del;			//삭제여부 
	
	public Bb_BeverageDto() {}

	public Bb_BeverageDto(int seq, String name, int price, int cal, int del) {
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
		return "Bb_BeverageDto [seq=" + seq + ", name=" + name + ", price=" + price + ", cal=" + cal + ", del=" + del
				+ "]";
	}
	
	
}	
