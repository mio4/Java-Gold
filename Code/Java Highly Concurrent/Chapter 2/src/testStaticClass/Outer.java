package testStaticClass;

public class Outer {
	private String name;
	private int age;

	public static class Builder{
		private String name;
		private int age;

		public Builder(int age){
			this.age = age;
		}

		public Builder BuilderWithName(String name){
			this.name = name;
			return this;
		}

		public Builder WithAge(int age){
			this.age = age;
			return this;
		}

		public Outer build(){
			return new Outer(this);
		}
	}

	private Outer(Builder b){
		this.name = b.name;
		this.age = b.age;
	}
}
