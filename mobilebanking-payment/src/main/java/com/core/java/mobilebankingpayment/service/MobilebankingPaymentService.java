package com.core.java.mobilebankingpayment.service;

import org.springframework.stereotype.Service;

import com.core.java.mobilebankingpayment.dto.FundTransferDTO;
import com.core.java.mobilebankingpayment.exception.PaymentGatewayException;

@Service
public class MobilebankingPaymentService {

	public String doFundTransfer(FundTransferDTO fundTransferDTO) throws PaymentGatewayException {
		String response;
		if(String.valueOf(fundTransferDTO.getAccountNo()).length() <= 4) {
			throw new PaymentGatewayException("Invalid account number..! Minimum 5 digit..!");
		}else {
			response = "fund transfer success..!";
		}
		return response;
	}
}
