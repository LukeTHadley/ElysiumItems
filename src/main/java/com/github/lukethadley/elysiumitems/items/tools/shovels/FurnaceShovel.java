package com.github.lukethadley.elysiumitems.items.tools.shovels;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class FurnaceShovel extends CustomItem {

    private static final String NAME = "FurnaceShovel";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#dbd32e") + "&lFurnace Shovel";
    private static final String DESCRIPTION = "This item will drop glass when mining sand!";
    private static final String[] ITEM_LORE = new String[]{net.md_5.bungee.api.ChatColor.of("#dbd32e") + "Diggy Diggy Hole!", "&7Sand mined with this shovel", "&7will be turned into Glass!"};

    public FurnaceShovel(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.IRON_SHOVEL);
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
        nbti.setString("item", NAME);

        nbti.applyNBT(itmStk);


        return itmStk;
    }

}
