package bba.com.a.model;

import java.io.Serializable;
import java.util.List;

public class Bb_MenuDto implements Serializable {

  private int seq;
  private Bb_IngredientDto burger;
  private Bb_IngredientDto side;
  private Bb_IngredientDto beverage;
  private String name;
  private int creatorSeq;
  private int price;
  private int calorie;
  private boolean del;
  
  /*---------------------------------------------------------------------------------------
  Constructor
  --------------------------------------------------------------------------------------- */
  public Bb_MenuDto() { }
  
  public Bb_MenuDto(Bb_IngredientDto burger, Bb_IngredientDto side, Bb_IngredientDto beverage, String name,
      int creatorSeq, int price, int calorie) {
    super();
    this.burger = burger;
    this.side = side;
    this.beverage = beverage;
    this.name = name;
    this.creatorSeq = creatorSeq;
    this.price = price;
    this.calorie = calorie;
  }

  public Bb_MenuDto(int seq, Bb_IngredientDto burger, Bb_IngredientDto side, Bb_IngredientDto beverage, String name,
      int creatorSeq, int price, int calorie, boolean del) {
    super();
    this.seq = seq;
    this.burger = burger;
    this.side = side;
    this.beverage = beverage;
    this.name = name;
    this.creatorSeq = creatorSeq;
    this.price = price;
    this.calorie = calorie;
    this.del = del;
  }

  /*---------------------------------------------------------------------------------------
  Getter & Setter
  --------------------------------------------------------------------------------------- */
  
  public int getSeq() {
    return seq;
  }

  public void setSeq(int seq) {
    this.seq = seq;
  }

  public Bb_IngredientDto getBurger() {
    return burger;
  }

  public void setBurger(Bb_IngredientDto burger) {
    this.burger = burger;
  }

  public Bb_IngredientDto getSide() {
    return side;
  }

  public void setSide(Bb_IngredientDto side) {
    this.side = side;
  }

  public Bb_IngredientDto getBeverage() {
    return beverage;
  }

  public void setBeverage(Bb_IngredientDto beverage) {
    this.beverage = beverage;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCreatorSeq() {
    return creatorSeq;
  }

  public void setCreatorSeq(int creatorSeq) {
    this.creatorSeq = creatorSeq;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getCalorie() {
    return calorie;
  }

  public void setCalorie(int calorie) {
    this.calorie = calorie;
  }

  public boolean isDel() {
    return del;
  }

  public void setDel(boolean del) {
    this.del = del;
  }
  
  
  
  
}
