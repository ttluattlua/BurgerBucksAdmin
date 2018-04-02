package bba.com.a.dao;

import bba.com.a.model.Bb_AdminDto;

public interface BbaMemberDao {

	//사원 등록
	boolean addAdmin(Bb_AdminDto adminDto)throws Exception;
	
}
