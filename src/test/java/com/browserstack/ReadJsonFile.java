package com.browserstack;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class ReadJsonFile {

  JSONParser parser = new JSONParser ();
  HashMap<String, Integer> windowsFirefox = new HashMap<String, Integer> ();
  HashMap<String, Integer> windowsChrome = new HashMap<String, Integer> ();
  HashMap<String, Integer> macChrome = new HashMap<String, Integer> ();
  HashMap<String, Integer> macFirefox = new HashMap<String, Integer> ();

  @Test
  public void readJson () throws FileNotFoundException, IOException, ParseException {

    JSONArray a = (JSONArray) parser
        .parse (new FileReader ("/Users/ashwin/work/learning/com.browserstack/resources/browsers.json"));

    for (Object o: a) {

      JSONObject browsers = (JSONObject) o;

      String browserName = (String) browsers.get ("browser");

      String browser = (String) browsers.get ("browser_version");

      int browserVersion = Integer.parseInt (browser.replaceAll ("[.][0-9]+$", ""));

      String osName = (String) browsers.get ("os");

      if (osName.equals ("Windows") && browserName.equals ("Firefox")) {
        windowsFirefox.put (browserName + UUID.randomUUID (), browserVersion);
      }

      if (osName.equals ("Windows") && browserName.equals ("Chrome")) {
        windowsChrome.put (browserName + UUID.randomUUID (), browserVersion);
      }

      if (osName.equals ("OS X") && browserName.equals ("Chrome")) {
        macChrome.put (browserName + UUID.randomUUID (), browserVersion);
      }

      if (osName.equals ("OS X") && browserName.equals ("Firefox")) {
        macFirefox.put (browserName, browserVersion);
      }

    }

    printNames (windowsFirefox, "Firefox", "Windows");
    printNames (windowsChrome, "Chrome", "Windows");
    printNames (macFirefox, "Firefox", "OS X");
    printNames (macChrome, "Chrome", "OS X");

  }

  public void printNames (HashMap<String, Integer> windows, String browser, String os) {

    Map.Entry<String, Integer> maxEntry = null;

    for (Map.Entry<String, Integer> entry: windows.entrySet ()) {

      if (maxEntry == null || entry.getValue ().compareTo (maxEntry.getValue ()) > 0) {
        maxEntry = entry;
      }
    }

    System.out.println ("latest " + browser + " version in " + os + " " + maxEntry.getValue ());

  }
}