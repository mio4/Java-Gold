import java.util.Iterator;

public class IterableFibonacci
extends Fibonacci implements Iterable<Integer>{
	private int  n;
	public IterableFibonacci(int count){
		this.n = count;
	}
	@Override
	public Iterator<Integer> iterator(){
		return new Iterator<Integer>(){
			public boolean hasNext(){
				return n > 0;
			}
			public Integer next(){
				n--;
				return IterableFibonacci.this.next();
			}
			public void remove(){ //not implemented
				throw new UnsupportedOperationException();
			}
		};
	}
	public static void main(String[] args){
		for(int i : new IterableFibonacci(10)){
			System.out.println(i + "");
		}
	}
}
