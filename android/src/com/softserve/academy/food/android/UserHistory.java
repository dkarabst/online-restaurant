package com.softserve.academy.food.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.softserve.academy.food.android.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class UserHistory extends Activity implements OnClickListener
{
	Button button, button1, button_back;
	String url1 = "http://10.0.2.2:8777/au/echo";
	EditText outputText, outputText1;
	String url2 = "http://10.0.2.2:8666/AndroidJAX-RS/jaxrs/helloworld";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_history);
		LinearLayout linearLayout;
		linearLayout = (LinearLayout)findViewById(R.id.linlayout);
        linearLayout.setBackgroundColor(Color.rgb(160, 200, 240));

		findViewsById();
		StrictMode.enableDefaults();

		button.setOnClickListener(this);
		button_back.setOnClickListener(new View.OnClickListener() 
		
		{
			public void onClick(View v)
			{
				Intent intent_button_back = new Intent(UserHistory.this, MainActivity.class);
				startActivity(intent_button_back);
			}
		});
		button1.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v)
			{
				try{
				HttpClient client = new DefaultHttpClient();
				HttpGet request = new HttpGet(url1);
				HttpResponse response = client.execute(request);
				BufferedReader rd = new BufferedReader(
						new InputStreamReader(response.getEntity().getContent()));
				String result = "";
				while ((result = rd.readLine()) != null)
				{
					outputText1.setText(result);
				}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void findViewsById()
	{
		button = (Button) findViewById(R.id.button1);
		outputText = (EditText) findViewById(R.id.editText1);
		button_back  = (Button) findViewById(R.id.button_back);
		button1  = (Button) findViewById(R.id.Button01);
		outputText1 = (EditText) findViewById(R.id.EditText01);
	}

	public void onClick(View arg0)
	{
		try{
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url2);
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent()));
		String result = "";
		while ((result = rd.readLine()) != null)
		{
			outputText.setText(result);
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}