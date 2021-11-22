package XiaoZhao.ObjectClass;

import java.util.HashMap;

/**
 * 主要研究Object.hashCode方法和equals方法的细节
 */
class People{
    private String name;
    private int age;

    public People(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public boolean equals(Object obj){
        return this.name.equals(((People)obj).name) && this.age == (((People)obj).age);
    }

    //需要重写
    @Override
    public int hashCode(){
        return name.hashCode()*37+age;
    }
}

public class rewriteHashcode {

    public static void main(String[] args){
        People p1 = new People("mio",20);
        System.out.println(p1.hashCode());

        HashMap<People,Integer> hashMap = new HashMap<>();
        hashMap.put(p1,1);

        System.out.println(hashMap.get(new People("mio",20)));
    }
}
