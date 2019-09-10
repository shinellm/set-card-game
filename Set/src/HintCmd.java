import java.util.ArrayList;

/**
 * HintCmd.java
 * Command class to perform a hint command.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class HintCmd extends Command {
	private ArrayList<ArrayList<Card>> sets; //The current cards at play
	
	/**
	 * When the "Hint" button is clicked, check the cards at play
	 * and determine if there is a set. If there is a set, highlight
	 * the cards that make up that set. If there are no sets, display the 
	 * message "There are zero sets found."
	 * 
	 * @param dwg the drawing 
	 */
	public void executeClick(Drawing dwg) {
		sets = dwg.getAllSets();
		if (sets.isEmpty() != true) {
			ArrayList<Card> setToHighlight = sets.get(0);
			
			if (dwg.isShowingHint() == false) { //Is a hint already being shown?
				for (int i = 0; i < 3; i++) { //Use the multi-dimensional ArrayList received to highlight only one index
					setToHighlight.get(i).setHint();
				}
				dwg.setHintCards(setToHighlight);
				//setToHighlight.clear();
				dwg.showingHint();
			}
		}
	}
}