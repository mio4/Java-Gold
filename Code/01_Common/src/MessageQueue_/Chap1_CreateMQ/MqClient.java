package MessageQueue_.Chap1_CreateMQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MqClient {

    public void produce(String msg) throws IOException { //生产消息
        Socket socket = new Socket(InetAddress.getLocalHost(),BrokerServer.SERVICE_PORT);
        try{
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(msg);
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String consume() throws IOException { //消费消息
        Socket socket = new Socket(InetAddress.getLocalHost(),BrokerServer.SERVICE_PORT);
        String msg = "";
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            //1. 消息队列发送“CONSUME”字段
            out.println("CONSUME");
            out.flush();
            //2. 获取接受的消息
            msg = in.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return msg;
    }
}
