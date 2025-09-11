package lesson8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
//        List<String> list2 = Arrays.asList("123", "456", "789");
//        list2.set(1, "12");
//        List<String> list = List.of("a", "b", "c");
////        list.set(1, "d");
//        list.set(1, "d");

        List<Integer> listInt1 = Arrays.asList(1, 2, 3);
        List<Integer> listInt2 = Arrays.asList(1, 2, 3);

        System.out.println(listInt1.equals(listInt2));

        LinkedHashSet<Integer> linkedHashSet1 = new LinkedHashSet<>(listInt1);

        Integer i = 1;
        System.out.println(i.toString());

        int[] arr = new int[]{1, 2, 3};
        System.out.println(arr.toString());


    }
}
