import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangmanGameEntity implements HangmanGameEntitHasToDO{
	
		//the word the user must guess
		private static String wordToFind;
		//The word found to show the progression of the user during the Hangman Game
		private static String [] wordFound;
		//The number of errors made by the user when trying to guess the word
		public static final int MAX_ERRORS = 6;
		// letters already entered by user
		private ArrayList<String> letters = new ArrayList<>();
		//number of errors per run
		private int numberOfErrors;
		
		
		
	//method of word selection, for each new run	
	@SuppressWarnings("resource")
	public String chooseFromExistingWords() throws Exception  {
		// pass the path to the file as a parameter 
		File file = new File("C:\\Users\\EleutheriadisK\\eclipse-workspace\\Hangman\\src\\AllExistingWords"); 
		Scanner sc;
		sc = new Scanner(file);
		// na to kanw me new lines
		String[] words = sc.next().split(","); 
		Random rand = new Random();
		int randomElement = rand.nextInt(words.length);
		return words[randomElement];

	}
	
	//method of new run of the game
	public void StartNewGame() throws Exception {
		int numberOfErrors = 0;
		letters.clear();
		
		HangmanGameEntity newRunWord = new HangmanGameEntity();
		wordToFind = newRunWord.chooseFromExistingWords(); //h wordToFind einai h leksh tou gurou
		
		wordFound = new String [wordToFind.length()];
		
		for (int i = 0; i < wordFound.length; i++) {
			wordFound[i] = "_";
		}
	}
	
	//method pou sou gurnaei minima epituxias
	
	public boolean WinningMessage() {
	
		return wordToFind.equals(wordFound);
	}
	
}