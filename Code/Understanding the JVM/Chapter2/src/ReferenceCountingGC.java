//通过这个实例可以发现java虚拟机的GC机制不是基于程序计数器的模型
public class ReferenceCountingGC {
	public Object instance = null;
	private static final int _1MB = 1024 * 1024;
	private byte[] bigSize =  new byte[2 * _1MB];
	
	public static void testGC(){
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		System.gc();
	}
	public static void main(String[] args){
		ReferenceCountingGC.testGC();
	}
}
