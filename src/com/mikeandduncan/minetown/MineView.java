package com.mikeandduncan.minetown;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MineView extends View {
	
	/**
	 * A reference to the player
	 */
	private Player player = null;
	
	/**
	 * 2D array to hold all the block tiles
	 */
	private Block[][] blocks;
	
	/**
	 * A reference to above ground
	 */
	private Land land = null;
	
	/**
	 * The dimensions of our game
	 */
	private int bWidth = 10;
	private int bHeight = 10;
	
	/**
	 * The block bitmap that the player digs
	 */
	private Bitmap blockMap;
	
	/**
	 * The block bitmap that the player has dug
	 */
	private Bitmap badMap;
	
	/**
	 * Wut
	 */
	private Bitmap empty;

	public MineView(Context context) {
		super(context);
		init(context);
	}

	public MineView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public MineView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}
	
	/**
	 * Initialize the mine view
	 * @param context
	 */
	public void init(Context context){
		// Create our array to hold the blocks
		blocks = new Block[bWidth][bHeight];

		// Load bitmaps
		blockMap = BitmapFactory.decodeResource(context.getResources(), R.drawable.block);
		badMap = BitmapFactory.decodeResource(context.getResources(), R.drawable.block_bad);
		empty = Bitmap.createBitmap(blockMap.getHeight(), blockMap.getWidth(), Bitmap.Config.ARGB_8888);
		land = new Land(context);
		
		// Build our world!
		for(int i =0; i<bWidth; i++)
		{
			for(int j = 0; j<bHeight; j++)
			{
				if(j != 0)
					blocks[i][j] = new Block(context, blockMap);
				else
					blocks[i][j] = new Block(context, empty);
			}
		}
		
		// Create the player
		player = new Player(context);
		
	}

	/**
	 * Draw the world
	 * @param canvas
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// Draw the land
		// TODO: FIX MEH
		land.draw(canvas, -(player.getX()+1)*blockMap.getWidth(), -player.getY()*blockMap.getHeight());
		
		// Draw the underground world
		for(int i = 0; i<bWidth; i++)
		{
			for(int j = 0; j<bHeight; j++)
			{
				blocks[i][j].draw(canvas,i,j,player.getX(),player.getY());
			}
		}
		
		// Draw the player
		player.draw(canvas);
		
		

		
	}

	/**
	 * Handle a touch event
	 * @param event
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {		
        switch(event.getActionMasked()) {
        case MotionEvent.ACTION_DOWN:
        	move(event);

        }
		return super.onTouchEvent(event);
	}

	/**
	 * Move stuff
	 * @param event
	 */
	private void move(MotionEvent event) {
		float x = event.getX()/this.getWidth();
		float y = event.getY()/this.getHeight();
		
		boolean diag1 = (x+y>1);//Bottom Right
		boolean diag2 = (x>y);//Top Right
		
		if(diag1 && diag2)
		{
			//Right
			if(player.getX()<bWidth-1)
				player.setX(player.getX()+1);
			player.setDirection(90);
		}
		else if(diag1 && !diag2)
		{
			//Down
			if(player.getY()<bHeight-1)
				player.setY(player.getY()+1);
			player.setDirection(180);

		}
		else if(!diag1 && !diag2)
		{
			//Left
			if(player.getX() != 0)
				player.setX(player.getX()-1);
			player.setDirection(270);

		}
		else if(!diag1 && diag2)
		{
			//Up
			if(player.getY() != 0)
				player.setY(player.getY()-1);
			player.setDirection(0);

		}
		else
		{
			//This should never happen
		}
		eraseBlock();
		invalidate();
	}

	/**
	 * This function gets called everytime the player moves, and then whatever position they move to gets changed to
	 * the respective new bitmap. right now it changes it to "badmap" but can be expaned to draw an already diggen(dug?)
	 * space.
	 */
	private void eraseBlock() {
		
		//THIS IS BACKWARDS, BUT WORKS. NEEDS TO BE FIXED SOMEHOW
		//Y  up = +1 y Down = -1, I think that's backwards
		//change in the above function, and the way the blocks draw
		if(player.getY() !=0)
			blocks[player.getX()][player.getY()].setBitmap(badMap);
		//blocks[6][1].setBitmap(badMap);

	}

}
