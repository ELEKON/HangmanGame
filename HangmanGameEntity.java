import java.util.ArrayList;

public class HangmanGameEntity extends GameEntity{
	
		//the word the user must guess
		private static String wordToFind;
		//The word found to show the progression of the user during the Hangman Game
		private static char[] wordFound;
		// letters already entered by user
		private ArrayList<String> letters = new ArrayList<>();
		
		public String getWordToFind() {
			return wordToFind;
		}
		public void setWordToFind(String wordToFind) {
			HangmanGameEntity.wordToFind = wordToFind;
		}
		public char[] getWordFound() {
			return wordFound;
		}
		public void setWordFound(char[] cs) {
			HangmanGameEntity.wordFound = cs;
		}
		public ArrayList<String> getLetters() {
			return letters;
		}
		public void setLetters(ArrayList<String> letters) {
			this.letters = letters;
		}
}