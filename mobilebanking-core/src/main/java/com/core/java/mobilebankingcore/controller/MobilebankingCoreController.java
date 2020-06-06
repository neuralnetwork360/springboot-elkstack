package com.core.java.mobilebankingcore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.core.java.mobilebankingcore.dto.FundTransferDTO;
import com.core.java.mobilebankingcore.exception.UserAuthenticationException;
import com.core.java.mobilebankingcore.service.MobilebankingCoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class MobilebankingCoreController {

	private static final Logger log = LoggerFactory.getLogger(MobilebankingCoreController.class.getName());

	@Autowired
	MobilebankingCoreService mobilebankingCoreService;

	@PostMapping("/fundtransfer")
	public String doTransaction(@RequestBody FundTransferDTO fundTransferDTO) {
		
		String response = "fund transfer failled ..!";
		try {
			response = mobilebankingCoreService.doFundTransfer(fundTransferDTO);
		} catch (UserAuthenticationException e) {
			log.info("Exception occured on :: ", e);
		}
		
		return response;
	}

}
