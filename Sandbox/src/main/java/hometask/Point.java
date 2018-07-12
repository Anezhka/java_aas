package hometask;

public class Point {
  public double x;  //объявить атрибуты
  public double y;

public Point(double X, double Y){   //конструктор
  this.x = X;
  this.y = Y;
}


  public double getDistance(Point anotherPoint) {    //метод
return Math.sqrt(Math.pow((this.x - anotherPoint.x), 2) + Math.pow((this.y - anotherPoint.y), 2));
  }
}

