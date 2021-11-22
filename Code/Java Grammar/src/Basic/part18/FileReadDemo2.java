package Basic.part18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadDemo2 {

	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader("filewriter.txt");
		/*char[] buf = new char[5];
		int num = fileReader.read(buf);
		System.out.println(num + ":" + new String(buf,0,num));

		num = fileReader.read(buf);
		System.out.println(num + ":" + new String(buf,0,num));
		fileReader.close();*/

		char[] buf = new char[1024];
		int num;
		while((num = fileReader.read(buf)) != -1){
			System.out.println(new String(buf,0,num));
		}
	}
}
