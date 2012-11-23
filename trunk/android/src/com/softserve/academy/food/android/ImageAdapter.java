package com.softserve.academy.food.android;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;

	public ImageAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return mThumbIds[position];
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) {
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(110, 110));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(4, 4, 4, 4);
		} else {
			imageView = (ImageView) convertView;
		}

		imageView.setImageResource(mThumbIds[position]);
		return imageView;
	}
	
	public	Integer[] mThumbIds = { R.drawable.rcat1, R.drawable.rcat2,
			R.drawable.rcat3, R.drawable.rcat4, R.drawable.rcat5,
			R.drawable.rcat6, R.drawable.rcat7, R.drawable.rcat8,
			R.drawable.rcat9, R.drawable.rcat10,R.drawable.rcat11 };
}