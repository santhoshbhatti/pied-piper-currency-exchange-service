package com.pp.ce.mappers;

import org.mapstruct.Mapper;

import com.pp.ce.entities.CurrencyExchangeEntity;
import com.pp.ce.vos.CurrencyExchange;

@Mapper(componentModel = "spring")
public interface CurrencyExchangeMapper {
	CurrencyExchangeEntity currencyExchangeVoToEntity(CurrencyExchange currencyExchange);
	CurrencyExchange currencyExchangeEntityToVo(CurrencyExchangeEntity currencyExchangeEntity);

}
