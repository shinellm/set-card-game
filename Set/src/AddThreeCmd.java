import java.awt.*;
import java.util.ArrayList;

/**
 * AddThreeCmd.java
 * Command class to perform an add three cards command.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class AddThreeCmd extends Command {

	/**
	 * When the "Add Three Cards" button is clicked, draw three cards from
	 * the deck and add it to the cards at play.
	 * 
	 * @param dwg the drawing 
	 */
	public void executeClick(Drawing dwg) {
		ArrayList<Card> table = dwg.getTable();
		if (table.size() < 15) {
			//take 3 cards from the deck and add it to the cards on the table.
			int counter = 0;
			while (counter < 3) {
				dwg.addCard(); 
				counter += 1;
			}
		}
	}
}