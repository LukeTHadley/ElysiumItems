package com.github.lukethadley.elysiumitems.items.armor;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import com.github.lukethadley.elysiumitems.items.armor.boots.BunnyBoots;
import com.github.lukethadley.elysiumitems.items.armor.boots.VoyagerBoots;
import com.github.lukethadley.elysiumitems.items.armor.chestplate.VoyagerChestplate;
import com.github.lukethadley.elysiumitems.items.armor.helmets.MinersHelmet;
import com.github.lukethadley.elysiumitems.items.armor.helmets.VoyagerHelmet;
import com.github.lukethadley.elysiumitems.items.armor.leggings.VoyagerLeggings;

import java.util.HashMap;

public class ArmorHandler {

    private HashMap<String, CustomItem> customItems;

    public ArmorHandler(){
        customItems = new HashMap<>();
        addItemsToMap();
    }

    private void addItemsToMap(){

        //Boots
        BunnyBoots bunnyBoots = new BunnyBoots();
        customItems.put(bunnyBoots.getName(), bunnyBoots);

        //Helmets
        MinersHelmet minersHelmet = new MinersHelmet();
        customItems.put(minersHelmet.getName(), minersHelmet);

        //Voyager Set
        VoyagerHelmet voyagerHelmet = new VoyagerHelmet();
        customItems.put(voyagerHelmet.getName(), voyagerHelmet);
        VoyagerChestplate voyagerChestplate = new VoyagerChestplate();
        customItems.put(voyagerChestplate.getName(), voyagerChestplate);
        VoyagerLeggings voyagerLeggings = new VoyagerLeggings();
        customItems.put(voyagerLeggings.getName(), voyagerLeggings);
        VoyagerBoots voyagerBoots = new VoyagerBoots();
        customItems.put(voyagerBoots.getName(), voyagerBoots);

    }

    public HashMap<String, CustomItem> getCustomItems(){
        return customItems;
    }

    public boolean checkExist(String customItemName){
        return customItems.containsKey(customItemName);
    }
}
