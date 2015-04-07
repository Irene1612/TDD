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
		moveFromWasteToFoundationController.wasteSet.add(cardOnTopWaste);
		do {
			Random r = new Random();
			cardOnTopWaste = new Card(r.nextInt(3), r.nextInt(11), false);
		} while (moveFromWasteToFoundationController.getWasteSet().contains(cardOnTopWaste));
		moveFromWasteToFoundationController.initializeFoundations(cardOnTopWaste.getNumber(), cardOnTopWaste
				.getSuit());
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
		assertEquals(cardOnTopWaste, wasteSet.get(wasteSize));
	}

	@Test
	public void initializeFoundationsTest() {
		ArrayList<ArrayList<Card>> foundations = moveFromWasteToFoundationController.getFoundationsSet();
		int numberOfFoundations = foundations.size();
		assertEquals(4, numberOfFoundations);
		ArrayList<Card> foundationOfDestination = foundations.get(cardOnTopWaste.getSuit());
		assertEquals(cardOnTopWaste.getNumber(), foundationOfDestination.size());
	}

	@Test
	public void moveFromWasteToFoundationTest() {
		int foundationSizeBeforeMove = moveFromWasteToFoundationController.getFoundationsSet().get(
				cardOnTopWaste.getSuit()).size();
		int wasteSizeBeforeMove = moveFromWasteToFoundationController.getWasteSet().size();
		moveFromWasteToFoundationController.moveFromWasteToFoundation();
		assertEquals(wasteSizeBeforeMove - 1, moveFromWasteToFoundationController.getWasteSet().size());
		assertEquals(foundationSizeBeforeMove, moveFromWasteToFoundationController.getFoundationsSet().get(
				cardOnTopWaste.getSuit()).size());
		assertEquals(cardOnTopWaste, moveFromWasteToFoundationController.getFoundationsSet().get(
				cardOnTopWaste.getSuit()).get(foundationSizeBeforeMove+1));
	}
}
