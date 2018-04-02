package bba.com.a.service;

import java.util.List;

import bba.com.a.model.Bb_AdminDto;

public interface BbaMemberSerivce {

	//사원등록
	boolean addAdmin(Bb_AdminDto adminDto) throws Exception;
	//사원리스트 가져오기
	public List<Bb_AdminDto> getAdminList() throws Exception;
}
