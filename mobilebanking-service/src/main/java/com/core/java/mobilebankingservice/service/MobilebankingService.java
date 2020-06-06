package com.core.java.mobilebankingservice.service;

import org.springframework.stereotype.Service;

import com.core.java.mobilebankingservice.dto.FundTransferDTO;
import com.core.java.mobilebankingservice.exception.InsufficientAmountException;

@Service
public class MobilebankingService {

	public String doFundTransfer(FundTransferDTO fundTransferDTO) throws InsufficientAmountException {
		String response;
		if(fundTransferDTO.getAmount() < 100) {
			throw new InsufficientAmountException("Insufficient amount..! Minimum transfer amount 100rs");
		}else {
			response = "fund transfer success..!";
		}
		return response;
	}
}
