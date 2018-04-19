package bba.com.a.dao.Impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaFaqDao;
import bba.com.a.model.Bb_FaqDto;

@Repository
public class BbaFaqDaoImpl implements BbaFaqDao {

	@Autowired
	private SqlSessionTemplate sqlsession;
	
	private String ns="BBAFaq.";

	/*--------------------------------------------------------------------------------------------
	 * FAQ 새로 등록 
	 *-------------------------------------------------------------------------------------------*/	
	@Override
	public int registerFaq(Bb_FaqDto bfdto) {
		// TODO Auto-generated method stub
		int count = sqlsession.insert(ns+"registerFaq", bfdto);
		int seq = bfdto.getSeq();
		return seq;
	}

	/*--------------------------------------------------------------------------------------------
	 * 해당 seq faq뽑아오기 
	 *-------------------------------------------------------------------------------------------*/	
	@Override
	public Bb_FaqDto getFaqDetail(int seq) {
		// Bb_FaqDto Auto-generated method stub
		return sqlsession.selectOne("getFaqDetail", seq);
	}

	/*--------------------------------------------------------------------------------------------
	 * faq리스트 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public List<Bb_FaqDto> getFaqList() {
		// TODO Auto-generated method stub
		return sqlsession.selectList(ns+"getFaqList");
	}
	/*--------------------------------------------------------------------------------------------
	 * faq답글달기
	 *-------------------------------------------------------------------------------------------*/

	@Override
	public int registerAnswerFaq(Bb_FaqDto bfdto) {
		int count = sqlsession.insert(ns+"registerAnswerFaq", bfdto);
		int seq = bfdto.getSeq();
		return seq;
	}
	/*--------------------------------------------------------------------------------------------
	 * faq답글을 위한 업데이트(status 상태 1로바꿔주기)
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public void updateFaqForAnswer(int seq) {
		int count = sqlsession.update(ns+"updateFaqForAnswer", seq);
		
	}
	/*--------------------------------------------------------------------------------------------
	 * faq수정하기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public void faqUpdateAf(Bb_FaqDto bfdto) {
		int count = sqlsession.update(ns+"faqUpdateAf", bfdto);
		
	}
	/*--------------------------------------------------------------------------------------------
	 * 수정된 글의 답글 카테고리 수정하기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public void faqAnswerUpdateAf(Bb_FaqDto bfdto) {
		int count = sqlsession.update(ns+"faqAnswerUpdateAf", bfdto);
		
	}

	/*--------------------------------------------------------------------------------------------
	 * 삭제하기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public void deleteFaq(Bb_FaqDto bfdto) {
		int count = sqlsession.update(ns+"deleteFaq", bfdto);	
	}

	
	
}
