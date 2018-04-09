package bba.com.a.model;

import java.io.Serializable;


/*------------------------------------------------------------------------------
 * 버거를 위한  DTO(버거 속 재료들은 모두 Bb_IngredientDto 클래스로 받아줌)
 * -----------------------------------------------------------------------------*/
public class Bb_BurgerDto implements Serializable {
	private int seq;				//시퀀스
	private String name;			//버거이름
	
	
	private Bb_IngredientDto breadCls;				//빵종류
	private Bb_IngredientDto ingredientsCls1;	//재료1
	private Bb_IngredientDto ingredientsCls2;		//재료2
	private Bb_IngredientDto ingredientsCls3;		//재료3
	private Bb_IngredientDto ingredientsCls4;		//재료4
	private Bb_IngredientDto ingredientsCls5;		//재료5
	private Bb_IngredientDto ingredientsCls6;		//재료6
	private Bb_IngredientDto ingredientsCls7;		//재료7
	private Bb_IngredientDto ingredientsCls8;		//재료8
	private Bb_IngredientDto ingredientsCls9;		//재료9
	
	
	private int bread;				//빵종류
	private int ingredients1;	//재료1
	private int ingredients2;		//재료2
	private int ingredients3;		//재료3
	private int ingredients4;		//재료4
	private int ingredients5;		//재료5
	private int ingredients6;		//재료6
	private int ingredients7;		//재료7
	private int ingredients8;		//재료8
	private int ingredients9;		//재료9
	private int creator;			//만든이(고객이만들었을때는 해당사람 seq번호, admin이 만들었을경우 0)
	private int price;				//버거가격
	private int cal;				//칼로리
	private int del;				//삭제여부
	
	//이미지
	////이미지테이블 
	private String what_Image;
	private String image_Src;
	private int image_Seq;
	
	
	
	public Bb_BurgerDto() {}



