package cell1_5;

import static cell1_5.Cell.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class CellFrame {
	
	static CellFrame load = new CellFrame();
	
	static final int FRAME_SIZE = 480;
	
	static boolean getcondition(int row, int col) {
		return jp[row][col].getBackground().equals(Color.BLACK);
	}
	
	static void changecondition(int row, int col) {
		if(getcondition(row, col))
			jp[row][col].setBackground(Color.WHITE);
		else 
			jp[row][col].setBackground(Color.BLACK);
	}
	
	static JFrame jF = new JFrame("Cell");
	
	public void jF_() {
		jF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jF.setResizable(false);
		jF.setBounds(90, 60, FRAME_SIZE + 6, (int)(1.2 * FRAME_SIZE) + 28);
		jF.setLayout(null);
		
		jP_();
		jP_control();
		
		jF.setVisible(true);
	}
	
	static JPanel jP = new JPanel();
	static JPanel[][] jp = new JPanel[SIZE + 1][SIZE + 1];
	
	static void jP_() {
		jP.setBounds(0, 0, FRAME_SIZE, FRAME_SIZE);
		jP.setLayout(new GridLayout(SIZE, SIZE));
		
		for (int row = 1; row <= SIZE; row++)
			for(int col = 1; col <= SIZE; col++) {
				jp[row][col] = new JPanel();
				jp[row][col].setBackground(Color.WHITE);
				//jp[row][col].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
				jp[row][col].addMouseListener(new JPanelClickCommand(jp[row][col]));
				jP.add(jp[row][col]);
		}
		
		jF.add(jP);
	}
	
	static JPanel jPc = new JPanel();
	static JButton jB = new JButton("¿ªÊ¼/ÔÝÍ£");
	
	static void jP_control() {
		jPc.setBounds(0, FRAME_SIZE, FRAME_SIZE, (int)(0.2 * FRAME_SIZE));
		
		jB.addActionListener(event -> sign = !sign);
		jPc.add(jB);
		
		jF.add(jPc);
	}
	
	 private static class JPanelClickCommand implements MouseListener {
		
		private JPanel jP;

		public JPanelClickCommand(JPanel _jP) {
			jP = _jP ;
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(!jP.getBackground().equals(Color.BLACK))
					jP.setBackground(Color.LIGHT_GRAY);
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(jP.getBackground().equals(Color.LIGHT_GRAY))
				jP.setBackground(Color.WHITE);
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(jP.getBackground().equals(Color.BLACK))
				jP.setBackground(Color.WHITE);
			else
				jP.setBackground(Color.BLACK);
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
}
