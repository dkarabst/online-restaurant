package com.softserve.academy.food.android;

import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.softserve.academy.food.android.Request;

public class RegisterActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        loginScreen.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				finish();
			}
		});
        
        Button button_go  = (Button) findViewById(R.id.btnRegister);
        button_go.setOnClickListener(new View.OnClickListener() 	
		{
			public void onClick(View v)
			{

				String s = "Error is :\n";
		        boolean check = false;
		        if (!(Pattern.matches("\\w+[^\\d]", ((TextView)findViewById(R.id.reg_fullname)).getText() ))) {
		            s += "Name\n";
		            check = true;
		        }
		        if (!(Pattern.matches("\\w+", ((TextView)findViewById(R.id.reg_password)).getText() ))) {
		            s += "Password\n";
		            check = true;
		        }
		        if (!(Pattern.matches("\\d{7}", ((TextView)findViewById(R.id.reg_phone)).getText() ))) {
		            s += "Phone number\n";
		            check = true;
		        }
		        if (!(Pattern.matches("^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)"
		                + "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)"
		                + "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)"
		                + "+(?:[a-zA-Z]){2,}\\.?)$", ((TextView)findViewById(R.id.reg_email)).getText() ))) {
		            s += "Email address\n";
		            check = true;
		        }
				
				if (check) {
					Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_SHORT).show();
				} else {
					
					((Role) getApplicationContext()).setUserModel(Request.newUser(((TextView)findViewById(R.id.reg_fullname)).getText().toString(),
							((TextView)findViewById(R.id.reg_password)).getText().toString(),
							((TextView)findViewById(R.id.reg_phone)).getText().toString(),
							((TextView)findViewById(R.id.reg_email)).getText().toString()
							));
						((Role) getApplicationContext()).setLogin(((TextView)findViewById(R.id.reg_fullname)).getText().toString());

						((Role) getApplicationContext()).setUser();
						Request.userModel=((Role) getApplicationContext()).getUserModel();
					Toast.makeText(RegisterActivity.this, "You was registred", Toast.LENGTH_SHORT).show();
					
				}
				
			}
		});
        
    }
}