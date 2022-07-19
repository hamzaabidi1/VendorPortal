package com.smartech.vendorportal.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.smartech.vendorportal.entities.FileDB;
import com.smartech.vendorportal.entities.ResponseMessage;
import com.smartech.vendorportal.entities.Rfq;
import com.smartech.vendorportal.entities.User;
import com.smartech.vendorportal.services.FileStorageService;
import com.smartech.vendorportal.services.RfqLineService;
import com.smartech.vendorportal.services.RfqService;
import com.smartech.vendorportal.services.UserControl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/public/Rfq")
public class PublicApi {
	@Autowired
	RfqService rfqService;
	@Autowired
	UserControl userControl;
	@Autowired
	RfqLineService rfqLineService;
	@Autowired
	private FileStorageService storageService;

	@PostMapping("/addRfq/{email}")
	public Rfq addRfq(@RequestBody Rfq rfq, @PathVariable("email") String email) {
		User user = userControl.retrieveOneUserByEmail(email);
		rfq.setUser(user);
		return rfqService.addRFQ(rfq);

	}

	@PostMapping("/addRfqUsername/{username}")
	public Rfq addRfqUserName(@RequestBody Rfq rfq, @PathVariable("username") String username) {
		User user = userControl.getbyUserName(username);
		rfq.setUser(user);
		return rfqService.addRFQ(rfq);

	}
	
	
	@PostMapping("/AddRfqwithfile/{username}")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("rfq") Rfq rfq, @RequestParam("file") List<MultipartFile> file, @PathVariable("username") String username) {
		User user = userControl.getbyUserName(username);
		rfq.setUser(user);
		
		String message = "";
		ResponseEntity<ResponseMessage> re = ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
				.body(new ResponseMessage("no file to upload"));
		List<FileDB> files = new ArrayList<>();
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
		rfqService.addRFQ(rfq);
		return re;
	}


}
