package com.mikeandduncan.minetown;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Block {

	/**
	 * Our block bitmap
	 */
	private Bitmap blockBitmap = null;
	
	public Bitmap getBitmap() {
		return blockBitmap;
	}
	
	public void setBitmap(Bitmap bitmap) {
		this.blockBitmap = bitmap;
	}
	
	public Block(Context context, Bitmap bmap) {
		blockBitmap = bmap;
	}
	
	/**
	 * Draw the block
	 * @param canvas
	 * @param x X location
	 * @param y Y location
	 * @param ox offset x?
	 * @param oy offset y?
	 */
	public void draw(Canvas canvas, int x, int y, int ox, int oy) {
		canvas.save();
		canvas.scale(.1f, .1f);
		canvas.translate((x-ox+4)*blockBitmap.getWidth(), (y-oy+6)*blockBitmap.getHeight());
		canvas.drawBitmap(blockBitmap, 0, 0, null);
		canvas.restore();
	}

}
