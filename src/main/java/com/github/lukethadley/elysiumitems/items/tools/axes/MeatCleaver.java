package com.github.lukethadley.elysiumitems.items.tools.axes;


import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MeatCleaver extends CustomItem {

    private static final String NAME = "MeatCleaver";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#8f4369") + "&lMeat Cleaver";
    private static final String DESCRIPTION = "This pickaxe will one hit farm animals";
    private static final String[] ITEM_LORE = new String[]{net.md_5.bungee.api.ChatColor.of("#8f4369") + "Resident Butcher", "&7All farm animals killed", "&7with this item will be", "&7instantly killed!"};

    public MeatCleaver() {
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.IRON_AXE);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);
        ItemMeta itmMeta = itmStk.getItemMeta();

        itmMeta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        itmMeta.setLore(Arrays.asList(getLore()));

        itmMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);

        itmStk.setItemMeta(itmMeta);

        NBTItem nbti = new NBTItem(itmStk);
        nbti.setString("plugin", "Elysium-Items");
        nbti.setString("item", NAME);

        nbti.applyNBT(itmStk);
        
        return itmStk;
    }

}
