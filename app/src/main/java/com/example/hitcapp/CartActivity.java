package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private ListView cartListView;
    private TextView emptyMessage;
    private Button btnBackHome, btnCheckout;
    private List<Product> cartItems;       // ✅ Đổi từ ArrayList -> List
    private CartAdapter adapter;           // ✅ Dùng đúng CartAdapter để hiển thị giỏ hàng

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Ánh xạ View
        cartListView = findViewById(R.id.cart_list);
        emptyMessage = findViewById(R.id.empty_message);
        btnBackHome = findViewById(R.id.btn_back_home);
        btnCheckout = findViewById(R.id.btn_checkout);

        // Lấy danh sách sản phẩm từ giỏ hàng
        cartItems = CartManager.getInstance().getCartItems();  // ✅ Không cần ép kiểu nếu dùng List

        if (cartItems.isEmpty()) {
            cartListView.setVisibility(View.GONE);
            emptyMessage.setVisibility(View.VISIBLE);
        } else {
            adapter = new CartAdapter(this, cartItems);         // ✅ Hiển thị sản phẩm
            cartListView.setAdapter(adapter);
            cartListView.setVisibility(View.VISIBLE);
            emptyMessage.setVisibility(View.GONE);
        }

        // Nút quay về trang chủ
        btnBackHome.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        // Nút chuyển đến thanh toán
        btnCheckout.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
            startActivity(intent);
        });
    }
}
