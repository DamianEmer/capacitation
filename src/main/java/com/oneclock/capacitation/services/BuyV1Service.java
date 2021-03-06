package com.oneclock.capacitation.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneclock.capacitation.controllers.forms.BuyForm;
import com.oneclock.capacitation.dto.ProductDTO;
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
	
	public List<ProductDTO> CreateBuy(BuyForm buyForm) {

		User user = userDAO.findUserById(1);
		
		List<Product> productList = new ArrayList<Product>();
		Product product = productDAO.findByProductByID(buyForm.getProductID());
		
		if( user != null && product != null) {
			
			if(buyForm.getQuantity() <= product.getStock()) {
				
				BuyID buyID = new BuyID(user.getUserID(), product.getProductID());
				buyDAO.save(new Buy(buyID, buyForm.getQuantity()));
				
				List<Buy> listBuys = buyDAO.findByBuysID(user.getUserID());
			
				listBuys.stream().map(item ->
					productList.add(productDAO.findById(item.getProductID()).get())
							);
			}
		}
		//TicketDTO(String userName, String lastName, String productName, BigDecimal price, Date creationDate)
		
		
		return populateListProductDTO(productList);
		
	}

	private List<ProductDTO> populateListProductDTO(List<Product> productList) {
		
		return productList.stream().map(product -> populateProductDTO(product)).collect(Collectors.toList());
		
	}

	private ProductDTO populateProductDTO(Product product) {
		// TODO Auto-generated method stub
		return new ProductDTO(product.getProductID(), product.getProductName(), product.getStock(),product.getPrice());
	}
	

}
