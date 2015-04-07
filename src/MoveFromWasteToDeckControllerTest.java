import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MoveFromWasteToDeckControllerTest {

	MoveFromWasteToDeckController moveFromWasteToDeckController;

	@Before
	public void before() {
		moveFromWasteToDeckController = new MoveFromWasteToDeckController();
	}

	@Test
	public void initializeDeckTest() {
		assertEquals(0, moveFromWasteToDeckController.getDeckSet().size());
	}

	@Test
	public void initializeWasteTest() {
		ArrayList<Card> wasteSet = moveFromWasteToDeckController.getWasteSet();
		int wasteSize = wasteSet.size();
		assertTrue(wasteSize > 0 && wasteSize < 25);
		for (int i = 0; i < wasteSize; i++) {
			Card card = wasteSet.get(i);
			assertNotNull(card);
			assertFalse(card.isCovered());
			wasteSet.remove(card);
			assertFalse(wasteSet.contains(card));
			wasteSet.add(card);
		}
	}
}
