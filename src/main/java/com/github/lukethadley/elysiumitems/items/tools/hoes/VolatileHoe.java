package com.github.lukethadley.elysiumitems.items.tools.hoes;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class VolatileHoe extends CustomItem {

    private static final String NAME = "VolatileHoe";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#669999") + "&lVolatile Hoe";
    private static final String DESCRIPTION = "This item will explode when it breaks!";
    private static final String[] ITEM_LORE = new String[]{net.md_5.bungee.api.ChatColor.of("#669999") + "It was good while it lasted...", "&cWARNING: &fThis item will explode and", "&fcause you damage when it break!"};

    public VolatileHoe(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.IRON_HOE);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);
        ItemMeta itmMeta = itmStk.getItemMeta();

        itmMeta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        itmMeta.setLore(Arrays.asList(getLore()));


        itmMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 8, true);

        itmStk.setItemMeta(itmMeta);

        NBTItem nbti = new NBTItem(itmStk);
        nbti.setString("plugin", "Elysium-Items");
        nbti.setString("item", "Volatile");

        nbti.applyNBT(itmStk);

        itmStk.setDurability((short) (getItemType().getMaxDurability() - 3));

        return itmStk;
    }
}
