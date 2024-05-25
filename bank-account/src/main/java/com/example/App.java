package com.example;

import java.util.Scanner;
import com.example.models.Account;
import com.example.services.AccountService;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    AccountService accountService = new AccountService();
    char createAnotherAccount;

    do {
      Account newAccount = accountService.createAccount(scanner);
      accountService.showMessage(newAccount);

      System.out.print("Deseja criar outra conta? (S/N): ");
      createAnotherAccount = scanner.next().charAt(0);
      scanner.nextLine();
    } while (Character.toUpperCase(createAnotherAccount) == 'S');

    scanner.close();
  }
}
