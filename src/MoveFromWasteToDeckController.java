import java.util.ArrayList;
import java.util.Random;


public class MoveFromWasteToDeckController {
	
	ArrayList<Card> deckSet;
	ArrayList<Card> wasteSet;
	
	public MoveFromWasteToDeckController() {
		this.initializeDeck();
		this.initializeWaste();
	}	

	public ArrayList<Card> getDeckSet() {
		return deckSet;
	}

	public ArrayList<Card> getWasteSet() {
		return wasteSet;
	}
	
	private void initializeDeck() {
		this.deckSet = new ArrayList<Card>();
	}
	
	private void initializeWaste() {
		this.wasteSet = new ArrayList<Card>();
		Random r = new Random();
		int wasteSize = r.nextInt(25);
		for (int i = 0; i < wasteSize; i++) {
			Card card;
			do {
				r = new Random();
				card = new Card(r.nextInt(3), r.nextInt(11), false);
			} while (this.wasteSet.contains(card));
			this.wasteSet.add(card);
		}
	}

}
