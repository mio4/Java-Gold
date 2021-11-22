package Basic.part18;
import java.io.*;
public class FileWriterDemo {


	public static void main(String[] args) throws IOException {
		FileWriter fileWriter = new FileWriter("filewriter.txt",false);
		fileWriter.write("mio");
		fileWriter.write("demo");
		//fileWriter.flush();
		fileWriter.close();
	}
}
