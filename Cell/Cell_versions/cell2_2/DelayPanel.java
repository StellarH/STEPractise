package cell2_2;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

@SuppressWarnings("serial")
public final class DelayPanel extends JPanel {
	
	public DelayPanel(Timer timer) {
		
		setLayout(new BorderLayout());
		
		JTextField DelayText = new JTextField("100");
		add(DelayText, BorderLayout.NORTH);
		
		JButton DelayButton = new JButton("setDelay (ms)");
		DelayButton.addActionListener(event -> {
			try{
				short delay = Short.parseShort(DelayText.getText());
				timer.setDelay(delay);
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Input ERROR", "ERROR", 0);
				DelayText.setText("");
			}
		});
		add(DelayButton);
	}
}
