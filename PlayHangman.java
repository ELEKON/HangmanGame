public class PlayHangman {
	
	public static void main(String[] args) throws Exception  { 
		
		HangmanGameEntity entity = new HangmanGameEntity();
		WordGamesLogic startGame = new WordGamesLogic(entity);
		
		startGame.StartGame();
		HangmanGameLogic play = new HangmanGameLogic(entity,startGame);
		
		play.play();
		
//		HangmanGameEntity entity = new HangmanGameEntity();
//		WordGamesLogic startGame = new WordGamesLogic();
//		startGame.setEntity(entity);
		
		
	
	}
	}
	