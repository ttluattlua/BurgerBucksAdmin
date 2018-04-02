package bba.com.a.dao.Impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaMemberDao;
import bba.com.a.model.Bb_AdminDto;

@Repository
public class BbaMemberDaoImpl implements BbaMemberDao {

	@Autowired	
	SqlSession sqlSession;
	
	private String namespace = "BBAMember."; 
	
	
	/*------------------------------------------------------------------------------
	* 사원등록(브랜치매니저)
	* -----------------------------------------------------------------------------*/
	@Override
	public boolean addAdmin(Bb_AdminDto adminDto) throws Exception {
		
		int n = sqlSession.insert(namespace + "addAdmin", adminDto);		
		return n>0?true:false;
	}

	
	
}
