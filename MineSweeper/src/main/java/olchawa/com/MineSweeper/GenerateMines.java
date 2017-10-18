package olchawa.com.MineSweeper;

public class GenerateMines {

	public static void main(String[] args) {

		MineSweeperImpl mineSweeper = new MineSweeperImpl();

		try {
			mineSweeper.setMineField("*...\n..*.\n....");
			System.out.println(mineSweeper.getHintField());  

		} catch (IllegalArgumentException e) {

			System.out.println("Field String is in wrong format");

		} catch (IllegalStateException em) {
			System.out.println(" The mine-field has not been initialised");
		}

	}

}
