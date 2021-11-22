enum Shrubbery {CROUND, CRAWLING, HANING}
public class EnumClass {
	public static void main(String[] args){
		for(Shrubbery s : Shrubbery.values()){
			System.out.println(s + "ordinal:" + s.ordinal());
			System.out.println(s.compareTo(Shrubbery.CRAWLING) + "");
			System.out.println(s.equals(Shrubbery.CRAWLING) + " ");
			System.out.println(s == Shrubbery.CRAWLING);
			System.out.println(s.getDeclaringClass());
			System.out.println(s.name());
			System.out.println("-------------");
		}
		for(String s : "HANING CRAWING GROUND".split(" ")) {
			//Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
			//System.out.println(shrub);
		}
	}
}
