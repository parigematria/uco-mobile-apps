package Trees;

import java.util.Timer;
import java.util.TimerTask;

import android.os.SystemClock;

import DrawViews.AVLDrawView;

public class TreeAnimate {
	static AVLDrawView dv;
	String type = "";
	private static boolean running = true;
	private static boolean animating = true;
	private static int counter = 0;
	public TreeAnimate(AVLDrawView AVLdv) {
		dv = AVLdv;
	}

	public static void run() {
		while (running) {
				redraw();
				counter = (counter + 1) % 500;
				if(counter == 0){
					dv.incFrame();
				}
		}
	}
	public void changeAnimating(){
		animating = !animating;
	}
	protected static void redraw() {
		dv.postInvalidate();
	}

	public static void stopThread() {
		running = false;
	}

}