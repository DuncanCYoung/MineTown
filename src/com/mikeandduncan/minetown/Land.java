package com.mikeandduncan.minetown;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Land {

	/**
	 * Land bitmap
	 */
	private Bitmap bmap;
	
	public Land(Context context) {
		bmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.land);
	}

	/**
	 * Draw the land
	 * @param canvas
	 * @param x
	 * @param y
	 */
	public void draw(Canvas canvas, int x, int y)
	{
		canvas.save();
		canvas.scale(.1f, .1f);
		canvas.translate(x, y);
		canvas.translate(bmap.getWidth(),bmap.getHeight());
		canvas.drawBitmap(bmap, 0, 0, null);
		canvas.restore();
	}

}
