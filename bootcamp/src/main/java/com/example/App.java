package com.example;

import com.example.models.*;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    Bootcamp bootcamp = new Bootcamp("Java Developer Bootcamp", "Bootcamp intensivo de Java");
    Dev dev = new Dev("João");

    while (true) {
      System.out.println(menu());
      System.out.print("Selecione uma opção: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          addCourseToBootcamp(bootcamp);
          break;
        case 2:
          addMentoringToBootcamp(bootcamp);
          break;
        case 3:
          enrollDevInBootcamp(dev, bootcamp);
          break;
        case 4:
          completeCourse(dev);
          break;
        case 5:
          completeMentoring(dev);
          break;
        case 6:
          printDevProgress(dev);
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
            "1. Adicionar Curso ao Bootcamp",
            "2. Adicionar Mentoria ao Bootcamp",
            "3. Inscrever Dev no Bootcamp",
            "4. Completar Curso",
            "5. Completar Mentoria",
            "6. Imprimir Progresso do Dev",
            "7. Sair"
    );
  }

  private static void addCourseToBootcamp(Bootcamp bootcamp) {
    System.out.print("Digite o título do curso: ");
    String title = scanner.nextLine();
    System.out.print("Digite a descrição do curso: ");
    String description = scanner.nextLine();
    System.out.print("Digite a carga horária do curso: ");
    int workload = scanner.nextInt();
    scanner.nextLine();

    Course course = new Course(title, description, workload);
    bootcamp.addCourse(course);
    System.out.println("Curso adicionado ao bootcamp com sucesso.");
  }

  private static void addMentoringToBootcamp(Bootcamp bootcamp) {
    System.out.print("Digite o título da mentoria: ");
    String title = scanner.nextLine();
    System.out.print("Digite a descrição da mentoria: ");
    String description = scanner.nextLine();
    System.out.print("Digite a data da mentoria (YYYY-MM-DD): ");
    String date = scanner.nextLine();

    Mentoring mentoring = new Mentoring(title, description, LocalDate.parse(date));
    bootcamp.addMentoring(mentoring);
    System.out.println("Mentoria adicionada ao bootcamp com sucesso.");
  }

  private static void enrollDevInBootcamp(Dev dev, Bootcamp bootcamp) {
    for (Course course : bootcamp.getCourses()) {
      dev.enrollInCourse(course);
    }
    for (Mentoring mentoring : bootcamp.getMentorings()) {
      dev.enrollInMentoring(mentoring);
    }
    System.out.println("Dev inscrito no bootcamp com sucesso.");
  }

  private static void completeCourse(Dev dev) {
    System.out.print("Digite o título do curso a completar: ");
    String title = scanner.nextLine();
    Course course = dev.getEnrolledCourses().stream()
          .filter(c -> c.getTitle().equalsIgnoreCase(title))
          .findFirst()
          .orElse(null);

    if (course != null) {
      dev.completeCourse(course);
      System.out.println("Curso completado com sucesso.");
    } 
    else {
      System.out.println("Curso não encontrado ou não está matriculado.");
    }
  }

  private static void completeMentoring(Dev dev) {
    System.out.print("Digite o título da mentoria a completar: ");
    String title = scanner.nextLine();
    Mentoring mentoring = dev.getEnrolledMentorings().stream()
          .filter(m -> m.getTitle().equalsIgnoreCase(title))
          .findFirst()
          .orElse(null);

    if (mentoring != null) {
      dev.completeMentoring(mentoring);
      System.out.println("Mentoria completada com sucesso.");
    } 
    else {
      System.out.println("Mentoria não encontrada ou não está matriculada.");
    }
  }

  private static void printDevProgress(Dev dev) {
    System.out.println("Progresso do Dev:");
    System.out.println(dev);
  }
}
