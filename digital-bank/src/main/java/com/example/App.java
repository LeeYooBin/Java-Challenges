package com.example;

import com.example.models.*;
import com.example.services.TransferService;

import java.util.Scanner;

public class App {
  private static Bank bank = new Bank();
  private static TransferService transferService = new TransferService();
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
      System.out.println(menu());
      System.out.print("Selecione uma opção: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          addCustomer();
          break;
        case 2:
          addAccountToCustomer();
          break;
        case 3:
          deposit();
          break;
        case 4:
          withdraw();
          break;
        case 5:
          transfer();
          break;
        case 6:
          printAccountStatements();
          break;
        case 7:
          System.exit(0);
          break;
        default:
          System.out.println("Escolha inválida, tente novamente.");
      }
    }
  }

  private static String menu() {
    return String.join("\n",
        "\n",
        "1. Adicionar Cliente",
        "2. Adicionar Conta ao Cliente",
        "3. Depósito",
        "4. Saque",
        "5. Transferência",
        "6. Imprimir Extrato da Conta",
        "7. Sair"
    );
  }

  private static void addCustomer() {
    System.out.print("Digite o nome do cliente: ");
    String name = scanner.nextLine();
    Customer customer = new Customer(name);
    bank.addCustomer(customer);
    System.out.println("Cliente adicionado com sucesso.");
  }

  private static void addAccountToCustomer() {
    System.out.print("Digite o nome do cliente: ");
    String customerName = scanner.nextLine();
    Customer customer = findCustomerByName(customerName);
    
    if (customer == null) {
      System.out.println("Cliente não encontrado.");
      return;
    }

    System.out.print("Digite o saldo inicial: ");
    Double initialBalance = scanner.nextDouble();
    scanner.nextLine();

    System.out.print("Escolha o tipo de conta (1: Corrente, 2: Poupança): ");
    int accountType = scanner.nextInt();
    scanner.nextLine();

    Account account;
    if (accountType == 1) {
      account = new CheckingAccount(customerName, initialBalance);
    } 
    else if (accountType == 2) {
      account = new SavingsAccount(customerName, initialBalance);
    } 
    else {
      System.out.println("Tipo de conta inválido.");
      return;
    }

    customer.addAccount(account);
    System.out.println("Conta adicionada com sucesso.");
  }

  private static void deposit() {
    Account account = findAccountByCustomerName();
    if (account == null) return;

    System.out.print("Digite o valor do depósito: ");
    Double amount = scanner.nextDouble();
    scanner.nextLine();

    account.deposit(amount);
    System.out.println("Depósito realizado com sucesso.");
  }

  private static void withdraw() {
    Account account = findAccountByCustomerName();
    if (account == null) return;

    System.out.print("Digite o valor do saque: ");
    Double amount = scanner.nextDouble();
    scanner.nextLine();

    try {
      account.withdraw(amount);
      System.out.println("Saque realizado com sucesso.");
    } 
    catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  private static void transfer() {
    System.out.print("Digite o nome do cliente de origem: ");
    String sourceCustomerName = scanner.nextLine();
    Account fromAccount = findAccountByCustomerName(sourceCustomerName);
    if (fromAccount == null) return;

    System.out.print("Digite o nome do cliente de destino: ");
    String destinationCustomerName = scanner.nextLine();
    Account toAccount = findAccountByCustomerName(destinationCustomerName);
    if (toAccount == null) return;

    System.out.print("Digite o valor da transferência: ");
    Double amount = scanner.nextDouble();
    scanner.nextLine();

    try {
      transferService.transfer(fromAccount, toAccount, amount);
      System.out.println("Transferência realizada com sucesso.");
    } 
    catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  private static void printAccountStatements() {
    Account account = findAccountByCustomerName();
    if (account == null) return;

    account.printAccountStatements();
  }

  private static Customer findCustomerByName(String name) {
    return bank.getCustomers().stream()
        .filter(customer -> customer.getName().equalsIgnoreCase(name))
        .findFirst()
        .orElse(null);
  }

  private static Account findAccountByCustomerName() {
    System.out.print("Digite o nome do cliente: ");
    String customerName = scanner.nextLine();
    return findAccountByCustomerName(customerName);
  }

  private static Account findAccountByCustomerName(String customerName) {
    Customer customer = findCustomerByName(customerName);
    if (customer == null) {
      System.out.println("Cliente não encontrado.");
      return null;
    }

    if (customer.getAccounts().isEmpty()) {
      System.out.println("Nenhuma conta encontrada para este cliente.");
      return null;
    }

    return customer.getAccounts().get(0);
  }
}
