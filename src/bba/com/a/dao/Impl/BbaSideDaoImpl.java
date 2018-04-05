package bba.com.a.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaSideDao;
import bba.com.a.model.Bb_ImageDto;
import bba.com.a.model.Bb_SideDto;

@Repository
public class BbaSideDaoImpl implements BbaSideDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String ns = "BBASide.";

	@Override
	public int registerSide(Bb_SideDto bsdto) {
		System.out.println("BbaSideDaoImpl registerSide");
		System.out.println(bsdto.toString());
		int count = sqlSession.insert(ns+"registerSide", bsdto);
		//select key로 리터해온거
		int seq = bsdto.getSeq();
		System.out.println("seq: " + seq);
		return seq;
	}

	@Override
	public void registerSideImage(Bb_ImageDto bidto) {
		// TODO Auto-generated method stub
		sqlSession.insert(ns+"registerSideImage", bidto);
	}
}
