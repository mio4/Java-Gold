//泛型定义的时候使用T表示抽象的类，但是在实例变量的时候申明具体的类
//告诉编译器你需要使用怎样的类，细节对程序员透明
public class Holder3<T> {
    private T a;
    public Holder3(T a ){
        this.a = a;
    }
    public void set(T a ){
        this.a = a;
    }
    public T get(){
        return this.a;
    }
    public static void main(String[] args){
        Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
        Automobile a = h3.get();
        System.out.println(a);
    }
}
