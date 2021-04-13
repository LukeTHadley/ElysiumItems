package com.github.lukethadley.elysiumitems.items.tools.swords;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class VolatileSword extends CustomItem {

    public VolatileSword() {
        super("VolatileSword", "&6&lVolatile Sword", "This item will explode when it breaks!", new String[]{"&7This item will explode when it breaks!"}, Material.GOLDEN_SWORD);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);
        ItemMeta itmMeta = itmStk.getItemMeta();

        itmMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', getItemName()));
        itmMeta.setLore(Arrays.asList(getLore()));


        itmMeta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 10, true);

        itmStk.setItemMeta(itmMeta);

        itmStk.setDurability((short) (getItemType().getMaxDurability() - 3));

        return itmStk;
    }
}
