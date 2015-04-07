import java.util.ArrayList;


public class MoveFromWasteToDeckController {
	
	ArrayList<Card> deckSet;
	
	public MoveFromWasteToDeckController() {
		this.initializeDeck();
	}

	private void initializeDeck() {
		this.deckSet = new ArrayList<Card>();
	}

	public ArrayList<Card> getDeckSet() {
		return deckSet;
	}

}
