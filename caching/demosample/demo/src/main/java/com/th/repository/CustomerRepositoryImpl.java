package com.th.repository;

import java.util.ArrayList;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.th.model.Customer;


@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@Override
	@Cacheable("customer")
	public Customer getCustName(int id) {
		ArrayList<Customer> custtable = new ArrayList<>();
		custtable.add( new Customer(1,"venky1"));
		custtable.add(new Customer(2,"venky2"));
		
		
		
		return custtable.get(id);
	}

}
