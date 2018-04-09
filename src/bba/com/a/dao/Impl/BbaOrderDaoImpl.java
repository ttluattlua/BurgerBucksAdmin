package bba.com.a.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaOrderDao;
import bba.com.a.model.Bb_AddrDto;
import bba.com.a.model.Bb_MemberDto;
import bba.com.a.model.Bb_MenuTableDto;
import bba.com.a.model.Bb_OrderDto;
import bba.com.a.model.Bb_OrderMenuDto;
import bba.com.a.model.Bb_StoreDto;

@Repository
public class BbaOrderDaoImpl implements BbaOrderDao {

	@Autowired
	SqlSession sqlSession;
	private String namespace = "BBAOrder."; 
	
	
	/*------------------------------------------------------------------------------
	* 주문 리스트 불러오기
	* -----------------------------------------------------------------------------*/
	@Override
	public List<Bb_OrderDto> getOrderList() throws Exception {
		// sqlSession 설정 타입 (BATCH, SIMPLE)
		
		System.out.println("타입:" + sqlSession.getConfiguration().getDefaultExecutorType());
		
		List<Bb_OrderDto> list = new ArrayList<Bb_OrderDto>();		
		list = sqlSession.selectList(namespace + "getOrderList");
						
		return list;
	}

	/*------------------------------------------------------------------------------
	* 멤버 리스트 불러오기
	* -----------------------------------------------------------------------------*/
	@Override
	public List<Bb_MemberDto> getMemberList(int member_seq) throws Exception {

		List<Bb_MemberDto> list = new ArrayList<Bb_MemberDto>();
		list = sqlSession.selectList(namespace + "getMemberList", member_seq);
		return list;
	}

	/*------------------------------------------------------------------------------
	* 주소 리스트 불러오기
	* -----------------------------------------------------------------------------*/
	@Override
	public List<Bb_AddrDto> getAddrList(int member_addr) throws Exception {
		List<Bb_AddrDto> list = new ArrayList<Bb_AddrDto>();
		list = sqlSession.selectList(namespace + "getAddrList", member_addr);
		return list;
	}

	/*------------------------------------------------------------------------------
	* 점포 리스트 불러오기
	* -----------------------------------------------------------------------------*/
	@Override
	public List<Bb_StoreDto> getStoreList(int store_seq) throws Exception {
		List<Bb_StoreDto> list = new ArrayList<Bb_StoreDto>();
		list = sqlSession.selectList(namespace + "getStoreList", store_seq);
		return list;
	}

	/*------------------------------------------------------------------------------
	* 주문 상세 가져오기 (ordermenu)
	* -----------------------------------------------------------------------------*/
	@Override
	public List<Bb_OrderMenuDto> getOrderMenuList(int seq) throws Exception {
		List<Bb_OrderMenuDto> list = new ArrayList<Bb_OrderMenuDto>();
		list = sqlSession.selectList(namespace + "getStoreList", seq);
		return list;
	}

	
	/*------------------------------------------------------------------------------
	* 메뉴 리스트 가져오기
	* -----------------------------------------------------------------------------*/
	@Override
	public List<Bb_MenuTableDto> getMenuList(int seq) throws Exception {
		List<Bb_MenuTableDto> list = new ArrayList<Bb_MenuTableDto>();
		list = sqlSession.selectList(namespace + "getMenuList", seq);
		return list;
	}
	
	
	
	
	
	
	
	
	
	
}
