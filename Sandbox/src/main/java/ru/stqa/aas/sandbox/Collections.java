package ru.stqa.aas.sandbox;

import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }
   }
  }



 //for (int i = 0; i < langs.length; i++) {
        //System.out.println("Я хочу выучить " + langs[i]);
        //}


  //List<String> languages = new ArrayList<String>();
    //languages.add("Java");
          //  languages.add("C#");
          //  languages.add("Python");


