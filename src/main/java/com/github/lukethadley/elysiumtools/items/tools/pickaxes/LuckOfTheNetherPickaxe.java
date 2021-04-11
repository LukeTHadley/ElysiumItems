package com.github.lukethadley.elysiumtools.items.tools.pickaxes;

import com.github.lukethadley.elysiumtools.items.CustomToolInterface;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class LuckOfTheNetherPickaxe extends CustomToolInterface {

    private static final String NAME = "LuckOfTheNetherPickaxe";
    private static final String ITEM_DISPLAY_NAME = "&c&lLuck Of The Nether Pickaxe";
    private static final String DESCRIPTION = "This pickaxe will drop extra loot while mining nether blocks in the end!";
    private static final String[] ITEM_LORE = new String[]{"&7This pickaxe will drop", "&7 extra loot while", "&7mining nether blocks in the end!"};

    public LuckOfTheNetherPickaxe(){
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
