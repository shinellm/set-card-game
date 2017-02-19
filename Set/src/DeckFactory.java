/**
 * Implements the Factory design pattern
 * to encapsulate the creation of each 
 * specific deck of cards.
 * 
 * Written on 18 February 2017
 */
public class DeckFactory {
	
	//use getDeck method to get object of type GeneralDeck
	public GeneralDeck getDeck(String deckType) {
		if (deckType == null) {
			return null;
		} 
		
		if (shapeType.equals("Set Deck")) {
			return Deck.getUniqueInstance();
		}
	}
}