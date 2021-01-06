import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanGameLogic implements PlayGame{

			//create a HangmanGameEntity Object
			HangmanGameEntity newGame = new HangmanGameEntity();
			private int numberOfErrors;

			//method of word selection, for each new run	
			@SuppressWarnings("resource")
			public String chooseFromExistingWords() throws Exception  {
				// pass the text file path as parameter 
				File file = new File("C:\\Users\\EleutheriadisK\\eclipse-workspace\\Hangman\\src\\AllExistingWords"); 
				Scanner sc;
				sc = new Scanner(file);
				String[] words = sc.next().split(","); 
				Random rand = new Random();
				int randomElement = rand.nextInt(words.length);
				return words[randomElement];
			}
			
			 public String getRandomElement(List<String> list) 
			    { 
			        Random rand = new Random(); 
			        return list.get(rand.nextInt(list.size())); 
			    } 
		
			//method of new run of the game
			public void StartNewGame() throws Exception {
				//---------------Me TO POU KSEKINAEI TO PAIXNIDI--------------------//
				//pinakas grammatwn pou exei dwsei o xrhsths adeiazei				//
				//nea leksh mpainei sto paixnidi									//
				//pinakas word Found BE instantiated vasei tou megethous ts lekshs  //		
				//------------------------------------------------------------------//
				
				ArrayList<String> empty = new ArrayList<>();
				newGame.setLetters(empty);
				
				newGame.setWordToFind(chooseFromExistingWords()); 
				
				int wordSize = newGame.getWordToFind().length();
			
				newGame.setWordFound(new char[wordSize]);
				
				for (int i = 0; i < newGame.getWordFound().length; i++) {
					newGame.getWordFound()[i] =  '+';
				}
				
			}
		
			//method pou sou gurnaei true an h wordToFind einai idia me ton pinaka wordFound alliws false
			public boolean wordFound() {
				// helper gia na lunw to grufo mexri na ftoiaksw teleiws ola ta themata
				//System.out.println(newGame.getWordToFind().toString());
				if(newGame.getWordToFind().contentEquals(new String (newGame.getWordFound()))){
					newGame.setWin(true);
					return newGame.isWin();
				}else{
					newGame.setWin(false);
					return newGame.isWin();
				}
			}
			
			//method updating the wordFound table after user enter a character that match
			public void UpdateWordFoundTable(String entry) {

				//update only when a character has not already be entered		
				if(!newGame.getLetters().contains(entry)) {
					
					if (newGame.getWordToFind().contains(entry)) {
						int index = newGame.getWordToFind().indexOf(entry);
						
						while (index >=0 ) {
							newGame.getWordFound()[index] = entry.charAt(0);
							index = newGame.getWordToFind().indexOf(entry, index + 1);
						}
					}else {
						numberOfErrors++;
					}
					newGame.getLetters().add(entry);
				}
			}
			
			//method returning the state of the word found by the user until by now
			private String wordFoundContent() {
				StringBuilder builder = new StringBuilder();
				//StringBuilder usage For example, if z refers to a string builder object whose current 
				//contents are "start", then the method call z.append("le") would cause 
				//the string builder to contain "startle", 
				//whereas z.insert(4, "le") would alter the string builder to contain "starlet".
				//HangmanGameEntity newGame = new HangmanGameEntity();

				for(int i = 0; i< newGame.getWordFound().length; i++) {
					builder.append(newGame.getWordFound()[i]);
					
				}
				return builder.toString();
				
			}
			
			public void play() {
				try(Scanner input = new Scanner(System.in)){					
					
					System.out.println("\nHello Hangman Player!!! Have a nice Game!!! ");
					
					while (numberOfErrors < HangmanGameConstants.MAX_ERRORS) {
						System.out.println("\nEnter a letter : ");
						String string = input.next();
												
						UpdateWordFoundTable(string);
						System.out.println("\n" + wordFoundContent());
						
						System.out.println("\n Your entries are: " + newGame.getLetters());

						if(wordFound()) {
							System.out.println("\n You win lucky!");
							break;
						}else {
							System.out.println("\n Number of tries remaining:" + (HangmanGameConstants.MAX_ERRORS - numberOfErrors));
						}
					}
					
					if (numberOfErrors == HangmanGameConstants.MAX_ERRORS) {
						System.out.println("\n Sorry, but you lost :( ");
						System.out.println("\n The word was : " + newGame.getWordToFind());
					}
				}
			}
	
}