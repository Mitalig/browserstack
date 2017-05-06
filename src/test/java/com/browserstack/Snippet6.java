package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Snippet6 {

  WebDriver driver;

  @Test
  public void test () {

    WebElement element = driver.findElement (By.xpath ("(.//*[@id='siblings']//following-sibling::div)[12]"));

    // or
    WebElement element1 = driver.findElement (By.xpath ("//div[text()='4.3']"));

  }

}
