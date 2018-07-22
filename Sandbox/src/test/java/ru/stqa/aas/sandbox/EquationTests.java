package ru.stqa.aas.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {

  @Test
  public void test0(){ //тест для ситуации, когда решений у уравнения нет
Equation e = new Equation(1, 1, 1);
Assert.assertEquals(e.rootNumber(), 0); //у этого уравнения решений нет
  }

  @Test
  public void test1(){ //тест для ситуации, когда 1 решение
    Equation e = new Equation(1, 2, 1);
    Assert.assertEquals(e.rootNumber(), 1); //у этого уравнения 1 решение
  }

  @Test
  public void test2(){ //тест для ситуации, когда решений 2 решения
    Equation e = new Equation(1, 5, 6);
    Assert.assertEquals(e.rootNumber(), 2); //у этого уравнения 2 решения
  }

  @Test
  public void testLinear(){ //тест для ситуации, когда решений 2 решения
    Equation e = new Equation(0, 1, 1);
    Assert.assertEquals(e.rootNumber(), 1); //у этого уравнения 1 корень
  }

  @Test
  public void testConstant(){ //тест для ситуации, когда решений 2 решения
    Equation e = new Equation(0, 0, 1);
    Assert.assertEquals(e.rootNumber(), 0); //у этого уравнения корней 0
  }

  @Test
  public void testZero(){ //тест для ситуации, когда решений 2 решения
    Equation e = new Equation(0, 0, 0);
    Assert.assertEquals(e.rootNumber(), -1); //у этого уравнения корней -1 (бесконечно много)
  }
}
