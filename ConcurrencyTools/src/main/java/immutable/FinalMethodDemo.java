package immutable;

/**
 * 描述：     final的方法
 */
public class FinalMethodDemo {

    public void drink() {

    }

    public final void eat() {
        System.out.println("test");
    }

    public static void sleep() {

    }
}

class SubClass extends FinalMethodDemo {

    @Override
    public void drink() {
        super.drink();
        eat();
    }

//    public final void eat() {
//
//    }
    public static void sleep() {

    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.eat();
    }
}