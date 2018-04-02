package bba.com.a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BbaStoreController {
	private static final Logger logger = LoggerFactory.getLogger(BbaMemberController.class);
	
	/*--------------------------------------------------------------------------------------------
	 * store 관리 페이지로 이동
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="storelist.do", method=RequestMethod.GET)
	public String storelist(Model model) {
		logger.info("BbaStoreController storelist.do");
		
		
		
		
		//위에 현재 위치 나타내줌 
		model.addAttribute("doc_title", "스토어관리");
		model.addAttribute("doc_menu", "스토어관리");
		return "storelist.tiles";
	}

	
	/*--------------------------------------------------------------------------------------------
	 * store 새로 등록 
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value="registerStore.do", method=RequestMethod.POST)
	public String registerStore(Model model) {
		logger.info("BbaStoreController registerStore");
		
		
		
		
		//위에 현재 위치 나타내줌 
		model.addAttribute("doc_title", "스토어관리");
		model.addAttribute("doc_menu", "스토어관리");
		return "storelist.tiles";
	}
	
	/*--------------------------------------------------------------------------------------------
	 * store 수정
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value="updateStore.do", method=RequestMethod.POST)
	public String updateStore(Model model) {
		logger.info("BbaStoreController registerStore");
		
		
		
		
		//위에 현재 위치 나타내줌 
		model.addAttribute("doc_title", "스토어관리");
		model.addAttribute("doc_menu", "스토어관리");
		return "storelist.tiles";
	}
}
