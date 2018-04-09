package bba.com.a.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bba.com.a.model.Bb_IngredientDto;
import bba.com.a.service.BbaBurgerService;

@Controller
public class BbaBurgerController {
	private static final Logger logger = LoggerFactory.getLogger(BbaBurgerController.class);

	@Autowired
	BbaBurgerService bbaBurgerService;
	
	// xml에 설정된 리소스 참조
    // bean의 id가 uploadPath인 태그를 참조
    @Resource(name="uploadPath")
    String uploadPath;	
	
	
	/*--------------------------------------------------------------------------------------------
	 * 버거 관리 클릭했을때 burgerlist.jsp로 이동
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="burgerlist.do", method=RequestMethod.GET)
	public String burgerlist(Model model,  HttpServletRequest req) {
		logger.info("BbaBurgerController burgerlist.do");
		

		HttpSession session = req.getSession(true);
		String imagePath = (String)session.getAttribute("imagePath");
		
		
		List<Bb_IngredientDto> IngList = bbaBurgerService.getIngredientList();
		
		for (Bb_IngredientDto bb_IngredientDto : IngList) {
			bb_IngredientDto.setImage_Src(imagePath+bb_IngredientDto.getImage_Src());
		}
		
		model.addAttribute("IngList", IngList);
		model.addAttribute("doc_title", "버거 관리");
		model.addAttribute("doc_menu", "테이블 관리");
		return "burgerlist.tiles";
	}

}
