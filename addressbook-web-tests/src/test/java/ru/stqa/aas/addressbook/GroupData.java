package ru.stqa.aas.addressbook;

public class GroupData { //объект
  private final String name;  //три атрибута
  private final String header;
  private final String footer;

  public GroupData(String name, String header, String footer) { //конструктор инициализирует объекты значениями
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public String getName() {
    return name;
  }  //три метода, которые возвращают эти атрибуты

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }
}
