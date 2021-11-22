package XiaoZhao.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 0. 开始通信，建立连接
 * 1. client向server发送数据
 * 2. server计算结果
 * 3. server将结果发送到client
 * 4. 结束通信
 */
public class SocketServer {
    public static int port = 7000;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port); //创建一个嵌套字
        Socket socket = serverSocket.accept();
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

        do{
            double length = dis.readDouble();
            System.out.println("服务器接受到的数据：" + length);
            double result = length * length;
            dos.writeDouble(result);
            dos.flush(); //强制发送缓冲区的数据,不必等到缓冲区满
        }while(dis.readInt() != 0);

        socket.close();
        serverSocket.close();
    }
}
