package _02_LeetCode_Solution.Tree.No114;

class Person{
    int age;
    String name;
    public Person(int age,String name){
        this.age = age;
        this.name = name;
    }
}

public class testSomething {
    public static void changePerson(Person p){
        Person p2 = new Person(2,"u");
        p = p2;
        p.age = 10;
    }

    public static void main(String[] args){
        Person p = new Person(1,"m");
        changePerson(p);
        System.out.println(p.age);
    }
}
