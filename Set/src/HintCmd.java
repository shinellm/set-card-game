import java.util.ArrayList;

/**
 * HintCmd.java
 * Command class to perform a hint command.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class HintCmd extends Command {
	private ArrayList<Card> table; //The current cards at play
	/**
	 * When the "Hint" button is clicked, check the cards at play
	 * and determine if there is a set. If there is a set, highlight
	 * the cards that make up that set. If there are no sets, display the 
	 * message "There are zero sets found."
	 * 
	 * @param dwg the drawing 
	 */
	public void executeClick(Drawing dwg) {
		table = dwg.getTable();
		ArrayList<ArrayList<Card>> set = table.getAllSets(); //Use the array received only highlight one index
		set.setHighlighted();  
		
	}
}