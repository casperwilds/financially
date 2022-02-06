package com.casper.financially.service;

import com.casper.financially.domain.Account;
import com.casper.financially.model.AccountDTO;
import com.casper.financially.repos.AccountRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountDTO> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(account -> mapToDTO(account, new AccountDTO()))
                .collect(Collectors.toList());
    }

    public AccountDTO get(final Long id) {
        return accountRepository.findById(id)
                .map(account -> mapToDTO(account, new AccountDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final AccountDTO accountDTO) {
        final Account account = new Account();
        mapToEntity(accountDTO, account);
        return accountRepository.save(account).getId();
    }

    public void update(final Long id, final AccountDTO accountDTO) {
        final Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(accountDTO, account);
        accountRepository.save(account);
    }

    public void delete(final Long id) {
        accountRepository.deleteById(id);
    }

    private AccountDTO mapToDTO(final Account account, final AccountDTO accountDTO) {
        accountDTO.setId(account.getId());
        accountDTO.setInstitution(account.getInstitution());
        accountDTO.setAmount(account.getAmount());
        accountDTO.setBalance(account.getBalance());
        accountDTO.setDescription(account.getDescription());
        accountDTO.setRawDescription(account.getRawDescription());
        accountDTO.setCategory(account.getCategory());
        accountDTO.setSubcategory(account.getSubcategory());
        accountDTO.setTransactionDate(account.getTransactionDate());
        return accountDTO;
    }

    private Account mapToEntity(final AccountDTO accountDTO, final Account account) {
        account.setInstitution(accountDTO.getInstitution());
        account.setAmount(accountDTO.getAmount());
        account.setBalance(accountDTO.getBalance());
        account.setDescription(accountDTO.getDescription());
        account.setRawDescription(accountDTO.getRawDescription());
        account.setCategory(accountDTO.getCategory());
        account.setSubcategory(accountDTO.getSubcategory());
        account.setTransactionDate(accountDTO.getTransactionDate());
        return account;
    }

}
