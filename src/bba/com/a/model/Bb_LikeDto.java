package bba.com.a.model;

import java.io.Serializable;
import java.util.List;

public class Bb_LikeDto implements Serializable {

  private int seq;
  private int memberSeq ;
  private int bbsSeq;
  
  /*---------------------------------------------------------------------------------------
  Constructor
  --------------------------------------------------------------------------------------- */
  public Bb_LikeDto() { }
  
  public Bb_LikeDto(int seq, int memberSeq, int bbsSeq) {
    super();
    this.seq = seq;
    this.memberSeq = memberSeq;
    this.bbsSeq = bbsSeq;
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

  public int getMemberSeq() {
    return memberSeq;
  }

  public void setMemberSeq(int memberSeq) {
    this.memberSeq = memberSeq;
  }

  public int getBbsSeq() {
    return bbsSeq;
  }

  public void setBbsSeq(int bbsSeq) {
    this.bbsSeq = bbsSeq;
  }
  
}
