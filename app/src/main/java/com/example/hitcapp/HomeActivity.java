package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Nút Trang chủ - không chuyển trang vì đang ở Home
        Button btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(v -> {
            // Đang ở Home, không làm gì cả
        });

        // Nút Đăng nhập
        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
        });

        // Nút Đăng ký
        Button btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });

        // Nút Giỏ hàng
        Button btnCart = findViewById(R.id.btn_cart);
        btnCart.setOnClickListener(v -> {
            startActivity(new Intent(this, CartActivity.class));
        });

        // Nút Thanh toán
        Button btnCheckout = findViewById(R.id.btn_checkout);
        btnCheckout.setOnClickListener(v -> {
            startActivity(new Intent(this, CheckoutActivity.class));
        });

        // ✅ Nút Sản phẩm (hiển thị danh sách tất cả sản phẩm)
        Button btnProductList = findViewById(R.id.btn_product_list);
        btnProductList.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProductListActivity.class);
            intent.putExtra("category", "all");
            startActivity(intent);
        });
    }
}
