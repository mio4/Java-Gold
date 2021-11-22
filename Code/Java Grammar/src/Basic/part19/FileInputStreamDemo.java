package Basic.part19;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

	public static void main(String[] args) throws IOException{
		//readFile1();
		//readFile2();
		readFile3();
	}

	public static void readFile1() throws IOException{
		FileInputStream fileInputStream = new FileInputStream("stream.txt");
		int ch = 0;
		while((ch = fileInputStream.read()) != -1){
			System.out.print((char)ch);
		}
	}

	public static void readFile2() throws IOException{
		FileInputStream fileInputStream = new FileInputStream("stream.txt");
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = fileInputStream.read(buf)) != -1){
			System.out.print(new String(buf,0,len));
		}
	}

	public static void readFile3() throws IOException{
		FileInputStream fileInputStream = new FileInputStream("stream.txt");
		int num = fileInputStream.available();
		//System.out.println(num);
		byte[] buf = new byte[fileInputStream.available()];
		fileInputStream.read(buf);
		System.out.println(new String(buf));
	}
}
