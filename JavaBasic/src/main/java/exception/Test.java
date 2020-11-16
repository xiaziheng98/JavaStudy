package exception;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        System.out.println("front");

        try {
            int a = 1 / 0;
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("end");

    }

}
