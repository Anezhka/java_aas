package hometask.tests;

import hometask.model.ContactData;
import org.testng.annotations.Test;


public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {

    app.getNavigationHelper().gotoAddNewContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Ivan", "Ivanovich", "Ivanov", "Ivaha", "Boss", "WSAB", "Finland, Helsinki, Tehtankatu, 35", "+358777777", "+358555555", "+358333333", "+358999999", "boss@gmail.com"));
    app.getContactHelper().inputContactCreation();
    app.getContactHelper().returnToHomePage();
  }

}
