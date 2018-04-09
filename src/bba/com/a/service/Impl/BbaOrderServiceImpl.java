package bba.com.a.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaOrderDao;
import bba.com.a.model.Bb_AddrDto;
import bba.com.a.model.Bb_MemberDto;
import bba.com.a.model.Bb_OrderDto;
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
	public List<Bb_MemberDto> getMemberList(int member_addr) throws Exception {
		return bbaOrderDao.getMemberList(member_addr);
	}

	
	/*--------------------------------------------------------------------------------------------
	 * 주소 리스트 불러오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public List<Bb_AddrDto> getAddrList(int member_addr) throws Exception {
		return bbaOrderDao.getAddrList(member_addr);
	}

	/*--------------------------------------------------------------------------------------------
	 * 점포 리스트 불러오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public List<Bb_StoreDto> getStoreList(int store_seq) throws Exception {
		// TODO Auto-generated method stub
		return bbaOrderDao.getStoreList(store_seq);
	}

	
	
	
	
	
}
