package testThreadPool;

public class Demo1 {
	ThreadLocal<Long> longlocal = new ThreadLocal<>();
	ThreadLocal<String> stringlocal = new ThreadLocal<>();

	public void set(){
		longlocal.set(Thread.currentThread().getId());
		stringlocal.set(Thread.currentThread().getName());
	}

	public long getLong(){
		return longlocal.get();
	}

	public String getString(){
		return stringlocal.get();
	}

	public static void main(String[] args) throws InterruptedException{
		final Demo1 d = new Demo1();

		//System.out.println(d.getLong());
		//System.out.println(d.getString());

		Thread t1 = new Thread(){
			@Override
			public void run(){
				d.set();
				System.out.println(d.getLong());
				System.out.println(d.getString());
			}
		};

		t1.start();
		t1.join();
		//System.out.println(d.getLong());
		//System.out.println(d.getString());
	}
}
