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
	private ArrayList<Card> threeCards; // the index of the three cards selected in Solitaire

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
	public void executeClick(Drawing dwg) {
		int i = dwg.searchTable(p); // Find the index of the card containing p.
		Card c = dwg.getCard(i); // Find the card at index i.

		if (c != null) { // was there a Card containing p?
			if (threeCards.size() < 3) {
				threeCards.add(c); // save this card for when there's another click
				dwg.highlight(c); // highlights the card that has been selected.
			}
			else {
				// We have three cards in our ArrayList.
				if (dwg.isASet(threeCards) == true) {//check if the ArrayList contains a proper set.
					dwg.removeCard(compareForIndex(threeCards[0])); //remove the cards, which make up the set, from the drawing.
					dwg.removeCard(compareForIndex(threeCards[1]));
					dwg.removeCard(compareForIndex(threeCards[2]));
				}
				// Now we clear the ArrayList and can select 3 more cards.
				threeCards.clear();
			}
		}	  
	}
}
