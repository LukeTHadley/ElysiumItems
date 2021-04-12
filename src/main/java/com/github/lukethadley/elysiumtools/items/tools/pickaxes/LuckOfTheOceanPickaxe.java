package com.github.lukethadley.elysiumtools.items.tools.pickaxes;

import com.github.lukethadley.elysiumtools.items.CustomItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class LuckOfTheOceanPickaxe extends CustomItem {

    private static final String NAME = "LuckOfTheOceanPickaxe";
    private static final String ITEM_DISPLAY_NAME = "&9&lLuck Of The Ocean Pickaxe";
    private static final String DESCRIPTION = "This pickaxe will drop extra loot while mining Ocean materials in Ocean biomes!";
    private static final String[] ITEM_LORE = new String[]{"&7This pickaxe will drop", "&7extra loot while mining", "&7Ocean blocks Ocean Biomes!"};

    public LuckOfTheOceanPickaxe(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.GOLDEN_PICKAXE);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);
        ItemMeta itmMeta = itmStk.getItemMeta();

        itmMeta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        itmMeta.setLore(Arrays.asList(getLore()));

        itmMeta.addEnchant(Enchantment.LUCK, 1, true);
        itmMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itmStk.setItemMeta(itmMeta);

        return itmStk;
    }

}
