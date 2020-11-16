package jmm;

/**
 * 描述：     演示可见性带来的问题
 */
public class FieldVisibility {

    volatile int a = 1;
    volatile int b = 2;

    private void change() {
        a = 3;
        b = a;
    }

    private void print() {
        System.out.println("b=" + b + ";a=" + a);
    }

    public static void main(String[] args) {
        while (true) {
            FieldVisibility test = new FieldVisibility();
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.change();
            }).start();

            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.print();
            }).start();
        }
    }

    // 可能出现的四种情况
    // 1.a=3, b=2
    // 2.a=1, b=2
    // 3.a=3, b=3
    // 4.a=1, b=3 发生了可见性问题：两个线程在同一时刻看到同一变量的值可能会不相同

}
