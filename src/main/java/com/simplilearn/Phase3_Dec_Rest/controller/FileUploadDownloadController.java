package com.simplilearn.Phase3_Dec_Rest.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadDownloadController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileUpload(@RequestParam("file") MultipartFile file) {

		try {
			File storageFilePath = new File("/var/tmp/" + file.getOriginalFilename());
			storageFilePath.createNewFile();
			FileOutputStream fout = new FileOutputStream(storageFilePath);
			fout.write(file.getBytes());
			fout.close();
		} catch (Exception e) {
			return "Error occurred while uploading file." + e.getMessage();
		}
		return "File uploaded successfully";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<Object> downloadFile(@RequestParam("fileName") String fileName) {

		ResponseEntity<Object> responseEntity = null;

		try {
			File file = new File("/var/tmp/" + fileName);
			InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
			responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
					.contentType(MediaType.parseMediaType("application/txt")).body(resource);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}

}
