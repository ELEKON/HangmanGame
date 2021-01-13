import java.util.ArrayList;
import java.util.List;

public class WordGamesLogic{
	
	private HangmanGameEntity HangmanEntity;	
	
	//constructor injection
	public WordGamesLogic(HangmanGameEntity hangmanGameEntity) {
		this.HangmanEntity = hangmanGameEntity;
	}

	public void StartGame()  {
		//---------------Me TO POU KSEKINAEI TO PAIXNIDI--------------------//
		//user entries table become empty									//
		//find new word, for new run	 									//
		//table wordFound BE instantiated based on word length			    //		
		//------------------------------------------------------------------//
		
		List<String> empty = new ArrayList<>();
		HangmanEntity.setLetters(empty);
		
		try {
		HangmanEntity.setWordToFind(WordGamesUtilities.wordSelection());

		}catch(Exception ex){
			System.out.println(HangmanGameConstants.WORD_EXCEPTION_MESSAGE);
		}
		
		//final wordSize to be sure that its value be same at runtime 
		final int wordSize= HangmanEntity.getWordToFind().length(); 
		HangmanEntity.setWordFound(new char[wordSize]);
		
		for (int i = 0; i < wordSize; i++) {
			
			HangmanEntity.getWordFound()[i] =  HangmanGameConstants.LETTER_MASK;
		}
	}
		
	//method wordFound returns true if wordToFind==wordFound else returns false
	public boolean wordFound() {
		//System.out.println(HangmanEntity.getWordToFind().toString());
		if(HangmanEntity.getWordToFind().contentEquals(new String (HangmanEntity.getWordFound()))){
			HangmanEntity.setWin(true);
			return HangmanEntity.isWin();
		}else{
			HangmanEntity.setWin(false);
			return HangmanEntity.isWin();
		}
	}
	
	//method updating the wordFound table after user enter a character that match
	public void UpdateWordFoundTable(String entry) {
		
		//update only when a character has not already be entered		
		if(!HangmanEntity.getLetters().contains(entry) && entry.length() == 1) {
			
			if (HangmanEntity.getWordToFind().contains(entry)) {
				int index = HangmanEntity.getWordToFind().indexOf(entry);
				
				while (index >=0 ) {
					HangmanEntity.getWordFound()[index] = entry.charAt(0);
					index = HangmanEntity.getWordToFind().indexOf(entry, index + 1);
				}
			}else {
				
				int numberOfErrors=HangmanEntity.numberOfErrors + 1;
				HangmanEntity.setNumberOfErrors(numberOfErrors);
			}
			HangmanEntity.getLetters().add(entry);
			System.out.println(HangmanGameConstants.ENTRIES_MESSAGE + HangmanEntity.getLetters());
		}else {
		System.out.println("//////////" + HangmanGameConstants.NOT_VALID_VALUE_MESSAGE + "//////////");
		System.out.println(HangmanGameConstants.ENTRIES_MESSAGE + HangmanEntity.getLetters());

		}
	}
	
	//method returning the state of the word found by the user until by now
	public String wordFoundContent() {
		StringBuilder builder = new StringBuilder();

		for(int i = 0; i< HangmanEntity.getWordFound().length; i++) {
			builder.append(HangmanEntity.getWordFound()[i]);
		}
		return builder.toString();
	}



}