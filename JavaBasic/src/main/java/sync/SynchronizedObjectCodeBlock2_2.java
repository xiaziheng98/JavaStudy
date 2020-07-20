package sync;

/**
 * 对象锁示例1，代码块形式
 */
public class SynchronizedObjectCodeBlock2_2 implements Runnable{

    static SynchronizedObjectCodeBlock2_2 instance = new SynchronizedObjectCodeBlock2_2();

    final Object lock1 = new Object();
    final Object lock2 = new Object();

    @Override
    public void run() {
        // synchronized保证了两个线程串行执行
        synchronized (lock1) {
            System.out.println("lock1对象锁代码块形式，当前线程名：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "lock1运行结束");
        }

        // 如果把 lock2 换成 lock1，再看效果
        synchronized (lock2) {
            System.out.println("lock2对象锁代码块形式，当前线程名：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "lock2运行结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {
        }
        System.out.println("finished");
    }
}
