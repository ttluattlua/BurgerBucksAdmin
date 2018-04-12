package bba.com.a.model;

import java.io.Serializable;
import java.util.List;

public class Bb_MenuTableDto implements Serializable {

	
	/*SEQ NUMBER(10) PRIMARY KEY,
	BURGER NUMBER(10) NOT NULL,
	SIDE NUMBER(10) NOT NULL,
	BEVERAGE NUMBER(10) NOT NULL,
	NAME VARCHAR2(100) NOT NULL,
	CREATOR NUMBER(20) NOT NULL,
	PRICE NUMBER(20) NOT NULL,
	CAL NUMBER(20) NOT NULL,
	DEL NUMBER(1) NOT NULL*/
	
	//Menu
	
	  private int seq;						//menu seq
	  
	  private int burger;					//burger seq
	  private int side;						//side seq
	  private int beverage;					// beverage seq
	  
	  private Bb_BurgerDto burger_dto;		//bureger dto
	  private Bb_SideDto side_dto;			//side dto
	  private Bb_BeverageDto beverage_dto;	//beverage dto
	  private String name;					//menu name
	  private int creator;					//menu 만든 사람 (관리자 0)
	  private int price;					
	  private int cal;
	  private int del;
	  
	  
	public Bb_MenuTableDto() {
		super();
	}


	public Bb_MenuTableDto(int seq, Bb_BurgerDto burger_dto, Bb_SideDto side_dto, Bb_BeverageDto beverage_dto, String name,
			int creator, int price, int cal, int del) {
		super();
		this.seq = seq;
		this.burger_dto = burger_dto;
		this.side_dto = side_dto;
		this.beverage_dto = beverage_dto;
		this.name = name;
		this.creator = creator;
		this.price = price;
		this.cal = cal;
		this.del = del;
	}


	public Bb_MenuTableDto(int seq, int burger, int side, int beverage, String name, int creator, int price, int cal,
			int del) {
		super();
		this.seq = seq;
		this.burger = burger;
		this.side = side;
		this.beverage = beverage;
		this.name = name;
		this.creator = creator;
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


	public int getBurger() {
		return burger;
	}


	public void setBurger(int burger) {
		this.burger = burger;
	}


	public int getSide() {
		return side;
	}


	public void setSide(int side) {
		this.side = side;
	}


	public int getBeverage() {
		return beverage;
	}


	public void setBeverage(int beverage) {
		this.beverage = beverage;
	}


	public Bb_BurgerDto getBurger_dto() {
		return burger_dto;
	}


	public void setBurger_dto(Bb_BurgerDto burger_dto) {
		this.burger_dto = burger_dto;
	}


	public Bb_SideDto getSide_dto() {
		return side_dto;
	}


	public void setSide_dto(Bb_SideDto side_dto) {
		this.side_dto = side_dto;
	}


	public Bb_BeverageDto getBeverage_dto() {
		return beverage_dto;
	}


	public void setBeverage_dto(Bb_BeverageDto beverage_dto) {
		this.beverage_dto = beverage_dto;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCreator() {
		return creator;
	}


	public void setCreator(int creator) {
		this.creator = creator;
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
		return "Bb_MenuTableDto [seq=" + seq + ", burger=" + burger + ", side=" + side + ", beverage=" + beverage
				+ ", burger_dto=" + burger_dto + ", side_dto=" + side_dto + ", beverage_dto=" + beverage_dto + ", name="
				+ name + ", creator=" + creator + ", price=" + price + ", cal=" + cal + ", del=" + del + "]";
	}

	
	

  
}
