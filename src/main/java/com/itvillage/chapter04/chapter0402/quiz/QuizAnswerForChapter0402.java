package com.itvillage.chapter04.chapter0402.quiz;

import com.itvillage.common.Car;
import com.itvillage.common.CarType;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * 메서드 레퍼런스 퀴즈 문제 풀이
 */
public class QuizAnswerForChapter0402 {
    public static void main(String[] args) {
        Predicate<String> pp = String::isEmpty;
        System.out.println("Result1 : " + pp.test("11"));

        // 문제 2번
        Function<Integer, String> two = i -> String.valueOf(i);
        Function<Integer, String> two2 = String::valueOf;
        System.out.println("Result2 : " + two2.apply(11));

        // 문제 3번
        BiPredicate<List<Integer>, Integer> three = (list, num) -> list.contains(num);
        BiPredicate<List<Integer>, Integer> three2 = List::contains;
        System.out.println("Result3 : " + three2.test(Arrays.asList(11,22,33),11));

        //문제 4번
        Consumer<String> four = s -> System.out.println(s);
        Consumer<String> four2 = System.out::println;
        four2.accept("Result4 ");

        // 문제 5번
        BiFunction<String, CarType, Car> five = (s, carType) -> new Car(s, carType);
        BiFunction<String, CarType, Car> five2 = Car::new;
        Car fiveCar = five.apply("NewCar", CarType.SEDAN);
        System.out.println("Result5 : " + fiveCar.getCarName());




        System.out.println("\n\n\n\n\n\n\n\n\n");









        // 문제 1번
        Predicate<String> p1 = s -> s.isEmpty();

        // 문제 1번 정답
        Predicate<String> p2 = String::isEmpty;
        System.out.println("문제 1번 결과: " + p2.test("Not Empty"));

        // 문제 2번
        Function<Integer, String> f1 = i -> String.valueOf(i);

        // 문제 2번 정답
        Function<Integer, String> f2 = String::valueOf;
        System.out.println("문제 2번 결과: " + f2.apply(3));

        // 문제 3번
        BiPredicate<List<Integer>, Integer> bp1 = (list, num) -> list.contains(num);

        // 문제 3번 정답
        BiPredicate<List<Integer>, Integer> bp2 = List::contains;
        System.out.println("문제 3번 결과: " + bp2.test(Arrays.asList(1, 3, 5, 7, 9), 9));

        //문제 4번
        Consumer<String> c1 = s -> System.out.println(s);

        // 문제 4번 정답
        Consumer<String> c2 = System.out::println;
        c2.accept("문제 4번 결과: Hello!");

        // 문제 5번
        BiFunction<String, CarType, Car> bf1 = (s, carType) -> new Car(s, carType);

        // 문제 5번 정답
        BiFunction<String, CarType, Car> bf2 = Car::new;
        Car car = bf2.apply("말리부", CarType.SEDAN);
        System.out.println("문제 5번 결과: " + car.getCarName() + " / " + car.getCarType());
    }
}
