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

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class UserHistory extends Activity implements OnClickListener
{
	Button button, button1, button_back;
	String URL = "http://192.168.1.3:8080/au/echo";
	EditText outputText, outputText1;
	String line = "";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_history);
		LinearLayout linearLayout;
		linearLayout = (LinearLayout)findViewById(R.id.linlayout);
        linearLayout.setBackgroundColor(Color.rgb(160, 200, 240));

		findViewsById();
		button_back  = (Button) findViewById(R.id.button_back);
		button1  = (Button) findViewById(R.id.Button01);

		button.setOnClickListener(this);
		
		//******* hide the button
		if ( ((Role)getApplicationContext()).isGuest() ) {
			button1.setVisibility(View.INVISIBLE);
		} else {
			button1.setVisibility(View.VISIBLE);			
		}
		//*****************************
		button1.setOnClickListener(this);
		
		outputText1 = (EditText) findViewById(R.id.EditText01);
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
				HttpGet request = new HttpGet(URL);
				HttpResponse response = client.execute(request);
				BufferedReader rd = new BufferedReader(
						new InputStreamReader(response.getEntity().getContent()));
				while ((line = rd.readLine()) != null)
				{
					System.out.println(line);
				}
				} catch (IOException e) {
					e.printStackTrace();
				}
				outputText1.setText(line);
			}
		});
	}

	private void findViewsById()
	{
		button = (Button) findViewById(R.id.button1);
		outputText = (EditText) findViewById(R.id.editText1);

	}
	public void onClick(View view)
	{
		GetXMLTask task = new GetXMLTask();
		task.execute(new String[]{URL});
	}

	private class GetXMLTask extends AsyncTask<String, Void, String>
	{
		@Override
		protected String doInBackground(String... urls)
		{
			
			String output = null;
			for (String url : urls)
			{
				output = getOutputFromUrl(url);
			}
			return output;
		}
		private String getOutputFromUrl(String url)
		{
			StringBuffer output = new StringBuffer("");
			try
			{
				InputStream stream = getHttpConnection(url);
				BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
				String s = "";
				while ((s = buffer.readLine()) != null)
					output.append(s);
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
			return output.toString();
		}
		// Makes HttpURLConnection and returns InputStream
		private InputStream getHttpConnection(String urlString)
				throws IOException
		{
			InputStream stream = null;
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			try
			{
				HttpURLConnection httpConnection = (HttpURLConnection) connection;
				httpConnection.setRequestMethod("GET");
				httpConnection.connect();
				if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
				{
					stream = httpConnection.getInputStream();
				}
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
			return stream;
		}

		@Override
		protected void onPostExecute(String resultstring)
		{
			outputText.setText(resultstring);
		}
	}
	
	
	
}