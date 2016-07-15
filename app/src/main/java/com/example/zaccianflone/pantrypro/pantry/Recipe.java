package com.example.zaccianflone.pantrypro.pantry;

import com.example.zaccianflone.pantrypro.database.Create;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ben on 7/12/2016.
 */
public class Recipe implements Pantry {


    @Override
    public void addOrEdit(List<String> items) {
        HashMap<String, Object> itemFacts = new HashMap<>();
        itemFacts.put("Quantity", items.get(3));
        itemFacts.put("Units", items.get(4));

        HashMap<String, Object> ingredient = new HashMap<>();
        ingredient.put(items.get(2), itemFacts);

        HashMap<String, Object> recipeInfo = new HashMap<>();
        recipeInfo.put("Directions", items.get(1));
        recipeInfo.put("Ingredients", ingredient);

        HashMap<String, Object> recipe = new HashMap<>();
        recipe.put(items.get(0), recipeInfo);

        Create createRecipe = new Create();
        createRecipe.update(recipe, "Recipes");
    }

    @Override
    public void remove(List<String> items) {

    }
}
