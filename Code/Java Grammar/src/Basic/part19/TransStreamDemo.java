package Basic.part19;

import java.io.*;

public class TransStreamDemo {

	public static void main(String[] args) throws IOException {
/*		InputStream in = System.in;
		InputStreamReader inputStreamReader = new InputStreamReader(in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);*/

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("out.txt")));

		/*OutputStream out = System.out;
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);*/

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")));
		//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = null;
		while(true){
			s = bufferedReader.readLine();
			if("over".equals(s))
				break;
			else {
				//System.out.println(s.toUpperCase());
				bufferedWriter.write(s.toUpperCase());
				bufferedWriter.newLine();
				//outputStreamWriter.write(s.toUpperCase());
				//outputStreamWriter.flush();
				bufferedWriter.flush();
			}
		}
	}
}
