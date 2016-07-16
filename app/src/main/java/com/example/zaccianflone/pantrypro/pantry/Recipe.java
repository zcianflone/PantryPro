package com.example.zaccianflone.pantrypro.pantry;

import com.example.zaccianflone.pantrypro.database.Create;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ben on 7/12/2016.
 */
public class Recipe {

    String name;
    String description;
    Item item;

    List<Item> list = new ArrayList<>();

    public Recipe() {

    }


    public Recipe(String name, String description, Item item/*, String quantity, String ingredient, String unitType*/) throws ParseException {
        this.name = name;
        this.description = description;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public Item getItem() {
        return item;
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, Object> storeItems() {
        HashMap<String, Object> items = new HashMap<>();
        items.put("Quantity", item.getQuantity());
        items.put("Units", item.getUnitType());

        return items;
    }

    public HashMap<String, Object> storeRecipe() {
        HashMap<String, Object> recipe = new HashMap<>();
        recipe.put(item.getIngredient(), storeItems());
        recipe.put("Description", description);
        return recipe;
    }

    public void addRecipe() {
        HashMap<String, Object> recipe = new HashMap<>();
        recipe.put(name, storeRecipe());
        Create newRecipe = new Create();
        newRecipe.execute(recipe, "Recipe");
    }
}




//        this.quantity = quantity;
//        this.unitType = unitType;
//        this.ingredient = ingredient;
//    String quantity;
//    String ingredient;
//    String unitType;

//    public String getQuantity() {
//        return quantity;
//    }
//
//    public String getIngredient() {
//        return ingredient;
//    }
//
//    public String getUnitType() {
//        return unitType;
//    }

//    public void addOrEdit(List<String> items) {
//        HashMap<String, Object> itemFacts = new HashMap<>();
//        itemFacts.put("Quantity", items.get(3));
//        itemFacts.put("Units", items.get(4));
//
//        HashMap<String, Object> ingredient = new HashMap<>();
//        ingredient.put(items.get(2), itemFacts);
//
//        HashMap<String, Object> recipeInfo = new HashMap<>();
//        recipeInfo.put("Directions", items.get(1));
//        recipeInfo.put("Ingredients", ingredient);
//
//        HashMap<String, Object> recipe = new HashMap<>();
//        recipe.put(items.get(0), recipeInfo);
//
//        Create createRecipe = new Create();
//        createRecipe.update(recipe, "Recipes");
//    }

//    public void remove(List<String> items) {

//    }

