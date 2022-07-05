package com.smartech.vendorportal.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.smartech.vendorportal.entities.FileDB;
import com.smartech.vendorportal.entities.ResponseFile;
import com.smartech.vendorportal.entities.ResponseMessage;
import com.smartech.vendorportal.entities.Rfq;
import com.smartech.vendorportal.services.FileStorageService;
import com.smartech.vendorportal.services.RfqService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/file")
public class FileController {

	@Autowired
	private FileStorageService storageService;
	@Autowired
	RfqService rfqService;

	@PostMapping("/upload/{idrfq}")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") List<MultipartFile> file,
			@PathVariable("idrfq") Long idrfq) {
		String message = "";
		ResponseEntity<ResponseMessage> re = ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
				.body(new ResponseMessage("no file to upload"));
		List<FileDB> files = storageService.getAllFilesRfq(idrfq);
		Rfq rfq = rfqService.retrieveOneById(idrfq);
		for (int i = 0; i < file.size(); i++) {

			try {
				FileDB filedb = storageService.store(file.get(i));
				files.add(filedb);
				rfq.setFiles(files);
				message = "files Uploaded  successfully ";
				re = ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload  files !";
				re = ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}
		rfqService.updateRFQ(rfq);
		return re;
	}

	@GetMapping("/allfiles/{id}")
	public ResponseEntity<List<ResponseFile>> getListFilesPerRfq(@PathVariable("id") Long id) {
		List<ResponseFile> files = storageService.getAllFilesPerRfq(id).map(dbFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/file/files/")
					.path(dbFile.getId()).toUriString();

			return new ResponseFile(dbFile.getName(), fileDownloadUri, dbFile.getType(), dbFile.getData().length);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable("id") String id) {
		FileDB fileDB = storageService.getFile(id);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(fileDB.getData());
	}
	

	@DeleteMapping("/deletefile/{id}")
	public void deleteFile(@PathVariable("id") String id) {
		storageService.deleteFile(id);
	}
}