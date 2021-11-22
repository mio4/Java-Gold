package XiaoZhao.Socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    public static int port = 7000;
    public static String host = "localhost";
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(host,port);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        Scanner sc = new Scanner(System.in);
        boolean flag = false;

        while(!flag){
            System.out.println("输入长方形的边长：");
            double length = sc.nextDouble();
            dos.writeDouble(length);
            dos.flush();

            double area = dis.readDouble();
            System.out.println("服务器返回的长方体面积:" + area);

            while(true){
                System.out.println("继续计算（Y/N）：");
                String is_continue = sc.next();
                if("N".equalsIgnoreCase(is_continue)){
                    dos.writeInt(0);
                    dos.flush();
                    flag = true;
                    break;
                }else if("Y".equalsIgnoreCase(is_continue)){
                    dos.writeInt(1);
                    dos.flush();
                    break;
                }
            }
        }

        socket.close();
    }
}
