package bba.com.a.dao;

import bba.com.a.model.Bb_ImageDto;
import bba.com.a.model.Bb_SideDto;


public interface BbaSideDao {

	/*--------------------------------------------------------------------------------------------
	 * side 새로 등록 
	 *-------------------------------------------------------------------------------------------*/
	public int registerSide(Bb_SideDto bsdto);
	
	/*--------------------------------------------------------------------------------------------
	 * side 새로 이미지 등록 
	 *-------------------------------------------------------------------------------------------*/
	public void registerSideImage(Bb_ImageDto bidto);
}
