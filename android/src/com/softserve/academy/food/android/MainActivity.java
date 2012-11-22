package com.softserve.academy.food.android;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener
{
	private LinearLayout	linearLayout;
	private Button			rmenu, profile, login, about_us;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		StrictMode.enableDefaults();
		rmenu = (Button) findViewById(R.id.rmenu);
		rmenu.setOnClickListener(this);
		profile = (Button) findViewById(R.id.profile);
		profile.setOnClickListener(this);
		login = (Button) findViewById(R.id.login);
		login.setOnClickListener(this);
		about_us = (Button) findViewById(R.id.about_us);
		about_us.setOnClickListener(this);
		linearLayout = (LinearLayout) findViewById(R.id.linlayout);
		linearLayout.setBackgroundColor(Color.rgb(160, 200, 240));

		if (Request.model == null)
		{
			new Request();
			new GetData().execute();
			Request.getUserInfo(1);
		}
	}

	private class GetData extends AsyncTask<Void, Void, Void>
	{
		protected Void doInBackground(Void ...voids )
		{
			Request.getDishesByCatId();
			return null;
		}
	}

	public void onClick(View v)
	{
		switch (v.getId())
		{
		// case R.id.rmenu : Intent intent_rmenu = new Intent(this,
		// Categories.class);
			case R.id.rmenu:
				Intent intent_rmenu = new Intent(this, CategoryList.class);
				startActivity(intent_rmenu);
				break;
			case R.id.profile:
				Intent intent_profile = new Intent(this, Profile.class);
				startActivity(intent_profile);
				break;
			case R.id.login:
				Intent intent_login = new Intent(this, LoginActivity.class);
				startActivity(intent_login);
				break;
			case R.id.about_us:
				Intent intent_about_us = new Intent(this, AboutUs.class);
				startActivity(intent_about_us);
				break;
			default:
				break;
		}
	}
}