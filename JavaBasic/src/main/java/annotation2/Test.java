package annotation2;

import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args) {
        Student student = new Student();

        student.setMobile("123456789");

        try {
            System.out.println(Test.validate(student));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*
        validate什么时候会执行到呢，在哪调用呢
        原先在哪里做的判断，这个就写在哪里，如果想再进一步自动化，可以结合spring的AOP在方法进入时拦截并验证
    */
    public static String validate(Object object) throws IllegalAccessException {

        // 首先通过反射获取Object对象的类有哪些字段
        // 对本文来说就可以获取到Student类的id、name、mobile三个字段
        Field[] fields = object.getClass().getDeclaredFields();

        // for循环逐个字段校验，看哪个字段上标了注解
        for ( Field field : fields ) {
            // if判断：检查该字段上有没有标注了@Length注解
            if ( field.isAnnotationPresent(Length.class) ) {
                // 通过反射获取到该字段上标注的@Length注解的详细信息
                Length length = field.getAnnotation( Length.class );
                // 让我们在反射时能访问到私有变量
                field.setAccessible(true);
                // 用过反射获取字段的实际值
                int value = ( (String)field.get(object) ).length();
                // 将字段的实际值和注解上做标示的值进行比对
                if (value < length.min() || value > length.max()) {
                    return length.errorMsg();
                }
            }
        }

        return "电话号码长度正确";
    }
}
