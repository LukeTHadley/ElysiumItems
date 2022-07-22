package com.github.lukethadley.elysiumitems.items.tools.axes;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MagnetAxe extends CustomItem {

    private static final String NAME = "MagnetAxe";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#42f5da") + "&lMagnet Axe";
    private static final String DESCRIPTION = "This axe will attempt to place all that it mines into your inventory";
    private static final String[] ITEM_LORE = new String[]{net.md_5.bungee.api.ChatColor.of("#42f5da") + "MINE! MINE! MINE!", "&7This axe will attempt", "&7to place all that it mines", "&7into your inventory!"};

    public MagnetAxe(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.DIAMOND_AXE);
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
