class MyException extends Exception{
	public MyException(){}
	public MyException(String msg){super(msg);}
}
public class FullConstructors {
	public static void f() throws MyException{
		System.out.println("Throw MyException from f()");
		throw new MyException();
	}
	public static void g() throws MyException{
		System.out.println("Throw MyException from g()");
		throw new MyException("Originated from g()");
	}
	public static void main(String[] args){
		try{
			f();
		} catch(MyException e){
			e.printStackTrace(System.out);
			//e.printStackTrace();
		}

		try{
			g();
		} catch(MyException e){
			e.printStackTrace(System.out);
			//System.out.println("---");
			//e.printStackTrace();
		}
	}
}

