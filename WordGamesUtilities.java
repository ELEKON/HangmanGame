import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordGamesUtilities {
	
	private static BufferedReader reader;

	//reads a text file and returns a word to lower case type
	public static String wordSelectionFromFile() throws Exception  {
		
		try {
			reader = new BufferedReader(new FileReader(HangmanGameConstants.WORDS_TXT_FILE));
		} catch (FileNotFoundException e) {
			System.out.println(HangmanGameConstants.TXT_FILE_EXCEPTION_MESSAGE + e);
		}
	    String line = reader.readLine();
		
	    List<String> words = new ArrayList<String>();
	    while(line != null) {
	        String[] wordsOfLine = line.split(HangmanGameConstants.WORD_SPLITTER);
	        for(String word : wordsOfLine) {
	            words.add(word);
	        }
	        line = reader.readLine();
	    }

	    Random random = new Random(System.currentTimeMillis());
	    String randomWord = words.get(random.nextInt(words.size()));
		return randomWord.toLowerCase();
	}
}
