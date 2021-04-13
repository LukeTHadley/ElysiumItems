package com.github.lukethadley.elysiumitems.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public abstract class CustomItem {

    private String name, itemName, description;
    private String[] lore;
    private Material itemType;

    public CustomItem(String name, String itemName, String description, String[] lore, Material itemType){
        this.name = name;
        this.itemName = itemName;
        this.description = description;
        this.lore = new String[lore.length];
        for (int i = 0; i < lore.length; i++){
            this.lore[i] = ChatColor.translateAlternateColorCodes('&', lore[i]);
        }
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public String[] getLore() {
        return lore;
    }

    public List<String> getLoreAsListString(){
        return Arrays.asList(lore);
    }

    public Material getItemType() {
        return itemType;
    }

    public abstract ItemStack getItem();

}
