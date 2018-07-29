package ru.stqa.aas.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.aas.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {
  //тестовый фреймворк создает объект этого класса...

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }

}
