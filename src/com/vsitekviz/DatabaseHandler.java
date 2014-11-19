package com.vsitekviz;

import java.util.ArrayList;
import com.vsitekviz.Items;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
		//All static variables
		// Database version
		private static final int DATABASE_VERSION = 1;
		// Database name
		private static final String DATABASE_NAME = "quizDB";
		// Table name
		private static final String TABLE_NAME = "quizTable";
		// Columns names
		private static final String KEY_ID = "id";
		private static final String KEY_QUESTION = "question";
		private static final String KEY_ANSWER1 = "answer1";
		private static final String KEY_ANSWER2 = "answer2";
		private static final String KEY_ANSWER3 = "answer3";
		private static final String KEY_ANSWER4 = "answer4";
		private static final String KEY_CORRECT = "correctAnswer";
		
		private static final String[] COLUMNS = {KEY_ID, KEY_QUESTION, KEY_ANSWER1, KEY_ANSWER2, KEY_ANSWER3, KEY_ANSWER4, KEY_CORRECT};
		
		public DatabaseHandler(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		// Creating table
	    @Override
	    public void onCreate(SQLiteDatabase db) {
	        String CREATE_SQL_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_QUESTION + " TEXT,"
	                + KEY_ANSWER1 + " TEXT," + KEY_ANSWER2 + " TEXT," + KEY_ANSWER3 + " TEXT," + KEY_ANSWER4 + " TEXT," + KEY_CORRECT + " TEXT " + ")";
	        db.execSQL(CREATE_SQL_TABLE);
	    }
	    // Upgrading table
	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	        onCreate(db);
	    }
	    // Adding new row
	    public void addItems(Items items) {
	        SQLiteDatabase db = this.getWritableDatabase();
	        ContentValues values = new ContentValues();
	        values.put(KEY_QUESTION, items.getQuestion());
	        values.put(KEY_ANSWER1, items.getAnswer1());
	        values.put(KEY_ANSWER2, items.getAnswer2());
	        values.put(KEY_ANSWER3, items.getAnswer3());
	        values.put(KEY_ANSWER4, items.getAnswer4());
	        values.put(KEY_CORRECT, items.getCorrectAnswer());
	        db.insert(TABLE_NAME, null, values);
	        db.close();
	    }
	    // Getting single row
	    public Items getItems(int id) {
	        SQLiteDatabase db = this.getReadableDatabase();
	        Cursor cursor = db.query(TABLE_NAME, COLUMNS, KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);
	        if (cursor != null) cursor.moveToFirst();
	        Items items = new Items();
	        items.setID(Integer.parseInt(cursor.getString(0)));
	        items.setQuestion(cursor.getString(1));
	        items.setAnswer1(cursor.getString(2));
	        items.setAnswer2(cursor.getString(3));
	        items.setAnswer3(cursor.getString(4));
	        items.setAnswer4(cursor.getString(5));
	        items.setAnswer4(cursor.getString(5));
	        items.setCorrectAnswer(cursor.getString(6));
	        return items;
	    }
	    // Getting random row
	    public Items getRandomItems() {
	        SQLiteDatabase db = this.getReadableDatabase();
	        String selectQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY RANDOM() LIMIT 1";
	        Cursor cursor = db.rawQuery(selectQuery, null);
	        if (cursor != null) cursor.moveToFirst();
	        Items items = new Items();
	        items.setID(Integer.parseInt(cursor.getString(0)));
	        items.setQuestion(cursor.getString(1));
	        items.setAnswer1(cursor.getString(2));
	        items.setAnswer2(cursor.getString(3));
	        items.setAnswer3(cursor.getString(4));
	        items.setAnswer4(cursor.getString(5));
	        items.setAnswer4(cursor.getString(5));
	        items.setCorrectAnswer(cursor.getString(6));
	        return items;
	    }
	    // Getting all rows
	    public ArrayList<Items> getAllItems() {
	        ArrayList<Items> itemsList = new ArrayList<Items>();
	        String selectQuery = "SELECT * FROM " + TABLE_NAME;
	        SQLiteDatabase db = this.getWritableDatabase();
	        Cursor cursor = db.rawQuery(selectQuery, null);
	        if (cursor.moveToFirst()) {
	            do {
	                Items items = new Items();
	                items.setID(Integer.parseInt(cursor.getString(0)));
	                items.setQuestion(cursor.getString(1));
	                items.setAnswer1(cursor.getString(2));
	                items.setAnswer2(cursor.getString(3));
	                items.setAnswer3(cursor.getString(4));
	                items.setAnswer4(cursor.getString(5));
	                items.setCorrectAnswer(cursor.getString(6));
	                itemsList.add(items);
	            } while (cursor.moveToNext());
	        }
	        return itemsList;
	    }
	    // Updating single row
	    public int updateItems(Items items) {
	        SQLiteDatabase db = this.getWritableDatabase();
	        ContentValues values = new ContentValues();
	        values.put(KEY_QUESTION, items.getQuestion());
	        values.put(KEY_ANSWER1, items.getAnswer1());
	        values.put(KEY_ANSWER2, items.getAnswer2());
	        values.put(KEY_ANSWER3, items.getAnswer3());
	        values.put(KEY_ANSWER4, items.getAnswer4());
	        values.put(KEY_CORRECT, items.getCorrectAnswer());
	        return db.update(TABLE_NAME, values, KEY_ID + " = ?", new String[] { String.valueOf(items.getID()) });
	    }
	    // Deleting single row
	    public void deleteItems(Items items) {
	        SQLiteDatabase db = this.getWritableDatabase();
	        db.delete(TABLE_NAME, KEY_ID + " = ?", new String[] { String.valueOf(items.getID()) });
	        db.close();
	    }
}
