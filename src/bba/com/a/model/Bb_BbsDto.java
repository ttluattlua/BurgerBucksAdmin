package bba.com.a.model;

import java.io.Serializable;
import java.util.List;

public class Bb_BbsDto implements Serializable {

  private int seq;
  private Bb_BurgerDto burger;
  private int writer;
  private int price;
  private boolean del;
  
  /*---------------------------------------------------------------------------------------
  Constructor
  --------------------------------------------------------------------------------------- */
  
  public Bb_BbsDto() {
    super();
  }

  public Bb_BbsDto(Bb_BurgerDto burger, int writer, int price) {
    super();
    this.burger = burger;
    this.writer = writer;
    this.price = price;
  }

  public Bb_BbsDto(int seq, Bb_BurgerDto burger, int writer, int price, boolean del) {
    super();
    this.seq = seq;
    this.burger = burger;
    this.writer = writer;
    this.price = price;
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

  public Bb_BurgerDto getBurger() {
    return burger;
  }

  public void setBurger(Bb_BurgerDto burger) {
    this.burger = burger;
  }

  public int getWriter() {
    return writer;
  }

  public void setWriter(int writer) {
    this.writer = writer;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public boolean isDel() {
    return del;
  }

  public void setDel(boolean del) {
    this.del = del;
  }
  
}
