package bba.com.a.arrow;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;


public class DownloadView extends AbstractView {
	
/*	@Autowired
	KhPdsService khPdsService; 
	*/
	public DownloadView() {
		System.out.println("DownloadView DownloadView()");
		setContentType("application/download; charset=utf-8 "); 
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> arg0, HttpServletRequest arg1, HttpServletResponse arg2)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		
		File file = (File)model.get("downloadFile");
		resp.setContentType(getContentType());
		resp.setContentLength((int)file.length());

		String userAgent = req.getHeader("User-Agent");
		boolean ie = userAgent.indexOf("MSIE") > -1; // 인터넷익스플로어
									// chrome
		String filename = null;
		if(ie) {
			filename = URLEncoder.encode(file.getName(), "utf-8");
		}else {
			filename = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
		}
		
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
		resp.setHeader("Content-Transfer-Encoding", "binary");
        resp.setHeader("Content-Length", "" + file.length());
        resp.setHeader("Pragma", "no-cache;");
        resp.setHeader("Expires", "-1;");
		
        OutputStream out = resp.getOutputStream();
        FileInputStream fi = null;
        
        try {
        	fi = new FileInputStream(file);
        	FileCopyUtils.copy(fi, out);
        	
        	int seq = (Integer)model.get("seq");
        	
        	// downloadcount 증가
        	khPdsService.downloadCount(seq);
        	        	
        }catch (Exception e) {
		}finally {
			if(fi != null) {
				fi.close();
			}
		}
		out.flush();
	}*/

}