	public Bb_BurgerDto(int seq, String name, Bb_IngredientDto breadCls, Bb_IngredientDto ingredientsCls1,
			Bb_IngredientDto ingredientsCls2, Bb_IngredientDto ingredientsCls3, Bb_IngredientDto ingredientsCls4,
			Bb_IngredientDto ingredientsCls5, Bb_IngredientDto ingredientsCls6, Bb_IngredientDto ingredientsCls7,
			Bb_IngredientDto ingredientsCls8, Bb_IngredientDto ingredientsCls9, int bread, int ingredients1,
			int ingredients2, int ingredients3, int ingredients4, int ingredients5, int ingredients6, int ingredients7,
			int ingredients8, int ingredients9, int creator, int price, int cal, int del, String what_Image,
			String image_Src, int image_Seq) {
		super();
		this.seq = seq;
		this.name = name;
		this.breadCls = breadCls;
		this.ingredientsCls1 = ingredientsCls1;
		this.ingredientsCls2 = ingredientsCls2;
		this.ingredientsCls3 = ingredientsCls3;
		this.ingredientsCls4 = ingredientsCls4;
		this.ingredientsCls5 = ingredientsCls5;
		this.ingredientsCls6 = ingredientsCls6;
		this.ingredientsCls7 = ingredientsCls7;
		this.ingredientsCls8 = ingredientsCls8;
		this.ingredientsCls9 = ingredientsCls9;
		this.bread = bread;
		this.ingredients1 = ingredients1;
		this.ingredients2 = ingredients2;
		this.ingredients3 = ingredients3;
		this.ingredients4 = ingredients4;
		this.ingredients5 = ingredients5;
		this.ingredients6 = ingredients6;
		this.ingredients7 = ingredients7;
		this.ingredients8 = ingredients8;
		this.ingredients9 = ingredients9;
		this.creator = creator;
		this.price = price;
		this.cal = cal;
		this.del = del;
		this.what_Image = what_Image;
		this.image_Src = image_Src;
		this.image_Seq = image_Seq;
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



	public Bb_IngredientDto getBreadCls() {
		return breadCls;
	}



	public void setBreadCls(Bb_IngredientDto breadCls) {
		this.breadCls = breadCls;
	}



	public Bb_IngredientDto getIngredientsCls1() {
		return ingredientsCls1;
	}



	public void setIngredientsCls1(Bb_IngredientDto ingredientsCls1) {
		this.ingredientsCls1 = ingredientsCls1;
	}



	public Bb_IngredientDto getIngredientsCls2() {
		return ingredientsCls2;
	}



	public void setIngredientsCls2(Bb_IngredientDto ingredientsCls2) {
		this.ingredientsCls2 = ingredientsCls2;
	}



	public Bb_IngredientDto getIngredientsCls3() {
		return ingredientsCls3;
	}



	public void setIngredientsCls3(Bb_IngredientDto ingredientsCls3) {
		this.ingredientsCls3 = ingredientsCls3;
	}



	public Bb_IngredientDto getIngredientsCls4() {
		return ingredientsCls4;
	}



	public void setIngredientsCls4(Bb_IngredientDto ingredientsCls4) {
		this.ingredientsCls4 = ingredientsCls4;
	}



	public Bb_IngredientDto getIngredientsCls5() {
		return ingredientsCls5;
	}



	public void setIngredientsCls5(Bb_IngredientDto ingredientsCls5) {
		this.ingredientsCls5 = ingredientsCls5;
	}



	public Bb_IngredientDto getIngredientsCls6() {
		return ingredientsCls6;
	}



	public void setIngredientsCls6(Bb_IngredientDto ingredientsCls6) {
		this.ingredientsCls6 = ingredientsCls6;
	}



	public Bb_IngredientDto getIngredientsCls7() {
		return ingredientsCls7;
	}



	public void setIngredientsCls7(Bb_IngredientDto ingredientsCls7) {
		this.ingredientsCls7 = ingredientsCls7;
	}



	public Bb_IngredientDto getIngredientsCls8() {
		return ingredientsCls8;
	}



	public void setIngredientsCls8(Bb_IngredientDto ingredientsCls8) {
		this.ingredientsCls8 = ingredientsCls8;
	}



	public Bb_IngredientDto getIngredientsCls9() {
		return ingredientsCls9;
	}



	public void setIngredientsCls9(Bb_IngredientDto ingredientsCls9) {
		this.ingredientsCls9 = ingredientsCls9;
	}



	public int getBread() {
		return bread;
	}



	public void setBread(int bread) {
		this.bread = bread;
	}



	public int getIngredients1() {
		return ingredients1;
	}



	public void setIngredients1(int ingredients1) {
		this.ingredients1 = ingredients1;
	}



	public int getIngredients2() {
		return ingredients2;
	}



	public void setIngredients2(int ingredients2) {
		this.ingredients2 = ingredients2;
	}



	public int getIngredients3() {
		return ingredients3;
	}



	public void setIngredients3(int ingredients3) {
		this.ingredients3 = ingredients3;
	}



	public int getIngredients4() {
		return ingredients4;
	}



	public void setIngredients4(int ingredients4) {
		this.ingredients4 = ingredients4;
	}



	public int getIngredients5() {
		return ingredients5;
	}



	public void setIngredients5(int ingredients5) {
		this.ingredients5 = ingredients5;
	}



	public int getIngredients6() {
		return ingredients6;
	}



	public void setIngredients6(int ingredients6) {
		this.ingredients6 = ingredients6;
	}



	public int getIngredients7() {
		return ingredients7;
	}



	public void setIngredients7(int ingredients7) {
		this.ingredients7 = ingredients7;
	}



	public int getIngredients8() {
		return ingredients8;
	}



	public void setIngredients8(int ingredients8) {
		this.ingredients8 = ingredients8;
	}



	public int getIngredients9() {
		return ingredients9;
	}



	public void setIngredients9(int ingredients9) {
		this.ingredients9 = ingredients9;
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



	@Override
	public String toString() {
		return "Bb_BurgerDto [seq=" + seq + ", name=" + name + ", breadCls=" + breadCls + ", ingredientsCls1="
				+ ingredientsCls1 + ", ingredientsCls2=" + ingredientsCls2 + ", ingredientsCls3=" + ingredientsCls3
				+ ", ingredientsCls4=" + ingredientsCls4 + ", ingredientsCls5=" + ingredientsCls5 + ", ingredientsCls6="
				+ ingredientsCls6 + ", ingredientsCls7=" + ingredientsCls7 + ", ingredientsCls8=" + ingredientsCls8
				+ ", ingredientsCls9=" + ingredientsCls9 + ", bread=" + bread + ", ingredients1=" + ingredients1
				+ ", ingredients2=" + ingredients2 + ", ingredients3=" + ingredients3 + ", ingredients4=" + ingredients4
				+ ", ingredients5=" + ingredients5 + ", ingredients6=" + ingredients6 + ", ingredients7=" + ingredients7
				+ ", ingredients8=" + ingredients8 + ", ingredients9=" + ingredients9 + ", creator=" + creator
				+ ", price=" + price + ", cal=" + cal + ", del=" + del + ", what_Image=" + what_Image + ", image_Src="
				+ image_Src + ", image_Seq=" + image_Seq + "]";
	}

	
	
}
