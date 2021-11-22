enum Spiciness {
	NOT, MILD, MEDIUM, HOT, FLAMING
}
public class SimpleEnumUse {
	public static void main(String[] args){
		Spiciness howhot = Spiciness.HOT;
		System.out.println(howhot);

		for(Spiciness s : Spiciness.values())
			System.out.println(s + ",ordinal " + s.ordinal());
	}
}
