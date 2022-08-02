package com.smartech.vendorportal.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.smartech.vendorportal.entities.Config;
import com.smartech.vendorportal.entities.Docklinks;
import com.smartech.vendorportal.entities.MaximoSendFileDto;
import com.smartech.vendorportal.entities.Rfq;
import com.smartech.vendorportal.entities.RfqDto;
import com.smartech.vendorportal.entities.RfqLine;
import com.smartech.vendorportal.entities.User;
import com.smartech.vendorportal.services.ConfigService;
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
	ConfigService configService;

	@Value("${VendorPortal.app.urlmaximo}")
	private String maximourl;
	@Value("${VendorPortal.app.header.key}")
	private String key;
	@Value("${VendorPortal.app.header.value}")
	private String value;

	@PostMapping("/addRfq/{email}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public Rfq addRfq(@RequestBody Rfq rfq, @PathVariable("email") String email) {
		User user = userControl.retrieveOneUserByEmail(email);
		rfq.setUser(user);
		return rfqService.addRFQ(rfq);

	}

	@GetMapping("/GetRfq/{email}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public List<Rfq> getAllRfq(@PathVariable("email") String email) {
		List <Rfq> lstrfq=rfqService.retriveAllRfqByUser(email);
		for (int i=0;i<lstrfq.size();i++) {
			lstrfq.get(i).setFiles(null);
			lstrfq.get(i).setUser(null);
		}
		return lstrfq;

	}

	@GetMapping("/GetRfqdetails/{id}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public Rfq getRfqDetails(@PathVariable("id") Long id) {
		Rfq rfq=rfqService.retrieveOneById(id);
		rfq.setUser(null);
		rfq.setFiles(null);
		return rfq;

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
		List<Config> configs = configService.retriveAllConfig();
		String usermAXIMO = configs.get(0).getUsermaximo();
		rfqDto.setUserMaximo(usermAXIMO);
		String uri = maximourl+"/maximo/oslc/script/COPYRFQLINESTOQUOTATIONLINES";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set(key, value);
		HttpEntity<RfqDto> requestBody = new HttpEntity<>(rfqDto, headers);
		ResponseEntity<String> resultGet = restTemplate.exchange(uri, HttpMethod.POST, requestBody, String.class);
		Rfq rfq = rfqService.retrieveOneById(id);
		HttpHeaders headersfile = new HttpHeaders();
		headersfile.set(key, value);
		headersfile.set("x-method-override", "PATCH");
		headersfile.set("patchtype", "MERGE");
		headersfile.set("Content-Type", "application/json");
		MaximoSendFileDto maximoSendFileDto = new MaximoSendFileDto();
		maximoSendFileDto.setRfqnum(rfq.getRfqnum());
		maximoSendFileDto.setSiteid(rfq.getSiteid());
		List<Docklinks> docklist = new ArrayList<>();
		for (int i=0 ; i<rfq.getFiles().size();i++) {
			Docklinks docklinks=new Docklinks();
			docklinks.setUrlname(rfq.getFiles().get(i).getName());
			docklinks.setDescription(rfq.getFiles().get(i).getName());
			docklinks.setDocumentdata(Base64.getEncoder().encodeToString(rfq.getFiles().get(i).getData()));
			docklinks.setUrltype("FILE");
			docklinks.setDoctype("Attachments");
			docklist.add(docklinks);
			
		}
		maximoSendFileDto.setDoclinks(docklist);
		HttpEntity<?> getBodyFile = new HttpEntity<>(maximoSendFileDto,headersfile);
		String originalInput =rfq.getRfqnum()+"/"+rfq.getSiteid();
		String rfqIdentity = "_"+Base64.getEncoder().encodeToString(originalInput.getBytes()).toString();
		String urifile =maximourl+ "/maxrest/oslc/os/SMRFQ_DOCLINKS/"+rfqIdentity+"?lean=1";
		ResponseEntity<String> resultGetfile = restTemplate.exchange(urifile, HttpMethod.POST, getBodyFile,String.class);
		rfq.setStatusofSend(true);
		LocalDate today = LocalDate.now();
		rfq.setDateEnvoie(java.sql.Date.valueOf(today));
		rfqService.updateRFQ(rfq);
	}

}
