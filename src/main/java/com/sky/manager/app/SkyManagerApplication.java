package com.sky.manager.app;

import com.sky.manager.app.console.ConsoleApplication;

public final class SkyManagerApplication {

  private SkyManagerApplication() {
  }

  public static void main(String[] args) {
    new ConsoleApplication().run();
  }
}