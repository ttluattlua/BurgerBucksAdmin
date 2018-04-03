package bba.com.a.model;

import java.io.Serializable;
import java.util.List;

public class Bb_OrderMenuDto implements Serializable {

  private int seq;
  private int orderSeq;
  private Bb_MenuDto menu;
  private int quantity;
  private int price;
  private boolean del;
  
  /*---------------------------------------------------------------------------------------
  Constructor
  --------------------------------------------------------------------------------------- */
  
  public Bb_OrderMenuDto() {
    super();
  }

  public Bb_OrderMenuDto(int orderSeq, Bb_MenuDto menu, int quantity, int price) {
    super();
    this.orderSeq = orderSeq;
    this.menu = menu;
    this.quantity = quantity;
    this.price = price;
  }

  public Bb_OrderMenuDto(int seq, int orderSeq, Bb_MenuDto menu, int quantity, int price, boolean del) {
    super();
    this.seq = seq;
    this.orderSeq = orderSeq;
    this.menu = menu;
    this.quantity = quantity;
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

  public int getOrderSeq() {
    return orderSeq;
  }

  public void setOrderSeq(int orderSeq) {
    this.orderSeq = orderSeq;
  }

  public Bb_MenuDto getMenu() {
    return menu;
  }

  public void setMenu(Bb_MenuDto menu) {
    this.menu = menu;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
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
