package test_abstract_class;

public abstract class Shape2 {

	protected int height;
	protected int bottom;

	public Shape2(){

	}

	public Shape2(int bottom, int height){
		super();
		this.bottom = bottom;
		this.height = height;
	}

	public abstract void perimeter();
	public abstract void area();
}

class para extends Shape2{
	@Override
	public void perimeter(){
		System.out.println("perimeter in child class");
	}

	@Override
	public void area(){
		System.out.println("area in child class");
	}

	public static void main(String[] args){
		para p = new para();
		p.perimeter();;
		p.area();
	}
}
