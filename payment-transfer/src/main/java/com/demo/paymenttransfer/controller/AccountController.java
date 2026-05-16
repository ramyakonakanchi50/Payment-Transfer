package com.demo.paymenttransfer.controller;

import com.demo.paymenttransfer.model.AccountInfoRequest;
import com.demo.paymenttransfer.model.MiniStatement;
import com.demo.paymenttransfer.model.PaymentTransferRequest;
import com.demo.paymenttransfer.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@Validated
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public ResponseEntity<HttpStatus> createAccount(@Valid @RequestBody AccountInfoRequest accountInfoRequest) {
        accountService.createAccount(accountInfoRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/account/{id}")
    public ResponseEntity<Object> getAccountDetails(@Valid @PathVariable("id") String accountId) {
        return new ResponseEntity<>(accountService.getAccountDetails(accountId), HttpStatus.OK);
    }

    @GetMapping("/accounts")
    public ResponseEntity<Object> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccountDetails(), HttpStatus.OK);
    }

    @PostMapping("/accounts/transfer")
    public ResponseEntity<HttpStatus> transferMoney(@Valid @RequestBody PaymentTransferRequest paymentTransferRequest) {
        accountService.transferMoney(paymentTransferRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/accounts/{accountId}/mini")
    public ResponseEntity<Object> getMiniStatement(@Valid @PathVariable String accountId) {
        List<MiniStatement> miniStatement = accountService.getMiniStatement(accountId);
        return new ResponseEntity<>(miniStatement, HttpStatus.OK);
    }
}
