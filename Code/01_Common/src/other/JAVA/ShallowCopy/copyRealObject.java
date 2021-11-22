package other.JAVA.ShallowCopy;

class Student implements Cloneable{

    private int age;
    private String name;

    public Student(Integer age, String name){
        super();
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

public class copyRealObject {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student s = new Student(23,"zhang");
        Student s1 = (Student) s.clone();
        System.out.println(s);
        System.out.println(s1);

        System.out.println("sName " + s.getName().hashCode());
        System.out.println("s1Name " + s1.getName().hashCode());
    }
}
