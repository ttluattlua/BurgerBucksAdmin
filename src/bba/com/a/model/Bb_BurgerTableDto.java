package bba.com.a.model;

import java.io.Serializable;

public class Bb_BurgerTableDto implements Serializable {

/*	CREATE TABLE BB_BURGER(
			SEQ NUMBER(10) PRIMARY KEY,
			NAME VARCHAR2(100) NOT NULL,
			BREAD NUMBER(10) NOT NULL,
			INGREDIENT01 NUMBER(10) NOT NULL,
			INGREDIENT02 NUMBER(10) NOT NULL,
			INGREDIENT03 NUMBER(10) NOT NULL,
			INGREDIENT04 NUMBER(10) NOT NULL,
			INGREDIENT05 NUMBER(10) NOT NULL,
			INGREDIENT06 NUMBER(10) NOT NULL,
			INGREDIENT07 NUMBER(10) NOT NULL,
			INGREDIENT08 NUMBER(10) NOT NULL,
			INGREDIENT09 NUMBER(10) NOT NULL,
			CREATOR NUMBER(10) NOT NULL,
			PRICE NUMBER(20) NOT NULL,
			CAL NUMBER(20) NOT NULL,
			DEL NUMBER(1) NOT NULL
		);*/

	private int seq;
	private String name;
	private int bread;
	private int ingredient01;
	private int ingredient02;
	private int ingredient03;
	private int ingredient04;
	private int ingredient05;
	private int ingredient06;
	private int ingredient07;
	private int ingredient08;
	private int ingredient09;
	private int creator;
	private int price;
	private int cal;
	private int del;
	public Bb_BurgerTableDto() {
		super();
	}
	public Bb_BurgerTableDto(int seq, String name, int bread, int ingredient01, int ingredient02, int ingredient03,
			int ingredient04, int ingredient05, int ingredient06, int ingredient07, int ingredient08, int ingredient09,
			int creator, int price, int cal, int del) {
		super();
		this.seq = seq;
		this.name = name;
		this.bread = bread;
		this.ingredient01 = ingredient01;
		this.ingredient02 = ingredient02;
		this.ingredient03 = ingredient03;
		this.ingredient04 = ingredient04;
		this.ingredient05 = ingredient05;
		this.ingredient06 = ingredient06;
		this.ingredient07 = ingredient07;
		this.ingredient08 = ingredient08;
		this.ingredient09 = ingredient09;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBread() {
		return bread;
	}
	public void setBread(int bread) {
		this.bread = bread;
	}
	public int getIngredient01() {
		return ingredient01;
	}
	public void setIngredient01(int ingredient01) {
		this.ingredient01 = ingredient01;
	}
	public int getIngredient02() {
		return ingredient02;
	}
	public void setIngredient02(int ingredient02) {
		this.ingredient02 = ingredient02;
	}
	public int getIngredient03() {
		return ingredient03;
	}
	public void setIngredient03(int ingredient03) {
		this.ingredient03 = ingredient03;
	}
	public int getIngredient04() {
		return ingredient04;
	}
	public void setIngredient04(int ingredient04) {
		this.ingredient04 = ingredient04;
	}
	public int getIngredient05() {
		return ingredient05;
	}
	public void setIngredient05(int ingredient05) {
		this.ingredient05 = ingredient05;
	}
	public int getIngredient06() {
		return ingredient06;
	}
	public void setIngredient06(int ingredient06) {
		this.ingredient06 = ingredient06;
	}
	public int getIngredient07() {
		return ingredient07;
	}
	public void setIngredient07(int ingredient07) {
		this.ingredient07 = ingredient07;
	}
	public int getIngredient08() {
		return ingredient08;
	}
	public void setIngredient08(int ingredient08) {
		this.ingredient08 = ingredient08;
	}
	public int getIngredient09() {
		return ingredient09;
	}
	public void setIngredient09(int ingredient09) {
		this.ingredient09 = ingredient09;
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
		return "Bb_BurgerTableDto [seq=" + seq + ", name=" + name + ", bread=" + bread + ", ingredient01="
				+ ingredient01 + ", ingredient02=" + ingredient02 + ", ingredient03=" + ingredient03 + ", ingredient04="
				+ ingredient04 + ", ingredient05=" + ingredient05 + ", ingredient06=" + ingredient06 + ", ingredient07="
				+ ingredient07 + ", ingredient08=" + ingredient08 + ", ingredient09=" + ingredient09 + ", creator="
				+ creator + ", price=" + price + ", cal=" + cal + ", del=" + del + "]";
	}
	
	
	
	
	
}
