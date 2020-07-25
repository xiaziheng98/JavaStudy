package designpatterns.structural.adapter.classadapter;

/**
 * Created by geely
 * 类适配器模式，通过继承实现
 */
public class Test {
    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();



    }
}
