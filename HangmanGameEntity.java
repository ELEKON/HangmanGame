import java.util.List;

public class HangmanGameEntity extends WordGamesEntity{

	private String wordOfGame;
	private char[] wordStateDuringGame;
	private List<String> alreadyGivenLetters;
	private int numberOfErrors = 0;

	public String getWordOfGame() { return wordOfGame; }

	public void setWordOfGame(String wordOfGame) { this.wordOfGame = wordOfGame; }

	public char[] getWordStateDuringGame() { return wordStateDuringGame; }

	public void setWordStateDuringGame(char[] wordStateDuringGame) { this.wordStateDuringGame = wordStateDuringGame; }

	public List<String> getAlreadyGivenLetters() { return alreadyGivenLetters; }

	public void setAlreadyGivenLetters(List<String> alreadyGivenLetters) { this.alreadyGivenLetters = alreadyGivenLetters; }

	public int getNumberOfErrors() { return numberOfErrors; }

	public void setNumberOfErrors(int numberOfErrors) { this.numberOfErrors = numberOfErrors; }
}