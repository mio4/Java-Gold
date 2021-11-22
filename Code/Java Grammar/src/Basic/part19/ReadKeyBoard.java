package Basic.part19;

import java.io.IOException;
import java.io.InputStream;

/**
 * 读取键盘输入
 */
public class ReadKeyBoard {

	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		StringBuilder sb = new StringBuilder();
		while(true){
			int ch = in.read();
			if(ch == '\n'){
				String s = sb.toString();
				if("over".equals(s))
					break;
				System.out.println(s);
				sb.delete(0,sb.length());
			}
			else
				sb.append((char) ch);
		}
	}
}
