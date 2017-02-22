
/**
 * NewTwelveCardsCmd.java
 * Command class to perform a add twelve new cards command.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class NewTwelveCardsCmd extends Command {
  
  /**
   * When the "New Twelve Cards" button is clicked, replace the
   * cards at play with twelve new cards.
   * 
   * @param dwg the drawing 
   */
  public void executeClick(Drawing dwg) {
	  Deck deck = Deck.getUniqueInstance();
	  for (int i = 0; i < 12; i++) {
		  Card card = deck.deal();
		  dwg.replaceCard(i, card);
	  }
  }
}