package Stream;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodeDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "中文测试";
		String s8 = URLEncoder.encode(s,"utf-8");
		System.out.println(s8);
		String s_ = URLDecoder.decode(s8,"iso8859-1");
		System.out.println(s_);
		byte[] b = s_.getBytes("iso-8859-1");
		String s0 = new String(b,"utf-8");
		System.out.println(s0);
	}
}
