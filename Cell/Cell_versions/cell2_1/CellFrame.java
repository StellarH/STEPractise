package cell2_1;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public final class CellFrame extends JFrame {

	public CellFrame(short size) {
		super("Cell");
		
		setBounds(90, 60, 640 + 6, 480 + 29);
		setLayout(null);
		setResizable(false);
		
		CellPanel cellpanel = new CellPanel(size);
		cellpanel.setBounds(0, 0, 480, 480);
		add(cellpanel);
		
		Timer timer = new Timer(100, event -> cellpanel.nextstep());
		
		JPanel cpanel = new JPanel();
		cpanel.setBounds(480, 0, 160, 480);
		cpanel.setLayout(new GridLayout(0, 1));
			JButton start_stop = new JButton("Start/Stop");
			start_stop.addActionListener(event -> {
				if (timer.isRunning())
					timer.stop();
				else
					timer.start();
			});
		cpanel.add(start_stop);
			JButton nextstep = new JButton("NextStep");
			nextstep.addActionListener(event -> cellpanel.nextstep());
		cpanel.add(nextstep);
			DelayPanel delaypanel = new DelayPanel(timer);
		cpanel.add(delaypanel);
		add(cpanel);
	}
}
