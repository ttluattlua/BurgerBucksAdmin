package bba.com.a.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaInquiryDao;
import bba.com.a.model.Bb_InquiryDto;
import bba.com.a.service.BbaInquiryService;

@Service
public class BbaInquiryServiceImpl implements BbaInquiryService {

	@Autowired
	BbaInquiryDao bbaInquiryDao;

	
	/*--------------------------------------------------------------------------------------------
	 * 문의내역리스트 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public List<Bb_InquiryDto> getInquiryList() {
		return bbaInquiryDao.getInquiryList();
	}

	/*--------------------------------------------------------------------------------------------
	 * 메세지 보내고 status 1로 바꾸기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public void sendMail(Bb_InquiryDto bidto) {
		bbaInquiryDao.sendMail(bidto);	
	}
	

}
