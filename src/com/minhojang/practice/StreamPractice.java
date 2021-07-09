package com.minhojang.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {
  public static void main(String[] args) {
//    streamPractice1();
//    streamPractice2();
//    streamPractice3();
//    streamPractice4();
//    streamPractice5();
//    streamPractice6();
//    streamPractice7();
//    streamPractice8();
//    streamPractice9();
//    streamPractice10();
//    streamPractice11();
//    streamPractice12();
//    streamPractice13();
//    streamPractice14();
//    streamPractice15();
//    streamPractice16();
//    streamPractice17();
//    streamPractice18();
//    streamPractice19();
    streamPractice20();
  }

  private static void streamPractice1() {
    ArrayList<Integer> list = new ArrayList<>();

    list.add(4);
    list.add(2);
    list.add(3);
    list.add(1);

    Stream<Integer> stream = list.stream();
    stream.forEach(System.out::println);
  }

  private static void streamPractice2() {
    String[] arr = new String[] {"넷", "둘", "셋", "하나"};

    Stream<String> stream = Arrays.stream(arr);
    stream.forEach(e -> System.out.print(e + " "));
    System.out.println();

    Arrays.stream(arr, 1, 3).forEach(e -> System.out.print(e + " "));
  }

  private static void streamPractice3() {
    Stream<Double> stream = Stream.of(4.2, 5.5, 3.1, 1.9);
    stream.forEach(System.out::println);
  }

  private static void streamPractice4() {
    IntStream stream1 = IntStream.range(1, 4);
    stream1.forEach(e -> System.out.print(e + " "));
    System.out.println();

    IntStream stream2 = IntStream.rangeClosed(1, 4);
    stream2.forEach(e -> System.out.print(e + " "));
  }

  private static void streamPractice5() {
    IntStream stream = new Random().ints(4);
    stream.forEach(System.out::println);
  }

  private static void streamPractice6() {
    Stream<Integer> stream = Stream.iterate(2, n -> n+2);
    stream.limit(10).forEach(System.out::println);
  }

  private static void streamPractice7() {
    IntStream stream1 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
    IntStream stream2 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);

    stream1.distinct().forEach(e -> System.out.print(e + " "));
    System.out.println();

    stream2.filter(n -> n%2 != 0).forEach(e -> System.out.print(e + " "));
  }

  private static void streamPractice8() {
    Stream<String> stream = Stream.of("HTML", "CSS", "JAVA", "JAVASCRIPT");
    stream.map(String::length).forEach(System.out::println);
  }

  private static void streamPractice9() {
    String[] arr = {"I study hard", "You study JAVA", "I am hungry"};
    Stream<String> stream = Arrays.stream(arr);
    stream.flatMap(s -> Stream.of(s.split(" "))).distinct().forEach(System.out::println);
  }

  private static void streamPractice10() {
    IntStream stream1 = IntStream.range(0, 10);
    IntStream stream2 = IntStream.range(0, 10);
    IntStream stream3 = IntStream.range(0, 10);

    stream1.skip(4).forEach(n -> System.out.print(n + " "));
    System.out.println();

    stream2.limit(5).forEach(n -> System.out.print(n + " "));
    System.out.println();

    stream3.skip(3).limit(5).forEach(n -> System.out.print(n + " "));
  }

  private static void streamPractice11() {
    Stream<String> stream1 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");
    Stream<String> stream2 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");

    stream1.sorted().forEach(s -> System.out.print(s + " "));
    System.out.println();

    stream2.sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " "));
  }

  private static void streamPractice12() {
    IntStream stream = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);

    stream.peek(s -> System.out.println("원본 : " + s))
            .skip(2)
            .peek(s -> System.out.println("skip(2) 후 : " + s))
            .limit(5)
            .peek(s -> System.out.println("limit(5) 후 : " + s))
            .sorted()
            .peek(s -> System.out.println("sorted() 후 : " + s))
            .forEach(System.out::println);
  }

  private static void streamPractice13() {
    Stream<String> stream = Stream.of("넷", "둘", "셋", "하나");
    stream.forEach(System.out::println);
  }

  private static void streamPractice14() {
    Stream<String> stream1 = Stream.of("넷", "둘", "셋", "하나");
    Stream<String> stream2 = Stream.of("넷", "둘", "셋", "하나");

    Optional<String> result1 = stream1.reduce((s1, s2) -> s1 + "++" + s2);
    result1.ifPresent(System.out::println);

    String result2 = stream2.reduce("시작: ", (s1, s2) -> s1 + "++" + s2);
    System.out.println(result2);
  }

  private static void streamPractice15() {
    IntStream stream1 = IntStream.of(4, 2, 7, 3, 5, 1, 6);
    IntStream stream2 = IntStream.of(4, 2, 7, 3, 5, 1, 6);

    OptionalInt result1 = stream1.sorted().findFirst();
    System.out.println(result1.getAsInt());

    OptionalInt result2 = stream2.sorted().findAny();
    System.out.println(result2.getAsInt());
  }

  private static void streamPractice16() {
    IntStream stream1 = IntStream.of(30, 90, 70, 10);
    IntStream stream2 = IntStream.of(30, 90, 70, 10);

    System.out.println(stream1.anyMatch(n -> n > 80));
    System.out.println(stream2.allMatch(n -> n > 80));
  }

  private static void streamPractice17() {
    IntStream stream1 = IntStream.of(30, 90, 70, 10);
    IntStream stream2 = IntStream.of(30, 90, 70, 10);

    System.out.println(stream1.count());
    System.out.println(stream2.max().getAsInt());
  }

  private static void streamPractice18() {
    IntStream stream1 = IntStream.of(30, 90, 70, 10);
    DoubleStream stream2 = DoubleStream.of(30.3, 90.9, 70.7, 10.1);

    System.out.println(stream1.sum());
//    System.out.println(stream2.average().getAsDouble());
    stream2.average().ifPresent(System.out::println);
  }

  private static void streamPractice19() {
    Stream<String> stream = Stream.of("넷", "둘", "하나", "셋");

    List<String> list = stream.collect(Collectors.toList());
    for (String s : list) System.out.print(s + " ");
  }

  private static void streamPractice20() {
    Stream<String> stream = Stream.of("HTML", "CSS", "JAVA", "PHP");

    Map<Boolean, List<String>> patition = stream.collect(Collectors.partitioningBy(s -> s.length() % 2 == 0));

    List<String> oddLengthList = patition.get(false);
    System.out.println(oddLengthList);

    List<String> evenLengthList = patition.get(true);
    System.out.println(evenLengthList);
  }
}
