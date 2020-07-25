package lambda.syntax;

import lambda.interfaces.NoneReturnMutipleParam;
import lambda.interfaces.NoneReturnSingleParam;
import lambda.interfaces.SingleReturnMutipleParam;
import lambda.interfaces.SingleReturnNoneParam;

public class Synctax2 {
    public static void main(String[] args) {

        // 语法精简
        // 1.参数类型：
        // 由于在接口的抽象方法中，已经定义了参数的数量和类型，所以在lambda表达式中，参数的类型可以省略
        // 如果需要省略类型，则每一个参数的类型都要省略，千万不要出现有的省略，有的不省略
        NoneReturnMutipleParam lambda1 = (a, b) -> {
            System.out.println("hello world!");
        };

        // 2.参数小括号
        // 如果参数列表中，参数的数量只有一个，此时小括号可以省略
        NoneReturnSingleParam lambda2 = a -> {
            System.out.println("hello world!");
        };

        // 3.方法大括号
        // 如果方法体中只有一条语句，此时大括号可以省略
        NoneReturnSingleParam lambda3 = a -> System.out.println("hello world!");
        // 4.如果方法体中惟一的一条语句是一条返回语句，则在大括号可以省略的同时也必须省略掉return
        SingleReturnNoneParam lambda4 = () -> 10;

        SingleReturnMutipleParam lambda5 = (a, b) -> a + b;
    }
}
