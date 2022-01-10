package com.th.service;

import java.util.List;

import com.th.dto.CustomerDTO;
import com.th.exception.ThBankException;

public interface CustomerService {
	public CustomerDTO getCustomer(Integer customerId) throws ThBankException;
	public List<CustomerDTO> getAllCustomers() throws ThBankException;
}
