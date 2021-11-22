public class TwoTuple<A,B> {
    public final A first;
    public final B second;
    public TwoTuple(A a,B b){
        this.first = a;
        this.second = b;
    }
    public String toString(){
        return "(" + first + ", " + second + ")";
    }
}

class ThreeTuple<A,B,C> extends TwoTuple<A,B> {
    public final C third;
    public ThreeTuple(A a,B b,C c){
        super(a,b);
        this.third = c;
    }
    public String toString(){
        return "(" + first + "," + second + "," + third + ")";
    }
}
