public class PlayHangman {
	
	public static void main(String[] args) throws Exception  { 
		
		HangmanGameEntity entity = new HangmanGameEntity();
		WordGamesLogic startGame = new WordGamesLogic(entity);
		
		startGame.startGame();
		HangmanGameLogic player = new HangmanGameLogic(entity,startGame);

		player.play();
	}
}
	