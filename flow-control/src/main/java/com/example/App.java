package com.example;

import java.util.Scanner;
import com.example.exceptions.InvalidParametersException;
import com.example.exceptions.InvalidInputException;
import com.example.services.CounterService;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CounterService counter = new CounterService();

    try {
      System.out.print("Digite o primeiro parâmetro: ");
      int n1 = counter.readInteger(scanner);
      System.out.print("Digite o segundo parâmetro: ");
      int n2 = counter.readInteger(scanner);

      counter.count(n1, n2);
    } 
    catch (InvalidParametersException | InvalidInputException e) {
      System.out.println(e.getMessage());
    } 
    finally {
      scanner.close();
    }
  }
}
