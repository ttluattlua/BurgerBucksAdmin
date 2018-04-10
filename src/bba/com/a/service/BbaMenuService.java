package bba.com.a.service;

import java.util.List;

import bba.com.a.model.Bb_BeverageDto;
import bba.com.a.model.Bb_MenuDto;
import bba.com.a.model.Bb_SideDto;

public interface BbaMenuService {
	
	public List<Bb_MenuDto> getMenuList();
	
	public Bb_SideDto getDetailSide(int seq);
	
	public Bb_BeverageDto getDetailBeverage(int seq);
	
	public void deleteMenu(int seq);

}
