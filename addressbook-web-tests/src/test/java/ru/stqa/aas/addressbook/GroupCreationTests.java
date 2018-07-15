package ru.stqa.aas.addressbook;


import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {
  //тестовый фреймворк создает объект этого класса...

  @Test
  public void testGroupCreation() {

    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
