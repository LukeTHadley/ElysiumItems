package com.github.lukethadley.elysiumtools.items.armor.helmets;

import com.github.lukethadley.elysiumtools.items.CustomItem;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class MinersHelmet extends CustomItem {

    private static final String NAME = "MinersHelmet";
    private static final String ITEM_DISPLAY_NAME = "&e&lMiners Helmet";
    private static final String DESCRIPTION = "This item will give the user Haste while they are wearing it!";
    private static final String[] ITEM_LORE = new String[]{"&6Dig Faster! Mine Deeper! Minecraft!", "&7Gives the user Haste 1 while", "&7they are wearing the helmet!"};

    public MinersHelmet(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.LEATHER_HELMET);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);

        LeatherArmorMeta meta = (LeatherArmorMeta) itmStk.getItemMeta();
        meta.setColor(Color.YELLOW);

        meta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        meta.setLore(Arrays.asList(getLore()));

        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 8, true);

        itmStk.setItemMeta(meta);

        return itmStk;

    }

}
