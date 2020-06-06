package com.core.java.mobilebankingservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.core.java.mobilebankingservice.dto.FundTransferDTO;
import com.core.java.mobilebankingservice.exception.InsufficientAmountException;
import com.core.java.mobilebankingservice.service.MobilebankingService;

@RestController
public class MobilebankingServiceController {

	private static final Logger log = LoggerFactory.getLogger(MobilebankingServiceController.class.getName());

	@Autowired
	MobilebankingService mobilebankingService;

	@PostMapping("/fundtransfer")
	public String doTransaction(@RequestBody FundTransferDTO fundTransferDTO) {
		
		String response = "fund transfer failled ..!";
		try {
			response = mobilebankingService.doFundTransfer(fundTransferDTO);
		} catch (InsufficientAmountException e) {
			log.info("Exception occured on :: ", e);
		}
		
		return response;
	}
}
