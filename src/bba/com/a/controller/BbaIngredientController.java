package bba.com.a.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import bba.com.a.arrow.FileUploadMethod;
import bba.com.a.model.Bb_IngredientDto;
import bba.com.a.model.Bb_ImageDto;
import bba.com.a.service.BbaIngredientService;


@Controller
public class BbaIngredientController {
	private static final Logger logger = LoggerFactory.getLogger(BbaIngredientController.class);

	@Autowired
	BbaIngredientService bbaIngredientService;
	
	// xml에 설정된 리소스 참조
    // bean의 id가 uploadPath인 태그를 참조
    @Resource(name="uploadPath")
    String uploadPath;	
	
	/*--------------------------------------------------------------------------------------------
	 * 재료 관리 클릭했을때 ingredientlist.jsp로 이동
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="ingredientlist.do", method=RequestMethod.GET)
	public String ingredientlist(Model model, HttpServletRequest req) {
		logger.info("BbaIngredientController ingredientlist.do");

		HttpSession session = req.getSession(true);
		String imagePath = (String)session.getAttribute("imagePath");
		
		
		List<Bb_IngredientDto> IngList = bbaIngredientService.getIngList();
		
		for (Bb_IngredientDto bb_IngDto : IngList) {
			String filename = bb_IngDto.getImage_Src();
			bb_IngDto.setImage_Src(imagePath+filename);
			System.out.println("이미지경로"+ bb_IngDto.toString());
			System.out.println("이미지경로"+ bb_IngDto.getImage_Src());
		}
		
		model.addAttribute("IngList", IngList);
		
		
		
		model.addAttribute("doc_title", "재료 관리");
		model.addAttribute("doc_menu", "테이블 관리");
		return "ingredientlist.tiles";
	}
	
	



	/*--------------------------------------------------------------------------------------------
	 * 재료 등록 클릭했을때 재료등록 (prodeces넣는 이유-한글깨짐 방지)
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody 
	@RequestMapping(value = "registerIng.do", method= {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf8")
	    public String registerIng(@RequestParam("image_src")MultipartFile multi, Bb_IngredientDto bbdto, HttpServletRequest req) {
	         
	        // 저장 경로 설정
		 	logger.info("BbaSideController registerIng.do");
		 	logger.info(bbdto.toString());
		 	System.out.println(bbdto.toString());
		 	//톰캣 서버 경로주소 (상대경로)
			String root = System.getProperty("catalina.home");
			System.out.println("root: " + root);
			//xml파일에서 정해준 'upload'폴더로 디렉터리 정해줌
	      
	         
	        String newFileName = ""; // 업로드 되는 파일명
	        //파일업로드 함수
	        newFileName = FileUploadMethod.FileUpload(multi, uploadPath);
	         
	        Bb_ImageDto bidto = new Bb_ImageDto(0, "BB_INGREDIENT", bbdto.getWhat_Image(), newFileName, 0, 0);
	        System.out.println(bidto.toString());
	        
	        bbdto = bbaIngredientService.registerIng(bbdto, bidto);
			HttpSession session = req.getSession(true);
			String imagePath = (String)session.getAttribute("imagePath");
			
			bbdto.setImage_Src(imagePath+newFileName);
	        
	        Gson gson = new Gson();
	        String bbdtoJson = gson.toJson(bbdto);
	        System.out.println(bbdtoJson);
	        System.out.println("gson변환");

	        return bbdtoJson;
	    }

	/*--------------------------------------------------------------------------------------------
	 * 재료 수정 클릭했을때 데이터가져오기 (prodeces넣는 이유-한글깨짐 방지)
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody 
	@RequestMapping(value = "updateIng.do", method= {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf8")
	    public String updateIng(@RequestBody Map<String, Object> map) {
	         

			System.out.println("BbaIngController updateIng");
	
			System.out.println((int)map.get("seq"));
			
	
			int seq = (int)map.get("seq");
			//수정할 bbs_store_Dto DB에서 가져오기 
			
			Bb_IngredientDto bbdto = bbaIngredientService.getIngDetail(seq);
			
		
	        
	        Gson gson = new Gson();
	        String bbdtoJson = gson.toJson(bbdto);
	        System.out.println(bbdtoJson);
	        System.out.println("gson변환");

	        return bbdtoJson;
	    }
	
	/*--------------------------------------------------------------------------------------------
	 * 재료 수정 클릭했을때 재료등록 (prodeces넣는 이유-한글깨짐 방지)
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody 
	@RequestMapping(value = "updateIngAf.do", method= {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf8")
	    public String updateIngAf(@RequestParam("image_src")MultipartFile multi, Bb_IngredientDto bbdto, HttpServletRequest req) {
	         
	        // 저장 경로 설정
		 	logger.info("BbaSideController updateIngAf.do");
		 	logger.info(bbdto.toString());
		 	System.out.println(bbdto.toString());
		 	//톰캣 서버 경로주소 (상대경로)
		 	String newFileName = "";
		 	
		 	//파일도 수정하면
		 	String originalFile = multi.getOriginalFilename();
		 	System.out.println("originalFile:"+originalFile);
		 	if(originalFile.equals("") || originalFile == null) {
		 		System.out.println("파일수정안함");
		 		bbaIngredientService.updateIngAf(bbdto);
		 	}else{
		 		System.out.println("파일수정");
		 		newFileName = FileUploadMethod.FileUpload(multi, uploadPath);
		 		Bb_ImageDto bidto = new Bb_ImageDto(bbdto.getImage_Seq(), "BB_INGREDIENT", bbdto.getWhat_Image(), newFileName, 0, 0);
		        System.out.println(bidto.toString());
		        
				HttpSession session = req.getSession(true);
				String imagePath = (String)session.getAttribute("imagePath");
				
				//여기서 해당파일 찾아서 폴더에서 지워줘야함 (시간나면 할거임)
		        bbaIngredientService.updateIngAf(bbdto);
		        bbaIngredientService.updateIngImageAf(bidto);
		        
		        bbdto.setImage_Src(imagePath+newFileName);
		        
		 		
		 	//파일은 수정 안하면 
		 	}
			
	        
	        Gson gson = new Gson();
	        String bbdtoJson = gson.toJson(bbdto);
	        System.out.println(bbdtoJson);
	        System.out.println("gson변환");

	        return bbdtoJson;
	    }
	
	
	/*--------------------------------------------------------------------------------------------
	 * 재료 삭제 완료
	 *-------------------------------------------------------------------------------------------*/
	
	@ResponseBody
	@RequestMapping(value="deleteIng.do", method=RequestMethod.POST)
	public Map<String, Object> deleteIng(@RequestBody Map<String, Object> map) {
		logger.info("deleteIng");
		System.out.println("deleteIng");

		String sseq = (String)map.get("seq");
		String simage_Seq = (String)map.get("image_Seq");
		int seq = Integer.parseInt(sseq);
		int image_Seq = Integer.parseInt(simage_Seq);
		
		bbaIngredientService.deleteIng(seq, image_Seq);
	
		
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("msg","삭제완료");
		
		
		
		return rmap;
	}

}
