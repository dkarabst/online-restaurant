package com.softserve.academy.food.android;

//import org.json.JSONArray;
//
//import com.android.restaurant_menu_04.R;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.ListView;
//public class RMenu extends Activity
//{
//	private ListView list;
//	
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState)
//	{
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.rmenu);
//		Button button_back = (Button) findViewById(R.id.button_back);
//		button_back.setOnClickListener(new View.OnClickListener() 
//		{
//			public void onClick(View v)
//			{
//				Intent intent_button_back = new Intent(RMenu.this, MainActivity.class);
//				startActivity(intent_button_back);
//			}
//		});
//	}
//}
 

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
public class RMenu extends Activity implements OnClickListener
{
	final String LOG_TAG = "myLogs";
	ListView lvMain;
	String[] names;
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rmenu);
		LinearLayout linearLayout;
		linearLayout = (LinearLayout)findViewById(R.id.linlayout);
        linearLayout.setBackgroundColor(Color.rgb(160, 200, 240));
		lvMain = (ListView) findViewById(R.id.lvMain);
		// устанавливаем режим выбора пунктов списка
		lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		// —оздаем адаптер, использу€ массив из файла ресурсов
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.namesDish,
				android.R.layout.simple_list_item_multiple_choice);
		lvMain.setAdapter(adapter);
		Button btnChecked = (Button) findViewById(R.id.btnChecked);
		btnChecked.setOnClickListener(this);
		// получаем массив из файла ресурсов
		names = getResources().getStringArray(R.array.namesDish);
		
		Button button_back = (Button) findViewById(R.id.button_back);
		button_back.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v)
			{
				Intent intent_button_back = new Intent(RMenu.this, MainActivity.class);
				startActivity(intent_button_back);
			}
		});

	}
	public void onClick(View arg0)
	{
		// пишем в лог выделенный элемент
//		Log.d(LOG_TAG, "checked: " + names[lvMain.getCheckedItemPosition()]);
	}
}