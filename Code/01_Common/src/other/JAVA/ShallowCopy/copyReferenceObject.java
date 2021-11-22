package other.JAVA.ShallowCopy;

class Person{
    private String name;
    private int age;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }
}

public class copyReferenceObject {

    public static void main(String[] args) {
        Person p = new Person(23, "zhang");
        Person p1 = p;
        System.out.println(p);
        System.out.println(p1);
    }
}
