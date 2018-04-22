package bba.com.a.model;

import java.io.Serializable;


/*------------------------------------------------------------------------------
 * 재료를 위한  DTO
 * -----------------------------------------------------------------------------*/
public class Bb_IngredientDto implements Serializable {
	private int seq;		//시퀀스
	private String name;	//재료이름
	private int types;		//재료타입
	private int price;		//가격
	private int cal;		//칼로리
	private int del;		//삭제여부

////이미지테이블 
	private String what_Image;
	private String image_Src;
	private int image_Seq;
    private String type_name;
	
	
	public Bb_IngredientDto() {}

	public Bb_IngredientDto(int seq, String name, int types, int price, int cal, int del) {
		super();
		this.seq = seq;
		this.name = name;
		this.types = types;
		this.price = price;
		this.cal = cal;
		this.del = del;
	}
	
	

	
	
	public Bb_IngredientDto(int seq, String name, int types, int price, int cal, int del, String image_Src) {
		super();
		this.seq = seq;
		this.name = name;
		this.types = types;
		this.price = price;
		this.cal = cal;
		this.del = del;
		this.image_Src = image_Src;
	}

	public Bb_IngredientDto(int seq, String name, int types, int price, int cal, int del, String what_Image,
			String image_Src, int image_Seq, String type_name) {
		super();
		this.seq = seq;
		this.name = name;
		this.types = types;
		this.price = price;
		this.cal = cal;
		this.del = del;
		this.what_Image = what_Image;
		this.image_Src = image_Src;
		this.image_Seq = image_Seq;
		this.type_name = type_name;
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

	public int getTypes() {
		return types;
	}

	public void setTypes(int types) {
		this.types = types;
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

	public int getImage_Seq() {
		return image_Seq;
	}

	public void setImage_Seq(int image_Seq) {
		this.image_Seq = image_Seq;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	@Override
	public String toString() {
		return "Bb_IngredientDto [seq=" + seq + ", name=" + name + ", types=" + types + ", price=" + price + ", cal="
				+ cal + ", del=" + del + ", what_Image=" + what_Image + ", image_Src=" + image_Src + ", image_Seq="
				+ image_Seq + ", type_name=" + type_name + "]";
	}

	
	
	
}
