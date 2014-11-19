package com.vsitekviz;

import com.vsitekviz.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class NewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);	
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.answer_new, menu);
        return true;
    }
	//Action bar, select action button
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			 switch (item.getItemId()) {
			 case R.id.action_accept:
				 accept();
				 return true;
			 case R.id.action_cancel:
				 cancel();
				 return true;
		     default:
		    	 return super.onOptionsItemSelected(item);
			 }
		}
		//Accept, save items in database
		private void accept() {
			DatabaseHandler db = new DatabaseHandler(this);
			EditText question = (EditText)findViewById(R.id.editQuestion);
			EditText answer1 = (EditText)findViewById(R.id.editAnswer1); 
			EditText answer2 = (EditText)findViewById(R.id.editAnswer2);
			EditText answer3  = (EditText)findViewById(R.id.editAnswer3);
			EditText answer4  = (EditText)findViewById(R.id.editAnswer4);
			EditText correctAnswer  = (EditText)findViewById(R.id.editCorrectAnswer);
			String questionS = question.getText().toString();
			String answer1S =  answer1.getText().toString();
			String answer2S = answer2.getText().toString();
			String answer3S = answer3.getText().toString();
			String answer4S = answer4.getText().toString();
			String correctAnswerS = correctAnswer.getText().toString();
			Items item = new Items (questionS, answer1S, answer2S, answer3S, answer4S, correctAnswerS);
			db.addItems(item);      
	        finish();
		}
		//Cancel activity NewSchedule
		private void cancel() {
			finish();
		}
}
