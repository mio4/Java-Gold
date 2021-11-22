package reflection;
//利用反射查看类的Field Method
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {
	public static void main(String[] args){
		String name;
		if(args.length > 0)
			name = args[0];
		else{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name(e.g. java.util.Scanner) :");
			name = in.next();
		}

		try {
			//print class name and super class name
			Class c1 = Class.forName(name);
			Class supercl = c1.getSuperclass();
			String modifiers = Modifier.toString(c1.getModifiers());
			if(modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.print("class " + name);
			if(supercl != null && supercl != Object.class)
				System.out.print(" extends " + supercl.getName());

			System.out.print("\n{\n");
			printConstructors(c1);
			System.out.println();
			printMethods(c1);
			System.out.println();
			printFields(c1);
			System.out.println();
		} catch (Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}

	public static void printConstructors(Class cl){ //首先是打印类中所有的构造器
		Constructor[] constructors = cl.getDeclaredConstructors();
		for(Constructor c : constructors){
			String name = c.getName();
			System.out.print("    ");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.print(name + "(");

			//print parameters type
			Class[] paramTypes = c.getParameterTypes();
			for(int j=0; j < paramTypes.length; j++){
				if(j > 0)
					System.out.print(",");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}

	public static void printMethods(Class cl){ //打印一个类型中所有的方法
		Method[] methods = cl.getDeclaredMethods();

		for(Method m : methods){
			Class retType = m.getReturnType();
			String name = m.getName();

			System.out.print("	");
			//打印修饰符 返回值 方法名
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length() > 0) //字符串的length是一个方法
				System.out.print(modifiers + " ");
			System.out.print(retType.getName() + " " + name + "(");

			//打印参数
			Class[] paramTypes = m.getParameterTypes();
			for(int j=0; j < paramTypes.length; j++) { //数组的length是一个成员变量
				if(j > 0)
					System.out.print(",");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}

	public static void printFields(Class cl){ //打印类中所有的域
		Field[] fields = cl.getDeclaredFields();

		for(Field f : fields){
			Class type = f.getType();
			String name = f.getName();
			System.out.print("	");
			String modifiers = Modifier.toString(f.getModifiers());
			if(modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}

	}
}
