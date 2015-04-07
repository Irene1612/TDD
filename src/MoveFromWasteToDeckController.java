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
		deckSet = new ArrayList<Card>();
	}
	
	private void initializeWaste() {
		wasteSet = new ArrayList<Card>();
		Random r = new Random();
		int wasteSize = r.nextInt(25);
		for (int i = 0; i < wasteSize; i++) {
			Card card;
			do {
				r = new Random();
				card = new Card(r.nextInt(3), r.nextInt(11), false);
			} while (wasteSet.contains(card));
			wasteSet.add(card);
		}
	}

	public void moveCardFromWasteToDeck() {
		int wasteSize = wasteSet.size();
		for (int i = 0; i < wasteSize; i++) {
			deckSet.add(wasteSet.get(i).cover());
		}
		for (int i = 0; i < wasteSize; i++) {
			wasteSet.remove(0);
		}
		
	}

}
