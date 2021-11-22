package other;

/**
 * 静态内部类
 * 懒加载
 * 线程安全的单例模式
 */
public class Singleton {
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton(){}

    public static final Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
