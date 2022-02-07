package com.casper.financially.rest;

import com.casper.financially.model.TransactionDTO;
import com.casper.financially.service.TransactionService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(final TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransaction(@PathVariable final Long id) {
        return ResponseEntity.ok(transactionService.get(id));
    }

    @GetMapping("/institution/{institution}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByInstitution(@PathVariable final String institution) {
    	return ResponseEntity.ok(transactionService.getTransactionsByInstitution(institution));
    }
    
    @GetMapping("/category/{category}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByCategory(@PathVariable final String category) {
    	return ResponseEntity.ok(transactionService.getTransactionsByCategory(category));
    }
    
    @GetMapping("/subcategory/{subcategory}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsBySubcategory(@PathVariable final String subcategory) {
    	return ResponseEntity.ok(transactionService.getTransactionsBySubcategory(subcategory));
    }
    
    @GetMapping("/category/{category}/subcategory/{subcategory}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByCategoryAndSubcategory(
    		@PathVariable final String category, @PathVariable final String subcategory) {
    	return ResponseEntity.ok(transactionService.getTransactionsByCategoryAndSubcategory(category, subcategory));
    }

    @PostMapping
    public ResponseEntity<Long> createTransaction(@RequestBody @Valid final TransactionDTO transactionDTO) {
        return new ResponseEntity<>(transactionService.create(transactionDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTransaction(@PathVariable final Long id,
            @RequestBody @Valid final TransactionDTO transactionDTO) {
    	transactionService.update(id, transactionDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable final Long id) {
    	transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
