package cell1_5;

import static cell1_5.CellFrame.*;

import java.awt.AWTException;
import java.awt.Robot;

class Cell {
	
	static Cell run = new Cell();
	
	static final int SIZE = 48;
	static int delay = 100;

	static boolean[][] caculate = new boolean[SIZE + 2][SIZE + 2];
	static boolean sign = false;
			
	static int count(boolean[][] _caculate,int y,int x){
		int c = 0;
		for (int row = -1; row < 2; row++) 
			for (int col = -1; col < 2; col++) 
				if (_caculate[y+row][x+col]) c++;
		if (_caculate[y][x]) c--;
		return c;
	}
	
	void Main() {
		for (int row = 1; row <= SIZE; row++) {
			for (int col = 1; col <= SIZE; col++)
				caculate[row][col] = getcondition(row, col);
			caculate[row][0] = getcondition(row, SIZE);
			caculate[row][SIZE + 1] = getcondition(row, 1);
			caculate[0][row] = getcondition(SIZE, row);
			caculate[SIZE + 1][row] = getcondition(1, row);
		}
		caculate[0][0] = getcondition(SIZE, SIZE);
		caculate[0][SIZE + 1] = getcondition(SIZE, 1);
		caculate[SIZE + 1][0] = getcondition(1, SIZE);
		caculate[SIZE + 1][SIZE + 1] = getcondition(1, 1);
		
		for (int row = 1; row <= SIZE; row++)
			for (int col = 1; col <= SIZE; col++) {
				if(getcondition(row, col)) {
					if (count(caculate, row, col) > 3 | count(caculate, row, col) < 2)
						changecondition(row, col);
				}else {
					if (count(caculate, row, col) == 3)
						changecondition(row, col);
				}
		}
	}
	
	public static void main(String[] args) throws AWTException {
		Robot robot = new Robot();
		System.out.println();
		load.jF_();
		
		while(true) {
//			robot.delay(delay);
			while (sign) {
				robot.delay(delay);
				run.Main();
			}
		}
	}
}//¡ö¡ö¡ö¡õ¡õ¡õ
