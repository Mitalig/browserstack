package com.browserstack;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Snippet3 {

  WebDriver driver;

  public void test () {

    String firstWinHandle = driver.getWindowHandle ();
    driver.findElement (By.xpath ("xpath")).click ();
    Set handles = driver.getWindowHandles ();

    handles.remove (firstWinHandle);

    for (String handle1: driver.getWindowHandles ()) {

      driver.switchTo ().window (handle1);
      System.out.println ("The title of new window is " + driver.getTitle ());
      driver.switchTo ().window (firstWinHandle);

    }

  }
}
