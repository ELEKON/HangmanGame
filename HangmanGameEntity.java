import java.util.List;

public class HangmanGameEntity extends WordGamesEntity{

	
		//The word which user must guess
		private String wordToFind;
		//The word found table shows the progress of the user during the HangmanGame
		private char[] wordFound;
		//Table letters stores the letters which already entered by user
		private List<String> letters;
		//Instance for player errors at game flow
		public int numberOfErrors;
		
		
		
		public int getNumberOfErrors() {
			return numberOfErrors;
		}
		public void setNumberOfErrors(int numberOfErrors) {
			this.numberOfErrors = numberOfErrors;
		}
		
		public String getWordToFind() {
			return wordToFind;
		}
		public void setWordToFind(String wordToFind) {
			this.wordToFind = wordToFind;
		}
		public char[] getWordFound() {
			return wordFound;
		}
		public void setWordFound(char[] cs) {
			this.wordFound = cs;
		}
		public List<String> getLetters() {
			return letters;
		}
		public void setLetters(List<String> empty) {
			this.letters = empty;
		}
}