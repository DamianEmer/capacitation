package com.oneclock.capacitation.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneclock.capacitation.controllers.forms.BuyForm;
import com.oneclock.capacitation.dto.TicketDTO;
import com.oneclock.capacitation.entities.Buy;
import com.oneclock.capacitation.entities.BuyID;
import com.oneclock.capacitation.entities.Product;
import com.oneclock.capacitation.entities.User;
import com.oneclock.capacitation.repository.BuyDAO;
import com.oneclock.capacitation.repository.ProductDAO;
import com.oneclock.capacitation.repository.UserDAO;

@Service
public class BuyV1Service {

	
	@Autowired
	private BuyDAO buyDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	public TicketDTO CreateBuy(BuyForm buyForm) {
		Buy lastBuy = null;
		User user = userDAO.findUserById(buyForm.getUserID());
		
		Product product = productDAO.findByProductByID(buyForm.getProductID());
		
		if( user != null && product != null) {
			
			if(buyForm.getQuantity() <= product.getStock()) {
				
				BuyID buyID = new BuyID(user, product);
				buyDAO.save(new Buy(buyID, buyForm.getQuantity()));
				
				List<Buy> listBuys = buyDAO.findByBuysID(1);
				
				for(Buy buy : listBuys) {
					buy.getBuyID().productID.getProductID();
					
				}
				lastBuy = listBuys.get(0);
			}
		}
		//TicketDTO(String userName, String lastName, String productName, BigDecimal price, Date creationDate)
		Optional<User> userEntity = userDAO.findById(lastBuy.getUserID());
		Optional<Product> productEntity = productDAO.findById(lastBuy.getProductID());
		
		
		return new TicketDTO(userEntity.get().getUserName(), userEntity.get().getUserLastName(), productEntity.get().getProductName(), productEntity.get().getPrice(), lastBuy.getCreationDate());
		
	}
}
