package com.oneclock.capacitation.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.oneclock.capacitation.controllers.forms.BuyForm;
import com.oneclock.capacitation.dto.ProductDTO;
import com.oneclock.capacitation.dto.UserDTO;
import com.oneclock.capacitation.entities.Buy;
import com.oneclock.capacitation.entities.BuyID;
import com.oneclock.capacitation.entities.Product;
import com.oneclock.capacitation.entities.User;
import com.oneclock.capacitation.repository.BuyDAO;
import com.oneclock.capacitation.repository.ProductDAO;
import com.oneclock.capacitation.repository.UserDAO;

@Service
public class BuyService {

	@Autowired
	private BuyDAO buyDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	
	public void createBuy(BuyForm buyForm) {
		
		try {
			UserDTO userDTO = validUser(buyForm.getUserID());
			ProductDTO productDTO = validProduct(buyForm.getProductID());
			
			if(buyForm.getQuantity() <= productDTO.getStock()) {
				//BuyID buyID = new BuyID(userDTO, buyForm.getProductID());
				//buyDAO.save(new Buy(buyID, buyForm.getQuantity()));
				
			}
			
 		}catch(ResponseStatusException e) {
			
		}
	}


	private UserDTO validUser(int userID) throws ResponseStatusException {
		Optional<User> user = userDAO.findById(userID);
		
	
		
		if(user.isPresent()) {
			User userEntity = user.get();
			
			return new UserDTO(userEntity.getUserID(), userEntity.getUserName(), userEntity.getUserLastName());
		}
		
		  throw new ResponseStatusException(
		           HttpStatus.NOT_FOUND, "Foo Not Found" );
		
		
	}
	
	private ProductDTO validProduct(int productID) throws ResponseStatusException {
		Optional<Product> product = productDAO.findById(productID);
		
		
		
		if(product.isPresent()) {
			Product productEntity = product.get();
			
			return new ProductDTO(productEntity.getProductID(),productEntity.getProductName(), productEntity.getStock(), productEntity.getPrice());
		}
		
		  throw new ResponseStatusException(
		           HttpStatus.NOT_FOUND, "Foo Not Found" );
		
		
	}
	
	
	
	
	
}
