package com.example.services;

import com.example.exceptions.InvalidParametersException;
import com.example.exceptions.InvalidInputException;
import java.util.Scanner;

public class CounterService {

  public void count(int param1, int param2) throws InvalidParametersException {
    if (param1 >= param2) {
      throw new InvalidParametersException("O segundo parâmetro deve ser maior que o primeiro");
    }

    for (int i = 1; i <= param2 - param1; i++) {
      System.out.println("Imprimindo o número " + i);
    }
  }

  public int readInteger(Scanner scanner) throws InvalidInputException {
    if (!scanner.hasNextInt()) {
      throw new InvalidInputException("Entrada inválida. Por favor, digite um número inteiro.");
    }
    return scanner.nextInt();
  }
}
