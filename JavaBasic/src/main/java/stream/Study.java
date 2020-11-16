package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Study {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

//        List<String> filtered = strings.stream()
            strings.stream()
            .map(Study::isInclude).filter(Objects::nonNull)
            .filter(string -> !string.isEmpty())
            .forEach(System.out::println);
//                .collect(Collectors.toList());

//        filtered.forEach(System.out::println);

    }

    private static String isInclude(String v) {
        return v.startsWith("a") ? v : "";
    }
}
