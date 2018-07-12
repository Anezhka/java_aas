package hometask;

public class MySecondProgram {
  public static void main(String[] args) {


    Point p1 = new Point(8, 2);   //создание объектов в новом классе Point
    Point p2 = new Point(5, 6);

    System.out.println(getDistance(p1, p2)); //вызвать функцию
    System.out.println(p2.getDistance(p1));  //вызвать метод

  }

  public static double getDistance(Point p1, Point p2){
    return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
  }

}

