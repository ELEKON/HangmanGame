
public class WordGamesEntity {
	//when i play a game i can win or loose
	private boolean win;
	
	public static final int MAX_ERRORS = 10;


	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
	
}
