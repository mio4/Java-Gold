package Basic.part18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader("filewriter.txt");

/*		int ch = fileReader.read();
		System.out.println((char)ch);

		int ch2 = fileReader.read();
		System.out.println((char)ch2);

		int ch3 = fileReader.read();
		System.out.println(ch3);*/

		int ch;
		while((ch = fileReader.read()) != -1){
			System.out.println((char) ch);
		}
	}
}
