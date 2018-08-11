package ru.stqa.aas.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.aas.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstName("Ivan").withMiddleName("Ivanovich").withLastName("Ivanov").withNickname("Ivaha").withTitle("Boss").withCompany("WSAB").withAddress("Finland, Helsinki, Tehtankatu, 35").withHomePhone("+358777777").withMobilePhone("+358555555").withWorkPhone("+358333333").withFax("+358999999").withEmail("boss@gmail.com").withGroup("test1"), true);
    }
  }

  @Test
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Ivan").withMiddleName("Ivanovich").withLastName("Ivanov").withNickname("Ivaha").withTitle("Boss").withCompany("WSAB").withAddress("Finland, Helsinki, Tehtankatu, 35").withHomePhone("+358777777").withMobilePhone("+358555555").withWorkPhone("+358333333").withFax("+358999999").withEmail("boss@gmail.com");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() );

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after); //сравниваем множества До и После модификации
  }


}
