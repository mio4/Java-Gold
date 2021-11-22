package test_factory;

public interface AbstractDrinksFactory {
	/**
	 * 制造Coffee
	 * @return
	 */
	Coffee createCoffee();

	/**
	 * 制造茶
	 * @return
	 */
	Tea createTea();

	/**
	 * 制造苏打
	 * @return
	 */
	Sodas createSodas();
}

/**
 * 中国饮料工厂：生产卡布奇诺和茶
 */
class ChinaDrinksFactory implements AbstractDrinksFactory{
	@Override
	public Coffee createCoffee(){
		return new Cappuccino();
	}

	@Override
	public Tea createTea(){
		return new Tea();
	}

	@Override
	public Sodas createSodas(){
		return null;
	}
}

/**
 * 美国饮料工厂：生产拿铁和苏打
 */
class AmericaDrinksFactory implements AbstractDrinksFactory{
	@Override
	public Coffee createCoffee(){
		return new Latte();
	}

	@Override
	public Tea createTea(){
		return null;
	}

	@Override
	public Sodas createSodas(){
		return new Sodas();
	}
}

class AbstractFactoryTest{

	public static void main(String[] args){
		AbstractDrinksFactory chinaAbstractDrinksFactory =  new ChinaDrinksFactory();
		Coffee coffee = chinaAbstractDrinksFactory.createCoffee();
		Tea tea = chinaAbstractDrinksFactory.createTea();
		System.out.println("中国工厂生产的：");
		System.out.println(coffee.getName());
		System.out.println(tea.getName());

		AbstractDrinksFactory americaAbstractDrinksFactory = new AmericaDrinksFactory();
		coffee = americaAbstractDrinksFactory.createCoffee();
		Sodas sodas = americaAbstractDrinksFactory.createSodas();
		System.out.println("美国工厂生产的：");
		System.out.println(coffee.getName());
		System.out.println(sodas.getName());
	}

}
