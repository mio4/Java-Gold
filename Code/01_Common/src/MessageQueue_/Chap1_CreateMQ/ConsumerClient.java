package MessageQueue_.Chap1_CreateMQ;

import java.io.IOException;

public class ConsumerClient {
    public static void main(String[] args) throws IOException {
        MqClient mqClient = new MqClient();
        String msg = mqClient.consume();
        System.out.println("消费的消息：" + msg);
    }
}
