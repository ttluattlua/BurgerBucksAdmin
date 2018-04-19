package bba.com.a.dao;

import java.util.List;

import bba.com.a.model.Bb_InquiryDto;

public interface BbaInquiryDao {
	/*--------------------------------------------------------------------------------------------
	 * 문의내역리스트 가져오기
	 *-------------------------------------------------------------------------------------------*/
	public List<Bb_InquiryDto> getInquiryList();
}
