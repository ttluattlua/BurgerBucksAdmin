package bba.com.a.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bba.com.a.model.Bb_FaqDto;
import bba.com.a.model.Bb_InquiryDto;
import bba.com.a.service.BbaInquiryService;

@Controller
public class BbaInquiryController {

	@Autowired
	BbaInquiryService bbaInquiryService;
	
	private static final Logger logger = LoggerFactory.getLogger(BbaInquiryController.class);
	
	/*--------------------------------------------------------------------------------------------
	 * 고객문의 내역 
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="customer_inquiry.do", method=RequestMethod.GET)
	public String getInquiryList(Model model,  HttpServletRequest req) {
		logger.info("BbaInquiryController FAQ");


		List<Bb_InquiryDto> InquiryList = bbaInquiryService.getInquiryList();
		
		model.addAttribute("InquiryList", InquiryList);
		model.addAttribute("doc_title", "고객문의내역 관리");
		model.addAttribute("doc_menu", "고객서비스 관리");
		return "inquiry.tiles";
	}
}
