package com.example.services;

import java.util.Scanner;
import com.example.models.Account;

public class AccountService {
  
  public Account createAccount(Scanner scanner) {
    String agency = readAgency(scanner);
    int number = readNumber(scanner);
    String clientName = readClientName(scanner);
    double balance = readBalance(scanner);

    return new Account(number, agency, clientName, balance);
  }

  private String readAgency(Scanner scanner) {
    String agency;
    do {
      System.out.print("Por favor, digite o número da Agência (no formato XXXX-X): ");
      agency = scanner.nextLine();
    } while (!validAgency(agency));
    return agency;
  }

  private boolean validAgency(String agencia) {
    return agencia.matches("\\d{4}-\\d");
  }

  private int readNumber(Scanner scanner) {
    int number;
    do {
      System.out.print("Por favor, digite o número da Conta: ");
      while (!scanner.hasNextInt()) {
        System.out.print("Por favor, digite um número válido: ");
        scanner.next();
      }
      number = scanner.nextInt();
      scanner.nextLine();
    } while (number <= 0);
    return number;
  }

  private String readClientName(Scanner scanner) {
    System.out.print("Por favor, digite o nome do Cliente: ");
    return scanner.nextLine();
  }

  private double readBalance(Scanner scanner) {
    double saldo;
    do {
      System.out.print("Por favor, digite o saldo: ");
      while (!scanner.hasNextDouble()) {
        System.out.print("Por favor, digite um saldo válido: ");
        scanner.next();
      }
      saldo = scanner.nextDouble();
      scanner.nextLine();
    } while (saldo < 0);
    return saldo;
  }

  public void showMessage(Account account) {
    System.out.println("Olá " + account.getClientName() + ", obrigado por criar uma conta em nosso banco, sua agência é "
        + account.getAgency() + ", conta " + account.getNumber() + " e seu saldo $ " + account.getBalance()
        + " já está disponível para saque.");
  }
}
