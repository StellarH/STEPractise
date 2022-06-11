package Ant;

import static java.lang.System.*;
import java.util.*;
import java.awt.*;

public class Ant{
	public static void main(String[] args)throws AWTException{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		//Robot robot = new Robot();
		boolean[][] place = new boolean [40][40];
		int x = 26, y = 19;
		int px = x, py = y;
		int c = 0, d = 1, t = 1;
		String str;
		while (d > 0){
			d--;
			//robot.delay(100);
			str = "";
			out.println(t);
			for (int i = 0; i<40; i++){
				for (int j = 0; j<40; j++){
					if (i == y & j == x){
						switch (c){
							case 0: str += place[i][j]? "©ß": "¨m";//¡ø¡÷
							case 1: str += place[i][j]? "©Ç": "¨d";
							case 2: str += place[i][j]? "©×": "¨j";//¨‹¨Œ
							case 3: str += place[i][j]? "©Ï": "¨g";
						}
					}
					else str += place[i][j]? "  ": "¨€";
				}
			}
			out.println(str);
			if (d == 0) d = in.nextInt();
			switch (c){
				case 0: x += place[py][px]? 1: -1;
				case 1: y += place[py][px]? 1: -1;
				case 2: x += place[py][px]? -1: 1;
				case 3: y += place[py][px]? -1: 1;
			}
			c += place[py][px] ? 1 : -1;
			if (c < 0) c += 4;
			if (c > 3) c -= 4;
			place[py][px] = !place[py][px];
			px = x;
			py = y;
			t++;
		}
	}
}
//out.println("Hello World!");
/*
for(int i = 0;i < 19;i++){
	for(int j = 0;j < 19;j++){
		out.print(place[i][j]);
		}
	out.println(i);
*/