package com.minhojang.practice;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class OptionalPractice {
  public static void main(String[] args) {
//    optionalPractice1();
//    optionalPractice2();
//    optionalPractice3();
    optionalPractice4();
  }

  private static void optionalPractice1() {
    Optional<String> opt = Optional.ofNullable("자바 Optional 객체");
    System.out.println(opt.get());
  }

  private static void optionalPractice2() {
//    String s = "Optional Test";
    String s = null;
    Optional<String> opt = Optional.ofNullable(s);

    if (opt.isPresent())
      System.out.println(opt.get());
    else
      System.out.println("s is Null");
  }

  private static void optionalPractice3() {
    Optional<String> opt = Optional.empty();

    System.out.println(opt.orElse("빈 Optional 객체"));
    System.out.println(opt.orElseGet(String::new));
  }

  private static void optionalPractice4() {
    IntStream stream = IntStream.of(4, 2, 1, 3);
    OptionalInt result = stream.findFirst();

    result.ifPresent(System.out::println);
  }
}
