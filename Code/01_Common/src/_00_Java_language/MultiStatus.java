package _00_Java_language;

class Person {
    public void eat(){
        System.out.println("person eat");
    }
    public void speak(){
        System.out.println("person speak");
    }

}

class Girl extends Person{
    public void eat(){
        System.out.println("girl eat");
    }
    public void speak(String s){
        System.out.println("girl speak");
    }
    public void sing(){}
}

public class MultiStatus {
    public static void main(String[] args) {
        Person girl = new Girl();
        girl.speak(); //因为子类没有该方法，调用父类方法
        //girl.speak("none"); //不能执行，因为Person中没有这个方法

        girl.eat(); //子类和父类中同时存在该方法，调用子类方法
    }
}
