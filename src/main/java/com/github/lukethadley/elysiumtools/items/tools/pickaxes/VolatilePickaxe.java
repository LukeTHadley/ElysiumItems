package com.github.lukethadley.elysiumtools.items.tools.pickaxes;

import com.github.lukethadley.elysiumtools.items.CustomItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class VolatilePickaxe extends CustomItem {

    private static final String NAME = "VolatilePickaxe";
    private static final String ITEM_DISPLAY_NAME = "&6&lVolatile Pickaxe";
    private static final String DESCRIPTION = "This item will explode when it breaks!";
    private static final String[] ITEM_LORE = new String[]{"&7This item will explode when it breaks!"};

    public VolatilePickaxe(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.GOLDEN_PICKAXE);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);
        ItemMeta itmMeta = itmStk.getItemMeta();

        itmMeta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        itmMeta.setLore(Arrays.asList(getLore()));


        itmMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);

        itmStk.setItemMeta(itmMeta);

        itmStk.setDurability((short) (getItemType().getMaxDurability() - 3));

        return itmStk;
    }
}
