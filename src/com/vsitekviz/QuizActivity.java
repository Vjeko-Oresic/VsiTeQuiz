package com.vsitekviz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class QuizActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
	    getActionBar().hide();
		
		setContentView(R.layout.activity_quiz);
		
		DatabaseHandler db = new DatabaseHandler(this);
		//Fill TextView in QuizActivity with data from database
		TextView question = (TextView)findViewById(R.id.textQuestion);
		TextView answer1 = (TextView)findViewById(R.id.textAnswer1); 
		TextView answer2 = (TextView)findViewById(R.id.textAnswer2);
		TextView answer3  = (TextView)findViewById(R.id.textAnswer3);
		TextView answer4  = (TextView)findViewById(R.id.textAnswer4);
		Items item = db.getRandomItems();
		String questionS = item.getQuestion();
		question.setText(questionS);
		final String answer1S = item.getAnswer1();
		answer1.setText(answer1S);
		final String answer2S = item.getAnswer2();
		answer2.setText(answer2S);
		final String answer3S = item.getAnswer3();
		answer3.setText(answer3S);
		final String answer4S = item.getAnswer4();
		answer4.setText(answer4S);
		final String correctAnswerS = item.getCorrectAnswer();
		
		answer1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				check(answer1S,correctAnswerS);
			}
		});
		
		answer2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				check(answer2S,correctAnswerS);
			}
		});
		
		answer3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				check(answer3S,correctAnswerS);
			}
		});
		
		answer4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				check(answer4S,correctAnswerS);
			}
		});
	}
	
	private void check(String answer, String correct){
		if(answer.compareTo(correct)==0){
			Intent i = new Intent (this, CorrectActivity.class);
	  		startActivity(i);
	  		finish();
		}
		else {
			Intent i = new Intent (this, WrongActivity.class);
	  		startActivity(i);
	  		finish();
		}
	}
	@Override
	public void onBackPressed() {
		Intent i = new Intent (this, MainActivity.class);
  		startActivity(i);
  		finish();
  	}
}
