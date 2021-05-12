package com.pp.ce.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pp.ce.entities.CurrencyExchangeEntity;
import com.pp.ce.exceptions.CurrencyExchangeNotFoundException;
import com.pp.ce.mappers.CurrencyExchangeMapper;
import com.pp.ce.repository.CurrencyExchangeRepo;
import com.pp.ce.vos.CurrencyExchange;

@RestController
public class CurrencyExchangeController {
	
	@Value("${server.port}")
	private String serverPort;
	
	@Autowired
	CurrencyExchangeMapper currencyExchangeMapper;
	
	@Autowired
	CurrencyExchangeRepo currencyExchangeRepo;
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to) {
		logger.info("currency-exchange request to convert {} from {}",to,from);
		CurrencyExchangeEntity ce=currencyExchangeRepo.findByFromAndTo(from, to);
		if(ce == null) {
			throw new CurrencyExchangeNotFoundException("no exchange data found");
		}
		ce.setEnvironment(serverPort);
		CurrencyExchange currencyVo = currencyExchangeMapper
						.currencyExchangeEntityToVo(ce);
		return currencyVo;
	}

}
