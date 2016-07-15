package com.example.zaccianflone.pantrypro.pantry;

import com.example.zaccianflone.pantrypro.database.Create;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ben on 7/12/2016.
 */
public class Item implements Pantry {

    @Override
    public void addOrEdit(List<String> items) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("Expiration", items.get(1));
        map.put("Quantity", items.get(2));
        map.put("Unit", items.get(3));

        HashMap<String, Object> head = new HashMap<>();
        head.put(items.get(0), map);

        Create create = new Create();
        create.execute(head, "Item");
    }

    @Override
    public void remove(List<String> items) {

    }
}
