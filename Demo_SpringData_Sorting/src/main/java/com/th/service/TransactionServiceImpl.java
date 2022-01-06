package com.th.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.th.dto.TransactionDTO;
import com.th.entity.Transaction;
import com.th.exception.ThBankException;
import com.th.repository.TransactionRepository;

@Service(value = "transactionService")
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<TransactionDTO> getAllTransaction(Sort sort) throws ThBankException {
		Iterable<Transaction> transactions = transactionRepository.findAll(sort);
		List<TransactionDTO> transactionDTOs = new ArrayList<>();
		transactions.forEach(transaction -> {
			TransactionDTO t = new TransactionDTO(transaction.getTransactionId(), transaction.getTransactionDate(),
					transaction.getTransactionAmount());
			transactionDTOs.add(t);
		});

		if (transactionDTOs.isEmpty()) {
			throw new ThBankException("Service.NO_TRANSACTION_IN_THIS_PAGE");
		}
		return transactionDTOs;
	}

	@Override
	public List<TransactionDTO> getAllTransactionByTransactionDateAfter(LocalDate transactionDate, Pageable pageable) throws ThBankException {

		List<Transaction> transactions = transactionRepository.findByTransactionDateAfter(transactionDate, pageable);
		if (transactions.isEmpty()) {
			throw new ThBankException("Service.NO_TRANSACTION_IN_THIS_PAGE");
		}
		
		return transactions.stream()
				.map(p -> new TransactionDTO(p.getTransactionId(), p.getTransactionDate(), p.getTransactionAmount()))
				.collect(Collectors.toList());	
	}

}
