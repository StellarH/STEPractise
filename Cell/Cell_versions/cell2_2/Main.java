package cell2_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;	

public class Main {
	public static void main(String[] args) {
		System.out.print(System.getProperty("os.name"));
		
		short _size = 0;
		String s = JOptionPane.showInputDialog(null, "Size:(0, 480]", "Cell", 3);
		
		try {
			_size = Short.parseShort(s);
		}catch (Exception e) {}
		short size = _size;
		
		if (size > 480 || size <= 0) 
			JOptionPane.showMessageDialog(null, "Input Out Of Range", "ERROR", 0);
		else EventQueue.invokeLater(() -> {
			CellFrame cellframe = new CellFrame(size);
			cellframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cellframe.setVisible(true);
		});
		
	}
}
