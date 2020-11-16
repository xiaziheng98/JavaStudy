package hashcode;

import java.util.UUID;

public class Same {
    public static void main(String[] args) {
        String a = "ABCDEa123abc";
        String b = "ABCDFB123abc";

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        System.out.println(UUID.randomUUID().toString());
    }
}
