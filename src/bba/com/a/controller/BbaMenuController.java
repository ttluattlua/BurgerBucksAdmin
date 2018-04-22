package bba.com.a.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import bba.com.a.model.Bb_BeverageDto;
import bba.com.a.model.Bb_BurgerDto;
import bba.com.a.model.Bb_MenuDto;
import bba.com.a.model.Bb_SideDto;
import bba.com.a.service.BbaMenuService;

@Controller
public class BbaMenuController {
	private static final Logger logger = LoggerFactory.getLogger(BbaMenuController.class);

	@Autowired
	BbaMenuService bbaMenuService;
	

	
	/*--------------------------------------------------------------------------------------------
	 * 메뉴 관리 클릭했을때 menulist.jsp로 이동
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="menulist.do", method=RequestMethod.GET)
	public String menulist(Model model) {
		logger.info("BbaMenuController menuDetail.do");
		
		List<Bb_MenuDto> mList = bbaMenuService.getMenuList();
		
		model.addAttribute("mList", mList);
		model.addAttribute("doc_title", "메뉴 관리");
		model.addAttribute("doc_menu", "테이블 관리");
		return "menulist.tiles";
	}
	
	
	/*--------------------------------------------------------------------------------------------
	 * 메뉴 디테일
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value="menuDetail.do", method=RequestMethod.POST)
	public Map<String, Object> menuDetail(@RequestBody Map<String, Object> map, HttpServletRequest req) {
		logger.info("BbaMenuController menulist.do");
		
		List<Bb_MenuDto> mList = bbaMenuService.getMenuList();
		int seq = (int)map.get("seq");
		int burger_seq = (int)map.get("burger_seq");
		int side_seq = (int)map.get("side_seq");
		int beverage_seq = (int)map.get("beverage_seq");
		System.out.println("seq: "+seq+" /burger_seq: "+burger_seq+"/side_seq: "+side_seq+"/beverage_seq: "+beverage_seq);
		Bb_SideDto sideDto = null;
		Bb_BeverageDto bevDto= null;
		Bb_BurgerDto burgerDto = null;
		Gson gson = new Gson();
		
		HttpSession session = req.getSession(true);
		String imagePath = (String)session.getAttribute("imagePath");
		
		if(side_seq != 0) {
			sideDto = bbaMenuService.getDetailSide(side_seq);
			sideDto.setImage_Src(imagePath+sideDto.getImage_Src());
		}
		
		if(beverage_seq != 0) {
			bevDto = bbaMenuService.getDetailBeverage(beverage_seq);
			bevDto.setImage_Src(imagePath+bevDto.getImage_Src());
		}
		
		String burger_ingredient_name="";
		if(burger_seq != 0) {
			burgerDto = bbaMenuService.getDetailBurger(burger_seq);
			//이미지가 있을때만 경로로 세팅해줌 (이미지 없으면 기본버거 이미지불러줄거임)
			if(!burgerDto.getImage_Src().equals("없음")) {
				burgerDto.setImage_Src(imagePath+burgerDto.getImage_Src());
			}
			burger_ingredient_name += burgerDto.getBread_name() + " ";
			burger_ingredient_name += burgerDto.getIngredient01_name() + " ";
			burger_ingredient_name += burgerDto.getIngredient02_name() + " ";
			burger_ingredient_name += burgerDto.getIngredient03_name() + " ";
			burger_ingredient_name += burgerDto.getIngredient04_name() + " ";
			burger_ingredient_name += burgerDto.getIngredient05_name() + " ";
			burger_ingredient_name += burgerDto.getIngredient06_name() + " ";
			burger_ingredient_name += burgerDto.getIngredient07_name() + " ";
			burger_ingredient_name += burgerDto.getIngredient08_name() + " ";
			burger_ingredient_name += burgerDto.getIngredient09_name() + " ";
		}
		System.out.println("메뉴버거재료이름:"+burger_ingredient_name);
		
		String sideJson = gson.toJson(sideDto);
		System.out.println(sideDto);
		String bevJson = gson.toJson(bevDto);
		System.out.println(bevJson);
		String burgerJson = gson.toJson(burgerDto);
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("sideJson",sideJson);
		rmap.put("bevJson",bevJson);
		rmap.put("burgerJson",burgerJson);
		rmap.put("burger_ingredient_name",burger_ingredient_name);
		return rmap;
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 메뉴 삭제 완료
	 *-------------------------------------------------------------------------------------------*/
	
	@ResponseBody
	@RequestMapping(value="deleteMenu.do", method=RequestMethod.POST)
	public Map<String, Object> deleteMenu(@RequestBody Map<String, Object> map) {
		logger.info("deleteMenu");
		System.out.println("deleteMenu");

		String sseq = (String)map.get("seq");
		/*String simage_Seq = (String)map.get("image_Seq");*/
		int seq = Integer.parseInt(sseq);
		/*int image_Seq = Integer.parseInt(simage_Seq);*/
		
		bbaMenuService.deleteMenu(seq);
	
		
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("msg","삭제완료");
		
		
		
		return rmap;
	}

}
