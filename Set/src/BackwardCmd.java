import java.util.ArrayList;

/**
 * BackwardCmd.java
 * Command class for cycling decreasingly through the sets found in
 * the current cards at play.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class BackwardCmd extends Command {
	private ArrayList<Card> table = new ArrayList<Card>(); // The three cards, which make a set

	/**
	 * When the backward arrow button is clicked, display the previously seen set that exists
	 * within the cards at play. If there are no more sets to display, clicking the backward
	 * button shouldn't change the last set highlighted.
	 * 
	 * @param dwg the drawing 
	 */
	public void executeClick(Drawing dwg) {
		table = dwg.getTable();
		ArrayList<Card> setOfThree = table.getOneSet(); //Use the array received only highlight one index
		for (int i = 0; i < 3; i++) {
			setOfThree.get(i).setHighlighted();
		}
	}//Need a way to keep track of the index I took the cards out of
}