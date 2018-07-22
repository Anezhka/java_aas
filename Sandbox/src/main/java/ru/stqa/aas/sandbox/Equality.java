package ru.stqa.aas.sandbox;

public class Equality {
  public static void main(String[] args) {
    String s1 = "firefox";
    String s2 = new String (s1);

    System.out.println(s1 == s2); // == говорит, что не равны. Сравнение ссылок, идентичность объектов,
    // проверка, что ссылки ссылаются на один и тот же объект
    System.out.println(s1.equals(s2)); // equals говорит, что равны, сравнивает содержимое объекта
  }
}
