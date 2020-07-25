package lambda.exercise;

import lambda.data.Person;

import java.util.ArrayList;

public class Exercise1 {
    // 集合排序
    // ArrayList<>

    public static void main(String[] args) {
        // 需求：已知在一个ArrayList中有若干个Person对象，将这些Person对象按照年龄降序排序
        ArrayList<Person> list = new ArrayList<>();

        list.add(new Person("a", 10));
        list.add(new Person("b", 11));
        list.add(new Person("c", 12));
        list.add(new Person("d", 9));
        list.add(new Person("e", 9));
        list.add(new Person("f", 3));
        list.add(new Person("g", 40));

        list.sort((o1, o2) -> o2.age - o1.age);

        System.out.println(list);
        
        //视频P8
    }

}
