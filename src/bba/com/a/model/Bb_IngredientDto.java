package bba.com.a.model;

import java.io.Serializable;


/*------------------------------------------------------------------------------
 * 재료를 위한  DTO
 * -----------------------------------------------------------------------------*/
public class Bb_IngredientDto implements Serializable {
	private int seq;		//시퀀스
	private String name;	//재료이름
	private int types;		//재료타입
	private int price;		//가격
	private int cal;		//칼로리
	private int del;		//삭제여부
	
	public Bb_IngredientDto() {}

	public Bb_IngredientDto(int seq, String name, int types, int price, int cal, int del) {
		super();
		this.seq = seq;
		this.name = name;
		this.types = types;
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

	public int getTypes() {
		return types;
	}

	public void setTypes(int types) {
		this.types = types;
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
		return "Bb_IngredientDto [seq=" + seq + ", name=" + name + ", types=" + types + ", price=" + price + ", cal="
				+ cal + ", del=" + del + "]";
	}
	
	
}
