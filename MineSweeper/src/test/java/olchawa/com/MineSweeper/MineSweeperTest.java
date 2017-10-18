package olchawa.com.MineSweeper;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;

public class MineSweeperTest {

	MineSweeperImpl mineSweeper = new MineSweeperImpl();

	@Test
	public void getHintFieldTest() {
		mineSweeper.setMineField("*...\n..*.\n....");

		assertEquals("*211" + "\n" + "12*1" + "\n" + "0111" + "\n", mineSweeper.getHintField());
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void IllegalArgumentExceptionTest() {

		thrown.expect(IllegalArgumentException.class);
		mineSweeper.setMineField("*...*.\n..*.\n.*");

	}

	@Test
	public void IllegalArgumentExceptionTest2() {

		thrown.expect(IllegalArgumentException.class);
		mineSweeper.setMineField("*.3432*.\n12nb*.\n.*");

	}

	@Test
	public void IllegalStateExceptionTest() {

		thrown.expect(IllegalStateException.class);
		mineSweeper.getHintField();

	}

}
