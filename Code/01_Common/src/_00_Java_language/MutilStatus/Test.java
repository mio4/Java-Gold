package _00_Java_language.MutilStatus;

class Animal {
    int num = 10;
    static int age = 20;

    public void eat(){
        System.out.println("动物吃饭");
    }

    public static void sleep(){
        System.out.println("动物睡觉");
    }

    public void run(){
        System.out.println("动物奔跑");
    }
}

class Cat extends Animal{
    int num = 80;
    static int age = 90;
    String name = "tomCat";

    public void eat(){
        System.out.println("猫在吃饭");
    }

    public static void sleep(){
        System.out.println("猫在睡觉");
    }

    public void catchMouse(){
        System.out.println("猫在抓老鼠");
    }
}

public class Test{
    public static void main(String[] args) {
        Animal animal = new Cat();

        animal.eat();
        animal.sleep();
        animal.run();

        System.out.println(animal.num);
        System.out.println(animal.age);
    }
}

