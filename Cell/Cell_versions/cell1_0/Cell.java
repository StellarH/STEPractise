package cell1_0;

import java.awt.AWTException;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Cell {
	
	static final int size = 36;
	
	static JFrame
		jF = new JFrame("Cell"),
		jFc = new JFrame();
	static JButton jB = new JButton("¿ªÊ¼/ÔÝÍ£");
	static JLabel[][] jl = new JLabel[size + 1][size + 1];

	static boolean[][] caculate = new boolean[size + 2][size + 2];
	static boolean sign = false;
			
	static int count(boolean[][] _caculate,int y,int x){
		int c = 0;
		for (int row = -1; row < 2; row++) 
			for (int col = -1; col < 2; col++) 
				if (_caculate[y+row][x+col]) c++;
		if (_caculate[y][x]) c--;
		return c;
	}
	
	public static void main(String[] args) throws AWTException {
		
		jF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jF.setResizable(false);
		
		jFc .setUndecorated(true);
		
		jF.setBounds(90, 60, 486, 508);
		jF.setLayout(new GridLayout(size, size));
		
		jFc.setBounds(581, 60, 90, 60);
		
		for (int row = 1; row <= size; row++)
			for(int col = 1; col <= size; col++) {
				jl[row][col] = new JLabel("¡õ");
				jl[row][col].addMouseListener(new LabelClickCommand(jl[row][col]));
				jF.add(jl[row][col]);
		}
		jB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				sign = !sign;
			}
		});
		jFc.add(jB);
		
		jFc .setUndecorated(true);
		
		jF.setVisible(true);
		jFc.setVisible(true);
		
		Robot robot = new Robot();
		
		while(true)
			while (sign) {
				robot.delay(200);
				
				for (int row = 1; row <= size; row++) {
					for (int col = 1; col <= size; col++)
						caculate[row][col] = jl[row][col].getText().equals("¡ö");
					caculate[row][0] = jl[row][size].getText().equals("¡ö");
					caculate[row][size + 1] = jl[row][1].getText().equals("¡ö");
					caculate[0][row] = jl[size][row].getText().equals("¡ö");
					caculate[size + 1][row] = jl[1][row].getText().equals("¡ö");
				}
				caculate[0][0] = jl[size][size].getText().equals("¡ö");
				caculate[0][size + 1] = jl[size][1].getText().equals("¡ö");
				caculate[size + 1][0] = jl[1][size].getText().equals("¡ö");
				caculate[size + 1][size + 1] = jl[1][1].getText().equals("¡ö");
				
				for (int row = 1; row <= size; row++)
					for (int col = 1; col <= size; col++) {
						if (count(caculate, row, col) > 3 | count(caculate, row, col) < 2)
							jl[row][col].setText("¡õ");
						else if (count(caculate, row, col) == 3)
							jl[row][col].setText("¡ö");
				}
		}
	}
	static class LabelClickCommand implements MouseListener {
		
		private JLabel jL;

		public LabelClickCommand(JLabel _jL) {
			jL = _jL ;
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(jL.getText().equals("¡ö"))
				jL.setText("¡õ");
			else
				jL.setText("¡ö");
			sign = false;
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}//¡ö¡ö¡ö¡õ¡õ¡õ
