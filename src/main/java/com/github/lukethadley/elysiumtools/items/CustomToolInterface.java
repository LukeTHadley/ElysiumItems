package com.github.lukethadley.elysiumtools.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class CustomToolInterface {

    private String name, itemName, description;
    private String[] lore;
    private Material itemType;

    public CustomToolInterface(String name, String itemName, String description, String[] lore, Material itemType){
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
