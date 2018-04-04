package bba.com.a.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaMemberDao;
import bba.com.a.model.Bb_AdminDto;
import bba.com.a.model.Bb_MemberDto;
import bba.com.a.model.Bb_StoreDto;

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

	/*------------------------------------------------------------------------------
	* 사원리스트 불러오기 (브랜치매니저)
	* -----------------------------------------------------------------------------*/
	@Override
	public List<Bb_AdminDto> getAdminList() throws Exception {
		// sqlSession 설정 타입 (BATCH, SIMPLE)
		System.out.println("타입:" + sqlSession.getConfiguration().getDefaultExecutorType());
		
		List<Bb_AdminDto> list = new ArrayList<Bb_AdminDto>();		
		list = sqlSession.selectList(namespace + "getAdminList");
						
		return list;
	}

	/*------------------------------------------------------------------------------
	* 사원 id 중복체크 (브랜치매니저)
	* -----------------------------------------------------------------------------*/
	@Override
	public int getAdminID(Bb_AdminDto adminDto) {
		return sqlSession.selectOne(namespace + "getAdminID", adminDto);
	}

	/*------------------------------------------------------------------------------
	* 사원 삭제
	* -----------------------------------------------------------------------------*/
	@Override
	public void delAdmin(int seq) {
		sqlSession.selectOne(namespace + "delAdmin", seq);
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 사원 수정 상세 정보 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public Bb_AdminDto updateAdmin(int seq) {
		return sqlSession.selectOne(namespace+"updateAdmin", seq);
	}
	
	
	/*--------------------------------------------------------------------------------------------
	 * 사원 수정 하기 버튼 클릭 후
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public void updateAdminAf(Bb_AdminDto adminDto) {
		System.out.println("updateAdminAf:"+adminDto.toString());
		sqlSession.update(namespace+"updateAdminAf", adminDto);
		
	}


	
	/*--------------------------------------------------------------------------------------------
	 * 해당 시퀀스의 점포 DTO 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public Bb_StoreDto getStoreName(int seq) {
		return sqlSession.selectOne(namespace+"getStoreName",seq);
	}

	
	
	
	/*--------------------------------------------------------------------------------------------
	 * 고객 리스트 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public List<Bb_MemberDto> getCustomerList() throws Exception {
		List<Bb_MemberDto> list = new ArrayList<Bb_MemberDto>();		
		list = sqlSession.selectList(namespace + "getCustomerList");
						
		return list;
	}

	/*--------------------------------------------------------------------------------------------
	 * 고객 정보 삭제
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public void delCustomer(int seq) {
		sqlSession.selectOne(namespace + "delCustomer", seq);
		
	}

	
	/*--------------------------------------------------------------------------------------------
	 * 고객 정보 수정 (디테일 뷰)
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public Bb_MemberDto updateCustomer(int seq) {
		return sqlSession.selectOne(namespace+"updateCustomer", seq);
	}

	/*--------------------------------------------------------------------------------------------
	 * 고객 정보 수정 후 
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public void updateCustomerAf(Bb_MemberDto customerDto) {
		System.out.println("updateCustomerAf:"+customerDto.toString());
		sqlSession.update(namespace+"updateCustomerAf", customerDto);
		
	}

	
	
	
	
	
	
}
