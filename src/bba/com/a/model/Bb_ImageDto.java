package bba.com.a.model;

import java.io.Serializable;



/*------------------------------------------------------------------------------
 * 이미지테이블을 위한 DTO
 * -----------------------------------------------------------------------------*/
public class Bb_ImageDto implements Serializable {
	private int seq;
	private String table_Name;
	private String what_Image;
	private String image_Src;
	private int ref_Seq;
	private int del;
	
	
	public Bb_ImageDto() {}


	public Bb_ImageDto(int seq, String table_Name, String what_Image, String image_Src, int ref_Seq, int del) {
		super();
		this.seq = seq;
		this.table_Name = table_Name;
		this.what_Image = what_Image;
		this.image_Src = image_Src;
		this.ref_Seq = ref_Seq;
		this.del = del;
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getTable_Name() {
		return table_Name;
	}


	public void setTable_Name(String table_Name) {
		this.table_Name = table_Name;
	}


	public String getWhat_Image() {
		return what_Image;
	}


	public void setWhat_Image(String what_Image) {
		this.what_Image = what_Image;
	}


	public String getImage_Src() {
		return image_Src;
	}


	public void setImage_Src(String image_Src) {
		this.image_Src = image_Src;
	}


	public int getRef_Seq() {
		return ref_Seq;
	}


	public void setRef_Seq(int ref_Seq) {
		this.ref_Seq = ref_Seq;
	}


	public int getDel() {
		return del;
	}


	public void setDel(int del) {
		this.del = del;
	}


	@Override
	public String toString() {
		return "Bb_ImageDto [seq=" + seq + ", table_Name=" + table_Name + ", what_Image=" + what_Image + ", image_Src="
				+ image_Src + ", ref_Seq=" + ref_Seq + ", del=" + del + "]";
	}
	
	
}
