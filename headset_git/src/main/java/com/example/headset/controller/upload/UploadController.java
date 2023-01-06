package com.example.headset.controller.upload;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	String upload_path="c:/upload";
	// 첨부파일을 저장할 디렉토리

	@RequestMapping("/upload/input.do")
	public String input() {
		return "upload/input";
	}

	@RequestMapping("/upload/upload.do")
	public ModelAndView upload(MultipartFile file, ModelAndView mav) throws Exception {
	// 첨부파일의 이름
	String savedName = file.getOriginalFilename();
	// uuid를 추가한 파일이름
	savedName = uploadFile(savedName, file.getBytes());
	// jsp page의 이름
	mav.setViewName("upload/upload_result");
	// jsp page에 전달할 변수 저장
	mav.addObject("saved_name", savedName);
	// page로 포워드
	return mav;
	}

	public String uploadFile(String originalName, byte[] fileData) throws Exception {
	// uuid 생성 - Universal Unique IDentifier, 범용 고유 식별자	
	UUID uid = UUID.randomUUID();
	String savedName = uid.toString() + "_" + originalName;
	File target = new File(upload_path, savedName);
	// 파일 복사
	FileCopyUtils.copy(fileData, target);
	return savedName;
	}

}
