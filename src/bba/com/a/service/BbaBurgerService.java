package bba.com.a.service;

import java.util.List;

import bba.com.a.model.Bb_BurgerDto;
import bba.com.a.model.Bb_ImageDto;
import bba.com.a.model.Bb_IngredientDto;

public interface BbaBurgerService {
	
	/*--------------------------------------------------------------------------------------------
	 *버거 만들기 위한 재료들 가져오기
	 *-------------------------------------------------------------------------------------------*/	
	public List<Bb_IngredientDto> getIngredientList();
	
	
	public List<Bb_BurgerDto> getBurgerListForBurgerTB();
	
	/*--------------------------------------------------------------------------------------------
	 * 버거 새로 등록 (이미지와함께) 
	 *-------------------------------------------------------------------------------------------*/
	public Bb_BurgerDto registerBurger(Bb_BurgerDto bgdto, Bb_ImageDto bidto);
	
	/*--------------------------------------------------------------------------------------------
	 * 버거 등록후 재료들 이름뽑아오기 
	 *-------------------------------------------------------------------------------------------*/
	public Bb_BurgerDto getBurgerIngredientForBurgerTB(int seq);

}
