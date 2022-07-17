package com.github.lukethadley.elysiumitems.items.tools.shovels;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class VolatileShovel extends CustomItem {

    private static final String NAME = "VolatileShovel";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#669999") + "&lVolatile Shovel";
    private static final String DESCRIPTION = "This item will explode when it breaks!";
    private static final String[] ITEM_LORE = new String[]{net.md_5.bungee.api.ChatColor.of("#669999") + "It was good while it lasted...", "&7This item will explode when it breaks!"};

    public VolatileShovel(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.IRON_SHOVEL);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);
        ItemMeta itmMeta = itmStk.getItemMeta();

        itmMeta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        itmMeta.setLore(Arrays.asList(getLore()));


        itmMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 8, true);

        itmStk.setItemMeta(itmMeta);

        itmStk.setDurability((short) (getItemType().getMaxDurability() - 3));

        return itmStk;
    }

}
