package com.github.lukethadley.elysiumtools.items.armor.helmets;

import com.github.lukethadley.elysiumtools.items.CustomItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class VoyagerHelmet extends CustomItem {

    private static final String NAME = "VoyagerHelmet";
    private static final String ITEM_DISPLAY_NAME = "&b&lVoyager Helmet";
    private static final String DESCRIPTION = "When worn in the full set, the user will gain 4 extra hearts!";
    private static final String[] ITEM_LORE = new String[]{"&7When worn in the full set, the", "&7user will gain 4 extra hearts!"};

    public VoyagerHelmet(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.DIAMOND_HELMET);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);

        ItemMeta meta = itmStk.getItemMeta();

        meta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        meta.setLore(Arrays.asList(getLore()));

        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        meta.addEnchant(Enchantment.OXYGEN, 2, true);

        itmStk.setItemMeta(meta);

        return itmStk;
    }

}