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
    public ResponseEntity<List<TransactionDTO>> getAllAccounts() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getAccount(@PathVariable final Long id) {
        return ResponseEntity.ok(transactionService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createAccount(@RequestBody @Valid final TransactionDTO accountDTO) {
        return new ResponseEntity<>(transactionService.create(accountDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAccount(@PathVariable final Long id,
            @RequestBody @Valid final TransactionDTO accountDTO) {
    	transactionService.update(id, accountDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable final Long id) {
    	transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
