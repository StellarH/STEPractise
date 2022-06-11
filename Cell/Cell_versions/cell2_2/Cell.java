package cell2_2;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public final class Cell extends JPanel implements MouseListener {
	
	private boolean alive = false;
	public boolean tmp = false;
	
	public Cell() {
		super();
		setBackground(Color.WHITE);
		addMouseListener(this);
	}
	
	public boolean isalive() {
		return alive;
	}
	
	public void turnalive() {
		if(!alive)
			setBackground(Color.BLACK);
		else
			setBackground(Color.WHITE);
		alive = !alive;
	}
	
	public void refresh() {
		tmp = alive;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		turnalive();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!alive)
			setBackground(Color.LIGHT_GRAY);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!alive)
			setBackground(Color.WHITE);
	}
}
