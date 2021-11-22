package other;

public class ProductConsumerTest {
    private static int MAX_VALUE = 100;
    public static void main(String[] args){
        ProducerConsumer producerConsumer = new ProducerConsumer();
        new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    for(int i=0; i < MAX_VALUE; i++){
                        Thread.sleep(0);
                        producerConsumer.produce();
                    }
                } catch (Exception e){}
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(10);
                    for(int i=0; i < MAX_VALUE; i++){
                        producerConsumer.consumer();
                    }
                } catch (Exception e) {}
            }
        }).start();
    }
}
