package com.pp.ce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pp.ce.entities.CurrencyExchangeEntity;

@Repository
public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchangeEntity, Long>{
	
	CurrencyExchangeEntity findByFromAndTo(String from,String to);

}
