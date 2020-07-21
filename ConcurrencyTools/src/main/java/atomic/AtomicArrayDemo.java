package atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 描述：     演示原子数组的使用方法
 */
public class AtomicArrayDemo {

    public static void main(String[] args) {
        //1000个原子变量，每个都被加了100次和减了100次
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(1000);//new一个原子整数数组，长度为1000
        Incrementer incrementer = new Incrementer(atomicIntegerArray);//new一个给数组的每个元素自加操作的对象
        Decrementer decrementer = new Decrementer(atomicIntegerArray);//new一个给数组的每个元素自减操作的对象
        Thread[] threadsIncrementer = new Thread[100];//线程数组，存放一百个加线程
        Thread[] threadsDecrementer = new Thread[100];//线程数组，存放一百个减线程
        for (int i = 0; i < 100; i++) {
            threadsDecrementer[i] = new Thread(decrementer);
            threadsIncrementer[i] = new Thread(incrementer);
            threadsDecrementer[i].start();
            threadsIncrementer[i].start();
        }

//        Thread.sleep(10000);
        for (int i = 0; i < 100; i++) {
            try {
                threadsDecrementer[i].join();
                threadsIncrementer[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            if (atomicIntegerArray.get(i)!=0) {
                System.out.println("发现了错误"+i);
            }
            System.out.println(atomicIntegerArray.get(i));
        }
        System.out.println("运行结束");
    }
}

class Decrementer implements Runnable {

    private AtomicIntegerArray array;

    public Decrementer(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndDecrement(i);
        }
    }
}

class Incrementer implements Runnable {

    private AtomicIntegerArray array;

    public Incrementer(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndIncrement(i);
        }
    }
}
