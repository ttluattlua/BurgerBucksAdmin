package bba.com.a.model;

import java.io.Serializable;
import java.util.List;

public class Bb_FavoriteMenuDto implements Serializable {

  private int seq;
  private int favoriteSeq;
  private Bb_MenuTableDto menu;
  private int quantity;
  private int price;
  private boolean del;
  
  /*---------------------------------------------------------------------------------------
  Constructor
  --------------------------------------------------------------------------------------- */
  
  public Bb_FavoriteMenuDto() {
    super();
  }

  public Bb_FavoriteMenuDto(int favoriteSeq, Bb_MenuTableDto menu, int quantity, int price) {
    super();
    this.favoriteSeq = favoriteSeq;
    this.menu = menu;
    this.quantity = quantity;
    this.price = price;
  }

  public Bb_FavoriteMenuDto(int seq, int favoriteSeq, Bb_MenuTableDto menu, int quantity, int price, boolean del) {
    super();
    this.seq = seq;
    this.favoriteSeq = favoriteSeq;
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

  public int getfavoriteSeq() {
    return favoriteSeq;
  }

  public void setfavoriteSeq(int favoriteSeq) {
    this.favoriteSeq = favoriteSeq;
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
  
  
  
  
}
