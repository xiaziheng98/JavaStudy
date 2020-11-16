package reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ObjectPoolFactory {

    //定义一个对象池，前面是对象名，后面是实际对象
    private Map<String, Object> objectPool = new HashMap<>();

    /**
     *  定义一个创建对象的方法，该方法是通过Class对象的newInstance()方法来创建该Class对象对应类的实例
     *  该方法只要传入一个字符串类名，程序可以根据该类名生成Java对象
     *  参数 clazzName 是一个类的全限定类名
     */
    private Object createObjectByDefaultConstructor(String clazzName)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        //根据字符串来获取对应的Class对象
        Class<?> clazz = Class.forName(clazzName);

        //使用clazz对应类的默认构造器创建实例，默认构造器是无参构造
        return clazz.newInstance();
    }

    /**
     *  定义一个创建对象的方法，该方法是通过Constructor对象的getConstructor()方法来创建该Class对象对应类的实例
     *  该方法只要传入一个字符串类名，程序可以根据重载的构造器生成Java对象
     *  参数 clazzName 是一个类的全限定类名
     */
    private Object createObjectBySpecialConstructor(String clazzName)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

        //根据字符串来获取对应的Class对象
        Class<?> clazz = Class.forName(clazzName);

        //获取Book中带字符串参数的构造器
        Constructor ctor = clazz.getConstructor(String.class, String.class);

        //调用Constructor的newInstance方法创建对象
        return ctor.newInstance("1", "2");
    }

    /**
     *  定义一个创建对象的方法并调用该对象中指定的方法，该方法是通过Constructor对象的getConstructor()方法来创建该Class对象对应类的实例
     *  该方法只要传入一个字符串类名，程序可以根据重载的构造器生成Java对象并根据方法名调用指定的方法
     */
    private Object createObjectAndExecuteMethod(String clazzName)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

        //根据字符串来获取对应的Class对象
        Class<?> clazz = Class.forName(clazzName);

        //获取Book中带字符串参数的构造器
        Constructor ctor = clazz.getConstructor(String.class, String.class);

        //调用Constructor的newInstance方法创建对象
        Object book = ctor.newInstance("疯狂Java讲义", "李刚");
        Method mtd = clazz.getMethod("getName");
        Method mtd2 = clazz.getMethod("declaredMethod", int.class);

        return mtd.invoke(book) + " and " + mtd2.invoke(book, 1);
    }

    public static void main(String[] args) throws Exception {
        ObjectPoolFactory pf = new ObjectPoolFactory();

        Object book = pf.createObjectByDefaultConstructor("reflex.Book");
        Object book2 = pf.createObjectBySpecialConstructor("reflex.Book");
        Object book3 = pf.createObjectAndExecuteMethod("reflex.Book");

        System.out.println(book);
        System.out.println(book2);
        System.out.println(book3);
    }
}
