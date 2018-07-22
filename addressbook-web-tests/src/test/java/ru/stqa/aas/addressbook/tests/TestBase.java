package ru.stqa.aas.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.aas.addressbook.appmanager.ApplicationManager;

public class TestBase { //родительский класс

  public  ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeMethod
  public void setUp() throws Exception {  //потом выполняет метод setUp
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
