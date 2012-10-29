package com.example.aa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

//���� ��������� �� ����������, ������ �
//https://github.com/douglascrockford/JSON-java/downloads (Download as zip)
import org.json.JSONException;
import org.json.JSONObject;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;

import android.app.Activity;
import android.content.Context;

//���� ��������� ���� ������ �������
import com.models.*;

public class MainActivity extends Activity {
	private EditText tv = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (EditText) this.findViewById(R.id.textView1);

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);

		View.OnClickListener h = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {

				case R.id.button1: {

					//��������� ����������� �������� � ������
					ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
					NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
					if (networkInfo != null && networkInfo.isConnected()) {

						tv.append("connecting...\n");

						try {
							//������ ������, ��� ��������� � ������� �������� "�����"
							URL url = new URL(
									"http://10.0.2.2:8080/au/echo?model=ModelDish");

							//���������� ������
							HttpURLConnection con = (HttpURLConnection) url
									.openConnection();

							//������ ����� � ������
							String s = readStream(con.getInputStream());

							//���� ������ �� ������, ����� � �������
							if (!s.equals("")) {

								//������ � json-������ 
								JSONObject jObj = null;
								try {
									jObj = new JSONObject(s);
								} catch (JSONException e) {
									tv.append("ERROR: JSON parsing\n");
								}

								//������ ������ �������� � ��������� ���� ����������� �������
								ModelDish dish = new ModelDish();

								dish.setDescription(jObj
										.getString("description"));
								dish.setName(jObj.getString("name"));
								dish.setWeight(jObj.getString("weight"));

								tv.append(dish.getName() + "\n"
										+ dish.getWeight() + "\n"
										+ dish.getDescription());
							}
						} catch (Exception e) {
							tv.append("ERROR: connecting\n");
						}

					} else {
						tv.setText("ERROR: no connection");
					}
					;
				}
				}
			}
		};

		this.findViewById(R.id.button1).setOnClickListener(h);
	}

	//������ ������ ������� � ������
	private String readStream(InputStream in) {
		BufferedReader reader = null;
		String s = "";
		try {
			reader = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				s += line;
			}
		} catch (IOException e) {
			s = "";
			tv.append("ERROR: reading");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					tv.append("ERROR: closing");
					s = "";
				}
			}
		}
		return s;
	}

}
