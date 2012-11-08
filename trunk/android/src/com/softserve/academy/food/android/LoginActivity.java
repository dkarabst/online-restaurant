package com.softserve.academy.food.android;

import com.softserve.academy.food.android.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button button_back  = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() 
		
		{
			public void onClick(View v)
			{
				Intent intent_button_back = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(intent_button_back);
			}
		});

        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);
        
        // Listening to register new account link
        registerScreen.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// Switching to Register screen
				Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
				startActivity(i);
			}
		});
    }
}