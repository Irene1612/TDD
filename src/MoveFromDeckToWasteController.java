import java.util.ArrayList;
import java.util.Random;

public class MoveFromDeckToWasteController {
	ArrayList<Card> deckSet;
	ArrayList<Card> wasteSet;

	public MoveFromDeckToWasteController() {
		this.initializeDeck();
		this.initializeWaste();
	}

	public void initializeDeck() {
		this.deckSet = new ArrayList<Card>();
		for (int i = 0; i < 24; i++) {
			Card card;
			do {
				Random r = new Random();
				card = new Card(r.nextInt(3), r.nextInt(11), true);
			} while (deckSet.contains(card));
			deckSet.add(card);
		}
	}

	public void initializeWaste() {
		this.wasteSet = new ArrayList<Card>();
	}

	public ArrayList<Card> getDeskSet() {
		return deckSet;
	}

	public ArrayList<Card> getWasteSet() {
		return wasteSet;
	}

}
