package bba.com.a.dao;

import java.util.List;

import bba.com.a.model.Bb_AdminDto;

public interface BbaMemberDao {

	//사원 등록
	boolean addAdmin(Bb_AdminDto adminDto)throws Exception;
	//사원 리스트
	List<Bb_AdminDto> getAdminList() throws Exception;
	//사원 id 중복체크
	int getAdminID(Bb_AdminDto adminDto);
	//사원 삭제
	void deladmin(int seq);
	
	//사원 수정 디테일
	Bb_AdminDto updateadmin(int seq);
	//사원 수정 후
	void updateadminAf(Bb_AdminDto adminDto);
}
