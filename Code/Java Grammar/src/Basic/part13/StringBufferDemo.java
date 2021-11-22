package Basic.part13;

public class StringBufferDemo {
	public static void main(String[] args){
		//StringBuffer sb = new StringBuffer();
/*		StringBuffer sb1 = sb.append(100);
		System.out.println(sb == sb1);
		System.out.println(sb);
		System.out.println(sb1);*/

		/*sb.append(100);
		sb.append("mio");
		System.out.println(sb.toString());*/

		del();
		update();
	}

	public static void del(){
	    StringBuffer sb = new StringBuffer("abcdef");
	    //sb.delete(1,3);
        sb.delete(0,sb.length());
	    System.out.println(sb.toString());
    }

    public static void update(){
	    StringBuffer sb = new StringBuffer("abcde");
	    sb.replace(1,2,"java");
	    System.out.println(sb.toString());
    }
}
