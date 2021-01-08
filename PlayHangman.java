public class PlayHangman {
	
	public static void main(String[] args)  { 
		
		WordGamesUtilities startGame = new WordGamesUtilities();
		startGame.Startgame();		
		HangmanGameUtilities newGame  = new HangmanGameUtilities();
		newGame.play();
		}
	}