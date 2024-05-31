package com.example.models;

import com.example.interfaces.AccountInterface;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements AccountInterface {
  protected String accountHolderName;
  protected Double balance;
  protected List<String> transactions;

  public Account(String accountHolderName, Double initialBalance) {
    this.accountHolderName = accountHolderName;
    this.balance = initialBalance != null ? initialBalance : 0.0;
    this.transactions = new ArrayList<>();
    addTransaction(String.format("Conta aberta com saldo inicial: R$ %.2f", this.balance));
  }

  @Override
  public void deposit(Double value) {
    if (value == null || value <= 0) {
      throw new IllegalArgumentException("O valor do depósito deve ser maior que zero.");
    }
    balance += value;
    addTransaction(String.format("Depositado: R$ %.2f", value));
  }  

  @Override
  public void withdraw(Double value) {
    if (value == null || value <= 0) {
      throw new IllegalArgumentException("O valor do saque deve ser maior que zero.");
    }
    if (value > balance) {
      throw new IllegalArgumentException("Saldo insuficiente para saque.");
    }
    balance -= value;
    addTransaction(String.format("Sacado: R$ %.2f", value));
  }

  @Override
  public void transfer(Account destinyAccount, Double value) {
    if (destinyAccount == null) {
      throw new IllegalArgumentException("A conta de destino não deve ser nula.");
    }
    if (value == null || value <= 0) {
      throw new IllegalArgumentException("O valor da transferência deve ser maior que zero.");
    }
    if (value > balance) {
      throw new IllegalArgumentException("Saldo insuficiente para transferência.");
    }
    this.withdraw(value);
    destinyAccount.deposit(value);
    addTransaction(String.format("Transferido: R$ %.2f para %s", value, destinyAccount.getAccountHolderName()));
  }

  @Override
  public void printAccountStatements() {
    System.out.println(String.format("Extrato da conta para: ", accountHolderName));
    for (String transaction : transactions) {
      System.out.println(transaction);
    }
  }

  @Override
  public Double checkBalance() {
    return balance;
  }

  protected void addTransaction(String detail) {
    transactions.add(detail);
  }

  public String getAccountHolderName() {
    return accountHolderName;
  }
}
