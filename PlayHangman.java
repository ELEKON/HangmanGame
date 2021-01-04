public class PlayHangman {

	
	public static void main(String[] args) throws Exception { 
	  
		//wait for calling the right methods
		//HangmanGameEntity newGame = new HangmanGameEntity();
		//System.out.println(entity.chooseFromExistingWords());
		//newGame.StartNewGame();
		//SnewGame.play();
	
		HangmanGameUtilities play = new HangmanGameUtilities();
		play.StartNewGame();
		play.play();
	
	}
	
}	