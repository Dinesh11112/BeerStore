package com.example.beerstore;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAlchohalAdapter extends RecyclerView.Adapter<MyAlchohalAdapter.ViewHolder> {

   Item[] myAlchohalData;
   Context context;
    private RecyclerView rView;
    private MyAlchohalAdapter mAdapter;
    Dialog myDialog;
    @NonNull
    @Override
            public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                View view = layoutInflater.inflate(R.layout.item_list,parent,false);
                final ViewHolder viewHolder =new ViewHolder(view);
                return viewHolder;
            }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position)  {

        final  Item myAlchohalDataList = myAlchohalData[position];
        holder.textViewName.setText(myAlchohalDataList.getAlchohalName());
        holder.textViewPrice.setText(myAlchohalDataList.getAlchohalPrice());
        holder.alchohalImage.setImageResource(myAlchohalDataList.getAlchohalImage());

        // Dialog initiate

        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.dialog_alchohal);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_alchohal_name = (TextView) myDialog.findViewById(R.id.dialog_name_id);
                TextView dialog_alchohal_price = (TextView) myDialog.findViewById(R.id.dialog_price_id);
                ImageView dialog_alchohal_img = (ImageView) myDialog.findViewById(R.id.dialog_img);
                Button dialog_button_buy = (Button) myDialog.findViewById(R.id.dialog_btn_buy);
                Button dialog_button_cancel = (Button) myDialog.findViewById(R.id.dialog_btn_return);
                dialog_alchohal_name.setText(myAlchohalDataList.getAlchohalName());
                dialog_alchohal_price.setText((myAlchohalDataList.getAlchohalPrice()));
                dialog_alchohal_img.setImageResource(myAlchohalDataList.getAlchohalImage());
                 myDialog.show();
                dialog_button_buy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent activity2 = new Intent(v.getContext(),CheckoutActivity.class);
                         context.startActivity(activity2);
                    }
                });
                 dialog_button_cancel.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {

                         myDialog.dismiss();
                     }
                 });
            }
        });
    }
    public MyAlchohalAdapter(Item[] myAlchohalData,ShopActivity activity) {
        this.myAlchohalData = myAlchohalData;
        this.context = activity;


    }
    @Override
    public int getItemCount() {
        return myAlchohalData.length;
    }
    public  class ViewHolder extends RecyclerView.ViewHolder {

        ImageView alchohalImage;
        TextView textViewName;
        TextView textViewPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            alchohalImage = itemView.findViewById(R.id.imageview);
            textViewName = itemView.findViewById(R.id.textName);
            textViewPrice = itemView.findViewById(R.id.textprice);
        }
    }
}
