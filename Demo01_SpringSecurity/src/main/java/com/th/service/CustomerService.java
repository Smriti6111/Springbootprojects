package com.th.service;

import java.util.List;

import com.th.dto.CustomerDTO;
import com.th.exception.ThBankException;

public interface CustomerService {
	public CustomerDTO getCustomer(Integer customerId) throws ThBankException;
	public List<CustomerDTO> getAllCustomers() throws ThBankException;
	public Integer addCustomer(CustomerDTO customer) throws ThBankException;
	public void updateCustomer(Integer customerId, String emailId) throws ThBankException;
	public void deleteCustomer(Integer customerId) throws ThBankException;
}
