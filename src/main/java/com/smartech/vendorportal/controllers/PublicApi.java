package com.smartech.vendorportal.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.smartech.vendorportal.entities.Config;
import com.smartech.vendorportal.entities.FileDB;
import com.smartech.vendorportal.entities.FileExchangeMaximoDto;
import com.smartech.vendorportal.entities.ResponseMessage;
import com.smartech.vendorportal.entities.Rfq;
import com.smartech.vendorportal.entities.User;
import com.smartech.vendorportal.services.ConfigService;
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
	@Autowired
	ConfigService configService;
	
	@Value("${VendorPortal.app.header.key}")
	private String key;

	

	@PostMapping("/addRfq/{email}")
	public Rfq addRfq(@RequestBody Rfq rfq, @PathVariable("email") String email) {
		User user = userControl.retrieveOneUserByEmail(email);
		rfq.setUser(user);
		return rfqService.addRFQ(rfq);

	}

	@PostMapping("/addRfqUsername/{username}")
	public Rfq addRfqUserName(@RequestBody Rfq rfq, @PathVariable("username") String username) throws IOException {
		Config configs = configService.retriveAllConfig();
		User user = userControl.getbyUserName(username);
		rfq.setUser(user);
		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set(key,configs.getHeaderMaximo());
		String originalInput =rfq.getRfqnum()+"/"+rfq.getSiteid();
		String rfqIdentity = "_"+Base64.getEncoder().encodeToString(originalInput.getBytes());
		HttpEntity<Rfq> getBody = new HttpEntity<>(headers);
		String url = configs.getMaximopath()+"/maxrest/oslc/os/SMRFQ_DOCLINKS/"+rfqIdentity+"/doclinks?lean=1";
		ResponseEntity<FileExchangeMaximoDto> resultGet = restTemplate.exchange(url, HttpMethod.GET, getBody,FileExchangeMaximoDto.class);
		System.out.println("********  success ********");
		
		List<FileDB> dbfiles= new ArrayList<FileDB>();
		
		for (int i = 0;i<resultGet.getBody().getMember().size();i++) {
			FileDB dbfile=new FileDB();
			dbfile.setName(resultGet.getBody().getMember().get(i).getDescribedBy().getFileName());
			dbfile.setType(resultGet.getBody().getMember().get(i).getDescribedBy().getFormat().getLabel());
			
			ResponseEntity<byte[]> resultGetfile = restTemplate.exchange(resultGet.getBody().getMember().get(i).getHref(), HttpMethod.GET, getBody,byte[].class);
			dbfile.setData(resultGetfile.getBody());
			dbfiles.add(dbfile);
		}
		
		rfq.setFiles(dbfiles);
		return rfqService.addRFQ(rfq);

	}
	
	

	
	
	@PostMapping("/AddRfqwithfile/{username}")
	public ResponseEntity<ResponseMessage> uploadFile( @RequestPart Rfq rfq, 
			@RequestPart List<MultipartFile> file
			, @PathVariable("username") String username) {
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
