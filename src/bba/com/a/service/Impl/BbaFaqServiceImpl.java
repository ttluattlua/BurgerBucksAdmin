package bba.com.a.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaFaqDao;
import bba.com.a.model.Bb_FaqDto;
import bba.com.a.service.BbaFaqService;

@Service
public class BbaFaqServiceImpl implements BbaFaqService {
	@Autowired
	BbaFaqDao bbaFaqDao;

	/*--------------------------------------------------------------------------------------------
	 * FAQ 새로 등록 
	 *-------------------------------------------------------------------------------------------*/	
	@Override
	public Bb_FaqDto registerFaq(Bb_FaqDto bfdto) {
		// TODO Auto-generated method stub
		int seq = bbaFaqDao.registerFaq(bfdto);
		return bbaFaqDao.getFaqDetail(seq);
	}
	/*--------------------------------------------------------------------------------------------
	 * faq리스트 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public List<Bb_FaqDto> getFaqList() {
		// TODO Auto-generated method stub
		return bbaFaqDao.getFaqList();
	}
	
	/*--------------------------------------------------------------------------------------------
	 * faq답글달기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public Bb_FaqDto registerAnswerFaq(Bb_FaqDto bfdto, int seq) {
		int newSeq = bbaFaqDao.registerAnswerFaq(bfdto);
		System.out.println("등록후 seq:"+newSeq);
		System.out.println("bfdto_Seq:"+seq);
		bbaFaqDao.updateFaqForAnswer(seq);
		
		return bbaFaqDao.getFaqDetail(newSeq);
	}
	/*--------------------------------------------------------------------------------------------
	 * faq수정하기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public Bb_FaqDto faqUpdateAf(Bb_FaqDto bfdto) {
		
		//해당 글 수정
		bbaFaqDao.faqUpdateAf(bfdto);
		//답글이 있는경우 해당 글의 답글으 ㅣ카테고리와 제목도 변경해줘야함
		if(bfdto.getStatus() == 1) {
			bfdto.setTitle(bfdto.getTitle()+"에 대한 답글입니다.");
			bbaFaqDao.faqAnswerUpdateAf(bfdto);
		}
		
		return bbaFaqDao.getFaqDetail(bfdto.getSeq());
	}
	
	/*--------------------------------------------------------------------------------------------
	 * faq삭제하기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public void deleteFaq(Bb_FaqDto bfdto) {
		bbaFaqDao.deleteFaq(bfdto);
		
	}
	



}
