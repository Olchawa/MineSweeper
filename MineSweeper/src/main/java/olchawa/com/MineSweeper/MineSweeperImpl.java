package olchawa.com.MineSweeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MineSweeperImpl implements MineSweeper {

	List<String> lines = new ArrayList<String>();
	
	int m, n;
	boolean[][] field;
	int[][] numbers;

	@Override
	public void setMineField(String mineField) throws IllegalArgumentException {

		lines = Arrays.asList(mineField.split("\n"));

		for (String s : lines) {
			if (!(s.length() == lines.get(0).length()) || !s.matches("[*.]*"))

				throw new IllegalArgumentException();
		}

		m = lines.size();
		n = lines.get(0).length();

		field = new boolean[m + 2][n + 2];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (lines.get(i - 1).charAt(j - 1) == '.') {
					field[i][j] = false;
				} else
					field[i][j] = true;
			}
		}

	}

	@Override
	public String getHintField() throws IllegalStateException {

		if (lines.isEmpty())
			throw new IllegalStateException();

		StringBuilder fieldString = new StringBuilder();

		// adding 2 to deal with boundary conditions
		numbers = new int[m + 2][n + 2];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				for (int a = i - 1; a <= i + 1; a++) {
					for (int b = j - 1; b <= j + 1; b++) {
						if (field[a][b])
							numbers[i][j]++;
					}
				}
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (field[i][j])
					fieldString.append("*");
				else
					fieldString.append(numbers[i][j]);

			}
			fieldString.append("\n");
		}

		return fieldString.toString();

	}
}
