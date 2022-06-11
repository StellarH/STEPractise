package cell2_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		short size = Short.parseShort(JOptionPane.showInputDialog(null, "Size (1 ~ 480)", "Cell", 3));
		
		if (size > 480 || size < 1) JOptionPane.showMessageDialog(null, "Input Out Of Range", "ERROR", 0);
		
		else EventQueue.invokeLater(() -> {
			CellFrame cellframe = new CellFrame(size);
			cellframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cellframe.setVisible(true);
		});
	}
}
