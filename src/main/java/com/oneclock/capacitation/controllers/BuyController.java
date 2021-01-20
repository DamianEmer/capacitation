package com.oneclock.capacitation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneclock.capacitation.controllers.forms.BuyForm;
import com.oneclock.capacitation.dto.ProductDTO;
import com.oneclock.capacitation.dto.TicketDTO;
import com.oneclock.capacitation.services.BuyV1Service;

@RestController
@RequestMapping("buy")
public class BuyController {

	@Autowired
	private BuyV1Service buyV1Service;
	
	@PostMapping
	public ResponseEntity<List<ProductDTO>> createBuy(@Valid @RequestBody BuyForm buyfrom, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(buyV1Service.CreateBuy(buyfrom));
	}
	
	@GetMapping
	public String createBuy() {

		
		return "Hola mundox";
	}
	
	//RestController y controller
	//BindingResult 
	//Autowired
	
	//IOC  Principio para implementar Dependecy injection
	
	//3 tipos de inyeccion de dependencia cuando usar una y por que?
	//ResponseEntity
	
	
	
}
