package singleton;

/**
 * 描述：     双重检查（推荐面试使用）
 */
public class Singleton6 {

    // 使用volatile是因为创建对象不是原子操作，经历了三个步骤：
    // 1.
    // 2.
    // 3.
    private volatile static Singleton6 instance;

    private Singleton6() {

    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
