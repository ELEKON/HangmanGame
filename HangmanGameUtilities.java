import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//extra methods gia Handman Game alla kai implement orismenes methods apo to interface
//pou antiprosopevei tis vasikes methods afwn twn games
public class HangmanGameUtilities {

	//constructor of HangmanGameEntity class
	
	
	
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
				
				//newGame Object creation of HangmanGameEntity
				HangmanGameEntity newGame = new HangmanGameEntity();
				
				//set Number of player Errors to zero
				newGame.setNumberOfErrors(0);
				
				//set an empty string Array List to letters that player has use
				ArrayList<String> empty = new ArrayList<>();
				newGame.setLetters(empty);
				
				//h wordToFind einai h leksh tou newGame
				newGame.setWordToFind(chooseFromExistingWords()); 
				
				int wordSize = newGame.getWordToFind().length();
			
				String[] pinakas = new String [wordSize];
				
				for (int i = 0; i < pinakas.length; i++) {
					pinakas[i] =  "_";
				}
				
				newGame.setWordFound(pinakas);
				
				//deikse mou ton pinaka ths lekshs pou psaxnw na vrw sto guro 
				//System.out.println(Arrays.toString(newGame.getWordFound()));
			}
		
			//method pou sou gurnaei true an h wordToFind einai idia me ton pinaka wordFound
		
//			public boolean wordFound() {
//		
//				return wordToFind.contentEquals(new String(wordFound));
//			}
			
			//method updating the wordFound table after user enter a character
			
//			public void UpdateWordFoundTable(String entry) {
//				//update only when a character has not already be entered
//				if(!letters.contains(entry)) {
//					if (wordToFind.contains(entry + "")) {
//						int index = wordToFind.indexOf(entry);
//						
//						while (index >=0 ) {
//							wordFound[index] = entry.charAt(0);
//							index = wordToFind.indexOf(entry, index + 1);
//						}
//					}else {
//						numberOfErrors++;
//					}
//					letters.add(entry);
//				}
//			
//			}
			
			//method returning the state of the word found by the user until by now

//			private String wordFoundContent() {
//				StringBuilder builder = new StringBuilder();
//				//StringBuilder usage For example, if z refers to a string builder object whose current 
//				//contents are "start", then the method call z.append("le") would cause 
//				//the string builder to contain "startle", 
//				//whereas z.insert(4, "le") would alter the string builder to contain "starlet".
//				
//				for(int i = 0; i< wordFound.length; i ++) {
//					builder.append(wordFound[i]);
//					
//				}
//				return builder.toString();
//				
//			}
//			
//			public void play() {
//				try(Scanner input = new Scanner(System.in)){
//					while (numberOfErrors < MAX_ERRORS) {
//						System.out.println("\n Enter a letter : ");
//						String string = input.next();
//						
//						UpdateWordFoundTable(string);
//						
//						System.out.println("\n" + wordFoundContent());
//						
//						if(wordFound()) {
//							System.out.println("\n You win lucky!");
//							break;
//						}else {
//							System.out.println("\n Number of tries remaining:" + (MAX_ERRORS - numberOfErrors));
//						}
//					}
//					
//					if (numberOfErrors == MAX_ERRORS) {
//						System.out.println("\n Sorry, but you lost :( ");
//						System.out.println("\n The word was : " + wordToFind);
//					}
//				}
//			}
//
//			@Override
//			public boolean WinningMessage() {
//				//// TODO Auto-generated method stub
//				return false;
//			}
	
}
