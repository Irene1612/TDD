import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class MoveFromWasteToFoundationControllerTest {

	MoveFromWasteToFoundationController moveFromWasteToFoundationController;
	Card cardOnTopWaste;

	@Before
	public void before() {
		moveFromWasteToFoundationController = new MoveFromWasteToFoundationController();
		do {
			Random r = new Random();
			cardOnTopWaste = new Card(r.nextInt(3), r.nextInt(11), false);
		} while (moveFromWasteToFoundationController.getWasteSet().contains(cardOnTopWaste));
	}

	@Test
	public void initializeWasteTest() {
		ArrayList<Card> wasteSet = moveFromWasteToFoundationController.getWasteSet();
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
		wasteSet.add(cardOnTopWaste);
		assertEquals(cardOnTopWaste, wasteSet.get(wasteSize));
	}
}
