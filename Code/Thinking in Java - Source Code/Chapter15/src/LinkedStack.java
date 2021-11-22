//堆栈类：LinkedStack类中定义内部节点类，类似于struct
//LinkedStack对外呈现top（Node类型）变量，而top变量一个存储字符串，另一个存储一个Node类型（表示指向的下一个节点值）
//LinkedStack提供push和pop操作
public class LinkedStack<T> {
	private static class Node<U>{
		U item;
		Node<U> next;
		Node() {
			item = null;
			next = null;
		}
		Node(U item, Node<U> next) {
			this.item = item;
			this.next = next;
		}
		boolean end(){
			return item == null && next == null;
		}
	}
	private Node<T> top = new Node<T>();
	public void push(T item){ //入栈
		top = new Node<T>(item, top);
	}
	public T pop(){ //出栈
		T result = top.item;
		if(!top.end())
			top = top.next;
		return result;
	}
	public static void main(String[] args){
		LinkedStack<String> lss = new LinkedStack<String>();
		for(String s : "Phasers on stun".split(" "))
			lss.push(s);
		String s;
		while((s = lss.pop()) != null)
			System.out.println(s);
	}
}
