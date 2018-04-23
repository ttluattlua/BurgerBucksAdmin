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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import bba.com.a.arrow.FileUploadMethod;
import bba.com.a.arrow.directoryFinder;
import bba.com.a.arrow.xmlParser;
import bba.com.a.model.Bb_BbsDto;
import bba.com.a.model.Bb_BurgerDto;
import bba.com.a.model.Bb_ImageDto;
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
		List<Bb_IngredientDto> IngList = (List<Bb_IngredientDto>)bbaBurgerService.getIngredientList();
		
		for (Bb_IngredientDto bb_IngredientDto : IngList) {
			bb_IngredientDto.setImage_Src(imagePath+bb_IngredientDto.getImage_Src());
		}
		
		List<Bb_BurgerDto> burgerList = bbaBurgerService.getBurgerListForBurgerTB();
		for (Bb_BurgerDto bb_BurgerDto : burgerList) {
			if(bb_BurgerDto.getCreator() == 0) {
				bb_BurgerDto.setImage_Src(imagePath+bb_BurgerDto.getImage_Src());
			}
			System.out.println(bb_BurgerDto.toString());
		}
		
		model.addAttribute("IngList", IngList);
		model.addAttribute("burgerList", burgerList);
		model.addAttribute("doc_title", "버거 관리");
		model.addAttribute("doc_menu", "테이블 관리");
		return "burgerlist.tiles";
	}
	
	
	/*--------------------------------------------------------------------------------------------
	 * 버거 등록 클릭했을때 재료등록 (prodeces넣는 이유-한글깨짐 방지)
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody 
	@RequestMapping(value = "registerBurger.do", method= {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf8")
	    public String registerBurger(@RequestParam("image_src")MultipartFile multi, Bb_BurgerDto bgdto, HttpServletRequest req) {
	         
	        // 저장 경로 설정
		 	logger.info("BbaSideController registerIng.do");
		 	logger.info(bgdto.toString());
		 	System.out.println(bgdto.toString());
		 	//톰캣 서버 경로주소 (상대경로)
			String root = System.getProperty("catalina.home");
			System.out.println("root: " + root);
			//xml파일에서 정해준 'upload'폴더로 디렉터리 정해줌
			
	         
	        String newFileName = ""; // 업로드 되는 파일명
	        //파일업로드 함수
	        newFileName = FileUploadMethod.FileUpload(multi, uploadPath);
	         
	        Bb_ImageDto bidto = new Bb_ImageDto(0, "BB_BURGER", "실물사진", newFileName, 0, 0);
	        System.out.println(bidto.toString());
	        
	        bgdto = bbaBurgerService.registerBurger(bgdto, bidto);
			HttpSession session = req.getSession(true);
			String imagePath = (String)session.getAttribute("imagePath");
			
			bgdto.setImage_Src(imagePath+newFileName);
	        Bb_BurgerDto bgIng = bbaBurgerService.getBurgerIngredientForBurgerTB(bgdto.getSeq());
	        
	        //bgdto에 재료이름 뽑아온거 넣어주기 
	        bgdto.setBread_name(bgIng.getBread_name());
	        bgdto.setIngredient01_name(bgIng.getIngredient01_name());
	        bgdto.setIngredient02_name(bgIng.getIngredient02_name());
	        bgdto.setIngredient03_name(bgIng.getIngredient03_name());
	        bgdto.setIngredient04_name(bgIng.getIngredient04_name());
	        bgdto.setIngredient05_name(bgIng.getIngredient05_name());
	        bgdto.setIngredient06_name(bgIng.getIngredient06_name());
	        bgdto.setIngredient07_name(bgIng.getIngredient07_name());
	        bgdto.setIngredient08_name(bgIng.getIngredient08_name());
	        bgdto.setIngredient09_name(bgIng.getIngredient09_name());
	        
	        //gson으로 변환해서넘겨주기
	        Gson gson = new Gson();
	        String burgerJson = gson.toJson(bgdto);
	        System.out.println(burgerJson);
	        System.out.println("gson변환");

	        return burgerJson;
	    }

}
