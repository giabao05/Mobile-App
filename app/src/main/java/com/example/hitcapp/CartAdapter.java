package com.example.hitcapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CartAdapter extends BaseAdapter {

    private Context context;
    private List<Product> cartItems;

    public CartAdapter(Context context, List<Product> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @Override
    public int getCount() {
        return cartItems.size();
    }

    @Override
    public Object getItem(int position) {
        return cartItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView priceTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_cart_product, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.cart_product_image);
            holder.nameTextView = convertView.findViewById(R.id.cart_product_name);
            holder.priceTextView = convertView.findViewById(R.id.cart_product_price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Product product = cartItems.get(position);
        holder.imageView.setImageResource(product.getImageResId());
        holder.nameTextView.setText(product.getName());
        holder.priceTextView.setText(product.getPrice());

        return convertView;
    }
}
