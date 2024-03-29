package com.softserve.academy.food.android;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
public class Profile extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		LinearLayout linearLayout;
		linearLayout = (LinearLayout)findViewById(R.id.linlayout);
        linearLayout.setBackgroundColor(Color.rgb(160, 200, 240));
        
		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setText(
				"Hello, " + ((Role) getApplicationContext()).getLogin() + '\n' + '\n' + '\n' +
				"Your profile is" + "\n\n" +
				"Email: " + ((Role) getApplicationContext()).getUserModel().getEmail() +"\n" +
				"Phone: " + ((Role) getApplicationContext()).getUserModel().getPhone()
		);
        
        Button button_back = (Button) findViewById(R.id.button_back);
		button_back.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v)
			{
				Intent intent_button_back = new Intent(Profile.this, MainActivity.class);
				startActivity(intent_button_back);
			}
		});
	}		
}