package hire.testAtomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

//TODO 为什么不是Runnable接口的类都可以作为线程池参数，运行
class Count{
//    private Integer count = 0;
    private AtomicInteger count = new AtomicInteger(0);
    public Integer getCount(){
//        return count;
        return count.get();
    }
    public void increase(){
//        count++;
        count.incrementAndGet();
    }
}

public class withoutAtomic {
    public static void main(String[] args){
        ExecutorService service = Executors.newCachedThreadPool();
        Count count = new Count();
        for(int i=0; i < 100; i++){
            service.execute(() -> count.increase());
        }
        System.out.println(count.getCount());
    }
}
