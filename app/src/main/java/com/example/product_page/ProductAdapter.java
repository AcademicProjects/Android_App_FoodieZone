package com.example.product_page;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    final private productListOnCLickListener cLickListener;
    private List<Product> productList;

    public ProductAdapter(List<Product> productList, productListOnCLickListener cLickListener) {
        this.productList = productList;
        this.cLickListener = cLickListener;
    }

    public void updateData(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.producr_card_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.productTitle.setText(productList.get(position).getName());


        Glide.with(holder.productImage)
                .load(productList.get(position).getImageUrl())
                .into(holder.productImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cLickListener.onItemClick(productList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public interface productListOnCLickListener {
        void onItemClick(Product product);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView productTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.asian_salmon);
            productTitle = itemView.findViewById(R.id.salmon_title);

        }
    }

}
