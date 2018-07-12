package ru.stqa.aas.sandbox;

public class MyFirstProgram {

public static void main(String[] args) {
hello("world");
  hello("user");
  hello("Anna");

  Square s = new Square(5);
 // Square s2 = new Square(6);
  System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

  Reqtangle r = new Reqtangle(4, 6);
  System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
}

public static void hello(String somebody) {
  System.out.println("Hello," + somebody + "!");
}


}