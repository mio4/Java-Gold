package testSimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class testDemo {
	public static void main(String[] args) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date t = sdf.parse("2015-03-29 19:29:"+1%60);
		System.out.println(1+":"+t);
	}
}
