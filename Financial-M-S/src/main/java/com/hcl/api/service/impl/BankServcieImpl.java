package com.hcl.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.api.dao.BankDAO;
import com.hcl.api.dto.BalanceRequestDTO;
import com.hcl.api.dto.BalanceResponseDTO;
import com.hcl.api.exception.ApplicationCustomException;
import com.hcl.api.service.BankService;

@Service
public class BankServcieImpl implements BankService {

	@Autowired
	private MessageSource source;

	@Autowired
	private BankDAO bankDAO;

	/**
	 * This method is created to get the account information.
	 * 
	 * @param balanceRequestDTO
	 *            holds the information of the balance request
	 * @return
	 * @throws NoSuchMessageException
	 * @throws ApplicationCustomException
	 */
	@Override
	@Transactional
	public BalanceResponseDTO getAccountInfo(final BalanceRequestDTO balanceRequestDTO)
			throws NoSuchMessageException, ApplicationCustomException {
		if (balanceRequestDTO == null) {
			throw new ApplicationCustomException(source.getMessage("unformat.exception", null, null));
		}
		BalanceResponseDTO balanceResponseDTO = bankDAO.getAccountInfo(balanceRequestDTO);
		if (balanceResponseDTO != null) {
			return balanceResponseDTO;
		}
		return null;
	}

	/**
	 * This method is created to get the Account info based on the customer id
	 * 
	 * @param customerId
	 *            holds the information of the customer id
	 * @return
	 * @throws NoSuchMessageException
	 * @throws ApplicationCustomException
	 */
	@Override
	@Transactional
	public BalanceResponseDTO getAccount(int customerId) throws NoSuchMessageException, ApplicationCustomException {
		BalanceResponseDTO balanceResponseDTO = bankDAO.getAccount(customerId);
		System.out.println(balanceResponseDTO);
		if (balanceResponseDTO == null) {
			throw new ApplicationCustomException(source.getMessage("invalid.customer.id.exception", null, null));
		}
		if (balanceResponseDTO != null) {
			return balanceResponseDTO;
		}
		return null;
	}
}
