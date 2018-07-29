package ru.stqa.aas.sandbox;

public class Primes {

  public static boolean isPrime(int n) {
    for (int i = 2; i < n; i++) {  //инкремент (i = i + 1), (i += 1)
      if (n % i == 0) {  //если остаток деления n на i равен 0, тогда число n непростое
        return false;
      }
    }
    return true; //значит число простое
  }

  public static boolean isPrime(long n) {
    for (long i = 2; i < n; i++) {
      if (n % i == 0) {
      }
    }
    return true;
  }

  public static boolean isPrimeFast(int n) {
    int m = (int) Math.sqrt(n);
    for (int i = 2; i < m; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeWhile(int n) {
    int i = 2;
    while (i < n && n % i != 0) {
      i++;
    }
    return i == n;
  }

}
