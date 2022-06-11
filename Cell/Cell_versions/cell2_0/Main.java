package cell2_0;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {
	
	public static final short size = 48;
	public static final int delay = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			CellFrame cellframe = new CellFrame(size, delay);
			cellframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cellframe.setVisible(true);
		});
	}
}
