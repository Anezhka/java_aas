package ru.stqa.aas.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.aas.addressbook.model.GroupData;

import java.util.Set;


public class GroupCreationTests extends TestBase {
  //тестовый фреймворк создает объект этого класса...

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()); //преобразует объект в число
    before.add(group);
    Assert.assertEquals(before, after);
  }

}
