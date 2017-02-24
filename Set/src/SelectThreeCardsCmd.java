import java.awt.*;
import java.util.ArrayList;

/**
 * SelectThreeCardsCmd.java
 * Command class to highlight cards, store their index as they're selected, and
 * validate if they are a set.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class SelectThreeCardsCmd extends Command {
	private ArrayList<Card> threeCards = new ArrayList<Card>(); // the index of the three cards selected in Solitaire

	/**
	 * When a card is selected in Solitaire mode, the card's index is store in the
	 * the array. The card itself is also highlighted on the table. Once there are three
	 * card index's in the array, the selected cards are then checked to determine if they are
	 * a set. If they are a set, they are removed from the table and replaced
	 * with new cards. If they are not a set, they are unselected.
	 * 
	 * @param p the coordinates of the click
	 * @param dwg the drawing 
	 */
	public void executeClick(Drawing dwg) {	}

	public void addToSet(Drawing dwg, Point p) {
		int i = dwg.searchTable(p); // Find the index of the card containing p.
		Card c = dwg.getCard(i); // Find the card at index i.
		Deck deck = Deck.getUniqueInstance();

		if (c != null) { // was there a Card containing p?
			if (threeCards.size() < 2) {
				threeCards.add(c); // save this card for when there's another click
				c.setHighlighted(); // highlights the card that has been selected.
			}
			else {
				threeCards.add(c);
				// We have three cards in our ArrayList.
				if (dwg.isASet(threeCards)) {
					if (dwg.getTableSize() == 12) {
						//ArrayList contains a proper set and 12 cards on table
						if (deck.getPointerIndex() != 81) { //Checks if there enough cards in the deck to replace the selected set
							for (int j = 0; j < 3; j++) {
								Card card = deck.getPointer();
								int k = dwg.compareForIndex(threeCards.get(j));
								dwg.replaceCard(k, card);
								deck.deal();
							}
						}
						else {
							for (int j = 0; j < 3; j++) {
								dwg.removeCard(dwg.compareForIndex(threeCards.get(j)));
							}
						}
					} 
					else if (((dwg.getTableSize() == 15) || (dwg.getTableSize() < 12))) {
						//ArrayList contains a proper set and 15 cards on table
						for (int j = 0; j < 3; j++) {
							dwg.removeCard(dwg.compareForIndex(threeCards.get(j)));
						}
					}
					dwg.notShowingHint();
				}
				else if ((dwg.getTableSize() == 15) || (dwg.getTableSize() < 12)) {
					for (int j = 0; j < 3; j++) { //Deselect the previously highlighted cards
							threeCards.get(j).unsetHighlighted();
					}
				}
				// Now we clear the ArrayList and can select 3 more cards.
				threeCards.clear();
			}
		}
	}
}
