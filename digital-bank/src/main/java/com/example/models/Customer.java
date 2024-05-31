package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Account> accounts;

  public Customer(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Customer name must not be null or empty.");
    }
    this.name = name;
    this.accounts = new ArrayList<>();
  }

  public void addAccount(Account account) {
    if (account == null) {
      throw new IllegalArgumentException("Account must not be null.");
    }
    accounts.add(account);
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public String getName() {
    return name;
  }
}
