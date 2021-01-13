import java.util.Scanner;
public class HangmanGameLogic{

			private WordGamesLogic game;
			private HangmanGameEntity hangmanGameEntity;
			
			
			
			public HangmanGameLogic(HangmanGameEntity hangmanGameEntity, WordGamesLogic wordGamesLogic) {
				this.hangmanGameEntity = hangmanGameEntity;
				this.game = wordGamesLogic;
			}



			public void play() {
				try(Scanner input = new Scanner(System.in)){					

					System.out.println(HangmanGameConstants.WELCOMING_MESSAGE);
					System.out.println(HangmanGameConstants.RULES_MESSAGE);
					System.out.println("\n" + game.wordFoundContent());
					
					while (hangmanGameEntity.getNumberOfErrors() < HangmanGameEntity.MAX_ERRORS) {

						String PlayerTry = input.next();						

						game.UpdateWordFoundTable(PlayerTry);
						System.out.println("\n" + game.wordFoundContent());

						if(game.wordFound()) {
							System.out.println(HangmanGameConstants.WINNING_MESSAGE);
							break;
						}else {
							if((HangmanGameEntity.MAX_ERRORS-hangmanGameEntity.getNumberOfErrors()) > 0) {
								System.out.println(HangmanGameConstants.TRIES_REMAINING + (HangmanGameEntity.MAX_ERRORS - hangmanGameEntity.getNumberOfErrors()));
							}else {
								System.out.println(HangmanGameConstants.LOSE_MESSAGE);
								System.out.println(HangmanGameConstants.THE_WORD_WAS + hangmanGameEntity.getWordToFind());
							}
						}
					}
				}
			}
}