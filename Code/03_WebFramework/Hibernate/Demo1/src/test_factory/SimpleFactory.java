package test_factory;

public class SimpleFactory {

	/**
	 * 通过类型获取Coffee实体
	 * @param type
	 * @return
	 */
	public static Coffee createInstance(String type){
		if("americano".equals(type))
			return new Americano();
		else if("latte".equals(type))
			return new Latte();
		else if("cappuccino".equals(type))
			return new Cappuccino();
		else
			throw new RuntimeException("type " + type + " 类型不可识别");
	}

	public static void main(String[] args){
		Coffee latte = SimpleFactory.createInstance("latte");
		System.out.println("创建的Coffee实体为：" + latte.getName());
		Coffee cappuccino = SimpleFactory.createInstance("cappuccino");
		System.out.println("创建的Coffee实体为：" + cappuccino.getName());
	}
}
