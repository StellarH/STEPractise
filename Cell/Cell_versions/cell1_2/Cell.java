package cell1_2;

import static cell1_2.CellFrame.*;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;

class Cell {
	
	static final int SIZE = 24;
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
	
	static void Main() {
		for (int row = 1; row <= SIZE; row++) {
			for (int col = 1; col <= SIZE; col++)
				caculate[row][col] = jp[row][col].getBackground().equals(Color.BLACK);
			caculate[row][0] = jp[row][SIZE].getBackground().equals(Color.BLACK);
			caculate[row][SIZE + 1] = jp[row][1].getBackground().equals(Color.BLACK);
			caculate[0][row] = jp[SIZE][row].getBackground().equals(Color.BLACK);
			caculate[SIZE + 1][row] = jp[1][row].getBackground().equals(Color.BLACK);
		}
		caculate[0][0] = jp[SIZE][SIZE].getBackground().equals(Color.BLACK);
		caculate[0][SIZE + 1] = jp[SIZE][1].getBackground().equals(Color.BLACK);
		caculate[SIZE + 1][0] = jp[1][SIZE].getBackground().equals(Color.BLACK);
		caculate[SIZE + 1][SIZE + 1] = jp[1][1].getBackground().equals(Color.BLACK);
		
		for (int row = 1; row <= SIZE; row++)
			for (int col = 1; col <= SIZE; col++) {
				if(jp[row][col].getBackground().equals(Color.BLACK)) {
					if (count(caculate, row, col) > 3 | count(caculate, row, col) < 2)
						jp[row][col].setBackground(Color.WHITE);
				}else {
					if (count(caculate, row, col) == 3)
						jp[row][col].setBackground(Color.BLACK);
				}
		}
	}
	
	public static void main(String[] args) throws AWTException {
		Robot robot = new Robot();
		
		jF_();
		jF_control();
		
		while(true)
			while (sign) {
				robot.delay(delay);
				Main();
		}
	}
}//¡ö¡ö¡ö¡õ¡õ¡õ
