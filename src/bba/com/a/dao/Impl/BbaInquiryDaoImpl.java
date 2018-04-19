package bba.com.a.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaInquiryDao;
import bba.com.a.model.Bb_InquiryDto;

@Repository
public class BbaInquiryDaoImpl implements BbaInquiryDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	String ns = "BBAInquiry.";
	/*--------------------------------------------------------------------------------------------
	 * 문의내역리스트 가져오기
	 *-------------------------------------------------------------------------------------------*/
	public List<Bb_InquiryDto> getInquiryList(){
		return sqlSession.selectList(ns+"getInquiryList");
	}	
}
