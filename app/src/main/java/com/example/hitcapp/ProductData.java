package com.example.hitcapp;

import java.util.ArrayList;

public class ProductData {
    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> list = new ArrayList<>();

        list.add(new Product("iPhone 15 Pro Max", "$1199.00", R.drawable.ip, "Apple"));
        list.add(new Product("iPhone 14", "$899.00", R.drawable.ip, "Apple"));
        list.add(new Product("Samsung Galaxy S24 Ultra", "$1299.00", R.drawable.samsung, "Samsung"));
        list.add(new Product("RedMagic 9 Pro+", "$749.00", R.drawable.redmagic, "Gaming"));
        list.add(new Product("ASUS ROG Phone 8 Pro", "$1099.00", R.drawable.rogphone, "Gaming"));
        list.add(new Product("Xiaomi 15 Ultra", "$899.00", R.drawable.xiaomi, "Android"));
        list.add(new Product("OnePlus 12", "$799.00", R.drawable.oneplus, "Android"));
        list.add(new Product("Oppo Find X7 Ultra", "$999.00", R.drawable.oppo, "Android"));
        list.add(new Product("Vivo X100 Pro", "$999.00", R.drawable.vivo, "Android"));
        list.add(new Product("Nothing Phone (2)", "$599.00", R.drawable.nothingphone, "Android"));

        return list;
    }
}
