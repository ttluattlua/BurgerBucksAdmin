package bba.com.a.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaOrderDao;
import bba.com.a.model.Bb_AddrDto;
import bba.com.a.model.Bb_BeverageDto;
import bba.com.a.model.Bb_BurgerDto;
import bba.com.a.model.Bb_MemberDto;
import bba.com.a.model.Bb_MenuTableDto;
import bba.com.a.model.Bb_OrderDto;
import bba.com.a.model.Bb_OrderMenuDto;
import bba.com.a.model.Bb_SideDto;
import bba.com.a.model.Bb_StoreDto;
import bba.com.a.service.BbaOrderService;

@Service
public class BbaOrderServiceImpl implements BbaOrderService {
	
	@Autowired
	private BbaOrderDao bbaOrderDao;

	
	/*--------------------------------------------------------------------------------------------
	 * 주문 리스트 불러오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public List<Bb_OrderDto> getOrderList() throws Exception {
		return bbaOrderDao.getOrderList();
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 멤버 리스트 불러오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public Bb_MemberDto getMemberList(int member_addr) throws Exception {
		return bbaOrderDao.getMemberList(member_addr);
	}

	
	/*--------------------------------------------------------------------------------------------
	 * 주소 리스트 불러오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public Bb_AddrDto getAddrList(int member_addr) throws Exception {
		return bbaOrderDao.getAddrList(member_addr);
	}

	/*--------------------------------------------------------------------------------------------
	 * 점포 리스트 불러오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public Bb_StoreDto getStoreList(int store_seq) throws Exception {
		return bbaOrderDao.getStoreList(store_seq);
	}

	/*--------------------------------------------------------------------------------------------
	 * 주문 상세 가져오기 (orderMenu)
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public Bb_OrderMenuDto getOrderMenuList(int seq) throws Exception {
		return bbaOrderDao.getOrderMenuList(seq);
	}

	/*--------------------------------------------------------------------------------------------
	 * 메뉴 리스트 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public Bb_MenuTableDto getMenuList(int seq) throws Exception {
		return bbaOrderDao.getMenuList(seq);
	}

	
	
	
	/*--------------------------------------------------------------------------------------------
	 * 버거 리스트 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public List<Bb_BurgerDto> getBurgerList() throws Exception {
		return bbaOrderDao.getBurgerList();
	}

	/*--------------------------------------------------------------------------------------------
	 * 음료 리스트 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public List<Bb_BeverageDto> getBeverageList() throws Exception {
		return bbaOrderDao.getBeverageList();
	}

	/*--------------------------------------------------------------------------------------------
	 * 사이드 리스트 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public List<Bb_SideDto> getSideList() throws Exception {
		return bbaOrderDao.getSideList();
	}

	
	
	
	
	
	
	
	
	
}
