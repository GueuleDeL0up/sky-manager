package com.sky.manager.app.console;

import java.io.PrintStream;

public final class ConsoleOutput {

  private final PrintStream printStream;

  public ConsoleOutput(PrintStream printStream) {
    this.printStream = printStream;
  }

  public void println(String message) {
    printStream.println(message);
  }
}