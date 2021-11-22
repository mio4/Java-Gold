package Basic.part19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyImg {

	/**
	 * 拷贝图片
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream = new FileInputStream("F://我好菜啊.jpg");
			fileOutputStream = new FileOutputStream("I://我好菜啊.jpg");

			byte[] buf = new byte[1024];
			int len = 0;
			while((len = fileInputStream.read(buf)) != -1){
				fileOutputStream.write(buf);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			if(fileInputStream != null)
				fileInputStream.close();
			if(fileOutputStream != null)
				fileOutputStream.close();
		}
	}
}
