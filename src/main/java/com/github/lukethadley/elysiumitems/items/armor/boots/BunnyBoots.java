package com.github.lukethadley.elysiumitems.items.armor.boots;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class BunnyBoots extends CustomItem {

    private static final String NAME = "BunnyBoots";
    private static final String ITEM_DISPLAY_NAME = "&a&lBunny Boots";
    private static final String DESCRIPTION = "This item will give the wearer Jump Boost!";
    private static final String[] ITEM_LORE = new String[]{"&aBounce like the bunny you are!", "&7Gives the user Jump Boost 3 while", "&7they are wearing the boots!",
            "&8This item is not &8modifiable/fixable!"};

    public BunnyBoots(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.LEATHER_BOOTS);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);


        LeatherArmorMeta meta = (LeatherArmorMeta) itmStk.getItemMeta();
        meta.setColor(Color.GREEN);

        meta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        meta.setLore(Arrays.asList(getLore()));


        meta.addEnchant(Enchantment.DURABILITY, 5, true);

        itmStk.setItemMeta(meta);

        NBTItem nbti = new NBTItem(itmStk);
        nbti.setString("plugin", "Elysium-Items");
        nbti.setString("item", "BunnyBoots");
        nbti.applyNBT(itmStk);
        return itmStk;

    }
}
