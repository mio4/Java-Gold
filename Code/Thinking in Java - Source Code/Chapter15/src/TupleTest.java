public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<String, Integer>("hi", 21);
    }
    static ThreeTuple<Amphibian,String,Integer> g() {
        return new ThreeTuple<Amphibian,String,Integer> (new Amphibian(), "hi",22);
    }

    public static void main(String[] args){
        TwoTuple<String,Integer> ttsi = f();
        //ttsi.first = "test";
        System.out.println(ttsi);
        System.out.println(g());
    }
}

class Amphibian{}
