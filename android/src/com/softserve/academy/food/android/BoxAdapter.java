package com.softserve.academy.food.android;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.softserve.academy.food.android.model.DishModel;

public class BoxAdapter extends BaseAdapter
{
	Context ctx;
	LayoutInflater lInflater;
	RMenu rm = new RMenu();
	
	ArrayList<DishModel> allDishes = rm.getAllDishes();
	

	BoxAdapter(Context context, ArrayList<DishModel> products)
	{
		ctx = context;
		allDishes = products;
		lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	// кол-во элементов
	public int getCount()
	{
		return allDishes.size();
	}

	// элемент по позиции
	public Object getItem(int position)
	{
		return allDishes.get(position);
	}

	// id по позиции
	public long getItemId(int position)
	{
		return position;
	}

	// пункт списка
	public View getView(int position, View convertView, ViewGroup parent)
	{
		// используем созданные, но не используемые view
		View view = convertView;
		if (view == null)
		{
			view = lInflater.inflate(R.layout.item, parent, false);
		}

		DishModel dishModel = getDishModel(position);

		// заполняем View в пункте списка данными из товаров: наименование, цена
		// и картинка
		((TextView) view.findViewById(R.id.tvName)).setText(dishModel.getName());
		((TextView) view.findViewById(R.id.tvPrice)).setText("Цена: " + dishModel.getPrice() + " грн");
//		((ImageView) view.findViewById(R.id.ivImage)).setImageResource(dishModel.getPhoto());

		CheckBox cbBuy = (CheckBox) view.findViewById(R.id.cbBox);
		// присваиваем чекбоксу обработчик
		cbBuy.setOnCheckedChangeListener(myCheckChangList);
		// пишем позицию
		cbBuy.setTag(position);
		// заполняем данными из товаров: в корзине или нет
		cbBuy.setChecked(dishModel.isBox());
		return view;
	}

	// товар по позиции
	DishModel getDishModel(int position)
	{
		return ((DishModel) getItem(position));
	}

	// содержимое корзины
	ArrayList<DishModel> getBox()
	{
		ArrayList<DishModel> box = new ArrayList<DishModel>();
		for (DishModel dishModel : allDishes)
		{
			// если в корзине
			if (dishModel.isBox())
				box.add(dishModel);
		}
		return box;
	}

	// обработчик для чекбоксов
	OnCheckedChangeListener myCheckChangList = new OnCheckedChangeListener()
	{
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked)
		{
			// меняем данные товара (в корзине или нет)
			getDishModel((Integer) buttonView.getTag()).box = isChecked;
		}
	};
}