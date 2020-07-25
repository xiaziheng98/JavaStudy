package lambda.syntax;

import lambda.data.Person;

public class Synctax4 {

    public static void main(String[] args) {
        PersonCreater creater = () -> new Person();

        // 构造方法的引用：
        PersonCreater creater1 = Person::new;
        Person a = creater1.getPerson();

        PersonCreater2 creater2 = Person::new;
        Person b = creater2.getPerson("abc", 10);
    }
}


// 需求：
interface PersonCreater {
    Person getPerson();
}

interface PersonCreater2 {
    Person getPerson(String name, int age);
}