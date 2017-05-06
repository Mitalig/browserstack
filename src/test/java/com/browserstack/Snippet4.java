package com.browserstack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Snippet4 {

  WebDriver driver;

  @Test
  public void test () {

    WebElement e1 = driver.findElement (By.xpath ("xpath"));
    WebElement e2 = driver.findElement (By.xpath ("xpath"));

    Actions actions = new Actions (driver);
    Action dragAndDrop = actions.clickAndHold (e1)

        .moveToElement (e2)

        .release (e2)

        .build ();

    dragAndDrop.perform ();

  }
}
