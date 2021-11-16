import java.util.ArrayList;
import java.util.List;

public class WordGamesLogic{
	
	private HangmanGameEntity HangmanEntity;	
	
	//constructor injection
	public WordGamesLogic(HangmanGameEntity hangmanGameEntity) {
		this.HangmanEntity = hangmanGameEntity;
	}

	public void startGame()  {
		//---------------PROCESS WHEN GAME STARTS--------------------//
		//1)user entries table become empty							 //
		//2)New word selection, from existing file  				 //
		//3)table wordFound BE instantiated based on word length     //
		//-----------------------------------------------------------//
		
		List<String> userEntries = new ArrayList<>();
		HangmanEntity.setAlreadyGivenLetters(userEntries);
		
		try {
			HangmanEntity.setWordOfGame(WordGamesUtilities.wordSelectionFromFile());
		} catch(Exception ex) {
			System.out.println(HangmanGameConstants.WORD_EXCEPTION_MESSAGE + ex);
		}
		
		//final wordSize to be sure that its value be same at runtime 
		final int wordSize= HangmanEntity.getWordOfGame().length();
		HangmanEntity.setWordStateDuringGame(new char[wordSize]);
		
		for (int i = 0; i < wordSize; i++) {
			
			HangmanEntity.getWordStateDuringGame()[i] =  HangmanGameConstants.LETTER_MASK;
		}
	}
		
	//method wordFound returns true if wordToFind==wordFound else returns false
	public boolean playerFoundTheWord() {
		//System.out.println(HangmanEntity.getWordToFind().toString());
		if (HangmanEntity.getWordOfGame().contentEquals(new String (HangmanEntity.getWordStateDuringGame()))) {
			HangmanEntity.setWin(true);
			return HangmanEntity.isWin();
		} else{
			HangmanEntity.setWin(false);
			return HangmanEntity.isWin();
		}
	}
	
	//method updating the wordStateDuringGame table after user enter a character that match
	public void UpdateWordDuringGame(String entry) {
		
		//update only when a character has not already be entered		
		if(!HangmanEntity.getAlreadyGivenLetters().contains(entry) && entry.length() == 1) {
			
			if (HangmanEntity.getWordOfGame().contains(entry)) {
				int index = HangmanEntity.getWordOfGame().indexOf(entry);
				
				while (index >= 0) {
					HangmanEntity.getWordStateDuringGame()[index] = entry.charAt(0);
					index = HangmanEntity.getWordOfGame().indexOf(entry, index + 1);
				}
			}else {
				int numberOfErrors = HangmanEntity.getNumberOfErrors();
				numberOfErrors++;
				HangmanEntity.setNumberOfErrors(numberOfErrors);
			}
			HangmanEntity.getAlreadyGivenLetters().add(entry);
			System.out.println(HangmanGameConstants.ENTRIES_MESSAGE + HangmanEntity.getAlreadyGivenLetters());
		} else {
		System.out.println("//////////" + HangmanGameConstants.NOT_VALID_VALUE_MESSAGE + "//////////");
		System.out.println(HangmanGameConstants.ENTRIES_MESSAGE + HangmanEntity.getAlreadyGivenLetters());

		}
	}
	
	//method returning the state of the word found by the user until by now
	public String wordFoundContent() {
		StringBuilder builder = new StringBuilder();

		for(int i = 0; i< HangmanEntity.getWordStateDuringGame().length; i++) {
			builder.append(HangmanEntity.getWordStateDuringGame()[i]);
		}
		return builder.toString();
	}



}