package com.mikeandduncan.minetown;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Block {

	Bitmap bitmap = null;
	public Block(Context context) {
		// TODO Auto-generated constructor stub
		bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.block);
	}
	public void draw(Canvas canvas, int x, int y) {
		// TODO Auto-generated method stub
		canvas.save();
		canvas.scale(.1f, .1f);
		canvas.translate(x*bitmap.getWidth(), y*bitmap.getHeight());
		canvas.drawBitmap(bitmap, 0, 0, null);
		canvas.restore();
	}

}
