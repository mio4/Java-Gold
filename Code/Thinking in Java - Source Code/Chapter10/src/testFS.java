class Father{
	private String father;
	private String test;
	private int i;
	public Father(String str){
		test = str;
	}
	public  void setFather(String str){
		father = str;
	}
	public String getFather(){
		return father;
	}
	public void print(){
		System.out.println("from the father");
		i  = 3;
	}
	public int getI(){
		return i;
	}
}
class Son extends Father{
	private String test3;
	public Son(String test2){
		super(test2);
		test3 = "";
	}
	@Override
	public String getFather(){
		System.out.println("from the son");
		return super.getFather();
	}
	@Override
	public void print(){
		super.print();
	}
}

public class testFS {
	public static void main(String[] args){
		Son s = new Son("son");
		s.setFather("son fa");
		//System.out.println(s.getFather());
		s.print();
		System.out.println(s.getI());
	}
}
