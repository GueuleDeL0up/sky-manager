package com.sky.manager.app.console;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class ConsoleInputTest {

  @Test
  void readNonBlankShouldSkipBlankLinesAndReturnTrimmedValue() {
    String simulatedInput = "   \n\n  Paris-CDG  \n";
    ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();

    ConsoleInput consoleInput = new ConsoleInput(
        new Scanner(new ByteArrayInputStream(simulatedInput.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8),
        new PrintStream(outputBuffer));

    String value = consoleInput.readNonBlank("Aeroport: ");

    assertEquals("Paris-CDG", value);
  }

  @Test
  void readIntShouldRetryUntilValidIntegerIsProvided() {
    String simulatedInput = "abc\n  \n12\n";
    ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();

    ConsoleInput consoleInput = new ConsoleInput(
        new Scanner(new ByteArrayInputStream(simulatedInput.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8),
        new PrintStream(outputBuffer));

    int value = consoleInput.readInt("Numero: ");

    assertEquals(12, value);
  }
}
