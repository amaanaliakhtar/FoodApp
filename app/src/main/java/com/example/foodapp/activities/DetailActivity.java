package com.example.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.foodapp.R;
import com.example.foodapp.activities.food.FoodItem;
import com.example.foodapp.activities.helper.CartManager;

public class DetailActivity extends AppCompatActivity {

    private TextView addToCardBtn;
    private TextView detailTitle, detailPrice, detailDescription, detailQuantity;
    private ImageView plusBtn, minusBtn, detailImage;

    private FoodItem foodItem;
    int quantity = 1;
    private CartManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        cm = new CartManager(this);

        addToCardBtn = findViewById(R.id.add_to_cart_btn);

        detailTitle = findViewById(R.id.detail_title);
        detailPrice = findViewById(R.id.detail_price);
        detailDescription = findViewById(R.id.detail_description);
        detailQuantity = findViewById(R.id.detail_quantity);

        plusBtn = findViewById(R.id.plus_btn);
        minusBtn = findViewById(R.id.minus_btn);
        detailImage = findViewById(R.id.detail_image);

        getBundle();

    }

    private void getBundle(){
        foodItem = (FoodItem) getIntent().getSerializableExtra("foodItem");

        int drawableResourceId = this.getResources().getIdentifier(foodItem.getImage(), "drawable", this.getPackageName());

        Glide.with(this).load(drawableResourceId).into(detailImage);

        detailTitle.setText(foodItem.getTitle());
        detailPrice.setText("£" + foodItem.getPrice());
        detailDescription.setText(foodItem.getDescription());
        detailQuantity.setText(String.valueOf(quantity));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity += 1;
                detailQuantity.setText(String.valueOf(quantity));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantity > 1){
                    quantity -= 1;
                }
                detailQuantity.setText(String.valueOf(quantity));
            }
        });

        addToCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodItem.setInCart(quantity);
                cm.insertFoodItem(foodItem);
            }
        });
    }
}