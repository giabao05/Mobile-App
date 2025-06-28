package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    private ImageView productImage;
    private TextView productName, productPrice;
    private EditText receiverName, address, phone;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Ánh xạ view
        productImage = findViewById(R.id.checkout_product_image);
        productName = findViewById(R.id.checkout_product_name);
        productPrice = findViewById(R.id.checkout_product_price);
        receiverName = findViewById(R.id.et_receiver_name);
        address = findViewById(R.id.et_address);
        phone = findViewById(R.id.et_phone);
        confirmButton = findViewById(R.id.btn_confirm_payment);

        // Kiểm tra Intent có kèm dữ liệu sản phẩm không
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        int imageResId = intent.getIntExtra("imageResId", -1); // -1 nếu không có

        if (name != null && price != null && imageResId != -1) {
            // Hiển thị thông tin sản phẩm
            productImage.setImageResource(imageResId);
            productName.setText(name);
            productPrice.setText(price);

            productImage.setVisibility(ImageView.VISIBLE);
            productName.setVisibility(TextView.VISIBLE);
            productPrice.setVisibility(TextView.VISIBLE);
        }

        // Sự kiện xác nhận thanh toán
        confirmButton.setOnClickListener(v -> {
            String receiver = receiverName.getText().toString().trim();
            String addr = address.getText().toString().trim();
            String phoneNum = phone.getText().toString().trim();

            if (receiver.isEmpty() || addr.isEmpty() || phoneNum.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Thanh toán thành công!", Toast.LENGTH_LONG).show();

                // Nếu cần: clear giỏ hàng
                CartManager.getInstance().clearCart();

                // Quay về trang chủ
                Intent homeIntent = new Intent(this, MainActivity.class);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(homeIntent);
                finish();
            }
        });
    }
}
