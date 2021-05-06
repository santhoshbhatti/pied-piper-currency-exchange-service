package com.pp.ce.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pp.ce.entities.CurrencyExchangeEntity;
import com.pp.ce.mappers.CurrencyExchangeMapper;
import com.pp.ce.vos.CurrencyExchange;

@RestController
public class CurrencyExchangeController {
	
	@Value("${server.port}")
	private String serverPort;
	
	@Autowired
	CurrencyExchangeMapper currencyExchangeMapper;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to) {
		
		CurrencyExchange currencyVo = currencyExchangeMapper.currencyExchangeEntityToVo(new CurrencyExchangeEntity(1001L,from,to,new BigDecimal(80.0),serverPort));
		return currencyVo;
	}

}
