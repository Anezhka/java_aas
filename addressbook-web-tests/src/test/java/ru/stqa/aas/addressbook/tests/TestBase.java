package ru.stqa.aas.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.aas.addressbook.appmanager.ApplicationManager;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {  //потом выполняет метод setUp
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
