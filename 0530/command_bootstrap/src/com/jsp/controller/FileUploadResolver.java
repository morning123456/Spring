package com.jsp.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

public class FileUploadResolver {
	
	public static List<File> fileUpload(FileItem[] items, String uploadPath) throws Exception{
		List<File> uploadFileList = new ArrayList<File>();
		File file = new File(uploadPath);
		file.mkdirs();
		
		if(items != null)
			for(FileItem item : items) {
				//사용자가 업로드한 파일명 추출 -> item.getName()하면 사용자의 파일경로가 같이 오기 때문에 new File로 경로 없애주는 처리
				String fileName = new File(item.getName()).getName(); 
				fileName = MakeFileName.toUUIDFileName(fileName, "$$"); //고유화
				
				String filePath = uploadPath + File.separator + fileName;
				File storeFile = new File(filePath); //실제 파일이 아닌 경로와 파일명
				
				//로컬 HDD에 저장
				try {
					item.write(storeFile); //지정해준 경로와 이름으로 실제 파일인 item을 저장
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				uploadFileList.add(storeFile);
			}
		return uploadFileList;
	}
}
