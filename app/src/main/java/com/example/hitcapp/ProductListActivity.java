package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    private ListView listView;
    private ProductAdapter adapter;
    private ArrayList<Product> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        listView = findViewById(R.id.product_list);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String category = intent.getStringExtra("category");

        // Lấy danh sách từ MainActivity hoặc tạo lại
        filteredList = new ArrayList<>();

        // Đây là dữ liệu demo – bạn có thể lấy từ database hoặc intent
        ArrayList<Product> allProducts = ProductData.getAllProducts();  // cần tạo lớp ProductData chứa danh sách

        for (Product p : allProducts) {
            if (category.equals("all") || p.getCategory().equalsIgnoreCase(category)) {
                filteredList.add(p);
            }
        }

        adapter = new ProductAdapter(this, filteredList);
        listView.setAdapter(adapter);

        // Bắt sự kiện click item để mở ProductDetailActivity
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Product selected = filteredList.get(position);
            Intent detailIntent = new Intent(this, ProductDetailActivity.class);
            detailIntent.putExtra("name", selected.getName());
            detailIntent.putExtra("price", selected.getPrice());
            detailIntent.putExtra("category", selected.getCategory());
            detailIntent.putExtra("imageResId", selected.getImageResId());
            startActivity(detailIntent);
        });
    }
}
