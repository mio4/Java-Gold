package _00_Java_language._java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person{
    private String name;
    private Integer age;
    private String sex;

    public Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}

public class _stream2 {

    public static void main(String[] args) {
        filterSex();
        filterSexAndAge();
        getUsernameList();
    }

    public static void filterSex(){
        List<Person> res = ini();

        List<Person> collect = res
                .stream()
                .filter(person -> "男".equals(person.getSex()))
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    public static void filterSexAndAge(){
        List<Person> res = ini();

        List<Person> collect = res
                .stream()
                .filter(person -> {
                    if("男".equals(person.getSex()) && person.getAge() < 22)
                        return true;
                    return false;
                })
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    public static void getUsernameList(){
        List<Person> res = ini();

        List<String> collect = res
                .stream()
                .map(person -> person.getName())
                .collect(Collectors.toList());

        System.out.println(collect);
    }


    public static List<Person> ini(){
        List<Person> res = null;
        Person p1 = new Person("mio1",19,"男");
        Person p2 = new Person("mio2",20,"男");
        Person p3 = new Person("mio3",21,"男");
        Person p4 = new Person("mio4",22,"女");
        Person p5 = new Person("mio5",23,"男");
        res = Arrays.asList(p1,p2,p3,p4,p5);
        return res;
    }

}
