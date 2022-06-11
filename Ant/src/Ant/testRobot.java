package Ant;

import java.awt.*;


public class testRobot {
	public static void main(String[] args)throws AWTException{
		Robot robot = new Robot();

		int a = 36000;
		while(a != 0){
			robot.mouseMove(1024,768);
			//robot.keyPress(KeyEvent.VK_Q);
			robot.delay(100);
			a = a - 1;
		}

	}

}