package com.example.customer.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customer.model.*;

public interface CustomerRepo extends JpaRepository<Customer,String>{

}
