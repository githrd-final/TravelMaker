package com.project1.myTour;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.JsonObject;


@RestController
public class MyTourFileUploadController {
	static String uploadPath="C:\\Users\\junah\\git\\TravelMaker\\TravelMaker\\src\\main\\resources\\static\\upload\\";
	UUID uuid = null;
	String tempDir = "C:/Temp/";
	HttpServletRequest req;
	
	@RequestMapping(value="/MyTour/MyTourReviewInsert")
	@ResponseBody
	public void uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest req, HttpServletResponse resp ) throws IOException, ServletException  {
		JsonObject jsonObject = new JsonObject();
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
        
		PrintWriter out = resp.getWriter();
		String flag = "";

		
		if(req.getParameter("flag") != null) {
			flag = req.getParameter("flag");
		};
		
		if(flag.equals("delete")) {
			String target = req.getParameter("target");
			String[] temp = target.split("/");
			File delFile = new File(uploadPath + temp[temp.length-1]);
			if(delFile.exists()) delFile.delete();
			return;
		}else {
			
			Collection<Part> parts = req.getParts();
			
			
			for(Part p : parts) {
				
				
				if(p.getHeader("Content-Disposition").contains("filename=")){
					
					if(p.getSize()>0) {
						uuid = UUID.randomUUID();
						String temp = String.format("%s-%s",
												uuid.getLeastSignificantBits(),
												p.getSubmittedFileName() );
						p.write(uploadPath + temp);
						p.delete();
						
						
						try {
							Thread.sleep(10);
							out.print("../upload/" + temp);
						}catch(Exception ex) {
							ex.printStackTrace();
						}
						
							
					}
					
				}
			}// end of for
		
		}		
		
	}
	
}
