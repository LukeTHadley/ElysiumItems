package com.github.lukethadley.elysiumtools.items.armor.boots;

import com.github.lukethadley.elysiumtools.items.CustomItem;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class BunnyBoots extends CustomItem {

    private static final String NAME = "BunnyBoots";
    private static final String ITEM_DISPLAY_NAME = "&a&lBunny Boots";
    private static final String DESCRIPTION = "This item will give the wearer Jump Boost!";
    private static final String[] ITEM_LORE = new String[]{"&2Bounce like the bunny you are!", "&7Gives the user Jump Boost 3 while", "&7they are wearing the boots!"};

    public BunnyBoots(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.LEATHER_BOOTS);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);


        LeatherArmorMeta meta = (LeatherArmorMeta) itmStk.getItemMeta();
        meta.setColor(Color.GREEN);

        meta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        meta.setLore(Arrays.asList(getLore()));


        meta.addEnchant(Enchantment.DURABILITY, 3, true);

        itmStk.setItemMeta(meta);


        return itmStk;

    }
}
