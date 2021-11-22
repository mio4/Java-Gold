package DynamicProxy;

public class SportsCar implements Car{
	@Override
	public void run() {
		System.out.println("Sports car runs");
	}

	@Override
	public void stop() {
		System.out.println("Sports car stops");
	}
}
