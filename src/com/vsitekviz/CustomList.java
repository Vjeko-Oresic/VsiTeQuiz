package com.vsitekviz;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.vsitekviz.R;

public class CustomList extends BaseAdapter {

	Context context;
    private ArrayList<Items> aItem;
    	
    public CustomList(Context context, ArrayList<Items> i) {
         this.context = context;
         aItem = i;
     }
    
    public int getCount() {
        return aItem.size();
    }

    public Object getItem(int position) {
        return aItem.get(position);
    }

    public long getItemId(int position) {
        return position;
    }
       
    public View getView(int position, View convertView, ViewGroup parent) {
   	 Items item = aItem.get(position);
   	 if(convertView==null){
   		 LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
   		 convertView = inflater.inflate(R.layout.list_row, null);
   	 }
   	 TextView question = (TextView)convertView.findViewById(R.id.Question);
   	 question.setText(item.getQuestion());
   	 TextView answer1 = (TextView)convertView.findViewById(R.id.Answer1);
   	 answer1.setText(item.getAnswer1());
   	 TextView answer2 = (TextView)convertView.findViewById(R.id.Answer2);
   	 answer2.setText(item.getAnswer2());
   	 TextView answer3 = (TextView)convertView.findViewById(R.id.Answer3);
   	 answer3.setText(item.getAnswer3());
   	 TextView answer4 = (TextView)convertView.findViewById(R.id.Answer4);
   	 answer4.setText(item.getAnswer4());
   	 TextView correctAnswer = (TextView)convertView.findViewById(R.id.CorrectAnswer);
   	 correctAnswer.setText(item.getCorrectAnswer());
   	 return convertView;
    }
}
