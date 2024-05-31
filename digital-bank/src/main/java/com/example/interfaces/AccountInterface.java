package com.example.interfaces;

import com.example.models.Account;

public interface AccountInterface {
  void deposit(Double value);
  void withdraw(Double value);
  void transfer(Account destinyAccount, Double value);
  void printAccountStatements();
  Double checkBalance();
}
