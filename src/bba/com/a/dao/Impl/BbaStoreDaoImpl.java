package bba.com.a.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaStoreDao;
import bba.com.a.model.Bb_StoreDto;

@Repository
public class BbaStoreDaoImpl implements BbaStoreDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String ns ="BBAStore.";

	/*--------------------------------------------------------------------------------------------
	 * store 새로 등록 
	 *-------------------------------------------------------------------------------------------*/	
	@Override
	public int registerStore(Bb_StoreDto bsdto) {
		System.out.println("BbaStoreDaoImpl registerStore");
		System.out.println(bsdto.toString());
		int count = sqlSession.insert(ns+"registerStore", bsdto);
		int seq = bsdto.getSeq();
		System.out.println("seq: " + seq);
		return seq;
	}
	/*--------------------------------------------------------------------------------------------
	 * store 가져오기
	 *-------------------------------------------------------------------------------------------*/	
	@Override
	public List<Bb_StoreDto> GetStoreList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns+"storeList");
	}
	
	

}
