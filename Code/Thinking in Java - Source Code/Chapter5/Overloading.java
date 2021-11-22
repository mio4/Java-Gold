package Chapter5;

public class Overloading {
    public static void main(String[] args){
        for(int i=0; i < 5;i++){
            Tree t = new Tree(i);
            t.info();
            t.info("Overloading method ");
        }
    }
}

class Tree {
    int height;
    Tree(){
        System.out.println("Planting a seddling");
        height = 0;
    }
    Tree(int initialHeight){
        height = initialHeight;
        System.out.println("Creating a new tree that height is " + height + " feet tall");
    }
    void info(){
        System.out.println("Tree is " + height + " feet tall");
    }
    void info(String s){
        System.out.println(s + " tree is " + height + " feet tall");
    }
}
