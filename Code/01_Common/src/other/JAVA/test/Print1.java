package other.JAVA.test;

public class Print1 {
    public static void main(String args[]) {
        Thread t = new Thread() {
            public void run() {
                print();
            }
        };
        t.start();
        System.out.print("MT");
    }
    static void print() {
        System.out.print("_02_LeetCode_Solution/DP");
    }
}
