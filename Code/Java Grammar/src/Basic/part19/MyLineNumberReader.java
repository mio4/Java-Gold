package Basic.part19;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MyLineNumberReader extends MyBufferedReader{
	private Reader reader;
	private int lineNumber;

	MyLineNumberReader(Reader reader){
		super(reader);
		this.reader = reader;
	}

	public void setLineNumer(int lineNumber){
		this.lineNumber = lineNumber;
	}

	public String myReadLine() throws IOException {
		this.lineNumber++;
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while((ch = reader.read()) != -1){
			if(ch == '\r')
				continue;
			else if(ch == '\n')
				return sb.toString();
			else
				sb.append((char)ch);
		}
		if(sb.length() != 0)
			return sb.toString();
		return null;
	}

	public int getLineNumber(){
		return this.lineNumber;
	}
}

class TestMyLineNumberReader{
	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader("buffer.txt");
		MyLineNumberReader myLineNumberReader = new MyLineNumberReader(fileReader);
		String line = null;
		while((line = myLineNumberReader.myReadLine()) != null){
			System.out.println(myLineNumberReader.getLineNumber() + ":" + line);
		}
	}
}
