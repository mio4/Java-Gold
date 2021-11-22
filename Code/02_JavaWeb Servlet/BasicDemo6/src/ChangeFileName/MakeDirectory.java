package ChangeFileName;

import java.io.File;

public class MakeDirectory {
	public static void main(String[] args){
		//makeDirector();
		moveFile();
	}

	public static void makeDirector(){
		String path = "G:\\编程教学汇总\\黑马程序员_Java_毕向东";
		for(int i=1; i <= 25; i++){
			String path_d = path + "\\day" + i;
			File file = new File(path_d);
			if(!file.exists()){
				file.mkdir();
			}
		}
	}

	public static void moveFile(){ //将视频文件移动到指定文件夹
		String fromPath = "G:\\编程教学汇总\\黑马程序员_毕向东_Java基础视频教程";
		File dire = new File(fromPath);
		File[] files = dire.listFiles();
		for(File f : files){
			String fileName = f.getName();
			int len = fileName.length();
			boolean isRead = false;
			String s2 = "";
			for(int i=0; i < len; i++){
				if(fileName.charAt(i) >= '0' && fileName.charAt(i) <= '9'){
					s2 += fileName.charAt(i);
					isRead = true;
				} else{
					if(isRead)
						break;
				}
			}
			int num = Integer.parseInt(s2);
			String toPath = "G:\\编程教学汇总\\黑马程序员_Java_毕向东\\day" + num + "\\" + fileName;
			System.out.println(toPath);
			f.renameTo(new File(toPath));
		}
		System.out.println("done");
	}

}
