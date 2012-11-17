package com.softserve.academy.food.android;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.softserve.academy.food.android.model.DishModel;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
public class Profile extends Activity
{
	final String BASE_URL = "http://10.0.2.2:8666/Restaurant/android";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		LinearLayout linearLayout;
		linearLayout = (LinearLayout)findViewById(R.id.linlayout);
        linearLayout.setBackgroundColor(Color.rgb(160, 200, 240));

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
	
	// Выбор всех блюд	
	public void postOrder()
	{
		DishModel dm1 = new DishModel();
		DishModel dm2 = new DishModel();
		DishModel dm3 = new DishModel();
		dm1.setId(15);
		dm2.setId(17);
		dm3.setId(18);
		int[] ar = new int[3];
		String url = BASE_URL + "/order";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		restTemplate.postForObject(url, ar, Integer[].class);
	}
}