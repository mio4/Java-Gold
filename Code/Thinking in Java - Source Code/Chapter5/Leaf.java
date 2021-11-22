package Chapter5;
// Simple use of "this" keyword
class Leaf {
    int i = 0;
    public Leaf increment(){
        i++;
        return this;
    }
    public void print(){
        System.out.println("i = " + i);
    }

    /*
    public static void main(String[] args){
        Leaf l = new Leaf();
        l.increment().increment().increment().print();
    }
    */
}

class Person{
    public void eat(Apple apple){
        Apple peeled  = apple.getPeeled();
        System.out.println("Yummy");
    }
}
class Peeler{
    static Apple peel(Apple apple){
        //remove peal
        return apple;
    }
}
class Apple{
    Apple getPeeled(){ return Peeler.peel(this);}
}
class PassingThis{
    public static void main(String[] args){
        new Person().eat(new Apple());
    }
}

