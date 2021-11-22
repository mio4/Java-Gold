package _02_LeetCode_Solution.Array.No215;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Dog{
    public int age;
    public String name;
    public Dog(int age, String name){
        super();
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString(){
        return "[Dog[age=" + age + ",name=" + name + "]";
    }

}
public class testCompare {
    public static void main(String[] args){
        List<Dog> list = new ArrayList<Dog>();
        list.add(new Dog(5,"DogA"));
        list.add(new Dog(6,"DogB"));
        list.add(new Dog(7,"DogC"));
        list.add(new Dog(8,"DogD"));
        Collections.sort(list,new Comparator<Dog>(){
           @Override
           public int compare(Dog o1, Dog o2){
               //return o1.age - o2.age; -->按照升序排列
               return o2.age - o1.age;
            }
        });
        System.out.println("逆序排序" + list);

    }
}
