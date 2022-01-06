package com.th.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.th.dto.TransactionDTO;
import com.th.exception.ThBankException;

public interface TransactionService {

	public List<TransactionDTO> getAllTransaction(Sort sort) throws ThBankException;

	public List<TransactionDTO> getAllTransactionByTransactionDateAfter(LocalDate transactionDate, Pageable pageable) throws ThBankException;

}
