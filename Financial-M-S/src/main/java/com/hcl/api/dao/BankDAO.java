package com.hcl.api.dao;

import com.hcl.api.dto.BalanceRequestDTO;
import com.hcl.api.dto.BalanceResponseDTO;

public interface BankDAO {
	/**
	 * This method is created to get the account information
	 * 
	 * @param balanceRequestDTO
	 *            holds the information of the balance request.
	 * @return
	 */
	public BalanceResponseDTO getAccountInfo(BalanceRequestDTO balanceRequestDTO);

	/**
	 * This method is created to get the account based on the customerid
	 * 
	 * @param customerId
	 *            holds the information of the customer
	 * @return
	 */
	public BalanceResponseDTO getAccount(int customerId);
}
