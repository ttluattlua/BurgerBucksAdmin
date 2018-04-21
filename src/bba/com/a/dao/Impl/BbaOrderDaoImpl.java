package bba.com.a.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaOrderDao;
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
	* 주문 리스트 받아오기 (seq)
	* -----------------------------------------------------------------------------*/
	@Override
	public Bb_OrderDto getOrder(int seq) throws Exception {
		Bb_OrderDto orderDto = sqlSession.selectOne(namespace + "getOrder", seq);
		return orderDto;
	}

	/*------------------------------------------------------------------------------
	* 멤버 리스트 불러오기
	* -----------------------------------------------------------------------------*/
	@Override
	public Bb_MemberDto getMemberList(int member_seq) throws Exception {
		return sqlSession.selectOne(namespace + "getMemberList", member_seq);
	}

	/*------------------------------------------------------------------------------
	* 주소 리스트 불러오기
	* -----------------------------------------------------------------------------*/
	@Override
	public Bb_AddrDto getAddrList(int member_addr) throws Exception {
		return sqlSession.selectOne(namespace + "getAddrList", member_addr);
	}

	/*------------------------------------------------------------------------------
	* 점포 리스트 불러오기
	* -----------------------------------------------------------------------------*/
	@Override
	public Bb_StoreDto getStoreList(int store_seq) throws Exception {
		return sqlSession.selectOne(namespace + "getStoreList", store_seq);
	}

	/*------------------------------------------------------------------------------
	* 주문 상세 가져오기 (ordermenu)
	* -----------------------------------------------------------------------------*/
	@Override
	public List<Bb_OrderMenuDto> getOrderMenuList() throws Exception {
		List<Bb_OrderMenuDto> orderMenuDtoList = new ArrayList<Bb_OrderMenuDto>();
		orderMenuDtoList = sqlSession.selectList(namespace + "getOrderMenuList");
		return orderMenuDtoList;
	}

	
	/*------------------------------------------------------------------------------
	* 메뉴 리스트 가져오기
	* -----------------------------------------------------------------------------*/
	@Override
	public Bb_MenuTableDto getMenuList(int seq) throws Exception {
		return sqlSession.selectOne(namespace + "getMenuList", seq);
	}
	
	
	/*------------------------------------------------------------------------------
	* 버거 리스트 가져오기
	* -----------------------------------------------------------------------------*/
	@Override
	public List<Bb_BurgerTableDto> getBurgerList() throws Exception {
		List<Bb_BurgerTableDto> list = new ArrayList<Bb_BurgerTableDto>();
		list = sqlSession.selectList(namespace + "getBurgerList");
		return list;
	}
	
	/*------------------------------------------------------------------------------
	* 음료 리스트 가져오기
	* -----------------------------------------------------------------------------*/
	@Override
	public List<Bb_BeverageDto> getBeverageList() throws Exception {
		List<Bb_BeverageDto> list = new ArrayList<Bb_BeverageDto>();
		list = sqlSession.selectList(namespace + "getBeverageList");
		return list;
	}
	
	
	/*------------------------------------------------------------------------------
	* 재료 리스트 가져오기
	* -----------------------------------------------------------------------------*/
	@Override
	public List<Bb_IngredientDto> getIngreList() throws Exception {
		return sqlSession.selectList(namespace + "getIngreList");
	}
	

	/*------------------------------------------------------------------------------
	* 사이드 리스트 가져오기
	* -----------------------------------------------------------------------------*/
	@Override
	public List<Bb_SideDto> getSideList() throws Exception {
		List<Bb_SideDto> list = new ArrayList<Bb_SideDto>();
		list = sqlSession.selectList(namespace + "getSideList");
		return list;
	}

	
	/*------------------------------------------------------------------------------
	* 주문 상태 변경하기
	* -----------------------------------------------------------------------------*/
	@Override
	public void changeOrder(Bb_OrderDto orderDto) throws Exception {
		sqlSession.update(namespace + "changeOrder" , orderDto);
	}

	

	
	
	
	
}
