package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HtmlSnippet {

  WebDriver driver;
  
  public void test()  {
    
    WebElement element =driver.findElement (By.xpath ("//select[@id='dropdown']"));
    Select options = new Select(element);
    options.selectByVisibleText ("Option 2");
    
  }
}
