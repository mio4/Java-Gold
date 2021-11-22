package MessageQueue_.Chap1_CreateMQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BrokerServer implements Runnable{

    public static int SERVICE_PORT = 9999;

    private final Socket socket;

    public BrokerServer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            while(true){
                String str = in.readLine();
                if(str == null){
                    continue;
                }
                System.out.println("接受到的原始数据为：" + str);
                if(str.equals("CONSUME")){
                    String message = Broker.consume();
                    out.println(message);
                    out.flush();
                }
                else{
                    Broker.produce(str);
                }
            }
        }catch (Exception e){
            //FIXME 每次会产生异常
            //e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVICE_PORT);
        while(true) {
            BrokerServer brokerServer = new BrokerServer(serverSocket.accept());
            new Thread(brokerServer).start();
        }
    }
}
