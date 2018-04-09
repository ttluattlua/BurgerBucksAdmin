package bba.com.a.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
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
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;

import bba.com.a.arrow.FileUploadMethod;
import bba.com.a.model.Bb_ImageDto;
import bba.com.a.model.Bb_SideDto;
import bba.com.a.model.Bb_StoreDto;
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
	public String sidelist(Model model, HttpServletRequest req) {
		logger.info("BbaSideController sidelist.do");
		
		HttpSession session = req.getSession(true);
		String imagePath = (String)session.getAttribute("imagePath");
		
		
		List<Bb_SideDto> sideList = bbaSideService.getSideList();
		
		for (Bb_SideDto bb_SideDto : sideList) {
			String filename = bb_SideDto.getImage_Src();
			bb_SideDto.setImage_Src(imagePath+filename);
			System.out.println("이미지경로"+ bb_SideDto.toString());
			System.out.println("이미지경로"+ bb_SideDto.getImage_Src());
		}
		
		model.addAttribute("sideList", sideList);
		model.addAttribute("doc_title", "사이드 관리");
		model.addAttribute("doc_menu", "테이블 관리");
		return "sidelist.tiles";
	}

	/*--------------------------------------------------------------------------------------------
	 * 사이드 등록 클릭했을때 사이드등록 (prodeces넣는 이유-한글깨짐 방지)
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody 
	@RequestMapping(value = "registerSide.do", method= {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf8")
	    public String registerSide(@RequestParam("image_src")MultipartFile multi, Bb_SideDto bsdto, HttpServletRequest req) {
	         
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
	         
	        Bb_ImageDto bidto = new Bb_ImageDto(0, "BB_SIDE", bsdto.getWhat_Image(), newFileName, 0, 0);
	        System.out.println(bidto.toString());
	        
	        bsdto = bbaSideService.registerSide(bsdto, bidto);
			HttpSession session = req.getSession(true);
			String imagePath = (String)session.getAttribute("imagePath");
			
	        bsdto.setImage_Src(imagePath+newFileName);
	        
	        Gson gson = new Gson();
	        String bsdtoJson = gson.toJson(bsdto);
	        System.out.println(bsdtoJson);
	        System.out.println("gson변환");

	        return bsdtoJson;
	    }

	/*--------------------------------------------------------------------------------------------
	 * 사이드 수정 클릭했을때 데이터가져오기 (prodeces넣는 이유-한글깨짐 방지)
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody 
	@RequestMapping(value = "updateSide.do", method= {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf8")
	    public String updateSide(@RequestBody Map<String, Object> map) {
	         
			logger.info("BbaStoreController updateStore");
			System.out.println("BbaStoreController updateStore");
	
			System.out.println((int)map.get("seq"));
			
	
			int seq = (int)map.get("seq");
			//수정할 bbs_store_Dto DB에서 가져오기 
			
			Bb_SideDto bsdto = bbaSideService.getSideDetail(seq);
			
		
	        
	        Gson gson = new Gson();
	        String bsdtoJson = gson.toJson(bsdto);
	        System.out.println(bsdtoJson);
	        System.out.println("gson변환");

	        return bsdtoJson;
	    }
	
	/*--------------------------------------------------------------------------------------------
	 * 사이드 등록 클릭했을때 사이드등록 (prodeces넣는 이유-한글깨짐 방지)
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody 
	@RequestMapping(value = "updateSideAf.do", method= {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf8")
	    public String updateSideAf(@RequestParam("image_src")MultipartFile multi, Bb_SideDto bsdto, HttpServletRequest req) {
	         
	        // 저장 경로 설정
		 	logger.info("BbaSideController registerSide.do");
		 	logger.info(bsdto.toString());
		 	System.out.println(bsdto.toString());
		 	//톰캣 서버 경로주소 (상대경로)
		 	String newFileName = "";
		 	String fileName = bsdto.getImage_Src(); //기존이미지 받아줌(삭제위해)
		 	//파일도 수정하면
		 	String originalFile = multi.getOriginalFilename();
		 	System.out.println("originalFile:"+originalFile);
		 	if(originalFile.equals("") || originalFile == null) {
		 		System.out.println("파일수정안함");
		 		bbaSideService.updateSideAf(bsdto);
		 	}else{
		 		System.out.println("파일수정");
		 		newFileName = FileUploadMethod.FileUpload(multi, uploadPath);
		 		Bb_ImageDto bidto = new Bb_ImageDto(bsdto.getImage_Seq(), "BB_SIDE", bsdto.getWhat_Image(), newFileName, 0, 0);
		        System.out.println(bidto.toString());
		        
				HttpSession session = req.getSession(true);
				String imagePath = (String)session.getAttribute("imagePath");
				
				String root = System.getProperty("catalina.home");
				String path = root+"/"+uploadPath+"/"+fileName;
				FileUploadMethod.deleteFile(path);
				//여기서 해당파일 찾아서 폴더에서 지워줘야함 (시간나면 할거임)
		        bbaSideService.updateSideAf(bsdto);
		        bbaSideService.updateSideImageAf(bidto);
		        
		        bsdto.setImage_Src(imagePath+newFileName);
		        
		 		
		 	//파일은 수정 안하면 
		 	}
			
	        
	        Gson gson = new Gson();
	        String bsdtoJson = gson.toJson(bsdto);
	        System.out.println(bsdtoJson);
	        System.out.println("gson변환");

	        return bsdtoJson;
	    }
	
	
	/*--------------------------------------------------------------------------------------------
	 * side 삭제 완료
	 *-------------------------------------------------------------------------------------------*/
	
	@ResponseBody
	@RequestMapping(value="deleteSide.do", method=RequestMethod.POST)
	public Map<String, Object> deleteStore(@RequestBody Map<String, Object> map) {
		logger.info("BbaStoreController deleteSide");
		System.out.println("BbaStoreController deleteSide");

		String sseq = (String)map.get("seq");
		String simage_Seq = (String)map.get("image_Seq");
		int seq = Integer.parseInt(sseq);
		int image_Seq = Integer.parseInt(simage_Seq);
		
		bbaSideService.deleteSide(seq, image_Seq);
	
		
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("msg","삭제완료");
		
		
		
		return rmap;
	}


}
