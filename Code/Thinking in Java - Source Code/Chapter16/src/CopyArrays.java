import java.util.Arrays;

public class CopyArrays {
	public static void main(String[] args){
		int[] i = new int[7];
		int[] j = new int[10];
		Arrays.fill(i,10);
		Arrays.fill(j,20);
		System.out.println("i = " + Arrays.toString(i));
		System.out.println("j = " + Arrays.toString(j));

		System.arraycopy(i,0,j,0,7);
		System.out.println("j = " + Arrays.toString(j));

		i[1] = 15;
		System.out.println("i =" + Arrays.toString(i));
		System.out.println("j =" + Arrays.toString(j));
	}
}
