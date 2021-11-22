package Basic.part18;

import java.io.FileWriter;

public class FileWriterDemo2 {

	public static void main(String[] args){
		FileWriter fileWriter = null;
		try {
		fileWriter = new FileWriter("H://filewriter.txt");
		fileWriter.write("mio");
		} catch(Exception e){
			System.out.println(e.toString());
		} finally {
			try {
				if(fileWriter != null)
					fileWriter.close();
			} catch (Exception e){
				System.out.println(e.toString());
			}
		}
	}
}
