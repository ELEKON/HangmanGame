import java.util.Scanner;
public class HangmanGameUtilities{

			private WordGamesUtilities game = new WordGamesUtilities();
			private HangmanGameEntity entity = new HangmanGameEntity();
			
			public void play() {
				try(Scanner input = new Scanner(System.in)){					

					System.out.println(HangmanGameConstants.Welcoming_Message);
					System.out.println(HangmanGameConstants.Rules_Message);
					System.out.println("\n" + game.wordFoundContent());
					
					while (game.getNumberOfErrors() < HangmanGameConstants.MAX_ERRORS) {

						String PlayerTry = input.next();						

						game.UpdateWordFoundTable(PlayerTry);
						System.out.println("\n" + game.wordFoundContent());

						if(game.wordFound()) {
							System.out.println(HangmanGameConstants.Winning_Message);
							break;
						}else {
							if((HangmanGameConstants.MAX_ERRORS-game.getNumberOfErrors()) > 0) {
								System.out.println(HangmanGameConstants.Tries_Remaining + (HangmanGameConstants.MAX_ERRORS - game.getNumberOfErrors()));
							}else {
								System.out.println(HangmanGameConstants.Lose_Message);
								System.out.println(HangmanGameConstants.The_Word_Was + entity.getWordToFind());
							}
						}
					}
				}
			}
}