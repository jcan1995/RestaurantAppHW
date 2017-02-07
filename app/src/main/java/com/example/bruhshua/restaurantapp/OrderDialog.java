package com.example.bruhshua.restaurantapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by bruhshua on 2/7/17.
 */

public class OrderDialog extends DialogFragment {

    private MenuItem item;
    public OrderDialog(){}

    static OrderDialog newInstance(int arg, MenuItem menuItem) {
        OrderDialog f = new OrderDialog();

        Bundle args = new Bundle();
        args.putInt("count",arg);
        f.setArguments(args);
        f.setComplexVariable(menuItem);
        return f;
    }

    public void setComplexVariable(MenuItem menuItem){
        item = menuItem;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        final View view = inflater.inflate(R.layout.order_dialog,null);

        ImageView ivPicture = (ImageView)view.findViewById(R.id.ivFoodPhoto);

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) ivPicture.getLayoutParams();
        ivPicture.setLayoutParams(params);
        ivPicture.setImageResource(item.getPicture());

        TextView tvName = (TextView) view.findViewById(R.id.tvFoodName);
        tvName.setText(item.getName());

        TextView tvPrice = (TextView)view.findViewById(R.id.tvPrice);
        tvPrice.setText(""+item.getPrice());

        final Spinner sizes = (Spinner)view.findViewById(R.id.spinSize);
        final EditText etQuantity = (EditText)view.findViewById(R.id.etQuantity);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Place order");
        builder.setView(view);

        builder.setPositiveButton("Place Order", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(etQuantity.getText().toString().equals("")){
                    Toast.makeText(getActivity(),"Please input a quantity.",Toast.LENGTH_SHORT).show();

                }
                else{
                    String size = String.valueOf(sizes.getSelectedItem());//Size
                    int quantity = Integer.parseInt(etQuantity.getText().toString());
                    double price = item.getPrice();
                    String name = item.getName();
                    MenuItem newItem = new MenuItem(name,price,size,quantity);
                    MenuSingleton.getInstance(getActivity()).addOrder(newItem);
                    Toast.makeText(getActivity(),"Order added to cart",Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Canceled",Toast.LENGTH_SHORT).show();

            }
        });
        return builder.create();
    }


}
