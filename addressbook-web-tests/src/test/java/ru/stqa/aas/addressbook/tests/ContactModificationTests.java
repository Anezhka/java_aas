package ru.stqa.aas.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.aas.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Ivan", "Ivanovich", "Ivanov", "Ivaha", "Boss", "WSAB", "Finland, Helsinki, Tehtankatu, 35", "+358777777", "+358555555", "+358333333", "+358999999", "boss@gmail.com", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Petr", "Ivanovich", "Sidorov", "Ivaha", "Boss", "WSAB", "Finland, Helsinki, Tehtankatu, 35", "+358777777", "+358555555", "+358333333", "+358999999", "boss@gmail.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() );
  }
}
