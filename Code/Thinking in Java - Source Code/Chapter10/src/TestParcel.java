interface Destination{
	String readLabel();
}
interface Contents{
	int value();
}
class Parcel4{
	private class PContents implements Contents{
		int i = 10;
		public int value(){
			return i;
		}
	}
	protected class PDestination implements Destination{
		private String label;
		private PDestination(String whereto){
			label = whereto;
		}
		public String readLabel(){
			return this.label;
		}
	}
	public PDestination destination(String s){
		return new PDestination(s);
	}
	public PContents contents(){
		return new PContents();
	}

}
public class TestParcel {
	public static void main(String[] args) {
		Parcel4 p4 = new Parcel4();
		Contents c = p4.contents();
		Destination d = p4.destination("test");
	}
}
