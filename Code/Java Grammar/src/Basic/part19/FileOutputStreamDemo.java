package Basic.part19;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 操作图片文件
 */
public class FileOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		writeFile();
	}

	public static void writeFile() throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("stream.txt");
		fileOutputStream.write("mio".getBytes());
		fileOutputStream.close();
	}
}
