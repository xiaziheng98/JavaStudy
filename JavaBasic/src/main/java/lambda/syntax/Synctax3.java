package lambda.syntax;

import com.lambda.interfaces.SingleReturnSingleParam;

public class Synctax3 {

    public static void main(String[] args) {

        // 方法引用
        // 可以快速的将一个lambda表达式的实现指向一个已经实现的方法
        // 语法：方法的隶属者（静态方法隶属者是类，非静态方法的隶属者是对象
        // 隶属者::对象
        // 注意：
        // 1.参数数量和类型一定要和接口中定义的参数数量和类型一致
        // 2.返回值的类型也一定要和接口中定义的方法一致
        SingleReturnSingleParam lambda1 = a -> change(a);

        // 方法引用
        SingleReturnSingleParam lambda2 = Synctax3::change;
        System.out.println(lambda2.test(2));
    }



    private static int change(int a) {
        return a * 2;
    }
}
