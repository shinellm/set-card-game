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
	private ArrayList<ArrayList<Card>> sets; // The three cards, which make a set

	/**
	 * When the forward arrow button is clicked, display another set that exists
	 * within the cards at play. If there are no more sets to display, clicking the forward
	 * button shouldn't change the last set highlighted.
	 * 
	 * @param dwg the drawing 
	 */
	public void executeClick(Drawing dwg) {
		sets = dwg.getAllSets();
		ArrayList<Card> setToHighlight = sets.get(0);
		for (int i = 0; i < 3; i++) { //Use the multi-dimensional ArrayList received to highlight only one index
			setToHighlight.get(i).setHighlighted();
		}
	}//Need a way to keep track of the index I took the cards out of
}