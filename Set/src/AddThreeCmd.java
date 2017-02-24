/**
 * AddThreeCmd.java
 * Command class to perform an add three cards command.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class AddThreeCmd extends Command {

	/**
	 * When the "Add Three Cards" button is clicked, draw three cards from
	 * the deck and add it to the cards at play.
	 * 
	 * @param dwg the drawing 
	 */
	public void executeClick(Drawing dwg) {
		Deck deck = Deck.getUniqueInstance();
		if (dwg.getTableSize() < 15 & deck.getPointerIndex() != 81) { //take 3 cards from the deck and add it to the cards on the table.
			for (int i = 0; i < 3; i++) {
				Card card = deck.deal();
				dwg.addCard(i + 12, card);
			}
		}
	}
}
