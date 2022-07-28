package com.smartech.vendorportal.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartech.vendorportal.entities.Rfq;
import com.smartech.vendorportal.entities.RfqDto;
import com.smartech.vendorportal.entities.RfqLine;
import com.smartech.vendorportal.entities.RfqLineDto;
import com.smartech.vendorportal.repositories.FileDBRepository;
import com.smartech.vendorportal.repositories.RfqLineRepository;
import com.smartech.vendorportal.repositories.RfqRepository;

@Service
public class RfqServiceImpl implements RfqService {
	@Autowired
	RfqRepository rfqRepository;
	@Autowired
	RfqLineRepository rfqLineRepository;
	@Autowired
	private FileDBRepository fileDBRepository;

	@Override
	public List<Rfq> retriveAllRFQ() {

		return rfqRepository.findAll();
	}

	@Override
	public Rfq addRFQ(Rfq rfq) {
		for (int i = 0; i < rfq.getRfqline().size(); i++) {
			rfqLineRepository.save(rfq.getRfqline().get(i));
		}
		if (rfq.getFiles() != null)
		for (int i=0 ;i<rfq.getFiles().size();i++)
		{
			fileDBRepository.save(rfq.getFiles().get(i));
		}
		return rfqRepository.save(rfq);
	}

	@Override
	public void deleteRFQById(Long id) {
		rfqRepository.deleteById(id);

	}

	@Override
	public Rfq updateRFQ(Rfq rfq) {
		return rfqRepository.save(rfq);
	}

	@Override
	public Rfq retrieveOneById(Long id) {

		return rfqRepository.findById(id).get();
	}

	@Override
	public List<Rfq> retriveAllRfqByUser(String email) {
		return rfqRepository.findAllRfqByUser(email);
	}

	public RfqDto addRfqTORfqDtomaximo(Long id) {

		Rfq rfq = retrieveOneById(id);
		List<RfqLine> rfqline = rfq.getRfqline();
		List<RfqLineDto> rfqLinesDto = new ArrayList<>();
		RfqDto rfqDto = new RfqDto();
		rfqDto.setRfqnum(rfq.getRfqnum());
		rfqDto.setSiteid(rfq.getSiteid());
		rfqDto.setVendor(rfq.getUser().getUsername());
		int i = 0;
		while (i < rfqline.size()) {
			RfqLineDto rfqLineDto = new RfqLineDto();
			rfqLineDto.setRfqlinenum(rfqline.get(i).getRfqlinenum());
			rfqLineDto.setUnitcost(rfqline.get(i).getUnitcost());
			rfqLineDto.setQuotationqty(rfqline.get(i).getQuotationqty());
			rfqLineDto.setQuoteStartDate(rfqline.get(i).getQuoteStartDate().toString());
			rfqLineDto.setQuoteEndDate(rfqline.get(i).getQuoteEndDate().toString());
			rfqLineDto.setDelivryDate(rfqline.get(i).getDelivryDate().toString());
			rfqLinesDto.add(rfqLineDto);
			i++;
		}
		rfqDto.setRfqline(rfqLinesDto);
		rfqDto.setFile(rfq.getFiles());

		return rfqDto;

	}

}
