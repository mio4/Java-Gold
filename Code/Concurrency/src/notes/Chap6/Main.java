package notes.Chap6;

import java.util.Random;

/**
 * 读者写着模式：
 * 1. 读者和读者不互斥
 * 2. 读者和写者互斥
 * 3. 写者和写者互斥
 */
class Data{
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public Data(int size){
        this.buffer = new char[size];
        for(int i=0; i < size; i++){
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {
        lock.readLock();
        try{
            return doRead();
        } finally{
            lock.readUnlock();
        }
    }

    private char[] doRead(){
        char[] newbuf = new char[buffer.length];
        for(int i=0; i < buffer.length; i++){
            newbuf[i] = buffer[i];
        }
        slowly();
        return newbuf;
    }

    public void write(char c) throws InterruptedException {
        lock.writeLock();
        try {
            doWrite(c);
        } finally{
            lock.writeUnlock();
        }
    }

    private void doWrite(char c){
        for(int i=0; i < buffer.length; i++){
            buffer[i] = c;
            slowly();
        }
    }

    private void slowly(){
        try{
            Thread.sleep(50);
        } catch (InterruptedException e) {}
    }
}

class WriterThread extends Thread{
    private static final Random random = new Random();
    private final Data data;
    private final String filter;
    private int index;

    public WriterThread(Data data,String filter){
        this.data = data;
        this.filter = filter;
    }

    @Override
    public void run(){
        try{
            while(true){
                char c = nextChar();
                data.write(c);
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e){}
    }

    private char nextChar(){
        char c = filter.charAt(index);
        index++;
        if(index >= filter.length()){
            index = 0;
        }
        return c;
    }

}

class ReaderThread extends Thread{
    private final Data data;

    public ReaderThread(Data data){
        this.data = data;
    }

    @Override
    public void run(){
        try{
            while(true){
                char[] readbuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readbuf));
            }
        } catch (InterruptedException e) {}
    }
}

class ReadWriteLock{
    private int readingReaders = 0; //the number of readers while reading
    private int waitingWriters = 0; //the number of writers which want to write but wait for the lock
    private int writingWriters = 0; //the number of writers doing writing right now
    private boolean preferWriter = true; //set the priority of readers and writers

    public synchronized void readLock() throws InterruptedException {
        while(writingWriters > 0 || (preferWriter && waitingWriters > 0)){
            wait();
        }
        readingReaders++; //increase the counter
    }

    public synchronized void readUnlock(){
        readingReaders--; //decrease the counter
        preferWriter = true;
        notifyAll(); //notify the writers thread
    }

    public synchronized  void writeLock() throws InterruptedException {
        waitingWriters++;
        while(readingReaders > 0 || writingWriters > 0){
            wait();
        }
        waitingWriters--;
        writingWriters++;
    }

    public synchronized void writeUnlock(){
        writingWriters--;
        preferWriter = false;
        notifyAll(); //notify other writer and reader threads
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Data data = new Data(10);
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new WriterThread(data,"ABCDEFGHIJK").start();
        new WriterThread(data,"abcdefghijk").start();
    }
}




















