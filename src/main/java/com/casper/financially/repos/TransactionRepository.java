package com.casper.financially.repos;

import com.casper.financially.domain.Transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByInstitution(final String institution);

	List<Transaction> findByCategory(final String category);

	List<Transaction> findBySubcategory(final String subcategory);

	List<Transaction> findByCategoryAndSubcategory(final String category, final String subcategory);
}
