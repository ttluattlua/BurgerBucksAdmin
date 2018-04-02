package bba.com.a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BbaStoreController {
	private static final Logger logger = LoggerFactory.getLogger(BbaMemberController.class);
	
	/*--------------------------------------------------------------------------------------------
	 * store 관리 페이지로 이동
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="storelist.do", method=RequestMethod.GET)
	public String storelist(Model model) {
		logger.info("BbaStoreController storelist.do");
		return "storelist.tiles";
	}
	
}
