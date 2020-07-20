package lambda.syntax;

import com.lambda.interfaces.*;

public class Synctax1 {

    public static void main(String[] args) {

        // 基础语法
        // lambda是一个匿名函数
        // 参数列表 方法体 （返回值类型 方法名

        // () ：用来描述参数列表
        // {} ：用来描述方法体
        // -> : lambda运算符，读作goes to

        // 无返回无参
        NoneReturnNoneParam lambda1 = () -> {
            System.out.println("hello world!");
        };
        lambda1.test();

        // 无返回单参
        NoneReturnSingleParam lambda2 = (int a) -> {
            System.out.println(a);
        };
        lambda2.test(2);

        // 无返回多参
        NoneReturnMutipleParam lambda3 = (int a, int b) -> {
            System.out.println(a + b);
        };
        lambda3.test(10, 20);

        // 有返回值无参
        SingleReturnNoneParam lambda4 = () -> {
            System.out.println("lambada4");
            return 100;
        };
        System.out.println(lambda4.test());

        // 有返回值单参
        SingleReturnSingleParam lambda5 = (int a) -> {
            return a*2;
        };
        System.out.println(lambda5.test(20));

        // 有返回值多参
        SingleReturnMutipleParam lambda6 = (int a, int b) -> {
            return a + b;
        };
        System.out.println(lambda6.test(20, 30));
    }
}
