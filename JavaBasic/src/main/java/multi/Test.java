package multi;

public class Test {

    public static void main(String[] args) {
        Father child = new Child();
        child.fun1();
//        child.fun1(1); //报错，child里没有方法fun1(int i)

//        Child child = new Child();
//        child.fun1();
//        child.fun1(1);
    }
}
