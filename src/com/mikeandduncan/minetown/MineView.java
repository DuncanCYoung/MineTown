package com.mikeandduncan.minetown;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MineView extends View {

	public MineView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}

	public MineView(Context context, AttributeSet attrs) {
		super(context, attrs);

		init(context);
	}

	public MineView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		init(context);
	}
	
	Player player = null;
	Block[][] blocks;
	Land land = null;
	int bWidth = 10;
	int bHeight = 10;
	Bitmap blockMap;
	Bitmap badMap;
	Bitmap empty;
	
	public void init(Context context){
		blocks = new Block[bWidth][bHeight];

		blockMap = BitmapFactory.decodeResource(context.getResources(), R.drawable.block);
		badMap = BitmapFactory.decodeResource(context.getResources(), R.drawable.block_bad);
		empty = Bitmap.createBitmap(blockMap.getHeight(), blockMap.getWidth(), Bitmap.Config.ARGB_8888);
		land = new Land(context);
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
		player = new Player(context);
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);

		land.draw(canvas, -(player.getX()+1)*blockMap.getWidth(), -player.getY()*blockMap.getHeight());
		
		for(int i = 0; i<bWidth; i++)
		{
			for(int j = 0; j<bHeight; j++)
			{
				blocks[i][j].draw(canvas,i,j,player.getX(),player.getY());
			}
		}
		
		player.draw(canvas);
		
		

		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
        switch(event.getActionMasked()) {
        case MotionEvent.ACTION_DOWN:
        	move(event);

        }
		return super.onTouchEvent(event);
	}

	private void move(MotionEvent event) {
		// TODO Auto-generated method stub
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

	private void eraseBlock() {
		// TODO Auto-generated method stub
		
		//THIS IS BACKWARDS, BUT WORKS. NEEDS TO BE FIXED SOMEHOW
		//Y  up = +1 y Down = -1, I think that's backwards
		//change in the above function, and the way the blocks draw
		if(player.getY() !=0)
			blocks[player.getX()][player.getY()].setBitmap(badMap);
		//blocks[6][1].setBitmap(badMap);

	}

}
