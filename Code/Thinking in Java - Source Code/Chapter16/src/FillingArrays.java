import java.util.Arrays;

public class FillingArrays {
	public static void main(String[] args){
		int size = 6;
		String[] a1 = new String[size];
		Arrays.fill(a1,"Hello");
		System.out.println("a1 " + Arrays.toString(a1));
	}
}
