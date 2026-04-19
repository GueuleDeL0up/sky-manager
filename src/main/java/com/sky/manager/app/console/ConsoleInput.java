package com.sky.manager.app.console;

import java.io.PrintStream;
import java.util.Scanner;

public final class ConsoleInput {

  private final Scanner scanner;
  private final PrintStream printStream;

  public ConsoleInput(Scanner scanner, PrintStream printStream) {
    this.scanner = scanner;
    this.printStream = printStream;
  }

  public String readNonBlank(String prompt) {
    while (true) {
      printStream.print(prompt);
      String value = scanner.nextLine().trim();
      if (!value.isEmpty()) {
        return value;
      }
      printStream.println("Valeur obligatoire.");
    }
  }

  public int readInt(String prompt) {
    while (true) {
      String value = readNonBlank(prompt);
      try {
        return Integer.parseInt(value);
      } catch (NumberFormatException exception) {
        printStream.println("Veuillez saisir un nombre entier.");
      }
    }
  }
}