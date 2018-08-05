package ru.stqa.aas.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.aas.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Ivan", "Ivanovich", "Ivanov", "Ivaha", "Boss", "WSAB", "Finland, Helsinki, Tehtankatu, 35", "+358777777", "+358555555", "+358333333", "+358999999", "boss@gmail.com", "test1");
    app.getContactHelper().createContact(contact, true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
