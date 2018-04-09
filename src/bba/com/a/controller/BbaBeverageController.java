package bba.com.a.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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

import bba.com.a.arrow.FileUploadMethod;
import bba.com.a.model.Bb_BeverageDto;
import bba.com.a.model.Bb_ImageDto;
import bba.com.a.service.BbaBeverageService;

@Controller
public class BbaBeverageController {
	private static final Logger logger = LoggerFactory.getLogger(BbaBeverageController.class);

	@Autowired
	BbaBeverageService bbaBeverageService;
	
	
	// xml에 설정된 리소스 참조
    // bean의 id가 uploadPath인 태그를 참조
    @Resource(name="uploadPath")
    String uploadPath;
	
	
	/*--------------------------------------------------------------------------------------------
	 * 음료 관리 클릭했을때 beveragelist.jsp로 이동
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="beveragelist.do", method=RequestMethod.GET)
	public String beveragelist(Model model,  HttpServletRequest req) {
		logger.info("BbaBeverageController beveragelist.do");

		
		HttpSession session = req.getSession(true);
		String imagePath = (String)session.getAttribute("imagePath");
		
		
		List<Bb_BeverageDto> BevList = bbaBeverageService.getBevList();
		
		for (Bb_BeverageDto bb_BevDto : BevList) {
			String filename = bb_BevDto.getImage_Src();
			bb_BevDto.setImage_Src(imagePath+filename);
			System.out.println("이미지경로"+ bb_BevDto.toString());
			System.out.println("이미지경로"+ bb_BevDto.getImage_Src());
		}
		
		model.addAttribute("BevList", BevList);
		
		
		model.addAttribute("doc_title", "음료 관리");
		model.addAttribute("doc_menu", "테이블 관리");
		return "beveragelist.tiles";
	}
	



	/*--------------------------------------------------------------------------------------------
	 * 음료 등록 클릭했을때 음료등록 (prodeces넣는 이유-한글깨짐 방지)
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody 
	@RequestMapping(value = "registerBev.do", method= {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf8")
	    public String registerBev(@RequestParam("image_src")MultipartFile multi, Bb_BeverageDto bbdto, HttpServletRequest req) {
	         
	        // 저장 경로 설정
		 	logger.info("BbaSideController registerBev.do");
		 	logger.info(bbdto.toString());
		 	System.out.println(bbdto.toString());
		 	//톰캣 서버 경로주소 (상대경로)
			String root = System.getProperty("catalina.home");
			System.out.println("root: " + root);
			//xml파일에서 정해준 'upload'폴더로 디렉터리 정해줌
	      
	         
	        String newFileName = ""; // 업로드 되는 파일명
	        //파일업로드 함수
	        newFileName = FileUploadMethod.FileUpload(multi, uploadPath);
	         
	        Bb_ImageDto bidto = new Bb_ImageDto(0, "BB_BEVERAGE", bbdto.getWhat_Image(), newFileName, 0, 0);
	        System.out.println(bidto.toString());
	        
	        bbdto = bbaBeverageService.registerBev(bbdto, bidto);
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
	 * 음료 수정 클릭했을때 데이터가져오기 (prodeces넣는 이유-한글깨짐 방지)
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody 
	@RequestMapping(value = "updateBev.do", method= {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf8")
	    public String updateBev(@RequestBody Map<String, Object> map) {
	         

			System.out.println("BbaBevController updateBev");
	
			System.out.println((int)map.get("seq"));
			
	
			int seq = (int)map.get("seq");
			//수정할 bbs_store_Dto DB에서 가져오기 
			
			Bb_BeverageDto bbdto = bbaBeverageService.getBevDetail(seq);
			
		
	        
	        Gson gson = new Gson();
	        String bbdtoJson = gson.toJson(bbdto);
	        System.out.println(bbdtoJson);
	        System.out.println("gson변환");

	        return bbdtoJson;
	    }
	
	/*--------------------------------------------------------------------------------------------
	 * 음료 등록 클릭했을때 음료등록 (prodeces넣는 이유-한글깨짐 방지)
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody 
	@RequestMapping(value = "updateBevAf.do", method= {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf8")
	    public String updateBevAf(@RequestParam("image_src")MultipartFile multi, Bb_BeverageDto bbdto, HttpServletRequest req) {
	         
	        // 저장 경로 설정
		 	logger.info("BbaSideController updateBevAf.do");
		 	logger.info(bbdto.toString());
		 	System.out.println(bbdto.toString());
		 	//톰캣 서버 경로주소 (상대경로)
		 	String newFileName = "";
		 	
		 	//파일도 수정하면
		 	String originalFile = multi.getOriginalFilename();
		 	System.out.println("originalFile:"+originalFile);
		 	if(originalFile.equals("") || originalFile == null) {
		 		System.out.println("파일수정안함");
		 		bbaBeverageService.updateBevAf(bbdto);
		 	}else{
		 		System.out.println("파일수정");
		 		newFileName = FileUploadMethod.FileUpload(multi, uploadPath);
		 		Bb_ImageDto bidto = new Bb_ImageDto(bbdto.getImage_Seq(), "BB_BEVERAGE", bbdto.getWhat_Image(), newFileName, 0, 0);
		        System.out.println(bidto.toString());
		        
				HttpSession session = req.getSession(true);
				String imagePath = (String)session.getAttribute("imagePath");
				
				//여기서 해당파일 찾아서 폴더에서 지워줘야함 (시간나면 할거임)
		        bbaBeverageService.updateBevAf(bbdto);
		        bbaBeverageService.updateBevImageAf(bidto);
		        
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
	 * side 삭제 완료
	 *-------------------------------------------------------------------------------------------*/
	
	@ResponseBody
	@RequestMapping(value="deleteBev.do", method=RequestMethod.POST)
	public Map<String, Object> deleteBev(@RequestBody Map<String, Object> map) {
		logger.info("deleteBev");
		System.out.println("deleteBev");

		String sseq = (String)map.get("seq");
		String simage_Seq = (String)map.get("image_Seq");
		int seq = Integer.parseInt(sseq);
		int image_Seq = Integer.parseInt(simage_Seq);
		
		bbaBeverageService.deleteBev(seq, image_Seq);
	
		
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("msg","삭제완료");
		
		
		
		return rmap;
	}

}
