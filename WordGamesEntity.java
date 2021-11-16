
public class WordGamesEntity {
	//flag gor win or loose
	private boolean win;
	//total ammount of player attempts, change it if you want
	public static final int MAX_ERRORS = 10;


	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
	
}
