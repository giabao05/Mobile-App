package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView nameTextView, priceTextView, categoryTextView;
    Button btnBack, btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // Ánh xạ view
        imageView = findViewById(R.id.product_image);
        nameTextView = findViewById(R.id.product_name);
        priceTextView = findViewById(R.id.product_price);
        categoryTextView = findViewById(R.id.product_category);
        btnBack = findViewById(R.id.btn_back);
        btnAddToCart = findViewById(R.id.btn_add_to_cart);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        String category = intent.getStringExtra("category");
        int imageResId = intent.getIntExtra("imageResId", R.drawable.ic_launcher_background);

        // Gán dữ liệu vào view
        nameTextView.setText(name);
        priceTextView.setText(price);
        categoryTextView.setText("Loại: " + category);
        imageView.setImageResource(imageResId);

        // Nút quay về
        btnBack.setOnClickListener(v -> finish());

        // Nút thêm vào giỏ hàng
        btnAddToCart.setOnClickListener(v -> {
            // Tạm thời hiển thị thông báo
            Toast.makeText(this, name + " đã được thêm vào giỏ hàng!", Toast.LENGTH_SHORT).show();

            // TODO: Sau này có thể thêm vào danh sách giỏ hàng toàn cục hoặc lưu vào SharedPreferences
        });
    }
}
