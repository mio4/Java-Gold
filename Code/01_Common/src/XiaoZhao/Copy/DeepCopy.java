package XiaoZhao.Copy;

class Money implements Cloneable{
    private int money;
    public Money(int money){
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Money{" +
                "money=" + money +
                '}';
    }

    public Object clone(){
        Object obj = null;
        try{
            obj = super.clone();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return obj;
    }
}

class Teacher implements Cloneable{
    private String name;
    private Money money;
    private int length;

    public Teacher(String name, Money money, int length) {
        this.name = name;
        this.money = money;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", length=" + length +
                '}';
    }

    //clone方法是实现深拷贝的关键
    public Object clone(){
        Object obj = null;
        try{
            obj = super.clone();
        } catch (Exception e){
            e.printStackTrace();
        }
        Teacher teacher = (Teacher) obj;
        teacher.money = (Money) teacher.getMoney().clone();
        return obj;
    }
}


/* 层次调用clone方法实现深拷贝 */
public class DeepCopy {
    public static void main(String[] args) {
        Money money = new Money(1000);
        Teacher teacher1 = new Teacher("mio",money,10);

        Teacher teacher2 = (Teacher) teacher1.clone();
        System.out.println(teacher1.toString());
        System.out.println(teacher2.toString());
        System.out.println();

        //修改原有的值
        teacher1.setName("mio-changed");
        teacher1.setLength(20);
        teacher1.setMoney(new Money(2000));
        System.out.println(teacher1.toString());
        System.out.println(teacher2.toString());
    }
}

