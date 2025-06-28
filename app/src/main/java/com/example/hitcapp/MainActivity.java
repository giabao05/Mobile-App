package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;
    private ProductAdapter adapter;
    private ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Đảm bảo layout có đầy đủ ID

        // Ánh xạ view
        listView = findViewById(R.id.product_list);
        searchView = findViewById(R.id.search_view);

        // Khởi tạo danh sách sản phẩm
        products = new ArrayList<>();
        products.add(new Product("iPhone 15 Pro Max", "$1199.00", R.drawable.ip, "Apple"));
        products.add(new Product("Samsung Galaxy S24 Ultra", "$1299.00", R.drawable.samsung, "Samsung"));
        products.add(new Product("RedMagic 9 Pro+", "$749.00", R.drawable.redmagic, "Gaming"));
        products.add(new Product("ASUS ROG Phone 8 Pro", "$1099.00", R.drawable.rogphone, "Gaming"));
        products.add(new Product("Xiaomi 15 Ultra", "$899.00", R.drawable.xiaomi, "Android"));
        products.add(new Product("OnePlus 12", "$799.00", R.drawable.oneplus, "Android"));
        products.add(new Product("Oppo Find X7 Ultra", "$999.00", R.drawable.oppo, "Android"));
        products.add(new Product("Vivo X100 Pro", "$999.00", R.drawable.vivo, "Android"));
        products.add(new Product("Nothing Phone (2)", "$599.00", R.drawable.nothingphone, "Android"));

        // Gắn adapter vào ListView
        adapter = new ProductAdapter(this, products);
        listView.setAdapter(adapter);

        // 🔍 Tìm kiếm
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return false;
            }
        });

        // 🔘 Gắn sự kiện các nút danh mục
        findViewById(R.id.btn_all).setOnClickListener(v -> adapter.filterByCategory("all"));
        findViewById(R.id.btn_apple).setOnClickListener(v -> adapter.filterByCategory("Apple"));
        findViewById(R.id.btn_samsung).setOnClickListener(v -> adapter.filterByCategory("Samsung"));
        findViewById(R.id.btn_gaming).setOnClickListener(v -> adapter.filterByCategory("Gaming"));
        findViewById(R.id.btn_android).setOnClickListener(v -> adapter.filterByCategory("Android"));

        // 🧭 Nút điều hướng
        findViewById(R.id.btn_login).setOnClickListener(v ->
                startActivity(new Intent(this, LoginActivity.class)));

        findViewById(R.id.btn_register).setOnClickListener(v ->
                startActivity(new Intent(this, RegisterActivity.class)));

        findViewById(R.id.btn_cart).setOnClickListener(v ->
                startActivity(new Intent(this, CartActivity.class)));

        findViewById(R.id.btn_checkout).setOnClickListener(v ->
                startActivity(new Intent(this, CheckoutActivity.class)));

        findViewById(R.id.btn_logout).setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        // 📱 Bắt sự kiện click item để mở ProductDetailActivity
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Product selected = products.get(position);
            Intent detailIntent = new Intent(this, ProductDetailActivity.class);
            detailIntent.putExtra("name", selected.getName());
            detailIntent.putExtra("price", selected.getPrice());
            detailIntent.putExtra("category", selected.getCategory());
            detailIntent.putExtra("imageResId", selected.getImageResId());
            startActivity(detailIntent);
        });
    }
}
