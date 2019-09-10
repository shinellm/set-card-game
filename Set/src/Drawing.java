/**
 * Drawing.java
 * Holds and draws all graphical objects
 * in the Applet
 * 
 * @Rory Bennett
 */
import java.awt.*;
import java.util.ArrayList;



public class Drawing {
	private ArrayList<Card> onTable = new ArrayList<Card>();
	private ArrayList<Card> highlightedCards;
	private ArrayList<Card> hintCards;
	private boolean showingHint;
	private int num_cards;
	private int highlight;
	
	private final int CARDS_PER_ROW = 3;
	private final int MAX_ARR_LEN = 15;	//The most cards the ArrayList can hold
	
	public Drawing () {
		num_cards = 0;
		highlight = 0;
		showingHint = false;
	}
	
	/**
	 * Adds a card at the index in the array, or the location
	 * on the "table."
	 * 
	 * @param: card the Card to be inserted
	 * @param: index the index at which the Card is to be inserted
	 */
	public void addCard(int index, Card card) {
		onTable.add(index, card);
		num_cards += 1;
	}
	
	public int getTableSize() {
		return onTable.size();
	}
	
	/**
	 * Removes a card from the ArrayList at the specified index
	 * 
	 * @param: index the index in the ArrayList at which the 
	 * card-to-be-removed is located.
	 */
	public void removeCard(int index) {
		onTable.get(index).unsetHighlighted();
		onTable.remove(index);
		num_cards = num_cards - 1;
	}
	
	/**
	 * Replaces the card at the specified index
	 */
	public void replaceCard(int index, Card card) {
		onTable.get(index).unsetHighlighted();
		onTable.remove(index);
		onTable.add(index, card);
	}
	
	/**
	 * Returns the onTable Card ArrayList
	 */
	public ArrayList<Card> getTable() {
		return onTable;
	}
	
