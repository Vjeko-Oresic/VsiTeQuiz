package com.vsitekviz;

import com.vsitekviz.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class EditActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		DatabaseHandler db = new DatabaseHandler(this);
		Bundle b = getIntent().getExtras();
		int id = b.getInt("id");
		//Fill EditText in EditActivity with data from database
		EditText question = (EditText)findViewById(R.id.editQuestionE);
		EditText answer1 = (EditText)findViewById(R.id.editAnswer1E); 
		EditText answer2 = (EditText)findViewById(R.id.editAnswer2E);
		EditText answer3  = (EditText)findViewById(R.id.editAnswer3E);
		EditText answer4  = (EditText)findViewById(R.id.editAnswer4E);
		EditText correctAnswer  = (EditText)findViewById(R.id.editCorrectAnswerE);
		Items item = db.getItems(id);
		String questionS = item.getQuestion();
		question.setText(questionS);
		String answer1S = item.getAnswer1();
		answer1.setText(answer1S);
		String answer2S = item.getAnswer2();
		answer2.setText(answer2S);
		String answer3S = item.getAnswer3();
		answer3.setText(answer3S);
		String answer4S = item.getAnswer4();
		answer4.setText(answer4S);
		String correctAnswerS = item.getCorrectAnswer();
		correctAnswer.setText(correctAnswerS);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.answer_edit, menu);
		return true;
	}
	//Action bar, select action button
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		 case R.id.action_accept:
			 acceptEdit();
			 return true;
		 case R.id.action_cancel:
			 cancelEdit();
			 return true;
		 case R.id.action_remove:
			 removeSelected();
			 return true;	 
	     default:
	    	 return super.onOptionsItemSelected(item);
		 }
	}
	//Accept edit, save items in database
	private void acceptEdit() {
		DatabaseHandler db = new DatabaseHandler(this);
		EditText question = (EditText)findViewById(R.id.editQuestionE);
		EditText answer1 = (EditText)findViewById(R.id.editAnswer1E); 
		EditText answer2 = (EditText)findViewById(R.id.editAnswer2E);
		EditText answer3  = (EditText)findViewById(R.id.editAnswer3E);
		EditText answer4  = (EditText)findViewById(R.id.editAnswer4E);
		EditText correctAnswer  = (EditText)findViewById(R.id.editCorrectAnswerE);
		String questionE = question.getText().toString();
		String answer1E =  answer1.getText().toString();
		String answer2E = answer2.getText().toString();
		String answer3E = answer3.getText().toString();
		String answer4E = answer4.getText().toString();
		String correctAnswerE = correctAnswer.getText().toString();
		Bundle b = getIntent().getExtras();
		int id = b.getInt("id");
		Items item = new Items (id, questionE, answer1E, answer2E, answer3E, answer4E, correctAnswerE);
		db.updateItems(item);     
		finish();
	}
	//Cancel activity Edit
	private void cancelEdit() {
		finish();
	}
	//Remove selected from database
	private void removeSelected() {
		DatabaseHandler db = new DatabaseHandler(this);
		Bundle b = getIntent().getExtras();
		int id = b.getInt("id");
		Items item = new Items (id);
		db.deleteItems(item);
		finish();
	}
	
}
