public class Sequence {
	private Object[] items;
	private int next = 0;
	public Sequence(int size){
		this.items = new Object[size];
	}
	public void add(Object x){
		if(next < items.length)
			items[next++] = x;
	}
	//定义内部类
	private class SequenceSelector implements Selector{
		private int i = 0;
		public boolean end(){
			return i == items.length;
		}
		public Object current(){
			return items[i];
		}
		public void next(){
			if(i < items.length)
				i++;
		}
	}
	public Selector selector(){
		return new SequenceSelector();
	}
	public static void main(String[] args){
		Sequence sequence = new Sequence(10);
		for(int i=0;i < 10;i++)
			sequence.add(Integer.toString(i));
		Selector selector = sequence.selector();
		while(!selector.end()){
			System.out.println(selector.current() + " ");
			selector.next();
		}
	}
}
interface Selector{
	boolean end();
	Object current();
	void next();
}
