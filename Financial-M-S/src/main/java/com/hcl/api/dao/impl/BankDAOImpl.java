package com.hcl.api.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.api.base.dao.BaseDAO;
import com.hcl.api.dao.BankDAO;
import com.hcl.api.dto.AccountDTO;
import com.hcl.api.dto.BalanceRequestDTO;
import com.hcl.api.dto.BalanceResponseDTO;
import com.hcl.api.model.Account;
import com.hcl.api.model.Customer;

@Repository
public class BankDAOImpl implements BankDAO {

	@Autowired
	private BaseDAO<Customer> customerBaseDAO;

	/**
	 * This method is created to get the account information
	 * 
	 * @param balanceRequestDTO
	 *            holds the information of the balance request.
	 * @return
	 */
	@Override
	public BalanceResponseDTO getAccountInfo(BalanceRequestDTO balanceRequestDTO) {
		BalanceResponseDTO balanceResponseDTO = new BalanceResponseDTO();

		Customer customerInfo = customerBaseDAO.findUniqueByColumn(Customer.class, "customerId",
				balanceRequestDTO.getCustomerId());

		if (customerInfo != null) {
			balanceResponseDTO.setCustomerId(customerInfo.getCustomerId());
			Set<Account> accountInfo = customerInfo.getAccounts();
			Set<AccountDTO> accountDTOs = new HashSet<>();

			for (Account account : accountInfo) {
				final AccountDTO accountDTO = new AccountDTO();
				accountDTO.setAccountId(account.getId());
				accountDTO.setBalance(account.getBalance());
				accountDTO.setCurrency(account.getCurrency());

				accountDTOs.add(accountDTO);
			}
			balanceResponseDTO.setAccounts(accountDTOs);
		}
		return balanceResponseDTO;
	}

	/**
	 * This method is created to get the account based on the customer id
	 * 
	 * @param customerId
	 *            holds the information of the customer
	 * @return
	 */
	@Override
	public BalanceResponseDTO getAccount(int customerId) {
		BalanceResponseDTO balanceResponseDTO = new BalanceResponseDTO();
		Customer customerInfo = customerBaseDAO.findUniqueByColumn(Customer.class, "customerId", customerId);
		if (customerInfo != null) {
			balanceResponseDTO.setCustomerId(customerInfo.getCustomerId());
			Set<Account> accountInfo = customerInfo.getAccounts();
			Set<AccountDTO> accountDTOs = new HashSet<>();

			for (Account account : accountInfo) {
				final AccountDTO accountDTO = new AccountDTO();
				accountDTO.setAccountId(account.getId());
				accountDTO.setBalance(account.getBalance());
				accountDTO.setCurrency(account.getCurrency());
				accountDTOs.add(accountDTO);
			}
			balanceResponseDTO.setAccounts(accountDTOs);
		}
		return balanceResponseDTO;
	}
}
