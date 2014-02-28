package com.mikeandduncan.minetown;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Land {

	private Bitmap bmap;
	public Land(Context context) {
		// TODO Auto-generated constructor stub

		bmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.land);
	}

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
