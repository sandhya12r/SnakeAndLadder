import java.util.ArrayList;

public class Game {
	Board board;
	ArrayList<Player> players= new ArrayList<Player>();
	ArrayList<Integer> playerPosition= new ArrayList<Integer>();
	Dice d;
	Player winner = null;
	
	public Game(Board board) {
		this.board = board;
		winner = null;
	}
	
	public void addPlayer(Player p) {
		this.players.add(p);
		this.playerPosition.add(0);
	}
	public int move(Player p, int playerIndex, int increment) {
		int currentPosition = this.playerPosition.get(playerIndex);
		System.out.println(p.name +" : "+currentPosition);

		if(currentPosition +increment <=100) {
			currentPosition +=increment;
		}
		if(this.board.isCurrentPositionSnakeorLadder(currentPosition)!= -1) {
			currentPosition = this.board.isCurrentPositionSnakeorLadder(currentPosition);
		}
		
		playerPosition.set(playerIndex, currentPosition);
		return currentPosition;
	}
	
	
	public void start() {
		while(this.winner== null) {
			for(int i =0; i<this.players.size(); i++) {
				Player p = this.players.get(i);
				int position = move(p, i, Dice.throwDice());
				if(position>=100) {
					this.winner = p;
					break;
				}
			}
			
		}
		System.out.println(this.winner.name +" won");
	}
}
