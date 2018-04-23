package bba.com.a.dao;

import java.util.List;

import bba.com.a.model.Bb_AddrDto;
import bba.com.a.model.Bb_BeverageDto;
import bba.com.a.model.Bb_BurgerTableDto;
import bba.com.a.model.Bb_IngredientDto;
import bba.com.a.model.Bb_MemberDto;
import bba.com.a.model.Bb_MenuTableDto;
import bba.com.a.model.Bb_OrderDto;
import bba.com.a.model.Bb_OrderMenuDto;
import bba.com.a.model.Bb_SideDto;
import bba.com.a.model.Bb_StoreDto;

public interface BbaOrderDao {

	
	//주문 리스트 불러오기
	List<Bb_OrderDto> getOrderList() throws Exception;
	
	//주문 내역 SEQ 불러오기
	Bb_OrderDto getOrder(int seq) throws Exception;
	
	
	
	
	//멤버 리스트 불러오기
	Bb_MemberDto getMemberList(int member_seq) throws Exception;
	
	//주소 리스트 불러오기
	Bb_AddrDto getAddrList(int member_addr) throws Exception;
	
	//점포 리스트 불러오기
	Bb_StoreDto getStoreList(int store_seq) throws Exception;
	
	
	
	
	
	//주문 상세 가져오기 (ordermenu)
	List<Bb_OrderMenuDto> getOrderMenuList() throws Exception;
	
	//메뉴 리스트 가져오기
	Bb_MenuTableDto getMenuList(int seq) throws Exception;
	
	
	
	
	
	//버거 불러오기
	List<Bb_BurgerTableDto> getBurgerList() throws Exception;
	
	//음료 불러오기
	List<Bb_BeverageDto> getBeverageList() throws Exception;
	
	//사이드 불러오기
	List<Bb_SideDto> getSideList() throws Exception;
	
	//재료 불러오기
	List<Bb_IngredientDto> getIngreList() throws Exception;
	
	//주문 상태 변경
	public void changeOrder(Bb_OrderDto orderDto) throws Exception;
	
	
}
