package bba.com.a.model;

import java.io.Serializable;
import java.util.List;

public class Bb_MenuDto implements Serializable {

  private int seq;
  private int burger_seq;	//버거 시퀀스
  private String burger_name;	//버거 네임
  private int side_seq;			//사이드 시퀀스
  private String side_name;		//사이드 네임
  private int beverage_seq;		//음료 시퀀스
  private String beverage_name;		//음료 네임
  private Bb_BurgerDto burger;		//버거 클래스
  private Bb_SideDto side;			//사이드 클래스
  private Bb_BeverageDto beverage;  //음료 클래스
  private String name;			//메뉴명
  private int creator;			//멤버 시퀀스
  private String creatorID;		//멤버 아이디
  private int price;			//가격
  private int cal;			//칼로리
  private int del;			//지움
  
  /*---------------------------------------------------------------------------------------
  Constructor
  --------------------------------------------------------------------------------------- */
  public Bb_MenuDto() { }

public Bb_MenuDto(int seq, int burger_seq, String burger_name, int side_seq, String side_name, int beverage_seq,
		String beverage_name, Bb_BurgerDto burger, Bb_SideDto side, Bb_BeverageDto beverage, String name, int creator,
		String creatorID, int price, int cal, int del) {
	super();
	this.seq = seq;
	this.burger_seq = burger_seq;
	this.burger_name = burger_name;
	this.side_seq = side_seq;
	this.side_name = side_name;
	this.beverage_seq = beverage_seq;
	this.beverage_name = beverage_name;
	this.burger = burger;
	this.side = side;
	this.beverage = beverage;
	this.name = name;
	this.creator = creator;
	this.creatorID = creatorID;
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

public int getBurger_seq() {
	return burger_seq;
}

public void setBurger_seq(int burger_seq) {
	this.burger_seq = burger_seq;
}

public String getBurger_name() {
	return burger_name;
}

public void setBurger_name(String burger_name) {
	this.burger_name = burger_name;
}

public int getSide_seq() {
	return side_seq;
}

public void setSide_seq(int side_seq) {
	this.side_seq = side_seq;
}

public String getSide_name() {
	return side_name;
}

public void setSide_name(String side_name) {
	this.side_name = side_name;
}

public int getBeverage_seq() {
	return beverage_seq;
}

public void setBeverage_seq(int beverage_seq) {
	this.beverage_seq = beverage_seq;
}

public String getBeverage_name() {
	return beverage_name;
}

public void setBeverage_name(String beverage_name) {
	this.beverage_name = beverage_name;
}

public Bb_BurgerDto getBurger() {
	return burger;
}

public void setBurger(Bb_BurgerDto burger) {
	this.burger = burger;
}

public Bb_SideDto getSide() {
	return side;
}

public void setSide(Bb_SideDto side) {
	this.side = side;
}

public Bb_BeverageDto getBeverage() {
	return beverage;
}

public void setBeverage(Bb_BeverageDto beverage) {
	this.beverage = beverage;
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

public String getCreatorID() {
	return creatorID;
}

public void setCreatorID(String creatorID) {
	this.creatorID = creatorID;
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
	return "{\"seq\":" + seq + ", \"burger_seq\":" + burger_seq + ", \"burger_name\":\"" + burger_name + "\", \"side_seq\":"
			+ side_seq + ", \"side_name\":\"" + side_name + "\", \"beverage_seq\":" + beverage_seq + ", \"beverage_name\":\""
			+ beverage_name + "\", \"name\":\"" + name + "\", \"creator\":" + creator + ", \"creatorID\":\"" + creatorID + "\", \"price\":"
			+ price + ", \"cal\":" + cal + ", \"del\":" + del + "}";
}



  
  
}
