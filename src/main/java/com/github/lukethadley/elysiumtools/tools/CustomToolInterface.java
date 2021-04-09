package com.github.lukethadley.elysiumtools.tools;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public abstract class CustomToolInterface {

    private String name, description;
    private String[] lore;
    private Material itemType;
    private Map<Enchantment, Integer> enchantments;
    private boolean showEnchantments;
    private int durability;

    public CustomToolInterface(String name, String description, String[] lore, Material itemType, Map<Enchantment, Integer> enchantments, boolean showEnchantments){
        this.name = name;
        this.description = description;
        this.lore = lore;
        this.itemType = itemType;
        this.enchantments = enchantments;
        this.showEnchantments = showEnchantments;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getLore() {
        return lore;
    }

    public Material getItemType() {
        return itemType;
    }

    public Map<Enchantment, Integer> getEnchantments() {
        return enchantments;
    }

    public boolean isShowEnchantments() {
        return showEnchantments;
    }

    public int getDurability(){ return durability; }

    public void setDurability(int amount){ durability = amount; }

    public abstract ItemStack getItem();


}
