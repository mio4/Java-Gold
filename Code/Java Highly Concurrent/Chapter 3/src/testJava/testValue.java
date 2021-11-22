package testJava;
import java.awt.Point;
public class testValue {
	public static void main(String[] args){
		Point p1 = new Point(1,1);
		Point p2 = new Point(1,1);
		System.out.println("Outside func Point1 x:" + p1.x + ",y:" + p1.y);
		System.out.println("Outside func Point2 x:" + p2.x + ",y:" + p2.y);
		System.out.println("***");

		tricky(p1,p2);

		System.out.println("***");
		System.out.println("Outside func Point1 x:" + p1.x + ",y:" + p1.y);
		System.out.println("Outside func Point2 x:" + p2.x + ",y:" + p2.y);
	}
	public static void tricky(Point args1, Point args2){
		args1.x = 2;
		args1.y = 2;
		Point temp = args1;
		args1 = args2;
		args2 = temp;

		System.out.println("Inside func args1 x:" + args1.x + ",y:" + args1.y);
		System.out.println("Inside func args2 x:" + args2.x + ",y:" + args2.y);
	}
}

