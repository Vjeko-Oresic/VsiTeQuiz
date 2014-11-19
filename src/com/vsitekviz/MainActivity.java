package com.vsitekviz;

import java.util.ArrayList;
import com.vsitekviz.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends Activity {

	ListView lView;
	DatabaseHandler db;
	ArrayList<Items> aItem;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lView = (ListView) findViewById(R.id.custom_list);
		showlist();
		//Click on list item open EditActivity
		lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				int pkId = ((Items)a.getAdapter().getItem((int)id)).getID();
				Intent i = new Intent (MainActivity.this, EditActivity.class);
				i.putExtra("id", pkId);
				startActivity(i);
			}
		});
	}
	//Method for show CustomList
	private void showlist() {
		ArrayList<Items> item = new ArrayList<Items>();
		db = new DatabaseHandler(this);
		item = db.getAllItems();
		CustomList cList = new CustomList(MainActivity.this, item);
		lView.setAdapter(cList);
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    //Action bar, select action button
  	@Override
  	public boolean onOptionsItemSelected(MenuItem item) {
  		 switch (item.getItemId()) {
  		 case R.id.action_new:
  			 openNew();
  			 return true;
  		 case R.id.action_quiz:
  			 openQuiz();
  			 return true;
  	     default:
  	    	 return super.onOptionsItemSelected(item);
  		 }
  	}
  	//Open activity NewActivity
  	private void openNew() {
  		Intent i = new Intent (this, NewActivity.class);
  		startActivity(i);
  	}
  	//Open activity QuizActivity
  	private void openQuiz() {
  		Intent i = new Intent (this, QuizActivity.class);
  		startActivity(i);
  		finish();
  	}
  	@Override
  	protected void onResume() {
  	   super.onResume();
  	   this.onCreate(null);
  	}
}
