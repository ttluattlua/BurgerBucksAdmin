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
	
	
	
}
