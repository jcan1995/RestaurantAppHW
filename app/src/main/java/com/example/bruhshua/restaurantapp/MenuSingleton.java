package com.example.bruhshua.restaurantapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;

/**
 * Created by bruhshua on 2/3/17.
 */
public class MenuSingleton {

    private int[] pictures = {R.drawable.artisan_grilledchick_sandwich,R.drawable.big_mac,
                                R.drawable.chick_mc_nuggets,R.drawable.double_quarter_cheese,
                                R.drawable.filet,R.drawable.grand_mac,R.drawable.mac_jr,
                                R.drawable.premium_chic_sand,R.drawable.quarter_pound_cheese};//Get pictures
    private double[] prices = {6.39,5.99,6.49,6.69,5.79,6.99,4.99,6.49,5.79};
    private String[] names = {"Artisan Grilled Chicken Sandwich","Big Mac",
            "Chick McNuggets","Double Quarter Pounder W/ Cheese",
            "Filet-O-Fish","Grand Mac","Mac Jr.","Premium Buttermilk Crispy Sandwich",
            "Quarter Pounder W/ Cheese(Royale W/ Cheese)"};

    private ArrayList<MenuItem> mItems = new ArrayList<MenuItem>();
    private ArrayList<MenuItem> mOrders = new ArrayList<>();

    private static MenuSingleton sMenuSingleton = null;
    private Context mAppContext;

    public static MenuSingleton getInstance(Context c) {
        if(sMenuSingleton == null){
            sMenuSingleton = new MenuSingleton(c.getApplicationContext());
        }
        return sMenuSingleton;
    }

    private MenuSingleton(Context appContext) {
        mAppContext = appContext;
        mItems = initializeArray();
    }
    //Function will create arrayList of menu items and return an ArrayList..Lets start with 5
    private ArrayList<MenuItem> initializeArray() {
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();

        for(int i = 0; i < 9; i++){
            MenuItem item = new MenuItem(pictures[i],names[i],prices[i]);
            items.add(item);
        }

        return items;
    }

    public ArrayList<MenuItem> getMenuItems(){
        return mItems;
    }
    public ArrayList<MenuItem> getOrders(){return  mOrders;}
    public void addOrder(MenuItem item){mOrders.add(item);}
}
