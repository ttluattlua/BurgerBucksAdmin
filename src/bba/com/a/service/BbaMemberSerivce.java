package bba.com.a.service;

import java.util.List;

import bba.com.a.model.Bb_AdminDto;
import bba.com.a.model.Bb_MemberDto;
import bba.com.a.model.Bb_StoreDto;

public interface BbaMemberSerivce {

	//사원등록
	boolean addAdmin(Bb_AdminDto adminDto) throws Exception;
	//사원리스트 가져오기
	List<Bb_AdminDto> getAdminList() throws Exception;
	//사원 id 중복 체크
	int getAdminID(Bb_AdminDto adminDto);
	//사원 삭제
	void delAdmin(int seq);
	
	
	//사원 수정 디테일
	Bb_AdminDto updateAdmin(int seq);
	//사원 수정 후
	void updateAdminAf(Bb_AdminDto adminDto);
	
	
	//점포 DTO 가져오기
	Bb_StoreDto getStoreName(int seq);
	
	
	
	//고객 리스트
	List<Bb_MemberDto> getCustomerList() throws Exception;
	
	//고객 삭제
	void delCustomer(int seq);
	
	//고객 수정 디테일
	Bb_MemberDto updateCustomer(int seq);
	//고객 수정 후
	void updateCustomerAf(Bb_MemberDto customerDto);
}
