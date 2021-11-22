import java.util.Arrays;

public class ArrayOption {
	public static void main(String[] args){
		BerySphere[] a;
		a = new BerySphere[]{new BerySphere(), new BerySphere()};

		BerySphere[] b = new BerySphere[5];
		System.out.println("b " + Arrays.toString(b));

		BerySphere[] c = new BerySphere[4];
		for(int i=0;i < 4;i++)
			if(c[i] == null)
				c[i] = new BerySphere();

		BerySphere[] d = {new BerySphere(), new BerySphere(), new BerySphere()};

		System.out.println("a " + a.length);
		System.out.println("b " + b.length);
		System.out.println("c " + c.length);
		System.out.println("d " + d.length);

	}
}
