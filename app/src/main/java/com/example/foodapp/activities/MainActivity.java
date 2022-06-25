package com.example.foodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodapp.R;
import com.example.foodapp.activities.category.Category;
import com.example.foodapp.activities.category.CategoryAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView categoryRecycler;

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

        adapter = new CategoryAdapter(categories);
        categoryRecycler.setAdapter(adapter);  //clip to padding attr on recycler view
    }
}