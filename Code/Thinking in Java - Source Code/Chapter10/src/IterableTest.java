import java.util.Iterator;
import java.util.Vector;

class GameCollection implements Iterable<String>{
	private Vector<String> games;

	public GameCollection(){
		games = new Vector<String>();
	}

	public void add(String game){
		games.add(game);
	}

	@Override
	public Iterator<String> iterator(){
		return games.iterator();
	}
}
public class IterableTest {
	public static void main(String[] args){
		GameCollection gc = new GameCollection();
		gc.add("aaa");
		gc.add("bbb");
		gc.add("ccc");
		Iterator<String> gameIterator = gc.iterator();
		while(gameIterator.hasNext()){
			System.out.println(gameIterator.next());
		}
	}
}
