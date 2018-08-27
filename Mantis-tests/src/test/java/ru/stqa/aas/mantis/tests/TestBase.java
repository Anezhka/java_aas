package ru.stqa.aas.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.aas.mantis.appmanager.ApplicationManager;

public class TestBase { //родительский класс


  public static ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws Exception {  //потом выполняет метод setUp
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }
}
