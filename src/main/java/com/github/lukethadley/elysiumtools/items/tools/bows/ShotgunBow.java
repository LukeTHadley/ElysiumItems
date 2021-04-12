package com.github.lukethadley.elysiumtools.items.tools.bows;

import com.github.lukethadley.elysiumtools.items.CustomItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ShotgunBow extends CustomItem {

    private static final String NAME = "ShotgunBow";
    private static final String ITEM_DISPLAY_NAME = ChatColor.BLUE + "" + ChatColor.BOLD + "Shotgun Bow";
    private static final String DESCRIPTION = "Shoots a volly of 5 arrows";
    private static final String[] ITEM_LORE = new String[]{ChatColor.GRAY + "Shoot a volly of 5 arrows at once!", ChatColor.GRAY + "You must have at least", ChatColor.GRAY + "5 arrows in your inventory."};

    public ShotgunBow(){
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
