package ru.stqa.aas.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.aas.addressbook.model.GroupData;
import ru.stqa.aas.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {
  //тестовый фреймворк создает объект этого класса...

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after.size(), equalTo(before.size() + 1));//может стоять до и после

    assertThat(after, equalTo(//преобразует объект в число
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))); //копия

  }

}
