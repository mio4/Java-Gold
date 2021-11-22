package GenerateFile;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

/**
 * ---
 * layout: post
 * title:  "Oracle基础(1)："
 * categories: 数据库
 * tags:  MySQL
 * author: mio4
 * ---
 *
 * * content
 * {:toc}
 *
 *
 *
 *
 * # （一）
 *
 *  -
 *
 * ```
 *
 * ```
 *
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        int month = (calendar.get(calendar.MONTH)) + 1;
        int day = calendar.get(calendar.DATE);

        System.out.println("please input the file name:(like LeetCode 20)");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("please input the title(like Leetcode : 解最小方程)");
        String title = scanner.nextLine();
        System.out.println("please input the categories(like 数据库)");
        String category = scanner.nextLine();
        System.out.println("please input the tags(like MySQL)");
        String tags = scanner.nextLine();
        String filename = year + "-" + month + "-" + day + "-" + name + ".md";

        FileWriter fileWriter = new FileWriter("E:\\" + filename);
        fileWriter.write("---\n");
        fileWriter.write("layout: post\n");
        fileWriter.write("title:  \"" + title +"\"\n");
        fileWriter.write("categories: " + category + "\n");
        fileWriter.write("tags: "+ tags +"\n");
        fileWriter.write("author: mio4\n");
        fileWriter.write("---\n");
        fileWriter.write("* content\n");
        fileWriter.write("{:toc}\n");
        fileWriter.write("\n");
        fileWriter.write("\n");
        fileWriter.write("\n");
        fileWriter.write("\n");
        fileWriter.write("#（一）");
        fileWriter.write("\n");

        fileWriter.close();
        System.out.println("Done~");
        Desktop.getDesktop().open(new File("E:\\" + filename));

    }
}
