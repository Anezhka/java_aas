package ru.stqa.aas.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{


  public SessionHelper(WebDriver wd) {

    super(wd); //обращение к конструктору базового класса
  }
  public void login(String username, String password) {
    type(By.name("user"), username);
    type(By.name("pass"), password);

    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
