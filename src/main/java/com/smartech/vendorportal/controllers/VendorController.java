package com.smartech.vendorportal.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.smartech.vendorportal.entities.Config;
import com.smartech.vendorportal.entities.Invoice;
import com.smartech.vendorportal.entities.InvoiceDto;
import com.smartech.vendorportal.entities.InvoiceRequestList;
import com.smartech.vendorportal.entities.MaximoRequest;
import com.smartech.vendorportal.entities.MaximoUpdatePo;
import com.smartech.vendorportal.entities.Po;
import com.smartech.vendorportal.entities.PoDto;
import com.smartech.vendorportal.entities.PoLine;
import com.smartech.vendorportal.entities.PoLineUpdate;
import com.smartech.vendorportal.entities.PoRequestList;
import com.smartech.vendorportal.entities.RequestProfile;
import com.smartech.vendorportal.entities.RfqDto;
import com.smartech.vendorportal.entities.RfqRequestListDto;
import com.smartech.vendorportal.entities.User;
import com.smartech.vendorportal.services.ConfigService;
import com.smartech.vendorportal.services.InvoiceService;
import com.smartech.vendorportal.services.PoLineService;
import com.smartech.vendorportal.services.PoService;
import com.smartech.vendorportal.services.RequestUpdateProfileService;
import com.smartech.vendorportal.services.UserControl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/fournisseur")
public class VendorController {
	@Value("${VendorPortal.app.header.key}")
	private String key;


	@Autowired
	RequestUpdateProfileService requestUpdateProfileService;
	@Autowired
	UserControl userControl;
	@Autowired
	ConfigService configService;
	@Autowired
	PoService poService;
	@Autowired
	PoLineService polineService;
	@Autowired
	InvoiceService invoiceService;

	@GetMapping("/invoices/{vendor}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public List<InvoiceDto> getinvoice(@PathVariable("vendor") String vendor) {
		Config configs = configService.retriveAllConfig();
		String uri = configs.getMaximopath() + "/maxrest/oslc/os/SMINVOICE?lean=1&oslc.select=*&_dropnulls=0&oslc.where=vendor=\""
				+ vendor + "\"";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Request to return JSON format
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(key, configs.getHeaderMaximo());
		HttpEntity<MaximoRequest> getBody = new HttpEntity<>(headers);
		ResponseEntity<InvoiceRequestList> result = restTemplate.exchange(uri, HttpMethod.GET, getBody,
				InvoiceRequestList.class);
		List<InvoiceDto> invoices = new ArrayList<InvoiceDto>();
		try {
			invoices = result.getBody().getMember();
			
			User user = userControl.getbyUserName(vendor);
			List<Invoice> invoicesLocal = new ArrayList<>();
			invoiceService.deleteAllInvoices();
			for (int i=0;i<invoices.size();i++)
			{
				Invoice invoice =invoiceService.InvoiceDtoToInvoice(invoices.get(i));
				invoice.setUser(user);
				invoicesLocal.add(invoice);
				invoiceService.addInvoice(invoicesLocal.get(i));	
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return invoices;

	}
	
	
	@PostMapping("/po/updateline/{poid}")
	@ResponseBody
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public void updatePoLine(@PathVariable("poid") String poid,@RequestBody PoLine polineupdate) {
		
		Config configs = configService.retriveAllConfig();
		String uri = configs.getMaximopath() + "/maxrest/oslc/os/SMPO/+"+poid+"?lean=1";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Request to return JSON format
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(key, configs.getHeaderMaximo());
		headers.set("x-method-override","PATCH");
		headers.set("patchtype","MERGE");
		PoLineUpdate poline =new PoLineUpdate(polineupdate.getPolinenum(),polineupdate.getVendeliverydate().substring(0,10));
		MaximoUpdatePo maximoUpdatePo = new MaximoUpdatePo();
		maximoUpdatePo.setPoline(poline);
	
		HttpEntity<MaximoUpdatePo> getBody = new HttpEntity<>(maximoUpdatePo,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, getBody, String.class);
	}

	@GetMapping("/po/{vendor}")
	@ResponseBody
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public List<PoDto> getPo(@PathVariable("vendor") String vendor) {
		Config configs = configService.retriveAllConfig();
		String uri = configs.getMaximopath() + "/maxrest/oslc/os/SMPO?lean=1&oslc.select=*&_dropnulls=0&oslc.where=vendor=\"" + vendor
				+ "\"";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Request to return JSON format
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(key, configs.getHeaderMaximo());
		HttpEntity<MaximoRequest> getBody = new HttpEntity<>(headers);
		ResponseEntity<PoRequestList> result = restTemplate.exchange(uri, HttpMethod.GET, getBody, PoRequestList.class);
		List<PoDto> pos = new ArrayList<PoDto>();
		try {
			pos = result.getBody().getMember();
			User user = userControl.getbyUserName(vendor);
			List<Po> posLocal = new ArrayList<>();
			poService.deleteAllPos	();
			for (int i=0;i<pos.size();i++)
			{
				Po po =poService.poDtoToPo(pos.get(i));
				po.setUser(user);
				posLocal.add(po);
				poService.addPO(posLocal.get(i));	
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pos;

	}

	@RequestMapping("/rfq/{vendor}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public List<RfqDto> getRfq(@PathVariable("vendor") String vendor) {
		Config configs = configService.retriveAllConfig();
		String uri = configs.getMaximopath()
				+ "/maxrest/oslc/os/SMRFQ?lean=1&oslc.select=*&_dropnulls=0&oslc.where=rfqvendor.vendor=\"" + vendor
				+ "\"";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set(key, configs.getHeaderMaximo());
		HttpEntity<MaximoRequest> getBody = new HttpEntity<>(headers);
		ResponseEntity<RfqRequestListDto> result = restTemplate.exchange(uri, HttpMethod.GET, getBody,
				RfqRequestListDto.class);
		List<RfqDto> rfqs = new ArrayList<RfqDto>();
		try {
			rfqs = result.getBody().getMember();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rfqs;
	}

	@PostMapping("/requestUpdateProfile/{email}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public ResponseEntity<?> requestUpdateProfile(@Valid @RequestBody RequestProfile profile,
			@PathVariable("email") String email) {
		System.out.println(profile.getDateEstablished());
		requestUpdateProfileService.addRequestUpdateProfile(profile, email);
		return ResponseEntity.ok().body(true);
	}

	@GetMapping("/getvendor/{email}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public User getVendorDetails(@PathVariable("email") String email) {
		return userControl.retrieveOneUserByEmail(email);
	}

	@GetMapping("/retrievevendor/{email}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public Boolean findRequest(@PathVariable("email") String email) {
		return requestUpdateProfileService.findRequestByEmail(email);
	}
	
	
	@PostMapping("/updateuserpassword/{email}/{password}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public void updateUserPassword(@PathVariable("email") String email,@PathVariable("password")  String password) {
		userControl.updateUserPassword ( email, password);
	}

}
