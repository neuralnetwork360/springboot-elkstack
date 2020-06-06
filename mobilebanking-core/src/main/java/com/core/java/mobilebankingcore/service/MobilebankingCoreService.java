package com.core.java.mobilebankingcore.service;

import org.springframework.stereotype.Service;

import com.core.java.mobilebankingcore.dto.FundTransferDTO;
import com.core.java.mobilebankingcore.exception.UserAuthenticationException;

@Service
public class MobilebankingCoreService {

	public String doFundTransfer(FundTransferDTO fundTransferDTO) throws UserAuthenticationException {
		String response;
		if(fundTransferDTO.getUserName().equals("admin") && fundTransferDTO.getPassword().equals("admin")) {
			response = "fund transfer success..!";
		}else {
			throw new UserAuthenticationException("User authentication failed.Invalid userName or password..!");
		}
		return response;
	}
}
