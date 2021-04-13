package com.github.lukethadley.elysiumitems.items.tools.bows;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class EnderBow extends CustomItem {

    private static final String NAME = "EnderBow";
    private static final String ITEM_DISPLAY_NAME = ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Ender Bow";
    private static final String DESCRIPTION = "Shoot an Ender Pearl with a bow and go where it lands";
    private static final String[] ITEM_LORE = new String[]{ChatColor.GRAY + "Shoot Pearls! Not Arrows!", ChatColor.GRAY + "You must have an " + ChatColor.LIGHT_PURPLE + "Ender Pearl", ChatColor.GRAY +  "In your inventory to use this bow!"};

    public EnderBow(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.BOW);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);
        ItemMeta itmMeta = itmStk.getItemMeta();

        itmMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', getItemName()));
        itmMeta.setLore(Arrays.asList(getLore()));

        itmMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        itmMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itmStk.setItemMeta(itmMeta);
        return itmStk;
    }

}
