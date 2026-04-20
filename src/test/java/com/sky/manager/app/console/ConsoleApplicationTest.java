package com.sky.manager.app.console;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

class ConsoleApplicationTest {

  @Test
  void runShouldPrintMenuAndExitWhenChoosingQuitOption() {
    String simulatedInput = "9\n";
    ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();

    ConsoleApplication application = new ConsoleApplication(
        new ByteArrayInputStream(simulatedInput.getBytes(StandardCharsets.UTF_8)),
        new PrintStream(outputBuffer));

    application.run();

    String content = outputBuffer.toString(StandardCharsets.UTF_8);
    assertTrue(content.contains("================ Sky Manager ================"));
    assertTrue(content.contains("9. Quitter"));
  }

  @Test
  void runShouldDisplayUnknownOptionMessageForInvalidChoice() {
    String simulatedInput = "42\n9\n";
    ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();

    ConsoleApplication application = new ConsoleApplication(
        new ByteArrayInputStream(simulatedInput.getBytes(StandardCharsets.UTF_8)),
        new PrintStream(outputBuffer));

    application.run();

    String content = outputBuffer.toString(StandardCharsets.UTF_8);
    assertTrue(content.contains("Option inconnue."));
  }
}
