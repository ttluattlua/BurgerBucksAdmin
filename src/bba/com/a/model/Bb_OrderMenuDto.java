package bba.com.a.model;

import java.io.Serializable;
import java.util.List;

public class Bb_OrderMenuDto implements Serializable {

  private int seq;
  private int order_seq;
  private int menu_seq;
  private Bb_MenuTableDto menu;
  private int quantity;
  private int price;
  private boolean del;
  
  /*---------------------------------------------------------------------------------------
  Constructor
  --------------------------------------------------------------------------------------- */
  
  public Bb_OrderMenuDto() {
    super();
  }

  public Bb_OrderMenuDto(int order_seq, Bb_MenuTableDto menu, int quantity, int price) {
    super();
    this.order_seq = order_seq;
    this.menu = menu;
    this.quantity = quantity;
    this.price = price;
  }

  public Bb_OrderMenuDto(int seq, int order_seq, int menu_seq, Bb_MenuTableDto menu, int quantity, int price, boolean del) {
    super();
    this.seq = seq;
    this.order_seq = order_seq;
    this.menu_seq = menu_seq;
    this.menu = menu;
    this.quantity = quantity;
    this.price = price;
    this.del = del;
  }
  
  

  public Bb_OrderMenuDto(int seq, int order_seq, int menu_seq, int quantity, int price, boolean del) {
	super();
	this.seq = seq;
	this.order_seq = order_seq;
	this.menu_seq = menu_seq;
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

  public int getOrder_seq() {
    return order_seq;
  }

  public void setOrder_seq(int order_seq) {
    this.order_seq = order_seq;
  }

  public Bb_MenuTableDto getMenu() {
    return menu;
  }

  public void setMenu(Bb_MenuTableDto menu) {
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

public int getMenu_seq() {
	return menu_seq;
}

public void setMenu_seq(int menu_seq) {
	this.menu_seq = menu_seq;
}

@Override
public String toString() {
	return "Bb_OrderMenuDto [seq=" + seq + ", order_seq=" + order_seq + ", menu_seq=" + menu_seq + ", menu=" + menu
			+ ", quantity=" + quantity + ", price=" + price + ", del=" + del + "]";
}
  
  
  
  
  
  
}
