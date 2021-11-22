package XiaoZhao.Generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Box<T>{
    private T data;

    public Box(){

    }

    public Box(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }
}

public class GenericTest {

    public static void main(String[] args){
//        List list = new ArrayList();
//        list.add("abc");
//        list.add("ef");
//        list.add(100);
//
//        for(int i =0; i < list.size(); i++){
//            String name = (String) list.get(i);
//            System.out.println("name : " + name);
//        }

//        Box<String> name = new Box<String>("corn");
//        System.out.println("name :" + name.getData());
//
//        Box<Integer> age = new Box<Integer>(15);
//        System.out.println("age :" + age.getData());

        //类型通配符
        Box<String> name = new Box<String>("corn");
        Box<Integer> age = new Box<Integer>(100);
        Box<Number> number = new Box<Number>(200);

        printData(name);
        printData(age);
        printData(number);
    }

    public static void printData(Box<?> data){
        System.out.println("data:" + data.getData());
    }
}
