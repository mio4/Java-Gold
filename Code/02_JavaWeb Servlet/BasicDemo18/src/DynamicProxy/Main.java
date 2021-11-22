package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理测试
 */
public class Main {
	public static void main(String[] args){
		final SportsCar sc = new SportsCar();

		//sc.run();
		//sc.stop();

		Car SportsCarPro = (Car) Proxy.newProxyInstance(SportsCar.class.getClassLoader(), new Class[]{Car.class}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//method.invoke(sc,null);

				if("run".equals(method.getName())){
					System.out.println("run faster");
				}
				Object o = method.invoke(sc,null);
				return method.invoke(sc,null);
			}
		});

		SportsCarPro.run();
		SportsCarPro.stop();
	}
}
