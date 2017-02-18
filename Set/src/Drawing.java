/**
 * Drawing.java
 * Holds and draws all graphical objects
 * in the Applet
 */
import java.awt.*;
import java.util.ArrayList;
import java.lang.*;

import javax.smartcardio.Card;

public class Drawing {
	private ArrayList<Card> onTable = new ArrayList<Card>();
	private int num_cards;
	
	private final int CARDS_PER_ROW = 3;
	private final int MAX_ARR_LEN = 15;	//The most cards the ArrayList can hold
	private final int startX = 30;		//The playing fields's upper-left corner's x-coordinate
	private final int startY = 30;		//The playing fields's upper-left corner's y-coordinate
	
	public Drawing () {
		num_cards = 0;
	}
	
	/**
	 * Adds a card at the index in the array, or the location
	 * on the "table."
	 * 
	 * @param: index the index in the array at which the card is to be inserted
	 * @param: card the Card to be inserted
	 */
	public void addCard(int index, Card card) {
		onTable.add(index, card);
		num_cards += 1;
	}
	
	/**
	 * Removes a card from the ArrayList at the specified index
	 * 
	 * @param: index the index in the ArrayList at which the 
	 * card-to-be-removed is located.
	 */
	public void removeCard(int index) {
		onTable.remove(index);
		num_shapes = num_shapes - 1;
	}
	
	/**
	 * Replaces the card at the specified index
	 */
	public void replaceCard(int index, Card card) {
		onTable.set(index, card);
	}
	
	/**
	 * Given a Card object, this method
	 * searches through the Drawing's arraylist-
	 * representation of cards on the table to find
	 * the index of the matching card.
	 * 
	 * @param: card the Card thats index must be found
	 * @return: the index of the Card if it is found,
	 * @return: -1 otherwise
	 */
	public int searchTable(Card card) {
		for (int i = 0; i < num_cards; i++) {
			if (compareCards(onTable.get(i), card) == true) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Compares the contents of two cards
	 * @param: card1 the first Card to be compared
	 * @param: card2 the second Card to be compared
	 * @return: true if the two Cards' four fields
	 * all hold the same values, false otherwise
	 */
	private boolean compareCards(Card card1, Card card2) {
		if (card1.getColor() == card2.getColor()) {
			if (card1.getShape() == card2.getShape()) {
				if (card1.getCount() == card2.getCount()) {
					if (card1.getShading() == card2.getShading()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Draws (or redraws) each Card, based on the latest chages 
	 * per the shapes' attributes/params.
	 * 
	 * @param: page the graphical component upon which everythin
	 * is to be drawn.
	 */
	public void draw(Graphics page) {
		for (int i = 0; i < num_cards; i++) {
			if (((i + 5) % CARDS_PER_ROW) == 2) {
				onTable.get(i).draw(page, startX + 10, startY + 10 + (80*(i/CARDS_PER_ROW)));
			} else if (((i + 5) % CARDS_PER_ROW) == 0) { 
				onTable.get(i).draw(page, startX + 60, startY + 10 + (80*(i/CARDS_PER_ROW)));
			} else {
				onTable.get(i).draw(page, startX + 110, startY + 10 + (80*(i/CARDS_PER_ROW)));
			}
		}
	}
}

