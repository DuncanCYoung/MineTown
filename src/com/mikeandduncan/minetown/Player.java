package com.mikeandduncan.minetown;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Player {

	private Bitmap bitmap = null;
	
	public Player(Context context) {
		// TODO Auto-generated constructor stub
		bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
	}
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.save();
		canvas.scale(.07f,.07f);
		canvas.drawBitmap(bitmap, 0, 0, null);

		canvas.restore();
	}

}
