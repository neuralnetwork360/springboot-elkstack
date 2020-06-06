package com.core.java.mobilebankingpayment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.core.java.mobilebankingpayment.dto.FundTransferDTO;
import com.core.java.mobilebankingpayment.exception.PaymentGatewayException;
import com.core.java.mobilebankingpayment.service.MobilebankingPaymentService;

@RestController
public class MobilebankingPaymentController {

	private static final Logger log = LoggerFactory.getLogger(MobilebankingPaymentController.class.getName());

	@Autowired
	MobilebankingPaymentService mobilebankingPaymentService;

	@PostMapping("/fundtransfer")
	public String doTransaction(@RequestBody FundTransferDTO fundTransferDTO) {
		
		String response = "fund transfer failled ..!";
		try {
			response = mobilebankingPaymentService.doFundTransfer(fundTransferDTO);
		} catch (PaymentGatewayException e) {
			log.info("Exception occured on :: ", e);
		}
		
		return response;
	}
}
