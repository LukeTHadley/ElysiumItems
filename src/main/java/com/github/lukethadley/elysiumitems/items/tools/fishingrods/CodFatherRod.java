package com.github.lukethadley.elysiumitems.items.tools.fishingrods;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CodFatherRod extends CustomItem {

    private static final String NAME = "CodFatherRod";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#ffcd36") + "&lCod Father Fishing Rod";
    private static final String DESCRIPTION = "This pair of leggings gives the users Speed 1 when worn!";
    private static final String[] ITEM_LORE = new String[]{
            net.md_5.bungee.api.ChatColor.of("#ffcd36") + "Local Chippy",  "&7All Cod and Salmon fished", "&7will be instantly cooked!"};


    public CodFatherRod (){ super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.FISHING_ROD); }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);

        ItemMeta meta = itmStk.getItemMeta();

        meta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        meta.setLore(Arrays.asList(getLore()));

        itmStk.setItemMeta(meta);

        NBTItem nbti = new NBTItem(itmStk);
        nbti.setString("plugin", "Elysium-Items");
        nbti.setBoolean("modifiable", true);
        nbti.setString("item", NAME);
        nbti.applyNBT(itmStk);
        return itmStk;
    }

}
