import java.awt.*;
import java.util.ArrayList;

/**
 * HintCmd.java
 * Command class to perform a hint command.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class HintCmd extends Command {
	private ArrayList<Card> setOfThree = new ArrayList<Card>(); // The three cards, which make a set

	/**
	 * Creates a private arrayList of three cards, which make a set.
	 * 
	 * @param arr an ArrayList of cards, which make a set 
	 */
	public HintCmd(ArrayList<Card> arr) {
		for (int i = 0; i < 3; i++) {
			setOfThree.add(i, arr.get(i));
		}
	}

	/**
	 * When the "Hint" button is clicked, check the cards at play
	 * and determine if there is a set. If there is a set, highlight
	 * the cards that make up that set. If there are no sets, display the 
	 * message "There are zero sets found."
	 * 
	 * @param dwg the drawing 
	 */
	public void executeClick(Drawing dwg) {
		for (int i = 0; i < setOfThree.size(); i++) {
			int tracker = compareForIndex(setOfThree.get(i));
			dwg.getCard(tracker).highlight();  
		}
	}
}