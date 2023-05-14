import java.util.HashMap;

public class Board {
	int cells;

	private HashMap<Integer, Snake> snakes = new HashMap<Integer, Snake>();
	private HashMap<Integer, Ladder> ladders = new HashMap<Integer, Ladder>();
	
	public Board(int cells) {
		this.cells = cells;
		
		this.addLadder(5, 10);
		this.addLadder(24, 86);
		this.addLadder(34, 78);
		
		this.addSnake(20, 8);
		this.addSnake(72,45);
		this.addSnake(99, 2);
	}
	public void addLadder(int start, int end) {
		this.ladders.put(start, new Ladder(start, end));
	}
	public void addSnake(int head, int tail) {
		this.snakes.put(head, new Snake(head, tail));
	}
	
	public int isCurrentPositionSnakeorLadder(int position) {
		if(this.snakes.get(position)!=null) {
			System.out.println("Snake");
			return this.snakes.get(position).getTail();
		}
		if(this.ladders.get(position)!=null) {
			System.out.println("Ladder");
			return this.ladders.get(position).getEnd();
		}
		return -1;
	}
	
}
