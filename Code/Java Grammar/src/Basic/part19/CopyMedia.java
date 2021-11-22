package Basic.part19;

import java.io.*;

public class CopyMedia {

	/**
	 * 拷贝文本文件
	 * 1.通过字节流缓冲区 702ms-464ms
	 * 2.通过自己的缓冲区 4ms
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		long s_time = System.currentTimeMillis();
		//copy1();
		copy2();
		long e_time = System.currentTimeMillis();
		System.out.println(e_time - s_time);
	}

	public static void copy1() throws IOException{
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("F://FictionJunction - 暁の車.mp3"));
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("I://FictionJunction - 暁の車.mp3"));
		int b;
		while((b = bufferedInputStream.read()) != -1){
			bufferedOutputStream.write(b);
		}

		bufferedInputStream.close();
		bufferedOutputStream.close();
	}

	public static void copy2() throws IOException{
		MyBufferedInputStream bufferedInputStream = new MyBufferedInputStream(new FileInputStream("F://FictionJunction - 暁の車.mp3"));
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("I://FictionJunction - 暁の車.mp3"));
		int b;
		//System.out.println(bufferedInputStream.myRead());
		while((b = bufferedInputStream.myRead()) != -1){
			bufferedOutputStream.write(b);
		}
		bufferedInputStream.myClose();
		bufferedOutputStream.close();
	}
}
