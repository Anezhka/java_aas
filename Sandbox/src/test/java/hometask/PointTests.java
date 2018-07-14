package hometask;


import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance() {
    Point p1 = new Point(8, 2);
    Point p2 = new Point(5, 6);
    Assert.assertEquals(p2.getDistance(p1), 5.0);
  }


  @Test
  public void getDistance() {
    Point p1 = new Point(8, 2);
    Point p2 = new Point(5, 6);
    Assert.assertEquals(MySecondProgram.getDistance(p1, p2), 5.0);
  }
}