import java.util.ArrayList;

public class HangmanGameEntity extends WordGamesEntity{
	
		//The word which user must guess
		private static String wordToFind;
		//The word found table shows the progress of the user during the HangmanGame
		private static char[] wordFound;
		//Table letters stores the letters which already entered by user
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