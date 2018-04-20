package bba.com.a.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bba.com.a.model.Bb_FaqDto;
import bba.com.a.model.Bb_InquiryDto;
import bba.com.a.service.BbaInquiryService;
import bba.com.a.service.MailService;

@Controller
public class BbaInquiryController {

	@Autowired
	BbaInquiryService bbaInquiryService;
	
	@Autowired
    MailService mailService;
 
    public void setMailService(MailService mailService) {

        this.mailService = mailService;

    }

	
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
	
    //문의내역 보내기

    @ResponseBody
    @RequestMapping(value = "sendMail.do", method = RequestMethod.POST, produces = "application/json")
    public boolean sendMailAuth(HttpSession session, @RequestBody Map<String, Object> map) {
    	System.out.println("문의메일보내기");
    	
    	String email = (String)map.get("email");
    	System.out.println("email : "+email);
    	String title = (String)map.get("title");
    	System.out.println("title : "+title);
    	String content = (String)map.get("contents");
    	System.out.println("content : "+content);
    	String sseq = (String)map.get("seq");
    	System.out.println("sseq : "+sseq);
    	int seq = Integer.parseInt(sseq);
    	
    	Bb_InquiryDto bidto = new Bb_InquiryDto(seq, title, email, null, content, 0);
    	System.out.println(bidto.toString());
    	bbaInquiryService.sendMail(bidto);

        return mailService.send(title, content, "buger0bucks@gmail.com", email, null);

    }
}
