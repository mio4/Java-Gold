package _00_Java_language;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FakeGeneric {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        //list.add("a"); // 这样直接添加肯定是不允许的

        //下面通过java的反射，绕过泛型来给添加字符串
        Method add = list.getClass().getMethod("add", Object.class);
        add.invoke(list,"a");

        System.out.println(list); //[1, a] 输出没有没问题
        System.out.println(list.get(1)); //a

    }
}
