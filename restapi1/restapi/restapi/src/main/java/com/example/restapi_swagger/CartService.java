package com.example.restapi_swagger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	
	
	public List<CartItem> getCartDetails() {
		return cartRepository.getcartDetails();
	}
	
	public int addCartDetails(CartItem cartItem) {
		 return cartRepository.addCartDetails(cartItem);
	}

	public int updateCartDetails(CartItem cartItem) {
		return cartRepository.updateCartDetails(cartItem);
	}

	public int deleteCartDetails(int id) {
		return cartRepository.deleteCartDetails(id);
	}
	
}
