package Basic.part19;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader {
	private Reader Reader;
	public MyBufferedReader(Reader Reader){
		this.Reader = Reader;
	}

	public String myReadLine() throws IOException {
		int ch;
		StringBuilder sb = new StringBuilder();
		while((ch = Reader.read()) != -1){
			if(ch == '\r')
				continue;
			else if(ch == '\n')
				return sb.toString();
			else
				sb.append((char)ch);
		}
		if(sb.length() != 0) //将剩下的数据返回##
			return sb.toString();
		return null;
	}

}

class TestMyBufferedReader{
	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader("buffer.txt");
		MyBufferedReader myBufferedReader = new MyBufferedReader(fileReader);
		String line = null;
		while((line = myBufferedReader.myReadLine()) != null){
			System.out.println(line);
		}
	}
}

