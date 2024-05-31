package com.example.services;

import com.example.models.Account;

public class TransferService {
  public void transfer(Account fromAccount, Account toAccount, Double amount) {
    if (fromAccount == null || toAccount == null) {
      throw new IllegalArgumentException("Both accounts must not be null.");
    }
    if (amount == null || amount <= 0) {
      throw new IllegalArgumentException("Transfer amount must be greater than zero.");
    }
    fromAccount.transfer(toAccount, amount);
  }
}
