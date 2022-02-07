package com.casper.financially.service;

import com.casper.financially.domain.Transaction;
import com.casper.financially.model.TransactionDTO;
import com.casper.financially.repos.TransactionRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(final TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionDTO> findAll() {
        return transactionRepository.findAll()
                .stream()
                .map(transaction -> mapToDTO(transaction, new TransactionDTO()))
                .collect(Collectors.toList());
    }

    public TransactionDTO get(final Long id) {
        return transactionRepository.findById(id)
                .map(transaction -> mapToDTO(transaction, new TransactionDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TransactionDTO> getTransactionsByInstitution(final String institution) {
    	return transactionRepository.findByInstitution(institution)
    			.stream()
    			.map(transaction -> mapToDTO(transaction, new TransactionDTO()))
    			.collect(Collectors.toList());
    }

    public List<TransactionDTO> getTransactionsByCategory(final String category) {
    	return transactionRepository.findByCategory(category)
    			.stream()
    			.map(transaction -> mapToDTO(transaction, new TransactionDTO()))
    			.collect(Collectors.toList());
    }

    public List<TransactionDTO> getTransactionsBySubcategory(final String subcategory) {
    	return transactionRepository.findBySubcategory(subcategory)
    			.stream()
    			.map(transaction -> mapToDTO(transaction, new TransactionDTO()))
    			.collect(Collectors.toList());
    }

    public List<TransactionDTO> getTransactionsByCategoryAndSubcategory(final String category, final String subcategory) {
    	return transactionRepository.findByCategoryAndSubcategory(category, subcategory)
    			.stream()
    			.map(transaction -> mapToDTO(transaction, new TransactionDTO()))
    			.collect(Collectors.toList());
    }

    public Long create(final TransactionDTO transactionDTO) {
        final Transaction transaction = new Transaction();
        mapToEntity(transactionDTO, transaction);
        return transactionRepository.save(transaction).getId();
    }

    public void update(final Long id, final TransactionDTO transactionDTO) {
        final Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(transactionDTO, transaction);
        transactionRepository.save(transaction);
    }

    public void delete(final Long id) {
    	transactionRepository.deleteById(id);
    }

    private TransactionDTO mapToDTO(final Transaction transaction, final TransactionDTO transactionDTO) {
    	transactionDTO.setId(transaction.getId());
    	transactionDTO.setInstitution(transaction.getInstitution());
    	transactionDTO.setAmount(transaction.getAmount());
    	transactionDTO.setBalance(transaction.getBalance());
    	transactionDTO.setDescription(transaction.getDescription());
    	transactionDTO.setRawDescription(transaction.getRawDescription());
    	transactionDTO.setCategory(transaction.getCategory());
    	transactionDTO.setSubcategory(transaction.getSubcategory());
    	transactionDTO.setTransactionDate(transaction.getTransactionDate());
        return transactionDTO;
    }

    private Transaction mapToEntity(final TransactionDTO transactionDTO, final Transaction transaction) {
    	transaction.setInstitution(transactionDTO.getInstitution());
    	transaction.setAmount(transactionDTO.getAmount());
    	transaction.setBalance(transactionDTO.getBalance());
    	transaction.setDescription(transactionDTO.getDescription());
    	transaction.setRawDescription(transactionDTO.getRawDescription());
    	transaction.setCategory(transactionDTO.getCategory());
    	transaction.setSubcategory(transactionDTO.getSubcategory());
    	transaction.setTransactionDate(transactionDTO.getTransactionDate());
        return transaction;
    }
}
