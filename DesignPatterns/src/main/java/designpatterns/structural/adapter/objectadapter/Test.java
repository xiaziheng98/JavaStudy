package designpatterns.structural.adapter.objectadapter;

/**
 * Created by geely
 * 对象适配器：通过组合模式实现
 */
public class Test {
    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();



    }
}
