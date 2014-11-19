package com.vsitekviz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class WrongActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
	    getActionBar().hide();
		
		setContentView(R.layout.activity_wrong);
		
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				Intent i = new Intent (WrongActivity.this, QuizActivity.class);
		  		startActivity(i);
		  		finish();
			}
		});
	}
	@Override
	public void onBackPressed() {
		Intent i = new Intent (this, MainActivity.class);
  		startActivity(i);
  		finish();
  	}
}
