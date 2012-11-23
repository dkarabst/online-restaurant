package com.softserve.academy.food.android;

import java.util.Collections;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.softserve.academy.food.android.model.Message;
import com.softserve.academy.food.android.model.UserModel;


public class LoginActivity extends AbstractAsyncActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		Button button_back = (Button) findViewById(R.id.button_back);
		button_back.setOnClickListener(new View.OnClickListener()

		{
			public void onClick(View v) {
				Intent intent_button_back = new Intent(LoginActivity.this,
						MainActivity.class);
				startActivity(intent_button_back);
			}
		});

		TextView registerScreen = (TextView) findViewById(R.id.link_to_register);
		registerScreen.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),
						RegisterActivity.class);
				startActivity(i);
			}
		});

		final Button submitButton = (Button) findViewById(R.id.btnLogin);

		submitButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new FetchSecuredResourceTask().execute();
			}
		});

	}

	private void displayResponse(Message response) {
		Toast.makeText(this, response.getText(), Toast.LENGTH_LONG).show();
	}
	
	private class FetchSecuredResourceTask extends
			AsyncTask<Void, Void, Message> {

		private String username;

		private String password;

		@Override
		protected void onPreExecute() {
			showLoadingProgressDialog();

			EditText editText = (EditText) findViewById(R.id.userName);
			this.username = editText.getText().toString();

			editText = (EditText) findViewById(R.id.userPassword);
			this.password = editText.getText().toString();
		}

		@Override
		protected Message doInBackground(Void... params) {
			final String url = getString(R.string.base_uri) + "/user/" + username;

			HttpAuthentication authHeader = new HttpBasicAuthentication(
					username, password);
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setAuthorization(authHeader);
			requestHeaders.setAccept(Collections
					.singletonList(MediaType.APPLICATION_JSON));

			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(
					new MappingJacksonHttpMessageConverter());
			
			try {

				ResponseEntity<UserModel> response = restTemplate.exchange(url,
						HttpMethod.GET, new HttpEntity<Object>(requestHeaders),
						UserModel.class);
				
				((Role) getApplicationContext()).setLogin(username);
				((Role) getApplicationContext()).setUserModel(response.getBody());
				Request.userModel=((Role) getApplicationContext()).getUserModel();
				
				if (response.getStatusCode().value() < 300) {
					Log.d("ROLE", "Admin");
					((Role) getApplicationContext()).setAdmin();
					return new Message(0, "", getResources().getString(
							R.string.mesUserOk));
				} else {
					return new Message(0, "", getResources().getString(
							R.string.mesUnknownError));
				}
			} catch (HttpClientErrorException e) {
				Log.e(TAG, e.getLocalizedMessage(), e);

				String resp;
				switch (e.getStatusCode().value()) {
				case 403: {
					Log.d("ROLE", "User");
					((Role) getApplicationContext()).setUser();
					resp = getResources().getString(R.string.mesUserOk);
					break;
				}
				case 401: {
					Log.d("ROLE", "Guest");
					((Role) getApplicationContext()).setGuest();
					resp = getResources().getString(R.string.mesGuestOk);
					break;
				}
				default:
					resp = getResources().getString(R.string.mesUnknownError);
					break;
				}
				return new Message(0, "", resp);
			}
		}

		@Override
		protected void onPostExecute(Message result) {
			dismissProgressDialog();
			displayResponse(result);
		}

	}
}