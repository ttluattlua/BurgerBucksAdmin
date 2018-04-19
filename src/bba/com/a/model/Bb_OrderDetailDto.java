package bba.com.a.model;

import java.io.Serializable;

public class Bb_OrderDetailDto implements Serializable{

	 private int order_seq;				//주문 시퀀스
	 
	 private int orderMenu_price;		//가격
	 private int orderMenu_quantity;	//수량
	 
	 private int menu_seq;				//주문 메뉴 seq
	 private String menu_name;			//-주문 메뉴 이름
	 
	 private int burger_seq;			//-버거 seq
	 private String burger_name;		//--버거명
	 private String burger_Ingredient;	//--버거 재료 순서
	 
	 private String beverage_name;		//-음료
	 private String side_name;			//-사이드
	public Bb_OrderDetailDto() {
		super();
	}
	public Bb_OrderDetailDto(int order_seq, int orderMenu_price, int orderMenu_quantity, int menu_seq, String menu_name,
			int burger_seq, String burger_name, String burger_Ingredient, String beverage_name, String side_name) {
		super();
		this.order_seq = order_seq;
		this.orderMenu_price = orderMenu_price;
		this.orderMenu_quantity = orderMenu_quantity;
		this.menu_seq = menu_seq;
		this.menu_name = menu_name;
		this.burger_seq = burger_seq;
		this.burger_name = burger_name;
		this.burger_Ingredient = burger_Ingredient;
		this.beverage_name = beverage_name;
		this.side_name = side_name;
	}
	public int getOrder_seq() {
		return order_seq;
	}
	public void setOrder_seq(int order_seq) {
		this.order_seq = order_seq;
	}
	public int getOrderMenu_price() {
		return orderMenu_price;
	}
	public void setOrderMenu_price(int orderMenu_price) {
		this.orderMenu_price = orderMenu_price;
	}
	public int getOrderMenu_quantity() {
		return orderMenu_quantity;
	}
	public void setOrderMenu_quantity(int orderMenu_quantity) {
		this.orderMenu_quantity = orderMenu_quantity;
	}
	public int getMenu_seq() {
		return menu_seq;
	}
	public void setMenu_seq(int menu_seq) {
		this.menu_seq = menu_seq;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
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
	public String getBurger_Ingredient() {
		return burger_Ingredient;
	}
	public void setBurger_Ingredient(String burger_Ingredient) {
		this.burger_Ingredient = burger_Ingredient;
	}
	public String getBeverage_name() {
		return beverage_name;
	}
	public void setBeverage_name(String beverage_name) {
		this.beverage_name = beverage_name;
	}
	public String getSide_name() {
		return side_name;
	}
	public void setSide_name(String side_name) {
		this.side_name = side_name;
	}
	@Override
	public String toString() {
		return "Bb_OrderDetailDto [order_seq=" + order_seq + ", orderMenu_price=" + orderMenu_price
				+ ", orderMenu_quantity=" + orderMenu_quantity + ", menu_seq=" + menu_seq + ", menu_name=" + menu_name
				+ ", burger_seq=" + burger_seq + ", burger_name=" + burger_name + ", burger_Ingredient="
				+ burger_Ingredient + ", beverage_name=" + beverage_name + ", side_name=" + side_name + "]";
	}
	 
	 
	 
	 
	 
	 
	 
}
