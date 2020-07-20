package sync;

public class DisappearRequest1 implements Runnable{

    private static DisappearRequest1 instance = new DisappearRequest1();
    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(i);
    }

    @Override
    // 1.对象锁的方法锁
//    public synchronized void run() {
    public void run() {
        /*
            i++，它看上去只是一个操作，实际包含了三个操作
            1. 读取i，
            2. 将i加1
            3. 将i的值写入到内存中

            例如：t1线程读到i的值为9，把i加1，还没有写回到内存中，
                 此时t2也来读取i，值也为9，把i加1，
                 就出现了两次i的值为9，加1结果为10的情况
         */
        for (int j = 0; j < 100000; j++) {
            i++;
        }





        // 2.对象锁的代码块锁
//        synchronized (this) {
//            for (int j = 0; j < 100000; j++) {
//                i++;
//            }
//        }




        // 3.类锁的静态方法锁
//        method();




        // 4.类锁的字节码锁
//        synchronized (DisappearRequest1.class) {
//            for (int j = 0; j < 100000; j++) {
//                i++;
//            }
//        }
    }

    public static synchronized void method() {
        for (int j = 0; j < 100000; j++) {
            i++;
        }
    }
}
