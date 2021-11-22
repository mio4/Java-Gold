package Test;
import java.util.Scanner;
public class Test {
	public static void main(String[] args){
		OUT:
			for(int i=0;i < 3; i++)
				for(int j=0; j < 3; j++) {
					if (i == 1 && j == 1)
						break OUT;
					System.out.println("i = " + i + " j = " + j);
				}
		System.out.println("DOne");
	}
}
