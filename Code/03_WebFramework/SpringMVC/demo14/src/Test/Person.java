package Test;

public class Person {
    public Person(){
        System.out.println("constructor 1 in person~");
    }

    public Person(String name){
        System.out.println("constructor 2 in person~ " + name);
    }

    public static void main(String[] args){
        //Chinese chinese = new Chinese();
        Chinese chinese = new Chinese("mio");
    }
}

class Chinese extends Person{

    public Chinese(){
        super();
        System.out.println("constructor 1 in Chinese~");
    }

    public Chinese(String xxx){
        super(xxx);
        System.out.println("constructor 2 in Chinese~ " + xxx );
    }
}