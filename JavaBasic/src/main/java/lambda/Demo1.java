package lambda;

public class Demo1 {
    public static void main(String[] args) {

        // 1.使用接口实现类
        Comparator comparator = new MyComparator();

        // 2.使用匿名内部类
        Comparator comparator1 = new Comparator() {
            @Override
            public int compare(int a, int b) {
                return a - b;
            }
        };

        // 3.lambda实现,lambda对接口的要求：接口声明的抽象方法只能有一个
        Comparator comparator2 = (a, b) -> a - b;

    }
}

class MyComparator implements Comparator {
    @Override
    public int compare(int a, int b) {
        return a - b;
    }
}

@FunctionalInterface
//修饰函数式接口，接口中的抽象方法只能有一个
interface Comparator {
    int compare(int a, int b);
}
