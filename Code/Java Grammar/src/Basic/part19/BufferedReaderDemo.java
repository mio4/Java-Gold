package Basic.part19;
import java.io.*;
public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader("buffer.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		///String s1 = bufferedReader.readLine();
		//System.out.println(s1);
		String s;
		while((s = bufferedReader.readLine()) != null){
			System.out.println(s);
		}

		bufferedReader.close();
	}
}