	/**
	 * Given a Card object, this method
	 * searches through the Drawing's arraylist-
	 * representation of cards on the table to find
	 * the index of the matching card.
	 * 
	 * @param: p the Point at which the actionEvent occurred,
	 * assuming the click in the canvas was meant for a Card object.
	 * @return: the index of the Card if it is found,
	 * @return: -1 otherwise
	 */
	public int searchTable(Point p) {
		for (int i = 0; i < num_cards; i++) {
			if (onTable.get(i).containsPoint(p) == true) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Given a Card, this method searches through
	 * this Drawing's table ArrayList and compares
	 * the four fields values with those of each 
	 * card in the ArrayList.
	 * 
	 * @param: card a card, the index for which the
	 * table ArrayList is being searched.
	 * @return: the index of the Card if it appears 
	 * on the table, -1 otherwise.
	 */
	public int compareForIndex(Card card) {
		for (int i = 0; i < num_cards; i++) {
			if ((card.getCount() == onTable.get(i).getCount())
				&& (card.getShape() == onTable.get(i).getShape())
				&& (card.getColor() == onTable.get(i).getColor())
				&& (card.getShading() == onTable.get(i).getShading())) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns the Card at the specified index in the
	 * table ArrayList. Used to get each card in the 
	 * Drawing's ArrayList, to then see if one of them 
	 * contains the point at which a click on the canvas
	 * in Solitaire mode occurred.
	 */
	public Card getCard(int index) {
		return onTable.get(index);
	}

	/**
	 * Compares the contents of two cards
	 * @param: card1 the first Card to be compared
	 * @param: card2 the second Card to be compared
	 * @return: true if the two Cards' four fields
	 * all hold the same values, false otherwise
	 */
	public boolean compareCards(Card card1, Card card2) {
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
	 * Given three unique Card objects, checks 
	 * to see if together, they constitute a 
	 * valid set.
	 * 
	 * @param: list the ArrayList containing the three
	 * Cards to be checked for sethood
	 * @return: true if they do make a set, false otherwise
	 */
	public boolean isASet(ArrayList<Card> list) {
		Card card1 = list.get(0);
		Card card2 = list.get(1);
		Card card3 = list.get(2);
		
		if (allOrNothing(card1.getColor(), card2.getColor(), card3.getColor())
				&& allOrNothing(card1.getShape(), card2.getShape(), card3.getShape())
				&& allOrNothing(card1.getCount(), card2.getCount(), card3.getCount())
				&& allOrNothing(card1.getShading(), card2.getShading(), card3.getShading())) {
			return true;
		}
		
		return false;
	}
	
	/**
	* Returns the ArrayList of all possible sets 
	* out of the existing cards on the table
	*
	* @return: allSets the ArrayList of each ArrayList that
	* represents each set on the table.
	*/
	public ArrayList<ArrayList<Card>> getAllSets() {
		ArrayList<ArrayList<Card>> allSets = new ArrayList<ArrayList<Card>>();
		int arr_index = 0;
		for (int i = 0; i < num_cards - 2; i++) {
			for (int j = i + 1; j < num_cards - 1; j++) {
				for (int k = j + 1; k < num_cards; k++) {
					ArrayList<Card> singleSet = new ArrayList<Card>();
					singleSet.add(0, onTable.get(i));
					singleSet.add(1, onTable.get(j));
					singleSet.add(2, onTable.get(k));
					if (isASet(singleSet) == true) {
						allSets.add(arr_index, singleSet);
						arr_index += 1;
					}
				}
			}
		}
		return allSets;
	}
	
	/**
	 * Helper method that checks whether or not given 
	 * three values, they are either all the same or 
	 * all different
	 * 
	 * @param: one the first value to be compared
	 * @param: two the second value
	 * @param: three the third value
	 * @returns: true if one, two, and three are all equal
	 * or all unequal, false otherwise
	 */
	private boolean allOrNothing(int one, int two, int three) {
		if ((one == two) && (one == three) && (two == three)) {
			return true;
		} else if ((one != two ) && (one != three) && (two != three)) {
			return true;
		} 
		
		return false;
	}
	
	/**
	 * Getters and setters for highlighted cards.
	 */
	public ArrayList<Card> getHighlightedCards() {
		return highlightedCards;
	}
	
	public void setHighlightedCards(ArrayList<Card> cards) {
		highlightedCards = cards;
	}
	
	public void clearHighlightedCards() {
		for (int i = 0; i < 3; i++) {
			highlightedCards.get(i).unsetHighlighted();
		}
	}
	
	/**
	 * Gets the current value of highlight
	*/
	public int getHighlight() {
		return highlight;
	}

	public void incrementHighlight() {
		highlight += 1;
	}

	public void decrementHighlight() {
		highlight -= 1;
	}

	/**
	 * Sets highlight back to zero, for when
	 * a set of 12 new cards are dealt in Tutorial
	*/
	public void newHighlight() {
		highlight = 0;
	}
	
	/**
	 * Getters and setters for hint cards.
	 */
	public ArrayList<Card> getHintCards() {
		return hintCards;
	}
	
	public void setHintCards(ArrayList<Card> cards) {
		hintCards = cards;
	}
	
	public void clearHintCards() {
		for (int i = 0; i < 3; i++) {
			hintCards.get(i).unsetHint();
		}
	}
	
	/**
	 * Gets the current value of showingHint
	*/
	public boolean isShowingHint() {
		return showingHint;
	}
	
	/**
	 * Sets showingHint to true.
	*/
	public void showingHint() {
		showingHint = true;
	}
	
	/**
	 * Sets showingHint to false.
	*/
	public void notShowingHint() {
		showingHint = false;
	}
	

	/**
	 * Draws (or redraws) each Card, based on the latest changes 
	 * per the shapes' attributes/params.
	 * 
	 * @param: page the graphical component upon which everythin
	 * is to be drawn.
	 * @param: startX The playing field's upper-left corner's x-coordinate
	 * @param: startY The playing field's upper-left corner's y-coordinate
	 */
	public void draw(Graphics page) {
		for (int i = 0; i < num_cards; i++) {
			if (((i + 5) % CARDS_PER_ROW) == 2) {
				onTable.get(i).draw(page, Mode.canvasX + 10, Mode.canvasY + 10 + (80*(i/CARDS_PER_ROW)));
			} else if (((i + 5) % CARDS_PER_ROW) == 0) { 
				onTable.get(i).draw(page, Mode.canvasX + 60, Mode.canvasY + 10 + (80*(i/CARDS_PER_ROW)));
			} else {
				onTable.get(i).draw(page, Mode.canvasX + 110, Mode.canvasY + 10 + (80*(i/CARDS_PER_ROW)));
			}
		}
	}
}

