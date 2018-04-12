package bba.com.a.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaStatisticDao;

@Repository
public class BbaStatisticDaoImpl implements BbaStatisticDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String ns="BBAStatistic.";
	/*--------------------------------------------------------------------------------------------
	 * 고객수 가져오기 
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public int getMemberCounts() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns+"getMemberCounts");
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 점포수 가져오기 
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public int getStoreCounts() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns+"getStoreCounts");
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 현재일을 기준으로 전달 총 매출  
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public int getPreviousMonthProfit() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns+"getPreviousMonthProfit");
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 현재일을 기준으로 전달 총 주문 개수 
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public int getPreviousMonthOrderCounts() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns+"getPreviousMonthOrderCounts");
	}
	
	
	
}
