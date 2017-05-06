package com.browserstack;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Snippet5 {

  @Test
  public void test (WebDriver driver) {

    new WebDriverWait (driver, 30).until ((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
        .executeScript ("return document.readyState").equals ("complete"));

  }
}
