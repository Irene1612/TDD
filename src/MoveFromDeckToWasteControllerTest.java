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
		int numberOfCardsToRemove = 3;
		ArrayList<Card> cardsFromDeskToWaste = new ArrayList<Card>(numberOfCardsToRemove);
		int deckSize = moveFromDeckToWasteController.getDeckSet().size();
		int wasteSize = moveFromDeckToWasteController.getWasteSet().size();		
		for (int i = 0; i < numberOfCardsToRemove; i++) {
			cardsFromDeskToWaste.add(moveFromDeckToWasteController.getDeckSet().get(i).uncover());
		}
		moveFromDeckToWasteController.moveCardFromDeckToWasteWhenThreeOrMoreCardsLeft();
		assertEquals(deckSize - numberOfCardsToRemove, moveFromDeckToWasteController.getDeckSet().size());
		assertEquals(wasteSize + numberOfCardsToRemove, moveFromDeckToWasteController.getWasteSet().size());
		for (int i = 0; i < numberOfCardsToRemove; i++) {
			assertEquals(cardsFromDeskToWaste.get(i), moveFromDeckToWasteController.getWasteSet().get(i));
		}
	}

	@Test
	public void moveCardFromDeckToWasteWhenTwoCardsLeftTest() {
		int numberOfCardsToRemove = 2;
		ArrayList<Card> cardsFromDeskToWaste = new ArrayList<Card>(numberOfCardsToRemove);
		int deckSize = moveFromDeckToWasteController.getDeckSet().size();
		for (int i = 0; i < deckSize-numberOfCardsToRemove; i++) {
			moveFromDeckToWasteController.getDeckSet().remove(i);
		}
		deckSize = moveFromDeckToWasteController.getDeckSet().size();
		int wasteSize = moveFromDeckToWasteController.getWasteSet().size();
		for (int i = 0; i < numberOfCardsToRemove; i++) {
			cardsFromDeskToWaste.add(moveFromDeckToWasteController.getDeckSet().get(i).uncover());
		}
		moveFromDeckToWasteController.moveCardFromDeckToWasteWhenTwoCardsLeft();
		assertEquals(deckSize - numberOfCardsToRemove, moveFromDeckToWasteController.getDeckSet().size());
		assertEquals(wasteSize + numberOfCardsToRemove, moveFromDeckToWasteController.getWasteSet().size());
		for (int i = 0; i < numberOfCardsToRemove; i++) {
			assertEquals(cardsFromDeskToWaste.get(i), moveFromDeckToWasteController.getWasteSet().get(i));
		}
	}
}
