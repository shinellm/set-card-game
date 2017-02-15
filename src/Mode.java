/**
 * A facade that the client interacts with, delegates 
 * to subclasses, Solitaire and Tutorial to
 * run specified mode.
 *  
 * @author Elizabeth
 *
 */
import java.util.ArrayList;

public class Mode {

	private Drawing dwg;
	
	/**
	 * Checks to see if the three given cards are a set.
	 * 
	 * @param set an arrayList of 3 cards to be checked
	 * @return true if the cards are a set
	 * 		   false if the cards are not a set
	 */
	public boolean isSet(ArrayList<Card> set){
		
		return false;
	}
	
	/**
	 * Finds all of the sets in the cards on the table.
	 * 
	 * @return a multi-dimensional arrayList containing 
	 * 		all of the sets found
	 */
	public ArrayList<ArrayList<Card>> getAllSets(){
		return null;
	}
	
	/**
	 * Go back to main screen
	 */
	public void back_home(){
		
	}
	
	/**
	 * Restart current mode. 
	 */
	public void restart(){
		
	}
}
