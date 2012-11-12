package com.softserve.academy.food.android;

import com.softserve.academy.food.android.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set View to register.xml
        setContentView(R.layout.register);
        Button button_back  = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() 
		
		{
			public void onClick(View v)
			{
				Intent intent_button_back = new Intent(RegisterActivity.this, MainActivity.class);
				startActivity(intent_button_back);
			}
		});

        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);
        
        // Listening to Login Screen link
        loginScreen.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// Switching to Login Screen/closing register screen
				finish();
			}
		});
    }
}