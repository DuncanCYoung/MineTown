package com.mikeandduncan.minetown;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Block {

	Bitmap bitmap = null;
	public Block(Context context, Bitmap bmap) {
		// TODO Auto-generated constructor stub
		bitmap = bmap;
	}
	public Bitmap getBitmap() {
		return bitmap;
	}
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	public void draw(Canvas canvas, int x, int y, int ox, int oy) {
		// TODO Auto-generated method stub
		canvas.save();
		canvas.scale(.1f, .1f);
		canvas.translate((x-ox+4)*bitmap.getWidth(), (y-oy+6)*bitmap.getHeight());
		canvas.drawBitmap(bitmap, 0, 0, null);
		canvas.restore();
	}

}
