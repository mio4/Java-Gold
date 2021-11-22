package MessageQueue_.Chap1_CreateMQ;

import java.io.IOException;

public class ProduceClient {
    public static void main(String[] args) throws IOException {
        MqClient mqClient = new MqClient();
        mqClient.produce("Hello,World");
    }
}
