package ru.stqa.aas.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.aas.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File (file));
    } else {
      System.out.println("Unrecognized format " + format);
    }

  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xStream = new XStream();
    xStream.processAnnotations(ContactData.class);
    String xml = xStream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstName(), contact.getMiddleName(), contact.getLastName(),
              contact.getNickname(), contact.getTitle(), contact.getCompany(), contact.getAddress(), contact.getHomePhone(),
              contact.getMobilePhone(), contact.getWorkPhone(), contact.getFax(), contact.getEmail(), contact.getEmail2(), contact.getEmail3(), contact.getGroup(), contact.getPhoto()));
    }
    writer.close();
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData()
      .withFirstName(String.format("Ivan %s", i))
      .withMiddleName(String.format("Ivanovich %s", i))
      .withLastName(String.format("Ivanov %s", i))
      .withNickname(String.format("Ivaha %s", i))
      .withTitle(String.format("Boss %s", i))
      .withCompany(String.format("WSAB %s", i))
      .withAddress(String.format("Finland, Helsinki, Tehtankatu, 35 %s", i))
      .withHomePhone(String.format("+358777777 %s", i))
      .withMobilePhone(String.format("+358555555 %s", i))
      .withWorkPhone(String.format("+358333333 %s", i))
      .withFax(String.format("+358999999 %s", i))
      .withEmail(String.format("boss@gmail.com %s", i))
      .withEmail2(String.format("bos@mail.ru %s", i))
      .withEmail3(String.format("bosya@yandex.ru %s", i))
      .withGroup(String.format("test1"))
      .withPhoto(String.format("src/test/resources/stru.png"))
      );
    }
    return contacts;
  }
}
