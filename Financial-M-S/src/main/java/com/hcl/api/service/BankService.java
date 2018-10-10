package com.hcl.api.service;

import org.springframework.context.NoSuchMessageException;

import com.hcl.api.dto.BalanceRequestDTO;
import com.hcl.api.dto.BalanceResponseDTO;
import com.hcl.api.exception.ApplicationCustomException;

public interface BankService {

	/**
	 * This method is created to get the account information.
	 * 
	 * @param balanceRequestDTO
	 *            holds the information of the balance request
	 * @return
	 * @throws NoSuchMessageException
	 * @throws ApplicationCustomException
	 */
	public BalanceResponseDTO getAccountInfo(BalanceRequestDTO balanceRequestDTO)
			throws NoSuchMessageException, ApplicationCustomException;

	/**
	 * This method is created to get the Account info based on the customer id
	 * 
	 * @param customerId
	 *            holds the information of the customer id
	 * @return
	 * @throws NoSuchMessageException
	 * @throws ApplicationCustomException
	 */
	public BalanceResponseDTO getAccount(int customerId) throws NoSuchMessageException, ApplicationCustomException;

}
