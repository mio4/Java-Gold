abstract class Bird{
	private String name;
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public abstract int fly();
}
public class TestAnn {
	public static void testBird(Bird bird){
		System.out.println(bird.getName() + "can fly " + bird.fly() + " meters");
	}
	public static void main(String[] args){
		TestAnn ta = new TestAnn();
		TestAnn.testBird(new Bird(){
			public int fly(){
				return 1000;
			}
			public String getName(){
				return "Dayan";
			}
		});
	}
}
