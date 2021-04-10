package com.github.lukethadley.elysiumtools.items.tools.pickaxes;

import com.github.lukethadley.elysiumtools.items.CustomToolInterface;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class LuckOfTheEndPickaxe extends CustomToolInterface {

    private static final String NAME = "LuckOfTheEndPickaxe";
    private static final String ITEM_DISPLAY_NAME = "&5&lLuck Of The End Pickaxe";
    private static final String DESCRIPTION = "This pickaxe has the chance of dropping extra loot while mining end blocks in the end!";
    private static final String[] ITEM_LORE = new String[]{"&7This pickaxe has the chance", "&7of dropping extra loot while", "&7mining end blocks in the end!"};

    public LuckOfTheEndPickaxe(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.DIAMOND_PICKAXE);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);
        ItemMeta itmMeta = itmStk.getItemMeta();

        itmMeta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        itmMeta.setLore(Arrays.asList(getLore()));


        itmMeta.addEnchant(Enchantment.DURABILITY, 3, true);

        itmStk.setItemMeta(itmMeta);

        return itmStk;
    }

}
