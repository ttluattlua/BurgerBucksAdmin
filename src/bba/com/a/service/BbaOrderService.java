package bba.com.a.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bba.com.a.model.Bb_AddrDto;
import bba.com.a.model.Bb_MemberDto;
import bba.com.a.model.Bb_OrderDto;
import bba.com.a.model.Bb_StoreDto;


public interface BbaOrderService {

	//주문 리스트 불러오기
	List<Bb_OrderDto> getOrderList() throws Exception;
	
	//멤버 리스트 가져오기
	List<Bb_MemberDto> getMemberList(int member_addr) throws Exception;
	
	//주소 리스트 가져오기
	List<Bb_AddrDto> getAddrList(int member_addr) throws Exception;
	
	//점포 리스트 가져오기
	List<Bb_StoreDto> getStoreList(int store_seq) throws Exception;
}
