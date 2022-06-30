package com.example.foodapp.activities.popular;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.R;
import com.example.foodapp.activities.category.Category;
import com.example.foodapp.activities.food.FoodItem;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<FoodItem> foodItems;

    public PopularAdapter(ArrayList<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_view_holder, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.foodItemName.setText(foodItems.get(position).getTitle());
        holder.foodItemPrice.setText(String.valueOf(foodItems.get(position).getPrice()));


        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(foodItems.get(position).getImage(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.foodItemImage);
    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView foodItemName, foodItemPrice, addBtn;
        ImageView foodItemImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodItemName = itemView.findViewById(R.id.food_item_title);
            foodItemPrice = itemView.findViewById(R.id.food_item_price);
            foodItemImage = itemView.findViewById(R.id.food_item_image);
            addBtn = itemView.findViewById(R.id.add_btn);
        }
    }
}
