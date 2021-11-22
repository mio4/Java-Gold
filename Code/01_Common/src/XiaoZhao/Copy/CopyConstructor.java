package XiaoZhao.Copy;

class Person{
    //两个属性值：分别代表值传递和引用传递
    private Age age;
    private String name;
    public Person(Age age,String name) {
        this.age=age;
        this.name=name;
    }
    //拷贝构造方法
    public Person(Person p) {
        this.name=p.name;
        this.age=p.age;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String toString() {
        return this.name+" "+this.age;
    }
}

class Age{
    private int age;
    public Age(int age) {
        this.age=age;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return getAge()+"";
    }
}

/* 拷贝构造方法实现浅拷贝 */
public class CopyConstructor {
    public static void main(String[] args) {
        Age a=new Age(20);
        Person p1=new Person(a,"摇头耶稣");
        Person p2=new Person(p1);
        System.out.println("p1是"+p1);
        System.out.println("p2是"+p2);
        //修改p1的各属性值，观察p2的各属性值是否跟随变化
        p1.setName("小傻瓜");
        a.setAge(99);
        System.out.println("修改后的p1是"+p1);
        System.out.println("修改后的p2是"+p2);
    }
}

