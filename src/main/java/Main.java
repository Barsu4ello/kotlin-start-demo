import lesson8.generics.Box;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String test = null;
    public static void main(String[] args) {
        Object s = "sfdds";
        String n = "";
        List<Integer> list = List.of(1, 2, 3, 4, 5).stream().toList();

        if (s instanceof String str) {
            str.length();
        }

        fizzBuzz(12);

        Double a = 2.0;
        long b = 3L;
        getInt(b);
    }

    private static String fizzBuzz(int data) {
        return switch (data) {
            case 15, 30, 45 -> "FizzBuzz: " + data;
            case 3, 6, 9, 12 -> "Fizz: " + data;
            case 5, 10, 20, 25 -> "Buzz: " + data;
            default -> String.valueOf(data);
        };
    }

    public static void getInt(double d) {
        System.out.println("Test double");
    }

    public static void getInt(long d) {
        System.out.println("Test long");
    }

    public static <T> T getFirstElement(List<T> list) {
        return list.get(0);
    }

}






