package bba.com.a.service;

import java.util.List;

import bba.com.a.model.Bb_InquiryDto;

public interface BbaInquiryService {
	
	/*--------------------------------------------------------------------------------------------
	 * 문의내역리스트 가져오기
	 *-------------------------------------------------------------------------------------------*/
	public List<Bb_InquiryDto> getInquiryList();

}
