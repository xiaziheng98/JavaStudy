package sync;

/**
 *  对象锁示例1，代码块形式
 */
public class SynchronizedObjectCodeBlock2_1 implements Runnable{

    static SynchronizedObjectCodeBlock2_1 instance = new SynchronizedObjectCodeBlock2_1();

    @Override
    public void run() {

        // synchronized保证了两个线程串行执行
        synchronized (this) {
            System.out.println("lock对象锁代码块形式，当前线程名：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "lock运行结束");
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
