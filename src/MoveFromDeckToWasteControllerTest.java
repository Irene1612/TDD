import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MoveFromDeckToWasteControllerTest {

	MoveFromDeckToWasteController moveFromDeckToWasteController;

	@Before
	public void before() {
		moveFromDeckToWasteController = new MoveFromDeckToWasteController();
	}

	@Test
	public void initializeDeckTest() {
		assertEquals(24, moveFromDeckToWasteController.getDeckSet().size());
	}

	@Test
	public void initializeWasteTest() {
		assertEquals(0, moveFromDeckToWasteController.getWasteSet().size());
	}

	@Test
	public void moveCardFromDeckToWasteWhenThreeOrMoreCardsLeftTest() {
		ArrayList<Card> cardsFromDeskToWaste = new ArrayList<Card>(3);
		int deckSize = moveFromDeckToWasteController.getDeckSet().size();
		int wasteSize = moveFromDeckToWasteController.getWasteSet().size();
		int numberOfCardsToRemove = 3;
		for (int i = 0; i < numberOfCardsToRemove; i++) {
			cardsFromDeskToWaste.add(moveFromDeckToWasteController.getDeckSet().get(i).uncover());
		}
		moveFromDeckToWasteController.moveCardFromDeckToWasteWhenThreeOrMoreCardsLeft();
		assertEquals(deckSize-3, moveFromDeckToWasteController.getDeckSet().size());
		assertEquals(wasteSize+3, moveFromDeckToWasteController.getWasteSet().size());
		for (int i = 0; i < numberOfCardsToRemove; i++) {
			assertEquals(cardsFromDeskToWaste.get(i), moveFromDeckToWasteController.getWasteSet().get(i));
		}
	}
	
	
}
