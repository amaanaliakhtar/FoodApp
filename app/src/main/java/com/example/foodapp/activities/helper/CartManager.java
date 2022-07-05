package com.example.foodapp.activities.helper;

import android.content.Context;
import android.widget.Toast;

import com.example.foodapp.activities.food.FoodItem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CartManager {
    private Context context;
    private TinyDB tinyDB;

    public CartManager(Context context){
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFoodItem(FoodItem item){
        ArrayList<FoodItem> foodItemList = getCart();
        boolean exists = false;
        int n = 0;

        for(int i = 0; i < foodItemList.size(); i++){
            if(foodItemList.get(i).getTitle().equals(item.getTitle())){
                exists = true;
                n = i;
                break;
            }
        }

        if(exists){
            foodItemList.get(n).setInCart(item.getInCart());
        }
        else {
            foodItemList.add(item);
        }

        tinyDB.putListObject("CartList", foodItemList);
        System.out.println("Added to cart");
        Toast.makeText(context, "Added to cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<FoodItem> getCart(){
        return tinyDB.getListObject("CartList");
    }
}
