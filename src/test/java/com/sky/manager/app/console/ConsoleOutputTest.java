package com.sky.manager.app.console;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

class ConsoleOutputTest {

  @Test
  void printlnShouldWriteMessageFollowedByLineSeparator() {
    ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
    ConsoleOutput output = new ConsoleOutput(new PrintStream(outputBuffer));

    output.println("Sky Manager");

    String content = outputBuffer.toString(StandardCharsets.UTF_8);
    assertEquals("Sky Manager" + System.lineSeparator(), content);
  }
}
