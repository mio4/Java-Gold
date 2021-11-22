package Basic.part19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyTestBuffer {

	public static void main(String[] args){
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;

		try{
			bufferedReader = new BufferedReader(new FileReader("fromBuffer.txt"));
			bufferedWriter = new BufferedWriter(new FileWriter("toBuffer.txt"));

			String line = null;
			while((line = bufferedReader.readLine()) != null){
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try {
				bufferedReader.close();
				bufferedWriter.close();
			} catch (Exception e){

			}
		}
	}
}
