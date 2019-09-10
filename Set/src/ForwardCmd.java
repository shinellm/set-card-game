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
	private ArrayList<Card> setToDeselect; //The last three cards highlighted

	/**
	 * When the forward arrow button is clicked, display another set that exists
	 * within the cards at play. If there are no more sets to display, clicking the forward
	 * button shouldn't change the last set highlighted.
	 * 
	 * @param dwg the drawing 
	 */
	public void executeClick(Drawing dwg) {
		sets = dwg.getAllSets();
		
		if (dwg.getHighlight() != sets.size()) {
			ArrayList<Card> setToHighlight = sets.get(dwg.getHighlight());
			
			if (dwg.getHighlight()-1 >= 0) {
				setToDeselect = sets.get(dwg.getHighlight()-1);
				
				for (int i = 0; i < 3; i++) { //Deselect the previously highlighted cards
					if (dwg.compareCards(setToDeselect.get(i),setToHighlight.get(i)) == false) {
						setToDeselect.get(i).unsetHighlighted();
					}
				}
			}
			
			for (int i = 0; i < 3; i++) { //Use the multi-dimensional ArrayList received to highlight only one index
				setToHighlight.get(i).setHighlighted();
			}
			
			dwg.incrementHighlight(); //Increments the index I took the cards out of and keeps track of the new index
			
			dwg.setHighlightedCards(setToHighlight); //Store currently highlighted cards
		}
	}
}
