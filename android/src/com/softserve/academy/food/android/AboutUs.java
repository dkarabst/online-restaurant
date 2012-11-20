package com.softserve.academy.food.android;

import com.softserve.academy.food.android.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
public class AboutUs extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_us);
		LinearLayout linearLayout;
		linearLayout = (LinearLayout)findViewById(R.id.linlayout);
        linearLayout.setBackgroundColor(Color.rgb(160, 200, 240));
		Button button_back = (Button) findViewById(R.id.button_back);
		button_back.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v)
			{
				Intent intent_button_back = new Intent(AboutUs.this, MainActivity.class);
				startActivity(intent_button_back);
			}
		});
	}
}