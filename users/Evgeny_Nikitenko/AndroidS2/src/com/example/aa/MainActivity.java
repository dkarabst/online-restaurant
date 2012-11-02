package com.example.aa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity
{
	private EditText tv = null;
	private EditText tv2 = null;
	public RestTemplate restTemplate;
	final String url = "http://10.0.2.2:8666/Spring/helloWorld";

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
		.permitAll().build();
StrictMode.setThreadPolicy(policy);
		StrictMode.enableDefaults();
		tv = (EditText) this.findViewById(R.id.textView1);
		
		Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				try{
					HttpClient client = new DefaultHttpClient();
					HttpGet request = new HttpGet(url);
					HttpResponse response = client.execute(request);
					BufferedReader rd = new BufferedReader(
						new InputStreamReader(response.getEntity().getContent()));
					String result = "";
					while ((result = rd.readLine()) != null)
					{
						System.out.println(result);
						tv.setText( result );
					}
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		});
		
		tv2 = (EditText) this.findViewById(R.id.EditText02);
		Button b2 = (Button) findViewById(R.id.Button02);
		b2.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
//				RestTemplate restTemplate = new RestTemplate();
//				String result = restTemplate.getForObject(url, String.class);

				HttpHeaders requestHeaders = new HttpHeaders();
				requestHeaders.setContentType(new MediaType("text", "xml"));
				HttpEntity requestEntity = new HttpEntity(requestHeaders);
				String url = "http://10.0.2.2:8666/Spring/helloWorld";
				RestTemplate restTemplate = new RestTemplate();
				ResponseEntity<String> responseEntity = restTemplate.exchange(
						url, HttpMethod.GET, requestEntity, String.class);
				String result = responseEntity.getBody().toString();
				tv2.setText(result);
			}
		});
	}
}