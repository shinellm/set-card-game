import java.util.ArrayList;

/**
 * ForwardCmd.java
 * Command class for cycling increasingly through the sets found in
 * the current cards at play.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class ForwardCmd extends Command {
	private ArrayList<Card> table = new ArrayList<Card>(); // The three cards, which make a set

	/**
	 * When the forward arrow button is clicked, display another set that exists
	 * within the cards at play. If there are no more sets to display, clicking the forward
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