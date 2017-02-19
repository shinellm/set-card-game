/**
 * An abstract class for any type of
 * card deck. 
 * 
 * Written on 18 February 2017
 */
import java.util.ArrayList;
public abstract class GeneralDeck {
	private int currCardPointer = 0;
	private ArrayList <GeneralCard> arr = new ArrayList <GeneralCard>();
	
	//These methods are abstract, because they refer to the 
	//maximum number of cards in the deck which, while a final
	//value, varies across decks and so cannot be concretely 
	//referenced in this abstract class.
	public abstract void shuffle();
	public abstract boolean isEmpty();
	
	//Concrete classes
	/**
	 * Returns the current pointer Card, but
	 * additionally moves the pointer forward
	 * 
	 * @return: the current pointer Card
	 */
	public GeneralCard deal() {
		GeneralCard card = getPointer();
		currCardPointer += 1;
		return card;
	}
	
	public GeneralCard getAtIndex(int index) {
		return arr.get(index);
	}
	
	public void setAtIndex(int index, GeneralCard card) {
		arr.set(index, card);
	}
	
	/**
	 * Returns the Card being pointed to
	 * by the currCardPointer variable
	 * 
	 * @return: the pointer card
	 */
	public GeneralCard getPointer() {
		GeneralCard pointer = arr.get(currCardPointer);
		return pointer;
	}
}