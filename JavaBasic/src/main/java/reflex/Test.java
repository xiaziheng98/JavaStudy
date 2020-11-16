package reflex;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println(Book.class);

        //根据字符串来获取对应的Class对象，参数是一个类的全限定类名
        Class<?> clazz = Class.forName("reflex.Book");
        System.out.println(clazz.newInstance());

        //使用clazz对应类的默认构造器创建实例
        Book book = (Book) clazz.newInstance();

        book.setAuthor("xia");
        book.setName("123");
        System.out.println(book);
    }
}
