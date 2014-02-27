package com.mikeandduncan.minetown;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
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
	int bWidth = 5;
	int bHeight = 5;
	
	public void init(Context context){
		blocks = new Block[5][5];
		
		for(int i =0; i<bWidth; i++)
		{
			for(int j = 0; j<bHeight; j++)
			{
				blocks[i][j] = new Block(context);
			}
		}
		player = new Player(context);
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		for(int i = 0; i<bWidth; i++)
		{
			for(int j = 0; j<bHeight; j++)
			{
				blocks[i][j].draw(canvas,i,j);
			}
		}
		player.draw(canvas);
		
	}

}
