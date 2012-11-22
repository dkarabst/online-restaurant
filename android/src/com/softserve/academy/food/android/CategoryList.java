package com.softserve.academy.food.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class CategoryList extends Activity {

	public static final String MSG ="category";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category_list);
		StrictMode.enableDefaults();

		GridView gridview = (GridView) findViewById(R.id.gridView1);
		gridview.setAdapter(new ImageAdapter(this));

		gridview.setOnItemClickListener(gridviewOnItemClickListener);
	}

	private GridView.OnItemClickListener gridviewOnItemClickListener = new GridView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {
			Intent intent = new Intent(CategoryList.this, Dishes.class);
			intent.putExtra("category", position+1);
			startActivity(intent);
		}
	};
}