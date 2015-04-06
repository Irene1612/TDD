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
	public void moveCardFromDeckToWasteTest() {
		ArrayList<Card> cardsFromDeskToWaste = new ArrayList<Card>(3);
		for (int i = 0; i < 3; i++) {
			cardsFromDeskToWaste.add(moveFromDeckToWasteController.getDeckSet().get(i).uncover());
		}
		moveFromDeckToWasteController.moveCardFromDeckToWaste();
		assertEquals(21, moveFromDeckToWasteController.getDeckSet().size());
		assertEquals(3, moveFromDeckToWasteController.getWasteSet().size());
		for (int i = 0; i < 3; i++) {
			assertEquals(cardsFromDeskToWaste.get(i), moveFromDeckToWasteController.getWasteSet().get(i));
		}
	}
}
