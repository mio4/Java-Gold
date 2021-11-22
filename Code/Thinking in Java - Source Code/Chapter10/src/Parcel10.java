public class Parcel10 {
	public Destination destination(final String dest,final float price){
		return new Destination(){
			private int cost;
			{
				cost = Math.round(price);
				if(cost > 100)
					System.out.println("Over budget");
			}
			private String label = dest;
			public String readLabel(){
				return this.label;
			}
		};
	}
	public static void main(String[] args){
		Parcel10 p10 = new Parcel10();
		Destination d = p10.destination("p10",101.1F);
	}
}
