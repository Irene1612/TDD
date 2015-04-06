import static org.junit.Assert.*;

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
		assertEquals(24, moveFromDeckToWasteController.getDeskSet().size());
	}

	@Test
	public void initializeWasteTest() {
		assertEquals(0, moveFromDeckToWasteController.getWasteSet().size());
	}

	@Test
	public void moveCardFromDeskToWasteTest() {

	}
}
