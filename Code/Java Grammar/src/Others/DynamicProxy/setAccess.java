package Others.DynamicProxy;

import java.lang.reflect.Field;

/**
 * Field.setAccessible（）能够在运行时获得类的private成员变量
 */
public class setAccess {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User();
        user.setName("mio");
        user.setAge(100);
        Class clazz = user.getClass();
        for(Field f: clazz.getDeclaredFields()){
            System.out.println(f.isAccessible());
            f.setAccessible(true);
            System.out.println(f.getName() + ":" + f.get(user));
        }

        System.out.println("--");
        for(Field f : clazz.getDeclaredFields()){
            System.out.println(f.getName() + ":" + f.get(user));
        }
    }
}

class User{
    private String name;
    private Integer age;
    public User(){

    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(Integer age){
        this.age = age;
    }
}
