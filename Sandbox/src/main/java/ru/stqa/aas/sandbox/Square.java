package ru.stqa.aas.sandbox;

public class Square {

  public double l; //атрибут класса

  public Square(double l){    //конструктор класса- метод, который вызывается при создании объекта
    this.l = l;
  }
  public double area() {   //getArea
    return this.l * this.l;  //метод класса
  }

}
