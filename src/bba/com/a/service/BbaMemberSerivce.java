package bba.com.a.service;

import bba.com.a.model.Bb_AdminDto;

public interface BbaMemberSerivce {

	//사원등록
	boolean addAdmin(Bb_AdminDto adminDto) throws Exception;
}
