import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordGamesUtilities implements WordGamesLogic{
	
	private int numberOfErrors;
	private BufferedReader reader;
	private HangmanGameEntity game = new HangmanGameEntity();	
	
	//method of word selection, for each new run	
	public String wordSelection() throws Exception  {
		
			try {
				reader = new BufferedReader(new FileReader(HangmanGameConstants.Words_txt_file));
			} catch (FileNotFoundException e) {
				System.out.println(HangmanGameConstants.TxtFile_ExceptionMessage);
			}
		    String line = reader.readLine();
			
		    List<String> words = new ArrayList<String>();
		    while(line != null) {
		        String[] wordsLine = line.split(HangmanGameConstants.word_splitter);
		        for(String word : wordsLine) {
		            words.add(word);
		        }
		        line = reader.readLine();
		    }

		    Random rand = new Random(System.currentTimeMillis());
		    String randomWord = words.get(rand.nextInt(words.size()));
			return randomWord.toLowerCase();
	}
	
	
	
	
	public void Startgame()  {
		//---------------Me TO POU KSEKINAEI TO PAIXNIDI--------------------//
		//user entries table become empty									//
		//find new word, for new run	 									//
		//table wordFound BE instantiated based on word length			    //		
		//------------------------------------------------------------------//
		
		
		ArrayList<String> empty = new ArrayList<>();
		game.setLetters(empty);
		
		try {
		game.setWordToFind(wordSelection());  
		}catch(Exception ex){
			System.out.println(HangmanGameConstants.Word_ExceptionMessage);
		}
		
		//final wordSize to be sure that its value be same at runtime 
		final int wordSize= game.getWordToFind().length(); 
		game.setWordFound(new char[wordSize]);
		
		for (int i = 0; i < game.getWordFound().length; i++) {
			game.getWordFound()[i] =  HangmanGameConstants.letter_mask;
		}
		
	}
		
	//method wordFound returns true if wordToFind==wordFound else returns false
	public boolean wordFound() {
		//System.out.println(game.getWordToFind().toString());
		if(game.getWordToFind().contentEquals(new String (game.getWordFound()))){
			game.setWin(true);
			return game.isWin();
		}else{
			game.setWin(false);
			return game.isWin();
		}
	}
	
	//method updating the wordFound table after user enter a character that match
	public void UpdateWordFoundTable(String entry) {
		
		//update only when a character has not already be entered		
		if(!game.getLetters().contains(entry) && entry.length() == 1) {
			
			if (game.getWordToFind().contains(entry)) {
				int index = game.getWordToFind().indexOf(entry);
				
				while (index >=0 ) {
					game.getWordFound()[index] = entry.charAt(0);
					index = game.getWordToFind().indexOf(entry, index + 1);
				}
			}else {
				setNumberOfErrors(++numberOfErrors);
			}
			game.getLetters().add(entry);
			System.out.println(HangmanGameConstants.Entries_Message + game.getLetters());
		}else {
		System.out.println("//////////" + HangmanGameConstants.NotValidValue_Message + "//////////");
		System.out.println(HangmanGameConstants.Entries_Message + game.getLetters());

		}
	}
	
	//method returning the state of the word found by the user until by now
	public String wordFoundContent() {
		StringBuilder builder = new StringBuilder();

		for(int i = 0; i< game.getWordFound().length; i++) {
			builder.append(game.getWordFound()[i]);
		}
		return builder.toString();
	}

	public int getNumberOfErrors() {
		return numberOfErrors;
	}

	public void setNumberOfErrors(int numberOfErrors) {
		this.numberOfErrors = numberOfErrors;
	}

}