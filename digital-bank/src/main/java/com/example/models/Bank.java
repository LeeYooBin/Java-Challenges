package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Bank {
  private List<Customer> customers;

  public Bank() {
    this.customers = new ArrayList<>();
  }

  public void addCustomer(Customer customer) {
    if (customer == null) {
      throw new IllegalArgumentException("Customer must not be null.");
    }
    customers.add(customer);
  }

  public List<Customer> getCustomers() {
    return customers;
  }
}
