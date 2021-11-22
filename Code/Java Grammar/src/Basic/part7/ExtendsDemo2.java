package Basic.part7;

class FatherClass{
	int num = 10;
}

class SonClass extends FatherClass{
	//int num =  100;
	void show(){
		System.out.println(num);
	}
}

public class ExtendsDemo2 {
	public static void main(String[] args){
		SonClass s = new SonClass();
		//System.out.println(s.num);
		s.show();
	}
}


