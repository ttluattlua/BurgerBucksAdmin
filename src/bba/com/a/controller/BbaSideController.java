package bba.com.a.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

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
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;

import bba.com.a.model.Bb_ImageDto;
import bba.com.a.model.Bb_SideDto;
import bba.com.a.service.BbaSideService;

@Controller
public class BbaSideController {
	private static final Logger logger = LoggerFactory.getLogger(BbaSideController.class);

	@Autowired
	BbaSideService bbaSideService;
	
	
	
	// xml에 설정된 리소스 참조
    // bean의 id가 uploadPath인 태그를 참조
    @Resource(name="uploadPath")
    String uploadPath;
	/*--------------------------------------------------------------------------------------------
	 * 사이드 관리 클릭했을때 sidelist.jsp로 이동
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="sidelist.do", method=RequestMethod.GET)
	public String sidelist(Model model) {
		logger.info("BbaSideController sidelist.do");
		
		model.addAttribute("doc_title", "사이드 관리");
		model.addAttribute("doc_menu", "테이블 관리");
		return "sidelist.tiles";
	}

	/*--------------------------------------------------------------------------------------------
	 * 사이드 등록 클릭했을때 사이드등록
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody 
	@RequestMapping(value = "registerSide.do", method= {RequestMethod.GET, RequestMethod.POST})
	    public String registerSide(@RequestParam("image_src")MultipartFile multi, Bb_SideDto bsdto) {
	         
	        // 저장 경로 설정
		 	logger.info("BbaSideController registerSide.do");
		 	logger.info(bsdto.toString());
		 	System.out.println(bsdto.toString());
		 	//톰캣 서버 경로주소 (상대경로)
			String root = System.getProperty("catalina.home");
			System.out.println("root: " + root);
			//xml파일에서 정해준 'upload'폴더로 디렉터리 정해줌
	        String path = root+"/"+uploadPath;
	         
	        String newFileName = ""; // 업로드 되는 파일명
	         
	        //폴더가 없으면 생성
	        File dir = new File(path);
	        if(!dir.isDirectory()){
	            dir.mkdir();
	        }
	         

	            String fileName = multi.getOriginalFilename();
	            System.out.println("실제 파일 이름 : " +fileName);
	            newFileName = System.currentTimeMillis()+"."
	                    +fileName.substring(fileName.lastIndexOf(".")+1);
	            System.out.println("새로운 파일 이름 : " +newFileName);
	           
	            try {
	    			File file = new File(path + "/" + newFileName);
	    			FileUtils.writeByteArrayToFile(file, multi.getBytes());
	    			// db insert 부분
	    			/*khPdsService.uploadPds(pdsdto);			
	    			*/
	    			logger.info("BbaSideController pdsupload success!!");
	    			System.out.println("업로드성공");
	    		}catch (IOException e) {
	    			logger.info("BbaSideController pdsupload fail~");
	    			System.out.println("업로드실패");
	    		}
	         
	     /*   String name = multi.getParameter("name"); //사이드명
	        String price = multi.getParameter("price");//사이드가격
	        String cal = multi.getParameter("cal");//사이드칼로리
	        String what_image = multi.getParameter("what_image");//이미지타입
	        
	        Bb_SideDto bsdto = new Bb_SideDto(0, name, Integer.parseInt(price), Integer.parseInt(cal), 0);
	        System.out.println(bsdto.toString());*/
	        
	        //해당 dto를 gson 클래스를 통해 json형태로 바꿔줌 
	        Bb_ImageDto bidto = new Bb_ImageDto(0, "BB_SIDE", bsdto.getWhat_Image(), newFileName, 0, 0);
	        System.out.println(bidto.toString());
	        
	        bsdto = bbaSideService.registerSide(bsdto, bidto);
	        
	        
	        Gson gson = new Gson();
	        String bsdtoJson = gson.toJson(bsdto);
	        System.out.println(bsdtoJson);
	        System.out.println("gson변환");

	        return bsdtoJson;
	    }

}
