package jmm;

import java.util.concurrent.CountDownLatch;

/**
 * 描述：     演示重排序的现象 “直到达到某个条件才停止”，测试小概率事件
 */
public class OutOfOrderExecution {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            CountDownLatch latch = new CountDownLatch(3);

            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.countDown();
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1; // 1
                    x = b; // 2
                }
            });
            Thread two = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.countDown();
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1; // 3
                    y = a; // 4
                }
            });
            // 这4行代码的执行顺序也就是两个线程的执行顺序决定了最终x和y的结果，一共有3种情况：
            // 1. a=1;x=b(0);b=1;y=a(1)，最终结果是x=0, y=1；线程one的1、2行执行完，线程two再执行3、4行
            // 2. b=1;y=a(0);a=1;x=b(1)，最终结果是x=1, y=0；线程two的3、4行执行完，线程one再执行1、2行
            // 3. a=1;b=1;x=b(1);y=a(1)，最终结果是x=1, y=1；线程one执行完第1行，线程two执行完第3行，线程one再执行第2行，线程two再执行第4行
            // 4. y=a(0);a=1;x=b(0);b=1，最终结果是x=0, y=0；线程two发生了指令重排
            // ------------    12-6    -------------
            one.start();
            two.start();
            latch.countDown();
            one.join();
            two.join();

            String result = "第" + i + "次（" + x + "," + y + ")";
            System.out.println(result);
            if (x == 1 && y == 1) {
                break;
            }
        }
    }


}
