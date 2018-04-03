package bba.com.a.model;

import java.io.Serializable;
import java.util.List;

public class Bb_FavoriteDto implements Serializable {

	private int seq;
	private int member_seq;
	private int del;
	List<Bb_FavoriteMenuDto> favorite_menu;
	
	public Bb_FavoriteDto(int seq, int member_seq, int del, List<Bb_FavoriteMenuDto> favorite_menu) {
		super();
		this.seq = seq;
		this.member_seq = member_seq;
		this.del = del;
		this.favorite_menu = favorite_menu;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	public List<Bb_FavoriteMenuDto> getFavorite_menu() {
		return favorite_menu;
	}
	public void setFavorite_menu(List<Bb_FavoriteMenuDto> favorite_menu) {
		this.favorite_menu = favorite_menu;
	}
	@Override
	public String toString() {
		return "Bb_FavoriteDto [seq=" + seq + ", member_seq=" + member_seq + ", del=" + del + ", favorite_menu="
				+ favorite_menu + "]";
	}
	
}
