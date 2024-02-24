package com.example.product_page;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder>{

    final private OrderAdapter.productListOnCLickListener cLickListener;
    private List<Order> OrderList;


    public OrderAdapter(List<Order> orderList , OrderAdapter.productListOnCLickListener cLickListener) {
        OrderList = orderList;
        this.cLickListener = cLickListener;
    }

    public void updateData(List<Order> List) {
        this.OrderList = List;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public OrderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_card_view, parent, false);
        return new OrderAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.MyViewHolder holder,@SuppressLint("RecyclerView") int position) {

        holder.productTitle.setText(OrderList.get(position).getP().getName());
        holder.productPrice.setText(" "+OrderList.get(position).getTotal_price());
        holder.productQuantity.setText(" "+OrderList.get(position).getCount());
        holder.productDate.setText(" "+OrderList.get(position).getOrderDate());

        Glide.with(holder.productImage)
                .load(OrderList.get(position).getP().getImageUrl())
                .into(holder.productImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cLickListener.onItemClick(OrderList.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return OrderList.size();
    }

    public interface productListOnCLickListener {
        void onItemClick(Order product);
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView productTitle;
        TextView productQuantity;
        TextView productPrice;
        TextView productDate;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.order_image);
            productTitle = itemView.findViewById(R.id.producr_name);
            productQuantity = itemView.findViewById(R.id.orderQuantity);
            productPrice = itemView.findViewById(R.id.orderPrice);
            productDate = itemView.findViewById(R.id.orderDate);


        }
    }


}
