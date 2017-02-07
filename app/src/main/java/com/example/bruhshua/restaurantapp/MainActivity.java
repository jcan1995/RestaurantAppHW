package com.example.bruhshua.restaurantapp;

import android.app.DialogFragment;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//To show
    private ListView listView;
    private ArrayList<MenuItem> mItems = new ArrayList<MenuItem>();;
    private ArrayList<ImageView> pictures;
    private Button bAdd;
    private EditText etQuantity;
    private FloatingActionButton FAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItems = MenuSingleton.getInstance(this).getMenuItems();
        listView = (ListView) findViewById(R.id.listView);
        Adapter mAdapter = new Adapter(mItems);
        listView.setAdapter(mAdapter);
        FAB = (FloatingActionButton)findViewById(R.id.bCheckout);
        FAB.setImageResource(R.mipmap.ic_checkout);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "To Checkout", Toast.LENGTH_LONG).show();
                //Todo: Start new activity passing arraylist? Maybe it comes from singleton..
                Intent intent = new Intent(getApplicationContext(),CheckoutActivity.class);
                startActivity(intent);
            }
        });

    }

    public class Adapter extends ArrayAdapter<MenuItem> {

        public Adapter(ArrayList<MenuItem> item) {
            super(getApplicationContext(), android.R.layout.simple_list_item_1, item);

        }

        @Override
        public int getPosition(MenuItem item) {
            return super.getPosition(item);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item, null);
            }


            final MenuItem itemPos = getItem(position);
            MenuItem item = getItem(position);

            ArrayList<EditText> editTexts;

            bAdd = (Button) convertView.findViewById(R.id.bOrder);
            bAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    switch (itemPos.getName()) {
                        case "Artisan Grilled Chicken Sandwich":
                            DialogFragment artisan = OrderDialog.newInstance(1, itemPos);
                            artisan.show(getFragmentManager(), "TAG");
                            break;
                        case "Big Mac":
                            DialogFragment bigMac = OrderDialog.newInstance(1, itemPos);
                            bigMac.show(getFragmentManager(), "TAG");
                            //  Toast.makeText(getApplicationContext(),"Inside 2st item",Toast.LENGTH_SHORT).show();
                            break;
                        case "Chick McNuggets":
                            DialogFragment nuggets = OrderDialog.newInstance(1, itemPos);
                            nuggets.show(getFragmentManager(), "TAG");
                            break;
                        case "Double Quarter Pounder W/ Cheese":
                            DialogFragment quarter = OrderDialog.newInstance(1, itemPos);
                            quarter.show(getFragmentManager(), "TAG");
                            break;
                        case "Filet-O-Fish":
                            DialogFragment fishy = OrderDialog.newInstance(1, itemPos);
                            fishy.show(getFragmentManager(), "TAG");
                            break;
                        case "Grand Mac":
                            DialogFragment grand = OrderDialog.newInstance(1, itemPos);
                            grand.show(getFragmentManager(), "TAG");
                            break;
                        case "Mac Jr.":
                            DialogFragment macJ = OrderDialog.newInstance(1, itemPos);
                            macJ.show(getFragmentManager(), "TAG");
                            break;
                        case "Premium Buttermilk Crispy Sandwich":
                            DialogFragment premium = OrderDialog.newInstance(1, itemPos);
                            premium.show(getFragmentManager(), "TAG");
                            break;
                        case "Quarter Pounder W/ Cheese(Royale W/ Cheese)":
                            DialogFragment royale = OrderDialog.newInstance(1, itemPos);
                            royale.show(getFragmentManager(), "TAG");
                            break;
                    }
                }
            });


            ImageView ivPicture = (ImageView) convertView.findViewById(R.id.ivFoodPhoto);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) ivPicture.getLayoutParams();
            ivPicture.setLayoutParams(params);
            ivPicture.setImageResource(item.getPicture());

            TextView tvName = (TextView) convertView.findViewById(R.id.tvFoodName);
            tvName.setText(item.getName());

            TextView tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
            tvPrice.setText("" + item.getPrice());


            return convertView;

        }


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }



}
