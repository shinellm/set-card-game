
/**
 * RestartCmd.java
 * Command class to perform a restart command.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class RestartCmd extends Command {

	/**
	 * When the "Restart" button is clicked, restart the mode the user is
	 * currently in. Shuffle the cards in the deck and have the decks pointer 
	 * return to index 0.  
	 * 
	 * @param dwg the drawing 
	 */
	public void executeClick(Drawing dwg) {
		Deck deck = Deck.getUniqueInstance();
		deck.shuffle();
		for (int i = 0; i < 12; i++) {
			Card card = deck.deal();
			dwg.replaceCard(i, card);
		}
		dwg.newHighlight();
	}
}