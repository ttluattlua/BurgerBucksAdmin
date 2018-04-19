package bba.com.a.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
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
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import bba.com.a.model.Bb_BeverageDto;
import bba.com.a.model.Bb_FaqDto;
import bba.com.a.model.Bb_ImageDto;
import bba.com.a.model.Bb_SideDto;
import bba.com.a.service.BbaFaqService;

@Controller
public class BbaFaqController {
	
	private static final Logger logger = LoggerFactory.getLogger(BbaFaqController.class);

	@Autowired
	BbaFaqService bbaFaqService;
	/*--------------------------------------------------------------------------------------------
	 * FAQ클릭했을때 FAQ페이지로 이동 
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="faq.do", method=RequestMethod.GET)
	public String FAQ(Model model,  HttpServletRequest req) {
		logger.info("BbaFaqController FAQ");


		List<Bb_FaqDto> faqList = bbaFaqService.getFaqList();
		
		model.addAttribute("faqList", faqList);
		model.addAttribute("doc_title", "FAQ 관리");
		model.addAttribute("doc_menu", "고객서비스 관리");
		return "faq.tiles";
	}
	
	/*--------------------------------------------------------------------------------------------
	 * FAQ등록클릭했을때 등록
	 *-------------------------------------------------------------------------------------------*/

	@ResponseBody 
	@RequestMapping(value = "registerFaq.do", method= {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf8")
	    public String registerFaq(@RequestBody Map<String, Object> map) {
	         
	        // 저장 경로 설정
		 	logger.info("BbaFaqController registerFaq.do");

		 	String title = (String)map.get("title");
		 	String contents = (String)map.get("contents");
		 	String categories = (String)map.get("categories");
		 	System.out.println(title);
		 	System.out.println(contents);
		 	System.out.println(categories);
		 	
		 	Bb_FaqDto bfdto = new Bb_FaqDto(title, contents, Integer.parseInt(categories));
		 	System.out.println(bfdto.toString());
		 	
		 	bfdto = bbaFaqService.registerFaq(bfdto);
		 	System.out.println("등록한이후bfdto: " + bfdto.toString());
		 	
	        Gson gson = new Gson();
	        String bsdtoJson = gson.toJson(bfdto);
	        System.out.println(bsdtoJson);
	        System.out.println("gson변환");

	        return bsdtoJson;
	    }
	
	/*--------------------------------------------------------------------------------------------
	 * FAQ답글 등록클릭했을때 등록
	 *-------------------------------------------------------------------------------------------*/
	
	@ResponseBody 
	@RequestMapping(value = "registerAnswerFaq.do", method= {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf8")
	    public String registerAnswerFaq(@RequestBody Map<String, Object> map) {
	         
	        // 저장 경로 설정
		 	logger.info("BbaFaqController registerAnswerFaq.do");

		 	String title = (String)map.get("title");
		 	String contents = (String)map.get("contents");
		 	String categories = (String)map.get("categories");
		 	String sseq = (String)map.get("seq");
		 	int seq = Integer.parseInt(sseq);
		 	String sgroups = (String)map.get("groups");
		 	int groups = Integer.parseInt(sgroups);
		 	
		 	Bb_FaqDto bfdto = new Bb_FaqDto(seq, title, contents, Integer.parseInt(categories), 1, groups);
		 	System.out.println(bfdto.toString());
		 	
		 	bfdto = bbaFaqService.registerAnswerFaq(bfdto, bfdto.getSeq());
		 	System.out.println("답글등록한이후bfdto: " + bfdto.toString());
		 	
	        Gson gson = new Gson();
	        String bsdtoJson = gson.toJson(bfdto);
	        System.out.println(bsdtoJson);
	        System.out.println("gson변환");

	        return bsdtoJson;
	    }
	
	/*--------------------------------------------------------------------------------------------
	 * FAQ수정 클릭했을때 수정 
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody 
	@RequestMapping(value = "faqUpdateAf.do", method= {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf8")
	    public String faqUpdateAf(@RequestBody Map<String, Object> map) {
	         
	        // 저장 경로 설정
		 	logger.info("BbaFaqController faqUpdateAf.do");

		 	String title = (String)map.get("title");
		 	String contents = (String)map.get("contents");
		 	String categories = (String)map.get("categories");
		 	String sseq = (String)map.get("seq");
		 	int seq = Integer.parseInt(sseq);
		 	String sstep = (String)map.get("step");
		 	int step = Integer.parseInt(sstep);
		 	String sgroups = (String)map.get("groups");
		 	int groups = Integer.parseInt(sgroups);
		 	String sstatus = (String)map.get("status");
		 	int status = Integer.parseInt(sstatus);

		 	Bb_FaqDto bfdto = new Bb_FaqDto(seq, title, contents, Integer.parseInt(categories), 0, step, groups, status, "", 0);
		 	System.out.println(bfdto.toString());
		 	
		 	bfdto = bbaFaqService.faqUpdateAf(bfdto);
		 	System.out.println("수정이후bfdto:"+ bfdto.toString());
		 	
	        Gson gson = new Gson();
	        String bsdtoJson = gson.toJson(bfdto);
	        System.out.println(bsdtoJson);
	        System.out.println("gson변환");

	        return bsdtoJson;
	    }
	
	
	
	/*--------------------------------------------------------------------------------------------
	 * FAQ 삭제 완료
	 *-------------------------------------------------------------------------------------------*/
	
	@ResponseBody
	@RequestMapping(value="deleteFaqMethod.do", method=RequestMethod.POST)
	public Map<String, Object> deleteFaqMethod(@RequestBody Map<String, Object> map) {
		logger.info("BbaFaqController deleteFaq");
		System.out.println("BbaFaqController deleteFaq");

		String sseq = (String)map.get("seq");
		int seq = Integer.parseInt(sseq);
		
		String sgroups = (String)map.get("groups");
		int groups = Integer.parseInt(sgroups);
		
		Bb_FaqDto bfdto = new Bb_FaqDto();
		bfdto.setSeq(seq);
		bfdto.setGroups(groups);
		
		
		bbaFaqService.deleteFaq(bfdto);
	
		
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("msg","삭제완료");
		
		
		
		return rmap;
	}
	

}
