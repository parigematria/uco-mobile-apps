package Shapes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public abstract class Shape{
	private int c = Color.WHITE;
	float x;
	private float y;
	private int numb;
	Shape prev;
	public abstract void Draw(Canvas canvas, Paint paint);
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public int getColor() {
		return c;
	}
	public void setColor(int c) {
		this.c = c;
	}
	public int getNumb() {
		return numb;
	}
	public void setNumb(int numb) {
		this.numb = numb;
	}
}