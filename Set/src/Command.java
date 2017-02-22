import java.awt.*;
/**
 * Command.java
 * Superclass for commands.
 * Provides empty definitions for the executeClick method.
 * 
 * @author Shinell Manwaring
 */
public class Command {
<<<<<<< HEAD
  public void executeClick(Drawing dwg) { }
=======
	//private ArrayList<Card> threeCards = new ArrayList<Card>();
	
  public void executeClick(Drawing dwg) { }
  
//  public addToSet(Drawing dwg, Point p) {
//		int i = dwg.searchTable(p); // Find the index of the card containing p.
//		Card c = dwg.getCard(i); // Find the card at index i.
//
//		if (c != null) { // was there a Card containing p?
//			if (threeCards.size() < 3) {
//				threeCards.add(c); // save this card for when there's another click
//				dwg.highlight(c); // highlights the card that has been selected.
//			}
//			else {
//				// We have three cards in our ArrayList.
//				if (dwg.isASet(threeCards) == true) {//check if the ArrayList contains a proper set.
//					dwg.removeCard(compareForIndex(threeCards[0])); //remove the cards, which make up the set, from the drawing.
//					dwg.removeCard(compareForIndex(threeCards[1]));
//					dwg.removeCard(compareForIndex(threeCards[2]));
//				}
//				// Now we clear the ArrayList and can select 3 more cards.
//				threeCards.clear();
//			}
//		}	
//  }
>>>>>>> 405e63e5a83f9c16b1f7aea35390ae591cd0761d
}

