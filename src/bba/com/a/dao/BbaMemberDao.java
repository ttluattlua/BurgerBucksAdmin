package bba.com.a.dao;

import java.util.List;

import bba.com.a.model.Bb_AdminDto;

public interface BbaMemberDao {

	//사원 등록
	boolean addAdmin(Bb_AdminDto adminDto)throws Exception;
	//사원 리스트
	List<Bb_AdminDto> getAdminList() throws Exception;
	
}
