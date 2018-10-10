package com.hcl.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.api.dto.BalanceRequestDTO;
import com.hcl.api.dto.BalanceResponseDTO;
import com.hcl.api.enums.SecurityError;
import com.hcl.api.exception.ApplicationCustomException;
import com.hcl.api.response.BaseResponse;
import com.hcl.api.service.BankService;

@RestController
@RequestMapping("/api")
public class BankController {

	@Autowired
	private MessageSource source;
	@Autowired
	private BankService bankService;

	/**
	 * This method is created to get the balance.
	 * 
	 * @param balanceRequestDTO
	 * @return
	 * @throws NoSuchMessageException
	 * @throws ApplicationCustomException
	 */
	@RequestMapping(value = "/balance", method = RequestMethod.POST)
	public ResponseEntity<?> getbalanceResponse(@RequestBody BalanceRequestDTO balanceRequestDTO)
			throws NoSuchMessageException, ApplicationCustomException {
		final BalanceResponseDTO balanceResponseDTO = bankService.getAccountInfo(balanceRequestDTO);
		if (balanceResponseDTO != null) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
					source.getMessage("list.message", null, null), balanceResponseDTO), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.OPERATION_FAILED.getDescription(), null), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This api is created to get the balance based on the customer-id
	 * 
	 * @param customerId
	 *            holds the information of the customer.
	 * @return
	 * @throws NoSuchMessageException
	 * @throws ApplicationCustomException
	 */
	@RequestMapping(value = "/{customer-id}", method = RequestMethod.GET)
	public ResponseEntity<?> getBalanceResponse(@PathVariable("customer-id") String customerId)
			throws NoSuchMessageException, ApplicationCustomException {
		int custId = Integer.parseInt(customerId);
		final BalanceResponseDTO balanceResponseDTO = bankService.getAccount(custId);
		if (balanceResponseDTO != null) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
					source.getMessage("list.message", null, null), balanceResponseDTO), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.OPERATION_FAILED.getDescription(), null), HttpStatus.BAD_REQUEST);
		}
	}
}
