package ru.stqa.aas.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.aas.addressbook.model.GroupData;
import ru.stqa.aas.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


  public class GroupCreationTests extends TestBase {



  @DataProvider
  public Iterator<Object[]> validGroupsFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xStream = new XStream();
      xStream.processAnnotations(GroupData.class);
      List<GroupData> groups = (List<GroupData>) xStream.fromXML(xml);
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {
      try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
        String json = "";
        String line = reader.readLine();
        while (line != null) {
          json += line;
          line = reader.readLine();
        }
        Gson gson = new Gson();
        List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
        }.getType()); //List<GroupData>.class
        return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
      }
    }

    //String[] split = line.split(";");
     //list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});

  @Test(dataProvider = "validGroupsFromJson")
  public void testGroupCreation(GroupData group) {
    app.goTo().groupPage();
    Groups before = app.db().groups();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));//может стоять до и после
    Groups after = app.db().groups();
    assertThat(after, equalTo(//преобразует объект в число
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))); //копия
    verifyGroupListInUI();
  }

  @Test (enabled = false)
  public void testBadGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test'");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));

  }
}
