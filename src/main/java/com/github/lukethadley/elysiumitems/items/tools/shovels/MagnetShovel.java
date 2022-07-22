package com.github.lukethadley.elysiumitems.items.tools.shovels;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MagnetShovel extends CustomItem {

    private static final String NAME = "MagnetShovel";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#42f5da") + "&lMagnet Shovel";
    private static final String DESCRIPTION = "This pickaxe will attempt to place all that it mines into your inventory";
    private static final String[] ITEM_LORE = new String[]{net.md_5.bungee.api.ChatColor.of("#42f5da") + "MINE! MINE! MINE!", "&7This shovel will attempt", "&7to place all that it mines", "&7into your inventory!"};

    public MagnetShovel(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.DIAMOND_SHOVEL);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);
        ItemMeta itmMeta = itmStk.getItemMeta();

        itmMeta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        itmMeta.setLore(Arrays.asList(getLore()));

        itmStk.setItemMeta(itmMeta);

        NBTItem nbti = new NBTItem(itmStk);
        nbti.setString("plugin", "Elysium-Items");
        nbti.setBoolean("modifiable", true);
        nbti.setString("item", "Magnet");

        nbti.applyNBT(itmStk);

        return itmStk;
    }
}
