package bba.com.a.arrow;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadMethod {
	
	public FileUploadMethod() {}
	
	public static String FileUpload(MultipartFile multi, String uploadPath) {
		
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

			System.out.println("업로드성공");
		}catch (IOException e) {

			System.out.println("업로드실패");
		}
            
        return newFileName;
	}
	
	public static void deleteFile(String path) {
        File file = new File(path);
        
        if( file.exists() ){
            if(file.delete()){
                System.out.println("파일삭제 성공");
            }else{
                System.out.println("파일삭제 실패");
            }
        }else{
            System.out.println("파일이 존재하지 않습니다.");
        }

	}

}
