package com.example.bruhshua.restaurantapp;

import android.app.Application;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by bruhshua on 2/7/17.
 */

public class CheckoutActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<MenuItem> mItems = new ArrayList<MenuItem>();;
    private double price_final;
    private TextView tvFinalPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_main);
        tvFinalPrice = (TextView) findViewById(R.id.tvFinalPrice);
        mItems = MenuSingleton.getInstance(getApplicationContext()).getOrders();
        listView = (ListView) findViewById(R.id.listView);
        CheckoutAdapter mAdapter = new CheckoutAdapter(mItems);
        listView.setAdapter(mAdapter);
        for(int i = 0; i < mItems.size();i++){
            price_final = price_final + (mItems.get(i).getPrice() * mItems.get(i).getQuantity());
        }

        tvFinalPrice.setText(String.valueOf(price_final));
    }

    public class CheckoutAdapter extends ArrayAdapter<MenuItem> {

        public CheckoutAdapter(ArrayList<MenuItem> item) {
            super(getApplicationContext(), android.R.layout.simple_list_item_1, item);

        }

        @Override
        public int getPosition(MenuItem item) {
            return super.getPosition(item);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.checkout_list_item, null);
            }

            MenuItem item = getItem(position);

            TextView tvName = (TextView) convertView.findViewById(R.id.tvFoodName);
            tvName.setText(item.getName());

            TextView tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
            tvPrice.setText("" + item.getPrice());

            TextView tvSize = (TextView) convertView.findViewById(R.id.tvSize);
            tvSize.setText(item.getSize());

            TextView tvQuantity = (TextView) convertView.findViewById(R.id.tvQuantity);
            tvQuantity.setText(String.valueOf(item.getQuantity()));

            return convertView;

        }
    }
}
