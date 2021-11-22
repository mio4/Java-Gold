public class ExceptionMethods {
	public static void main(String[] args){
		try {
			throw new Exception("My Exception");
		} catch (Exception e){
			System.out.println("Caught an Exception");
			System.out.println("getMessage():"+e.getMessage());
			System.out.println("getLocatedMessage():"+e.getLocalizedMessage());
			System.out.println("toString():"+e.toString());
			System.out.println("printStackTrace():");
			e.printStackTrace(System.out);
		}
	}
}
