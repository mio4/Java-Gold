package Basic.part18;
import java.io.*;
public class CopyTest {
	/**
	 * 将F盘文件拷入I盘
	 * @param args
	 */

	public static void main(String[] args) throws IOException{
		method2();
	}

	public static void method1() throws IOException {
		FileReader fileReader = new FileReader("F://from.txt");
		FileWriter fileWriter = new FileWriter("I://to.txt");

		//单个字符的读写
		int ch = 0;
		while((ch = fileReader.read()) != -1){
			fileWriter.write(ch);
		}
		fileWriter.close();
		fileReader.close();
	}

	public static void method2() throws IOException{
		FileReader fr = null;
		FileWriter fw = null;
		try{
			fr = new FileReader("F://from.txt");
			fw = new FileWriter("I://to.txt");

			char[] buf = new char[1024];
			int len = 0;
			while((len = fr.read(buf)) != -1){
				fw.write(buf,0,len);
			}
		} catch (Exception e){
			System.out.println("Copy failed");
			e.printStackTrace();
		} finally {
			if(fr != null)
				fr.close();
			if(fw != null)
				fw.close();
		}
	}

}
