package test_factory;

abstract class CoffeeFactory {
	/**
	 * 生产Coffee
	 * @return
	 */
	public abstract Coffee[] createCoffee();
}

/**
 * 中式Coffee工厂
 */
class ChinaCoffeeFactory extends CoffeeFactory{
	@Override
	public Coffee[] createCoffee(){
		//TODO
		return new Coffee[]{new Cappuccino(),new Latte()};
	}
}

/**
 * 美式Coffee工厂
 */
class AmericaCoffeeFactory extends CoffeeFactory{
	@Override
	public Coffee[] createCoffee(){
		//TODO
		return new Coffee[]{new Americano(),new Latte()};
	}
}

class FactoryMethodTest{
	static void print(Coffee[] coffees){
		for(Coffee c : coffees)
			System.out.println(c.getName());
	}
	public static void main(String[] args){
		CoffeeFactory chinaCoffeeFactory = new ChinaCoffeeFactory();
		Coffee[] chinaCoffees = chinaCoffeeFactory.createCoffee();
		System.out.println("中国生产的Coffee有：");
		print(chinaCoffees);

		CoffeeFactory americaCoffeeFactory = new AmericaCoffeeFactory();
		Coffee[] americaCoffees = americaCoffeeFactory.createCoffee();
		System.out.println("美国生产的Coffee有：");
		print(americaCoffees);
	}
}
