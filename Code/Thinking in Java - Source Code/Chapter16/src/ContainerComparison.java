import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BerySphere{
	private static long counter;
	private final long id = counter++;
	public String toString(){
		return "Sphere " + id;
	}
}
public class ContainerComparison {
	public static void main(String[] args){
		BerySphere[] spheres = new BerySphere[10]; //首先是创建数组对象，此时看做数组中是空的
		for(int i=0;i < 5;i++)
			spheres[i] = new BerySphere(); //然后对于数组中每个元素创建对应的对象
		System.out.println(Arrays.toString(spheres));
		System.out.println(spheres[4]);

		List<BerySphere> sphereList = new ArrayList<BerySphere>();
		for(int i=0;i < 10;i++)
			sphereList.add(new BerySphere());
		System.out.println(sphereList);
		System.out.println(sphereList.get(4));

		System.out.println("---");

	}

}
