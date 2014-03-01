package com.mikeandduncan.minetown;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MineActivity extends Activity {
	
	/**
	 * Mine view
	 */
	MineView mineView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mine);
		
		mineView = (MineView)findViewById(R.id.mineView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mine, menu);
		return true;
	}

}
