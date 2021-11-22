import java.util.Arrays;
import java.util.Random;

public class IceCream {
	private static Random rand = new Random(47);
	static final String[] FLAVORS = {
		"Chocolate", "Strawberry", "Rum",
		"Mocha", "Vanilia", "Fudge"
	};

	public static String[] flavorSet(int n){
		if(n > FLAVORS.length){
			throw new IllegalArgumentException("Set too big");
		}
		String[] results = new String[n];
		boolean[] picked = new boolean[FLAVORS.length];
		for(int i=0; i < n; i++){
			int t;
			do
				t = rand.nextInt(FLAVORS.length);
			while(picked[t]);
			results[i] = FLAVORS[t];
			picked[i] = true;
		}
		return results;
	}

	public static void main(String[] args){
		for(int i=0; i < 7; i++)
			System.out.println(Arrays.toString(flavorSet(3)));
	}
}
