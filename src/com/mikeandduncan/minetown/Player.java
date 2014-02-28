package com.mikeandduncan.minetown;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Player {

	private Bitmap bitmap = null;
	private int x = 0;
	private int y = 0;
	private int direction = 0;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Player(Context context) {
		// TODO Auto-generated constructor stub
		bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
	}
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.save();
		canvas.translate(canvas.getWidth()/2, canvas.getHeight()/2);
		canvas.scale(.06f,.06f);
		
		//canvas.translate(bitmap.getWidth()/2, bitmap.getHeight()/2);
		canvas.rotate(direction);
		canvas.translate(-bitmap.getWidth()/2, -bitmap.getHeight()/2);

		
		
		canvas.drawBitmap(bitmap, 0, 0, null);

		canvas.restore();
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}

}
