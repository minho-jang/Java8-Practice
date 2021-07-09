package com.minhojang.practice;

import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

public class LambdaPractice {
  public static void main(String[] args) {
//    lambdaTest1();
//    lambdaTest2();
//    lambdaTest3();
//    lambdaTest4();
    lambdaTest5();
  }

  private static void lambdaTest1() {
    new Thread(new Runnable() {
      public void run() {
        System.out.println("전통적인 방식의 일회용 스레드 생성");
      }
    }).start();

    new Thread(() -> System.out.println("람다 표현식을 사용한 일회용 스레드 생성")).start();
  }

  private static void lambdaTest2() {
    Calc minNum = (x, y) -> x < y ? x : y;
    System.out.println(minNum.min(3, 4));
  }

  @FunctionalInterface
  private interface Calc {
    int min(int x, int y);  // 오직 1개의 추상메소드를 가진다.
  }

  private static void lambdaTest3() {
    MyClass obj = new MyClass();
//    Function<Integer, Integer> func = (a) -> obj.makeDouble(a);
    Function<Integer, Integer> func = obj::makeDouble;
    System.out.println(func.apply(10));
  }

  static class MyClass {
    int makeDouble(int n) {
      return n * 2;
    }
  }

  private static void lambdaTest4() {
    DoubleUnaryOperator oper;
    oper = (n) -> Math.abs(n);
    System.out.println(oper.applyAsDouble(-5));

    oper = Math::abs;
    System.out.println(oper.applyAsDouble(-5));
  }

  private static void lambdaTest5() {
    Function<Integer, double[]> func1 = a -> new double[a];
    Function<Integer, double[]> func2 = double[]::new;
    System.out.println(Arrays.toString(func2.apply(5)));
  }

}
