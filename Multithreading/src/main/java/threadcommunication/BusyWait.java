package threadcommunication;

public class BusyWait {
    public static void main(String[] args) {
        MySignal mySignal = new MySignal();

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mySignal.setSignal(true);
        });

        Thread t2 = new Thread(() -> {
            try {
                while (!mySignal.getSignal()) {
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(1000);
                        System.out.println("i:" + i + " " + mySignal.getSignal());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
