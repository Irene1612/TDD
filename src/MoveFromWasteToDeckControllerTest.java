import static org.junit.Assert.assertEquals;

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
}
