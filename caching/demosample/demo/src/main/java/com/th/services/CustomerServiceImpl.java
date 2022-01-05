package com.th.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.th.model.Customer;
import com.th.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	
	@Autowired
	CustomerRepository custrepo;
	
	
	@Override
	public Customer getCustName(int index) {
		
		return custrepo.getCustName(index);
	}

	
	
	
	
	

}
