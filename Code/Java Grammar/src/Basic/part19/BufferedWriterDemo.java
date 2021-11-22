package Basic.part19;
import java.io.*;
public class BufferedWriterDemo {

	public static void main(String[] args) throws IOException {
		FileWriter fileWriter = new FileWriter("buffer.txt",true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.newLine();
		bufferedWriter.write("mio\n123456");

		bufferedWriter.flush();
		//bufferedWriter.close();

		bufferedWriter.close();
		//fileWriter.close();
	}
}
