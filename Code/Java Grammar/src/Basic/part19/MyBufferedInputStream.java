package Basic.part19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义缓冲区
 * TODO
 * 溢出Bug暂时没有De出来...
 */
public class MyBufferedInputStream {
	private FileInputStream inputStream;
	private byte[] buf = new byte[1024*4];
	private int pos = -1; //指针
	private int cnt = 0; //内存中剩余个数
	public MyBufferedInputStream(FileInputStream inputStream){
		this.inputStream = inputStream;
	}

	/**
	 * 读取硬盘上的数据，存储到内存中
	 * 如果去光了内存中数据，才从inputStream中获取
	 * @return
	 */
	public int myRead() throws IOException {
		if(cnt == 0) {
			cnt = inputStream.read(buf);
			pos = -1;
		}
		cnt--;
		pos++;
		//System.out.println(cnt);
		if(pos == 4095){
			System.out.println(cnt);
			//System.out.println(pos);
		}
		byte b = buf[pos];

		return (b & 0xff);
	}

	public void myClose() throws IOException {
		this.inputStream.close();
	}
}
