public class testString {
	private static int time = 100000;
	public static void main(String[] args){
		//tString();
		tStringBuffer();
		tStringBuilder();
	}
	public static void tString(){
		long begin = System.currentTimeMillis();
		String s = "";
		for(int i=0;i <  time;i++)
			s += "java";
		long over = System.currentTimeMillis();
		System.out.println(over-begin);
	}
	public static void tStringBuffer(){
		long begin = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i <  time;i++)
			sb = sb.append("java");
		long over = System.currentTimeMillis();
		System.out.println(over-begin);
	}
	public static void tStringBuilder(){
		long begin = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i <  time;i++)
			sb = sb.append("java");
		long over = System.currentTimeMillis();
		System.out.println(over-begin);
	}
}
