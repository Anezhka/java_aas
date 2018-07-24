package ru.stqa.aas.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.aas.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {
  //тестовый фреймворк создает объект этого класса...

  @Test
  public void testGroupCreation() {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
  }

}
