package com.example.demo.model;
import org.springframework.web.multipart.MultipartFile;

public class FileForm {
    private MultipartFile mFile;

	public MultipartFile getMultipartFile() {
		return mFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.mFile = multipartFile;
	}
}