package com.th.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.th.dto.CustomerDTO;
import com.th.entity.Customer;
import com.th.exception.ThBankException;
import com.th.repository.CustomerRepository;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDTO getCustomer(Integer customerId) throws ThBankException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new ThBankException("Service.CUSTOMER_NOT_FOUND"));
		CustomerDTO customer2 = new CustomerDTO();
		customer2.setCustomerId(customer.getCustomerId());
		customer2.setDateOfBirth(customer.getDateOfBirth());
		customer2.setEmailId(customer.getEmailId());
		customer2.setName(customer.getName());
		return customer2;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() throws ThBankException {
		Iterable<Customer> customers = customerRepository.findAll();
		List<CustomerDTO> customers2 = new ArrayList<>();
		customers.forEach(customer -> {
			CustomerDTO cust = new CustomerDTO();
			cust.setCustomerId(customer.getCustomerId());
			cust.setDateOfBirth(customer.getDateOfBirth());
			cust.setEmailId(customer.getEmailId());
			cust.setName(customer.getName());
			customers2.add(cust);
		});
		if (customers2.isEmpty())
			throw new ThBankException("Service.CUSTOMERS_NOT_FOUND");
		return customers2;
	}

	@Override
	public Integer addCustomer(CustomerDTO customer) throws ThBankException {
		Customer customerEntity = new Customer();
		customerEntity.setDateOfBirth(customer.getDateOfBirth());
		customerEntity.setEmailId(customer.getEmailId());
		customerEntity.setName(customer.getName());
		customerEntity.setCustomerId(customer.getCustomerId());
		Customer customerEntity2 = customerRepository.save(customerEntity);
		return customerEntity2.getCustomerId();
	}

	@Override
	public void updateCustomer(Integer customerId, String emailId) throws ThBankException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		Customer c = customer.orElseThrow(() -> new ThBankException("Service.CUSTOMER_NOT_FOUND"));
		c.setEmailId(emailId);
	}

	@Override
	public void deleteCustomer(Integer customerId) throws ThBankException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		customer.orElseThrow(() -> new ThBankException("Service.CUSTOMER_NOT_FOUND"));
		customerRepository.deleteById(customerId);
	}

}
