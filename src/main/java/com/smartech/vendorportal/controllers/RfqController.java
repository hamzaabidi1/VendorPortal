package com.smartech.vendorportal.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.smartech.vendorportal.entities.FileDB;
import com.smartech.vendorportal.entities.Rfq;
import com.smartech.vendorportal.entities.RfqDto;
import com.smartech.vendorportal.entities.RfqLine;
import com.smartech.vendorportal.entities.User;
import com.smartech.vendorportal.services.FileStorageService;
import com.smartech.vendorportal.services.RfqLineService;
import com.smartech.vendorportal.services.RfqService;
import com.smartech.vendorportal.services.UserControl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Rfq")
public class RfqController {
	@Autowired
	RfqService rfqService;
	@Autowired
	UserControl userControl;
	@Autowired
	RfqLineService rfqLineService;
	@Autowired
	private FileStorageService storageService;

	@Value("${VendorPortal.app.urlmaximo}")
	private String maximourl;
	@Value("${VendorPortal.app.header.key}")
	private String key;
	@Value("${VendorPortal.app.header.value}")
	private String value;

	@PostMapping("/addRfq/{email}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public Rfq addRfq(@RequestPart Rfq rfq, @PathVariable("email") String email,@RequestPart  List<MultipartFile> file) {
		User user = userControl.retrieveOneUserByEmail(email);
		
		
		List<FileDB> files = new ArrayList<>();
		
		for (int i = 0; i < file.size(); i++) {

			try {
				FileDB filedb = storageService.store(file.get(i));
				files.add(filedb);
				rfq.setFiles(files);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		rfq.setUser(user);
		return rfqService.addRFQ(rfq);

	}

	@GetMapping("/GetRfq/{email}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public List<Rfq> getAllRfq(@PathVariable("email") String email) {
		return rfqService.retriveAllRfqByUser(email);

	}

	@GetMapping("/GetRfqdetails/{id}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public Rfq getRfqDetails(@PathVariable("id") Long id) {
		return rfqService.retrieveOneById(id);

	}

	@GetMapping("/GetRfqLines/{id}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public List<RfqLine> getRfqLines(@PathVariable("id") Long id) {
		return rfqLineService.retriveAllRfqLine(id);

	}

	@GetMapping("/GetRfqLine/{id}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public RfqLine getRfqLineByid(@PathVariable("id") Long id) {
		return rfqLineService.retriveRfqLine(id);

	}

	@PutMapping("/updateRfqLine")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public RfqLine updateRfqLineByid(@RequestBody RfqLine rfqline) {
		return rfqLineService.updateRFQLine(rfqline);

	}

	@PostMapping("/addRfqmaximo/{id}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public void addRfqmaximo(@PathVariable("id") Long id) {
		RfqDto rfqDto = rfqService.addRfqTORfqDtomaximo(id);
		String uri = "http://demo.smartech-tn.com/maximo/oslc/script/COPYRFQLINESTOQUOTATIONLINES";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set(key, "bWF4YWRtaW46bWF4YWRtaW4xMjM=");
		HttpEntity<RfqDto> requestBody = new HttpEntity<>(rfqDto, headers);
		restTemplate.exchange(uri, HttpMethod.POST, requestBody, String.class);
		Rfq rfq = rfqService.retrieveOneById(id);
		rfq.setStatusofSend(true);
		LocalDate today = LocalDate.now();
		rfq.setDateEnvoie(java.sql.Date.valueOf(today));
		rfqService.updateRFQ(rfq);
	}

}
