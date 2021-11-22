package ChangeFileName;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *  1.修改文件夹下所有文件的文件名
 *  2.获取所有文件的连接，生成HTML链接
 *  https://raw.githubusercontent.com/mio4/Resource/master/parrot%20GIF/angelparrot.gif
 *  https://raw.githubusercontent.com/mio4/Resource/master/parrot%20GIF/ + i + .gif
 */

public class ChangeFileName {
	public static void main(String[] args){
		//changeName();
		//printURL();
		//printHTML();
	}

	public static void changeName(){
		String path="C:\\Users\\461152465\\Desktop\\网页\\cult";
		File file = new File(path);
		File[] fs = file.listFiles();
		int i = 1;
		for(File f : fs){
			if(!f.isDirectory()){
				String path2 = "C:\\\\Users\\\\461152465\\\\Desktop\\\\网页\\\\cult\\\\" + i +".gif";
				f.renameTo(new File(path2));
				i++;
			}
		}
	}

	public static void printURL(){
		for(int i=1; i <= 133; i++){
			String path3 = "https://raw.githubusercontent.com/mio4/Resource/master/parrot%20GIF/" + i + ".gif";
			System.out.println(path3);
		}
	}

	public static void printHTML(){
		String width = "75px";
		String height = "75px";
		File file = new File("C:\\Users\\461152465\\Desktop\\网页\\output.html");
		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("文件不存在，已经创建成功！");
			}
			PrintStream ps = new PrintStream(new FileOutputStream(file));
			ps.println("<html>");
			ps.println("\t<head></head>");
			ps.println("<body>");
			for(int i=1; i <= 133; i++){
				String path = "<img src=\"https://raw.githubusercontent.com/mio4/Resource/master/parrot%20GIF/"+ i + ".gif\" height=\"75px\" width=\"75px\" />";
				ps.println(path);
			}
			ps.println("</body>");
			ps.println("</html>");
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
