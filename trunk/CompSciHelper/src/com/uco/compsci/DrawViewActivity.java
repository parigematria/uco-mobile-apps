package com.uco.compsci;

import DrawViews.DrawView;
import Shapes.Types;
import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;

public class DrawViewActivity extends Activity {
	private Types t = new Types();
	private int spot;
	DrawView drawView = null;//new DrawView(this, "BubbleSort");
	Display display;  

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		display = getWindowManager().getDefaultDisplay();
				
		//gets data put in by me on other
		spot = getIntent().getExtras().getInt("type");
		t.setType(spot);
		spot = getIntent().getExtras().getInt("size");
		
		
		
		drawView = new DrawView(this, t, spot);
		setContentView(drawView);
		drawView.setDisplaySize(display.getHeight(), display.getWidth());
		//setContentView(R.layout.buttons);
	}

	@SuppressWarnings("finally")
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		try {
			if (drawView.getWait() || drawView.getFinished()) {

				if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN
						&& !drawView.getFinished())
					drawView.changeWait();
				// drawView.removeItem();

				else
					super.onKeyDown(keyCode, event);
			}

		} catch (Exception e) {
			super.onKeyDown(keyCode, event);
		} finally {
			return true;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater(); // from activity
		inflater.inflate(R.menu.selection, menu);
		// It is important to return true to see the menu
		return true;
	}
	
	@Override
	protected void onDestroy() {
		drawView.stopThread();
		super.onDestroy();
	}
}