package com.example.pet.controller.photo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class PhotoController {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value = "/photo/addFile", produces = "application/json; charset=utf8") 
	public Object fileSave(MultipartHttpServletRequest multipartRequest) {
		System.out.println("################ fileSave #################");
	    List<HashMap> fileArrayList = new ArrayList<HashMap>();
	    HashMap fileHashMap;
	 
	    String filePath = "C:/Pet/used_market/photo"; //파일 저장 경로, 설정파일로 따로 관리한다.
	 
	    File dir = new File(filePath); //파일 저장 경로 확인, 없으면 만든다.
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }
	  
	    Iterator<String> itr =  multipartRequest.getFileNames(); //파일들을 Iterator 에 넣는다.
	 
	    while (itr.hasNext()) { //파일을 하나씩 불러온다.
	        MultipartFile mpf = multipartRequest.getFile(itr.next());
	 
	        fileHashMap = new HashMap();
	 
	        String originalFilename = mpf.getOriginalFilename(); //파일명
	        String fileFullPath = filePath+"/"+originalFilename; //파일 전체 경로
	        
	        try { 
	            mpf.transferTo(new File(fileFullPath)); //파일저장
	           
	            fileHashMap.put("originalFilename", originalFilename);
	            fileHashMap.put("fileFullPath", fileFullPath);

	            fileArrayList.add(fileHashMap);
	        } catch (Exception e) {
	            System.out.println("postTempFile_ERROR======>"+fileFullPath);
	            e.printStackTrace();
	        }
	    }
	   
	    Map<String, Object> retVal = new HashMap<String, Object>(); //응답값 셋팅
	 
	    try{
	        retVal.put("fileInfoList", fileArrayList);  
	        retVal.put("code", "OK");
	    }catch(Exception e){
	        retVal.put("code", "FAIL");
	    }
	 
	    return retVal;
	}
}
