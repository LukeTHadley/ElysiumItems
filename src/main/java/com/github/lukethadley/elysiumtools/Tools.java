package com.github.lukethadley.elysiumtools;

import com.google.common.collect.ImmutableMap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

import java.util.Map;

public enum Tools {

    //BOWS
    ENDER_BOW(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Ender Bow",
            "Shoot an Ender Pearl with a bow and go where it lands",
            new String[]{ChatColor.GRAY + "Shoot Pearls! Not Arrows!", ChatColor.GRAY + "You must have an " + ChatColor.LIGHT_PURPLE + "Ender Pearl", ChatColor.GRAY +  "In your inventory to use this bow!"},
            Material.BOW,
            ImmutableMap.of(
                    Enchantment.ARROW_INFINITE, 1),
            false
            ), //The bow needs to have infinity otherwise it takes an arrow out of the players inventory even when cancelled.
    SHOTGUN_BOW(ChatColor.BLUE + "" + ChatColor.BOLD + "Shotgun Bow",
            "Shoots a volly of 5 arrows",
            new String[]{ChatColor.GRAY + "Shoot a volly of 5 arrows at once!", ChatColor.GRAY + "You must have at least", ChatColor.GRAY + "5 arrows in your inventory."},
            Material.BOW,
            ImmutableMap.of(
                    Enchantment.ARROW_INFINITE, 1),
            false
            ),


    //Swords
    DEMONIC_SWORD(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Demonic Sword",
            "Has a 20% chance of applying wither effect to your enemy for 10 seconds",
            new String[]{ChatColor.DARK_PURPLE + "Forged in the depths of hell", ChatColor.GRAY + "Has a 20% chance of applying the", ChatColor.GRAY + "wither effect to your enemy for 10 seconds"},
            Material.STONE_SWORD,
            ImmutableMap.of(
                    Enchantment.DURABILITY, 6),
            true
            );


    String name, description;
    String[] lore;
    Material itemType;
    Map<Enchantment, Integer> enchantments;
    boolean showEnchantments;

    Tools(String name, String description, String[] lore, Material itemType, Map<Enchantment, Integer> enchantments, boolean showEnchantments){
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
}
