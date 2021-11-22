package notes.Chap5;

import java.util.Random;

/**
 * 生产者-消费者模型
 */


/**
 * Producer
 */
class MakerThread extends Thread{
    private final Random random;
    private final Table table;
    private static int id = 0;

    public MakerThread(String name,Table table,Long seed){
        super(name);
        random = new Random(seed);
        this.table = table;
    }

    public synchronized static int nextId(){
        return id++;
    }

    @Override
    public void run(){
        try{
            while(true){
                Thread.sleep(random.nextInt(1000));
                String cake = "[ cake " + nextId() + " by " + Thread.currentThread().getName() + " ]";
                table.put(cake);
            }
        } catch (InterruptedException e) {

        }
    }
}

/**
 * Consumer
 */
class EaterThread extends Thread{
    private final Random random;
    private final Table table;

    public EaterThread(String name, Table table, Long seed){
        super(name);
        random = new Random(seed);
        this.table = table;
    }

    @Override
    public void run(){
        try{
            while(true){
                String cake = table.get();
                Thread.sleep(random.nextInt(1000));
            }
        }catch (InterruptedException e) {}
    }
}


/**
 * container
 * 构造一个循环队列，每次从头部取出cake,从尾部插入cake
 */
class Table{
    private final String[] buffer;
    private int head;
    private int tail;
    private int count;

    public Table(int maxCount){
        this.buffer = new String[maxCount];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while(count >= buffer.length){
            wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while(count <= 0){
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}

/**
 * test case
 */
public class Amain {

    public static void main(String[] args){
        Table table = new Table(3);
        new MakerThread("MakerThread-0",table,111L).start();
        new MakerThread("MakerThread-1",table,222L).start();
        new MakerThread("MakerThread-2",table,333L).start();
        new EaterThread("EaterThread-0",table,444L).start();
        new EaterThread("EaterThread-1",table,555L).start();
        new EaterThread("EaterThread-2",table,666L).start();
    }
}
