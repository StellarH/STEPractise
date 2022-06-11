package cell2_2;

import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public final class CellPanel extends JPanel {
	
	private final Cell[][] cell;
	private final short size;
	
	public CellPanel(short _size) {
		super();
		
		size = _size;
		setLayout(new GridLayout(size, size));
		
		cell = new Cell[size + 2][size + 2];
		
		for (short row = 1; row <= size; row++) for (short col = 1; col <= size; col++) {
			cell[col][row] = new Cell();
			//if (row % 2 == 0) cell[col][row].turnalive();
			add(cell[col][row]);
		}
		
		for (short index = 1; index <= size; index++) {
			cell[index][0] = cell[index][size];
			cell[index][size + 1] = cell[index][1];
			cell[0][index] = cell[size][index];
			cell[size + 1][index] = cell[1][index];
		}
		
		cell[0][0] = cell[size][size];
		cell[0][size + 1] = cell[size][1];
		cell[size + 1][0]=cell[1][size];
		cell[size + 1][size + 1]=cell[1][1];
	}
	
	private byte count(short x, short y) {
		byte count = 0;
		for (int row = -1; row <= 1; row++)
			for (int col = -1; col <= 1; col++) 
				if (cell[x + col][y + row].tmp) count++;
		if (cell[x][y].tmp) count--;
		return count;
	}
	
	public void nextstep() {
		for (short row = 1; row <= size; row++) 
			for (short col = 0; col <= size; col++)
				cell[col][row].refresh();
		
		for (short row = 1; row <= size; row++) for (short col = 1; col <= size; col++) {
			byte count = count(col, row);
				if(cell[col][row].tmp && (count > 3 || count < 2)) 
					cell[col][row].turnalive();
				else if (!cell[col][row].tmp && count == 3)
					cell[col][row].turnalive();
		}
	}
}
