package com.example.hitcapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Product> originalList;
    private ArrayList<Product> filteredList;
    private LayoutInflater inflater;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.originalList = new ArrayList<>(products);   // Dữ liệu gốc
        this.filteredList = new ArrayList<>(products);   // Dữ liệu đang hiển thị
        this.inflater = LayoutInflater.from(context);
    }

    // Lọc theo tên sản phẩm
    public void filter(String query) {
        query = query.toLowerCase().trim();
        filteredList.clear();

        if (query.isEmpty()) {
            filteredList.addAll(originalList);
        } else {
            for (Product product : originalList) {
                if (product.getName().toLowerCase().contains(query)) {
                    filteredList.add(product);
                }
            }
        }

        notifyDataSetChanged();
    }

    // Lọc theo danh mục
    public void filterByCategory(String category) {
        filteredList.clear();

        if ("all".equalsIgnoreCase(category)) {
            filteredList.addAll(originalList);
        } else {
            for (Product product : originalList) {
                if (product.getCategory().equalsIgnoreCase(category)) {
                    filteredList.add(product);
                }
            }
        }

        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return filteredList.size();
    }

    @Override
    public Product getItem(int position) {
        return filteredList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // ViewHolder pattern để tối ưu hiệu năng ListView
    static class ViewHolder {
        TextView name;
        TextView price;
        ImageView image;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.product_item, parent, false);
            holder = new ViewHolder();

            holder.name = convertView.findViewById(R.id.product_name);
            holder.price = convertView.findViewById(R.id.product_price);
            holder.image = convertView.findViewById(R.id.product_image);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Product product = getItem(position);

        holder.name.setText(product.getName());
        holder.price.setText(product.getPrice());
        holder.image.setImageResource(product.getImageResId());

        return convertView;
    }
}
