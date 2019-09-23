package com.metacube.mvc.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * class used to upload file/image
 * @author Rahul
 */
public class UploadImage {

	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}