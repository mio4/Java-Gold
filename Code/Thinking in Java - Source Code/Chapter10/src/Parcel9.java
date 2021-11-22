
public class Parcel9 {
	public Destination destination( String dest){
		return new Destination(){
			private String label = dest;
			public String readLabel(){
				return this.label;
			}
		};
	}
	public static void main(String[] args){
		Parcel9 p9 = new Parcel9();
		Destination d = p9.destination("P9");
		System.out.println(d.readLabel());
	}
}
