package cell0_0;

import java.awt.AWTException;
import java.awt.GridLayout;
import java.awt.Robot;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

class Cell {
	
	static final int size = 36;
	
	static boolean[][] 
			caculate = new boolean[size + 2][size + 2],
			result = new boolean[size + 1][size + 1];
	
	static int step = 1;
	
	static int count(boolean[][] caculate_,int y,int x){
		int c = 0;
		for (int row = -1; row < 2; row++) 
			for (int col = -1; col < 2; col++) 
				if (caculate_[y+row][x+col]) c++;
		if (caculate_[y][x]) c--;
		return c;
	}
	
	public static void main(String[] args) throws AWTException {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//jf.setResizable(false);
		
		jf.setBounds(90, 60, 366, 388);
		jf.setLayout(new GridLayout(size, size));
		
		JLabel[][] jl = new JLabel[size + 1][size + 1];
		for (int row = 1; row <= size; row++)
			for(int col = 1; col <= size; col++) {
				jl[row][col] = new JLabel();
				jf.add(jl[row][col]);
		}
		
		jf.setVisible(true);
		
		Robot robot = new Robot();
		
		result[12][11] = true;
		result[12][12] = true;
		result[12][13] = true;
		result[13][11] = true;
		result[13][13] = true;
		result[14][11] = true;
		result[14][13] = true;
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		while (true) {
			robot.delay(500);
			step--;
			if (step == 0) step = in.nextInt();
			
			for (int row = 1; row <= size; row++) {
				for (int col = 1; col <= size; col++)
					caculate[row][col] = result[row][col];
				caculate[row][0] = result[row][size];
				caculate[row][size + 1] = result[row][1];
				caculate[0][row] = result[size][row];
				caculate[size + 1][row] = result[1][row];
			}
			caculate[0][0] = result[size][size];
			caculate[0][size + 1] = result[size][1];
			caculate[size + 1][0] = result[1][size];
			caculate[size + 1][size + 1] = result[1][1];
			
			for (int row = 1; row <= size; row++)
				for (int col = 1; col <= size; col++) {
					if (count(caculate, row, col) > 3 | count(caculate, row, col) < 2) {
						result[row][col] = false;
						jl[row][col].setText("¡õ");
					}
					else if (count(caculate, row, col) == 3) {
						result[row][col] = true;
						jl[row][col].setText("¡ö");
					}
					else {
						if (result[row][col]) jl[row][col].setText("¡ö");
						else jl[row][col].setText("¡õ");
					}
			}
		}
	}
}//¡ö¡ö¡ö¡õ¡õ¡õ
