package com.example.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodapp.R;
import com.example.foodapp.activities.category.Category;
import com.example.foodapp.activities.category.CategoryAdapter;
import com.example.foodapp.activities.food.FoodItem;
import com.example.foodapp.activities.popular.PopularAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter categoryAdapter, popularAdapter;
    private RecyclerView categoryRecycler, popularRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
    }

    private void recyclerViewCategory(){
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.category_recycler);
        categoryRecycler.setLayoutManager(llm);

        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category("Pizza", "cat_1"));
        categories.add(new Category("Burger", "cat_1"));
        categories.add(new Category("Hot Dog", "cat_3"));
        categories.add(new Category("Drink", "cat_4"));
        categories.add(new Category("Donut", "cat_5"));

        categoryAdapter = new CategoryAdapter(categories);
        categoryRecycler.setAdapter(categoryAdapter);  //clip to padding attr on recycler view
    }

    private void recyclerViewPoplar(){
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularRecycler = findViewById(R.id.popular_recycler);

        ArrayList<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(new FoodItem("Pepperoni pizza", "pizza1", "Fresh pizza made with cheese, tomato and pepperoni", 6.99));
        foodItems.add(new FoodItem("Cheese Burger", "burger", "1/4 burger served with cheese and fresh salad", 3.50));
        foodItems.add(new FoodItem("Vegetable Pizza", "pizza2", "Spicy pizza with onions, peppers, garlic and mushrooms", 5.99));

        popularAdapter = new PopularAdapter(foodItems);
        popularRecycler.setAdapter(popularAdapter);
    }
}