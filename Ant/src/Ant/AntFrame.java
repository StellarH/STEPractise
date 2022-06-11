package Ant;

import static java.lang.System.*;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class AntFrame {
	public final static int size = 75 ;
	public static void main(String[] args) {

		JFrame jf = new JFrame("Ant");

		jf.setLayout(new GridLayout(45 ,0));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel[] jl = new JLabel[size];
		for(byte a = 0 ;a < 45 ;a++) {
			jl[a] = new JLabel("");
			jf.add(jl[a]);
		}
		jf.setBounds(0, 0, 1000, 550);
		jf.setVisible(true);

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		boolean[][] place = new boolean [45][size];
		int x = 29, y = 22;
		int px = x, py = y;
		int direction = 0, step = 1, times = 1;
		String str;

		while (step > 0){
			step--;
			out.println(times);

			for (int row = 0; row < 45; row++){
				str = "";
				for (int col = 0; col<size; col++){
					if (row == y & col == x){
						if (direction == 0) str += place[row][col]? "©ß": "¨m";//¡ø¡÷
						if (direction == 1) str += place[row][col]? "©Ç": "¨d";
						if (direction == 2) str += place[row][col]? "©×": "¨j";//¨‹¨Œ
						if (direction == 3) str += place[row][col]? "©Ï": "¨g";
					}
					else str += place[row][col]? "¡ö": "¡õ";
				}
				jl[row].setText(str);
			} 

			if (step == 0) step = in.nextInt();

			if (direction == 0) x += place[py][px]? 1: -1;//¡ø¡÷
			if (direction == 1) y += place[py][px]? 1: -1;
			if (direction == 2) x += place[py][px]? -1: 1;//¨‹¨Œ
			if (direction == 3) y += place[py][px]? -1: 1;

			direction += place[py][px] ? 1 : -1;
			if (direction < 0) direction += 4;
			if (direction > 3) direction -= 4;

			place[py][px] = !place[py][px];
			
			px = x;
			py = y;
			
			times++;
		}
	} 
}
