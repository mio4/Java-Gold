package testThreadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormatDemo {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static class ParseDate implements Runnable{
		int i;
		public ParseDate(int i){
			this.i = i;
		}
		@Override
		public void run(){
			try {
					Date t = sdf.parse("2018-09-07 08:23:22");
					System.out.println(i + ":" + t);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i=0; i < 10; i++){
			es.submit(new ParseDate(i));
		}
	}
}
