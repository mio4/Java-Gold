import java.util.Random;

public class testIntern {
	static final int MAX = 10000;
	static final String[] arr = new String[MAX];
	public static void main(String[] args){
		Integer[] sample = new Integer[10];
		Random random = new Random(1000);
		for(int i=0;i < sample.length;i++)
			sample[i] = random.nextInt();
		
		long start_t = System.currentTimeMillis();
		for(int i=0;i < MAX;i++){
			//arr[i] = new String(String.valueOf(sample[i%sample.length]));
			arr[i] = new String(String.valueOf(sample[i%sample.length])).intern();
		}
		System.out.println(System.currentTimeMillis()-start_t + "ms");
		System.gc();
	}
}
